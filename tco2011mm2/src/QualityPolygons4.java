import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QualityPolygons4 {
    private static final long TIME_OFFSET = 9900;
    private static final long[] TIME_OFFSETS = { 9900, 9700, 7500, 5000, 4000, 3000, 2000, 1000 };
    private long time;
    private int numPoints;
    private int[] points;
    private long lenDiff;
    private long radDiff;
    private int lines[];
    private int[] linesSorted;
    private int[] vecx;
    private int[] vecy;
    private boolean pUsed[];
    private int[] poly = new int[10];
    private int N;
    private List<String> result = new ArrayList<String>();
    private static int totalScore = 0;

    private static final void println(Object s) {
        System.out.println(s.toString());
    }

    private static final void print(Object s) {
        System.out.print(s.toString());
    }


    private static final int dist2(int x1, int y1, int x2, int y2) {
        int x = x1 - x2;
        int y = y1 - y2;
        return x * x + y * y;
    }

    private static final long cross(int x1, int y1, int x2, int y2) {
        return x1 * y2 - y1 * x2;
    }

    private static final long sq(long a) {
        return a * a;
    }

    public String[] choosePolygons(int[] points, int sidesDiff, int radiiDiff) {
        time = System.currentTimeMillis();
        this.points = points;
        numPoints = points.length / 2;
        lenDiff = (100 - sidesDiff) * (100 - sidesDiff);
        radDiff = (100 - radiiDiff) * (100 - radiiDiff);
        pUsed = new boolean[numPoints];
        lines = new int[numPoints*numPoints];
        linesSorted = new int[numPoints * numPoints];
        //linesSorted2 = new int[numPoints * numPoints];
        vecx = new int[numPoints*numPoints];
        vecy = new int[numPoints*numPoints];
        for (int i = 0; i < numPoints - 1; i++) {
            int x1 = points[i * 2];
            int y1 = points[i * 2 + 1];
            for (int j = i + 1; j < numPoints; j++) {
                int x2 = points[j * 2];
                int y2 = points[j * 2 + 1];
                int len = dist2(x1, y1, x2, y2);
                //long lenVal = i | ((long) j << 16) | ((long) len << 32);
                int lenVal = (j & 0x1fff) | ((len >>> 2) << 13);
                linesSorted[i*numPoints + j] = lenVal;
                //linesSorted2[i*numPoints + j] = len;
                lines[i*numPoints + j] = len;
                lines[j*numPoints + i] = len;
                vecx[i*numPoints + j] = x2 - x1;
                vecx[j*numPoints + i] = x1 - x2;
                vecy[i*numPoints + j] = y2 - y1;
                vecy[j*numPoints + i] = y1 - y2;
            }
            Arrays.sort(linesSorted, i*numPoints + i + 1, i*numPoints + numPoints);
            //Arrays.sort(linesSorted2, i*numPoints + i + 1, i*numPoints + numPoints);
        }
        System.out.println("Time1: " + (System.currentTimeMillis() - time));

        if (numPoints <= 100) {
            findPoly(7);
            findPoly(6);
            findPoly(5);
            findPoly(4);
        }
        if (numPoints <= 200) {
            findPoly(3);
        }
        if (numPoints <= 2500)
            findPoly(2);
        findPoly(1);
        findPoly(0);

        System.out.print("found " + result.size() + "\t");
        System.out.print("Time: " + (System.currentTimeMillis() - time) + "\t");
        return result.toArray(new String[0]);
    }

    private void findPoly(int edges) {
        main: for (int i = 0; i < numPoints - 1; i++) {
            if (pUsed[i])
                continue;
            if (edges == 0) {
                if (System.currentTimeMillis() - time > TIME_OFFSET) {
                    System.out.println("time break");
                    break;
                }
            }
            for (int jj = i + 1; jj < numPoints; jj++) {
                // od i+1 bo w linesSorted zaczynaja sie od tej pozycji
                if (edges > 0) {
                    if (System.currentTimeMillis() - time > TIME_OFFSETS[edges]) {
                        System.out.println("time break " + edges + "@" + i + "-" + jj);
                        edges--;
//                        usePotential();
//                        if (pUsed[i])
//                            continue;
                        if (edges==0)
                            break main;
                    }
                }
                //long lineIJ = linesSorted[i*numPoints + jj];
                //int j = (int) ((lineIJ >>> 16) & 0xFFFF);
                int lineIJ = linesSorted[i*numPoints + jj];
                int j = lineIJ & 0x1fff;
                if (pUsed[j])
                    continue;
                //long lenij = lineIJ >>> 32;
                long lenij = lines[i*numPoints + j];

                for (int kk = jj + 1; kk < numPoints; kk++) {
                    // od jj+1 aby nie sprawdzac 2 razy tych samych
                    //long lineIK = linesSorted[i*numPoints + kk];
                    //int k = (int) ((lineIK >>> 16) & 0xFFFF);
                    int lineIK = linesSorted[i*numPoints + kk];
                    int k = lineIK & 0x1fff;
                    if (pUsed[k])
                        continue;
                    //long lenik = lineIK >>> 32;
                    long lenik = lines[i*numPoints + k];
                    long minLen = lenij < lenik ? lenij : lenik;
                    long maxLen = lenij > lenik ? lenij : lenik;
                    if (100 * 100 * minLen < maxLen * lenDiff)
                        break;

                    poly[0] = j;
                    poly[1] = i;
                    poly[2] = k;
                    N = 3;
                    // Arrays.sort(poly, 0, 3);
                    
                    if (edges == 0) {
                        if (isValid(minLen, maxLen)) {
                            found();
                            continue main;
                        }
                    } else {
                        if (findEdge(minLen, maxLen, edges))
                            continue main;
                    }
                }
            }
        }
//        usePotential();
    }
    
    private boolean isValid(long minLen, long maxLen) {
        int last = poly[N - 1];
        int prev = poly[0];
        long len = lines[last*numPoints + prev];
        minLen = len < minLen ? len : minLen;
        maxLen = len >= maxLen ? len : maxLen;
        if (100 * 100 * minLen < maxLen * lenDiff)
            return false;
        if (!validate())
            return false;
        return true;
    }

    private boolean findEdge(long minLen, long maxLen, int edges) {
//        for (int i=0; i<N; i++) {
//            if (pUsed[poly[i]]) {
//                //print("err");
//                return true;
//            }
//        }
        int last = poly[N - 1];
        long minMinLen = maxLen * lenDiff;
        long maxMaxLen = 100*100*minLen/lenDiff;
        //boolean potentialAdded = false;
        nextp: for (int ii = last + 1; ii < numPoints; ii++) {
            //long line = linesSorted[last*numPoints + ii];
            //int i = (int) ((line >>> 16) & 0xFFFF);
            int line = linesSorted[last*numPoints + ii];
            int i = line & 0x1fff;
            if (pUsed[i])
                continue;
            //long len1 = line >>> 32;
            long len1 = lines[last*numPoints + i];
            if (100 * 100 * len1 < minMinLen)
                continue;
            if (maxMaxLen < len1)
                break;
            for (int p = 0; p < N; p++)
                if (i == poly[p])
                    continue nextp;
            long newminLen, newmaxLen;
            if (len1 < minLen) {
                newminLen = len1;
                newmaxLen = maxLen;
//                if (100 * 100 * newminLen < newmaxLen * lenDiff)
//                    continue;
            } else if (len1 > maxLen) {
                newminLen = minLen;
                newmaxLen = len1;
                if (100 * 100 * newminLen < newmaxLen * lenDiff) {
                    break;
                }
            } else {
                newminLen = minLen;
                newmaxLen = maxLen;
            }

            if (!fastIsConvex())
                continue;

            poly[N++] = i;
            
            if (edges == 1) {
                if (isValid(newminLen, newmaxLen)) {
                    found();
                    return true;
                }
            } else {
                if (findEdge(newminLen, newmaxLen, edges - 1))
                    return true;
//                if (!potentialAdded && isValid(newminLen, newmaxLen)) {
//                    potentialAdded = true;
//                    if (addPotential())
//                        break;
//                }
            }
            N--;
        }
        return false;
    }


    private void found() {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int idx = poly[i];
            pUsed[idx] = true;
            res.append(idx).append(' ');
        }
        res.setLength(res.length() - 1);
        result.add(res.toString());
        totalScore += sq(N);
        // print(res);
    }

    private boolean validate() {
        // if (!checkLen()) {
        // return false;
        // }
        for (int i=0; i<N; i++) {
            if (pUsed[poly[i]]) {
                //println("err");
                return false;
            }
        }
        return checkInscribed() && isConvex();
    }

    private boolean isConvex() {
        if (N == 3)
            return true;

        for (int i = 0; i < N; i++) {
            // use p[i] and p[i+1] as reference vector
            int idx1 = poly[(i + 1) % N];
            int idx0 = poly[i];
            int idx2 = poly[(i + 2) % N];
            int x1 = vecx[idx0*numPoints + idx1];
            int y1 = vecy[idx0*numPoints + idx1];
            int x2 = vecx[idx0*numPoints + idx2];
            int y2 = vecy[idx0*numPoints + idx2];

            long cross = cross(x1, y1, x2, y2);
            if (cross == 0)
                return false;
            else
                cross /= Math.abs(cross);
            for (int j = 3; j < N; j++) {
                int idx3 = poly[(i + j) % N];
                int x3 = vecx[idx0*numPoints + idx3];
                int y3 = vecy[idx0*numPoints + idx3];
                if (cross * cross(x1, y1, x3, y3) <= 0)
                    return false;
            }
        }


        return true;
    }
    
    
    private boolean fastIsConvex() {
        if (N == 3)
            return true;
        
        int idx0 = poly[0];
        int idx1 = poly[1];
        int idx2 = poly[2];
        int x1 = vecx[idx0*numPoints + idx1];
        int y1 = vecy[idx0*numPoints + idx1];
        int x2 = vecx[idx0*numPoints + idx2];
        int y2 = vecy[idx0*numPoints + idx2];
        long cross = cross(x1, y1, x2, y2);
        if (cross == 0)
            return false;
        else
            cross /= Math.abs(cross);

        for (int i = 1; i < N; i++) {
            idx0 = poly[i];
            idx1 = poly[(i + 1) % N];
            idx2 = poly[(i + 2) % N];
            x1 = vecx[idx0*numPoints + idx1];
            y1 = vecy[idx0*numPoints + idx1];
            x2 = vecx[idx0*numPoints + idx2];
            y2 = vecy[idx0*numPoints + idx2];
            if (cross * cross(x1, y1, x2, y2) <= 0)
                return false;
        }
        return true;
    }
    

    private boolean checkInscribed() {
        long sumX = 0, sumY = 0;
        for (int i = 0; i < N; i++) {
            int idx = poly[i];
            sumX += points[idx * 2];
            sumY += points[idx * 2 + 1];
        }
        int idx0 = poly[0];
        long maxR2 = sq(sumX - N * points[idx0 * 2]) + sq(sumY - N * points[idx0 * 2 + 1]);
        long minR2 = maxR2;
        long R2;
        // print(minR2);
        for (int i = 1; i < N; i++) {
            int idx = poly[i];
            R2 = sq(sumX - N * points[idx * 2]) + sq(sumY - N * points[idx * 2 + 1]);
            // print(R2);
            maxR2 = Math.max(maxR2, R2);
            minR2 = Math.min(minR2, R2);
        }
        if (100 * 100 * minR2 < maxR2 * radDiff) {
            return false;
        }
        // System.out.println("r=" + minR2 + " " + maxR2);
        return true;
    }

    public static void main(String[] args) {
        args = new String[] { "-seed", "4", "-manual", "-vis" };
        for (int i = 1; i <= 1; i++) {
//            if (i!=1 && i!=4 && i!=10)
//                continue;
            println("-- " + i + "\t");
            args = new String[] { "-seed", Integer.toString(i)  , "-manual" , "-debug" };
            QualityPolygonsVis.main(args);
        }
        println("totalScore=" + totalScore);
    }
    
}
