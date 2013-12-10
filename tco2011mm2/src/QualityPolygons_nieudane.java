
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class QualityPolygons_nieudane {
    private static final long TIME_OFFSET = 9900;
    private static final long[] TIME_OFFSETS = { 9900, 9700, 7500, 5000, 4000, 3000, 2000, 1000 };
    private long time;
    private int numPoints;
    private int[] points;
    private long lenDiff;
    private long radDiff;
    private int lines[];
    private int[] linesSorted;
//    private int[] linesSorted2;
    private int[] vecx;
    private int[] vecy;
    private boolean pUsed[];
    private int[] poly = new int[10];
    private int N;
    private List<String> result = new ArrayList<String>();
    private static int totalScore = 0;
//    private int[] potential = new int[2000];
//    private int potentialIdx = 0;
    //private Map<Integer, ArrayList<int[]>> polys = new HashMap<Integer, ArrayList<int[]>>();
    private ArrayList<Polygon> polys = new ArrayList<Polygon>();
    
    private static final class Polygon implements Comparable<Polygon> {
        int N;
        int[] points = new int[10];
        long minLen;
        long maxLen;
        
        public int compareTo(Polygon o) {
            return (int) (this.minLen - minLen);
        }
    }
    
    private static final void print(Object s) {
        System.out.println(s.toString());
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

//        if (numPoints <= 100) {
//            findPoly(7);
//            findPoly(6);
//            findPoly(5);
//            findPoly(4);
//        }
//        if (numPoints <= 200) {
//            findPoly(3);
//        }
//        if (numPoints <= 2500)
//            findPoly(2);
//        findPoly(1);
        findPoly(0);

        System.out.print("found " + result.size() + "\t");
        System.out.print("Time: " + (System.currentTimeMillis() - time) + "\t");
        return result.toArray(new String[0]);
    }

    private void findPoly(int edges) {
        int num3 = 0;

        main: for (int i = 0; i < numPoints - 1; i++) {
            if (pUsed[i])
                continue;
            if (edges == 0) {
                if (System.currentTimeMillis() - time > TIME_OFFSET) {
                    System.out.println("time break 0 @ " + i);
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

//                    poly = new int[10];
//                    poly[9] = 3;
//                    poly[0] = j;
//                    poly[1] = i;
//                    poly[2] = k;
//                    N = 3;
//                    num3++;
//                    int kmin = j < k ? j : k;
//                    int kmax = j > k ? j : k;
//                    int key = kmin | (kmax << 16);
//                    ArrayList<int[]> list = polys.get(key);
//                    if (list == null) {
//                        list = new ArrayList<int[]>();
//                        polys.put(key, list);
//                    }
//                    list.add(poly);
                    
                    Polygon p = new Polygon();
                    p.N = 3;
                    p.points[0] = j;
                    p.points[1] = i;
                    p.points[2] = k;
                    p.minLen = minLen;
                    p.maxLen = maxLen;
                    polys.add(p);
                    
                    //polys.add(poly);
                    
//                    if (edges == 0) {
//                        if (isValid(minLen, maxLen)) {
//                            found();
//                            continue main;
//                        }
//                    } else {
//                        if (findEdge(minLen, maxLen, edges))
//                            continue main;
//                    }
                }
            }
        }
        print("liczba3=" + polys.size());
        System.out.println("Time2: " + (System.currentTimeMillis() - time));
        compress();
//        usePotential();
    }
    
    private void compress() {
        Collections.sort(polys);
        System.out.println("Time3: " + (System.currentTimeMillis() - time));
        i: for (int i=0; i<polys.size()-1; i++) {
            Polygon p1 = polys.get(i);
            for (int j=i+1; j<polys.size(); j++) {
                
                if (System.currentTimeMillis() - time > TIME_OFFSET) {
                    System.out.println("time break 0 @ " + i + "-" + j);
                    break i;
                }
                
                Polygon p2 = polys.get(j);
                Polygon p3 = merge(p1, p2);
                N = p3.N;
                for (int x=0; x<N; x++) {
                    poly[x] = p3.points[x];
                }
                if (validate()) {
                    found();
                    continue i;
                }
            }
            

        }
        
        for (int i = 0; i < polys.size() - 1; i++) {
            Polygon p1 = polys.get(i);
            N = p1.N;
            for (int x = 0; x < N; x++) {
                poly[x] = p1.points[x];
            }
            if (validate()) {
                found();
            }
        }        
        
//      poly = new int[10];
//      Collection<ArrayList<int[]>> values = polys.values();
      
        
//        poly = new int[10];
//        Collection<ArrayList<int[]>> values = polys.values();
//        for (ArrayList<int[]> list : values) {
//            for (int i=0; i<list.size()-1; i++) {
//                int[] poly1 = list.get(i);
//                for (int j=i+1; j<list.size(); j++) {
//                    int[] poly2 = list.get(j);
//                    poly[0] = poly1[0];
//                    poly[1] = poly1[1];
//                    poly[2] = poly1[2];
//                    poly[3] = poly2[1];
//                    N = 4;
//                    if (validate()) {
//                        found();
//                    }
//                }
//            }
//            N = 3;
////            if (validate()) {
////                found();
////            }
//        }
        
    }

    private Polygon merge(Polygon p1, Polygon p2) {
        Polygon p3 = new Polygon();
        p3.N = p1.N;
        for (int i=0; i<p1.N; i++)
            p3.points[i] = p1.points[i];
        i: for (int i=0; i<p2.N; i++) {
            for (int j=0; j<p1.N; j++) {
                if (p3.points[j] == p2.points[i]) {
                    continue i;
                }
            }
            p3.points[p3.N++] = p2.points[i];
        }
        return p3;
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

//    private boolean addPotential() {
//        //print("add potential " + potentialIdx);
//        boolean res = false;
//        if (potentialIdx + N + 1 >= potential.length) {
//            usePotential();
//            res = true;
//        }
//        potential[potentialIdx++] = N;
//        for (int i = 0; i < N; i++) {
//            potential[potentialIdx++] = poly[i];
//        }
//        return res;
//    }

//    private void usePotential() {
//        //print("using potential " + potentialIdx);
//        int i=0;
//        int oldN = N;
//        int[] oldPoly = poly;
//        while (i<potentialIdx) {
//            N = potential[i++];
//            //print("size " + N);
//            boolean notused = true;
//            for (int j=0; j<N; j++) {
//                poly[j] = potential[i];
//                if (pUsed[poly[j]])
//                    notused = false;
//                i++;
//            }
//            if (notused) {
//                found();
//            }
//        }
//        N = oldN;
//        poly = oldPoly;
//        potentialIdx = 0;
//    }

    private void found() {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int idx = poly[i];
            pUsed[idx] = true;
            res.append(idx).append(' ');
        }
        // int d1 = lines[poly[0]][poly[2]];
        // int d2 = lines[poly[1]][poly[3]];
        // int minLen = Math.min(d1, d2);
        // int maxLen = Math.max(d1, d2);
        // print("d1=" + Math.sqrt(d1) + ",d2=" + Math.sqrt(d2));
        // if (100 * 100 * minLen < maxLen * lenDiff)
        // print("err");
        res.setLength(res.length() - 1);
        print(res);
        result.add(res.toString());
        // print(res);
        totalScore += sq(N);
    }

    private boolean validate() {
        // if (!checkLen()) {
        // return false;
        // }
        for (int i=0; i<N; i++) {
            if (pUsed[poly[i]]) {
                //print("err");
                return false;
            }
        }
        return checkLen() && checkInscribed() && isConvex();
    }
    
    private boolean checkLen() {
        long minLen = lines[poly[0]*numPoints + poly[N-1]];
        long maxLen = minLen;
        for (int i=0; i<N-1; i++) {
            long len = lines[poly[i]*numPoints + poly[i+1]];
            minLen = Math.min(minLen, len);
            maxLen = Math.max(maxLen, len);
        }
        if (100*100 * minLen < maxLen * this.lenDiff)
            return false;
        return true;
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

            // int idx1 = poly[(i + 1) % N] * 2;
            // int idx0 = poly[i] * 2;
            // int idx2 = poly[(i + 2) % N] * 2;
            // int x1 = points[idx1] - points[idx0];
            // int y1 = points[idx1 + 1] - points[idx0 + 1];
            // int x2 = points[idx2] - points[idx0];
            // int y2 = points[idx2 + 1] - points[idx0 + 1];

            long cross = cross(x1, y1, x2, y2);
            if (cross == 0)
                return false;
            else
                cross /= Math.abs(cross);
            for (int j = 3; j < N; j++) {
                // int idx3 = poly[(i + j) % N] * 2;
                // int x3 = points[idx3] - points[idx0];
                // int y3 = points[idx3 + 1] - points[idx0 + 1];
                int idx3 = poly[(i + j) % N];
                int x3 = vecx[idx0*numPoints + idx3];
                int y3 = vecy[idx0*numPoints + idx3];
                if (cross * cross(x1, y1, x3, y3) <= 0)
                    return false;
            }
        }

        // print(N);
        // for (int idx=0; idx<N-2; idx++) {
        // int idx0 = poly[idx] * 2;
        // int idx1 = poly[idx+1] * 2;
        // int idx2 = poly[idx+2] * 2;
        // int x1 = points[idx1] - points[idx0];
        // int y1 = points[idx1 + 1] - points[idx0 + 1];
        // int x2 = points[idx2] - points[idx0];
        // int y2 = points[idx2 + 1] - points[idx0 + 1];
        // long cross2 = cross(x1, y1, x2, y2);
        // print(cross2);
        // }
        // print("--");

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
        for (int i = 10; i <= 10; i++) {
//            if (i!=2 && i!=5 && i!=7)
//                continue;
            print("-- " + i + "\t");
            args = new String[] { "-seed", Integer.toString(i)  /*, "-manual" */};
            QualityPolygonsVis.main(args);
        }
        print("totalScore=" + totalScore);
    }

}
