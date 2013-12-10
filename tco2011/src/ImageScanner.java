import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ImageScanner {
    private static void debug(String s) {
        // System.out.print(s);
    }

    private static void debugln(String s) {
        // System.out.println(s);
    }

    private char[][] img;
    private char[][] img2;
    private int[][] imgVal;
    private int[][] imgValOrg;
    private int[][] imgValFull;
    private int W;
    private int H;
    private FastIntArray[][] possible;
    private int numBlack = 0;
    int numLetters = 0;
    int scannedCount = 0;
    // private String[] scannedRows;
    private boolean[] isScanned;
    private List<Rectangle> placed;
    private final int STEP = 3;
    private int nLetter;
    private int nb;
    // private List<ArrayList<MaxLetter>> maxLetters2;
    private ArrayList<MaxLetter> maxLetters;
    private long time;
    private int passScore;
    private int passScoreSum = 0;
    private int passScoreNum = 0;
    
    private static final long TIME_OFFSET = 9600;

    private static final class FastIntArray {
        private int size = 0;
        private final int[] array;

        public FastIntArray(int capacity) {
            array = new int[capacity];
        }

        // private static int[] copyOf(int[] original, int newLength) {
        // int[] copy = new int[newLength];
        // System.arraycopy(original, 0, copy, 0, original.length);
        // return copy;
        // }

        public void add(int elem, int score) {
            if (size >= array.length) {
                // array = copyOf(array, array.length*2);
                size -= 2; // ignore last elem
            }
            int idx = 0;
            while (idx < size && array[idx + 1] > score) {
                idx += 2;
            }
            System.arraycopy(array, idx, array, idx + 2, size - idx);
            array[idx] = elem;
            array[idx + 1] = score;
            size += 2;
        }

        public int[] getArray() {
            return array;
        }

        public int getSize() {
            return size;
        }

        // public void remove2Elem(int idx) {
        // size -= 2;
        // System.arraycopy(array, idx + 2, array, idx, size - idx);
        // }
        //
        // public void addArray(int[] arr, int start, int end) {
        // int len = end - start;
        // if (size + len >= array.length) {
        // array = Arrays.copyOf(array, size + len);
        // }
        // System.arraycopy(arr, 0, array, size, len);
        // size += len;
        // }
        //
        // public boolean contains(int lidx, int row) {
        // for (int i=0; i<size; i+=2) {
        // if (array[i] == lidx && array[i+1] == row)
        // return true;
        // }
        // return false;
        // }

        public void clear() {
            size = 0;
        }

    }

    // private void simpleCopy(int startRow) {
    // for (int row=startRow+2; row<H; row+=2) {
    // scanRow(row);
    // }
    //
    // for (int row=startRow+1; row<H; row+=2) {
    // for (int c=0; c<W; c++) {
    // if (img[row-1][c] == '1') {
    // if (row+1 >= H) {
    // img[row][c] = '1';
    // } else if (img[row+1][c] == '1') {
    // img[row][c] = '1';
    // }
    // } else {
    // if (c+1<W && row+1 < H && img[row+1][c] == '1') {
    // if (img[row-1][c+1] == '1') {
    // img[row][c] = '1';
    // }
    // }
    // }
    // }
    // }
    // }

    private void simpleCopy2(int startRow) {
        /*
         * for (int row=startRow; row<H; row+=3) { scanRow(row); }
         */
        for (int row = startRow; row < H - 1; row += 3) {
            for (int c = 0; c < W; c++) {
                if (img[row][c] == '1') {
                    img[row + 1][c] = '1';
                }
                if (row + 3 < H && img[row + 3][c] == '1') {
                    img[row + 2][c] = '1';
                }
            }
        }
    }

    // private void simpleCopy3(int startRow) {
    // for (int row=startRow; row<H; row+=4) {
    // scanRow(row);
    // }
    // for (int row=startRow; row<H-1; row+=4) {
    // for (int c=0; c<W; c++) {
    // if (img[row][c] == '1') {
    // img[row+1][c] = '1';
    // }
    // if (row+4 < H && img[row+4][c] == '1') {
    // img[row+3][c] = '1';
    // if (img[row+1][c] == '1') {
    // img[row+2][c] = '1';
    // }
    // }
    // }
    // }
    // }

//    private void displayPossible(int r) {
//        int maxbc = 0;
//        int maxbcidx = 0;
//        int rowPossible = 0;
//        for (int i = 0; i < W; i++) {
//            int[] arr1 = possible[r][i].getArray();
//            for (int p = 0; p < possible[r][i].getSize(); p += 2) {
//                int bc = Letters.letters[arr1[p]][arr1[p + 1]];
//                bc = Integer.bitCount(bc);
//                if (bc >= maxbc) {
//                    maxbc = bc;
//                    maxbcidx = arr1[p];
//                }
//                System.out.println("row=" + r + ", col=" + i + ", pos=" + p
//                        + " : " + Letters.lettersNames[arr1[p]] + ","
//                        + arr1[p + 1] + "," + bc);
//            }
//            int cnt = possible[r][i].getSize() / 2;
//            rowPossible += cnt;
//            if (cnt > 0) {
//                System.out.println("possible in " + i + "=" + cnt);
//                System.out.println("maxbc " + maxbc + ","
//                        + Letters.lettersNames[maxbcidx]);
//            }
//        }
//        System.out.println("possible in row " + r + "=" + rowPossible);
//    }
//
//    private void countPossible() {
//        int row;
//        int possibleCount = 0;
//        for (row = 0; row < H; row++) {
//            for (int c = 0; c < W; c++) {
//                int[] poss = possible[row][c].getArray();
//                for (int p = 0; p < possible[row][c].getSize(); p += 2) {
//                    possibleCount++;
//                }
//            }
//        }
//        System.out.println("Possible count " + possibleCount);
//    }

    private static int binToInt(char[] s, int start, int end) {
        int res = 0;
        int bn = 0;
        for (int i = end - 1; i >= start; i--) {
            if (s[i] == '1') {
                res |= (1 << bn);
            }
            bn++;
        }
        return res;
    }

    public boolean scanRow(int rnum) {
        // if (isScanned[rnum])
        // return scannedRows[rnum].indexOf('1') >= 0;
        String row = ImageToScan.scan(rnum);
        boolean hasBlack = false;
        for (int c = 0; c < row.length(); c++) {
            img[rnum][c] = row.charAt(c);
            img2[rnum][c] = img[rnum][c];
            if (img[rnum][c] == '1') {
                numBlack++;
                hasBlack = true;
            }
        }

        for (int i = W, nbyte = 0; i >= 0; i -= 32, nbyte++) {
            int start = Math.max(0, i - 32);
            imgVal[rnum][nbyte] = binToInt(img[rnum], start, i);
            //imgValOrg[rnum][nbyte] = imgVal[rnum][nbyte]; 
        }
        
//        for (int i = W; i > 0; i--) {
//            imgValFull[rnum][i-1] = getImgVal(imgValOrg, rnum, i);
//        }
        
        // scannedRows[rnum] = row;
        isScanned[rnum] = true;
        scannedCount++;
        return hasBlack;
    }
    
//    private int getImgVal(int[][] tab, int row, int col) {
//        int nbitAll = W - col;
//        int nbyte = nbitAll / 32;
//        int nbit = nbitAll % 32;
//        int v = tab[row][nbyte] >>> nbit;
//        if (nbyte < 10 && (nbitAll % 32)!=0) {
//            v |= tab[row][nbyte+1] << (32-nbit);
//        }
//        return v;
//    }

    private void analyse(int rnum, int lRowMin, int lRowMax) {
        // ArrayList<MaxLetter> maxList = maxLetters2.get(rnum);
        for (int i = W; i > 0; i--) {
            int s = Math.max(i - 32, 0);
            // String ss = scannedRows[rnum].substring(s, i);
            // int v = (int)Long.parseLong(ss, 2);
            // int v = binToInt(ss);
            //int v = binToInt(img[rnum], s, i);
//            int v = imgValFull[rnum][i-1];
            int v = binToInt(img[rnum], s, i);
//            if (v!=v2) 
//                System.out.println(v + "<>" + v2);
            
            
            for (Integer bm : Letters.lettersMap.keySet()) {
                if ((v & bm.intValue()) == bm.intValue()) {
                    int[] lettersAll = Letters.lettersMap.get(bm);
                    int start = 0;
                    while (start < lettersAll.length
                            && lettersAll[start + 1] < lRowMin) {
                        start += 2;
                    }
                    int end = start;
                    while (end < lettersAll.length
                            && lettersAll[end + 1] <= lRowMax) {
                        end += 2;
                    }

                    int col = i - 1;
                    for (int p = start; p < end; p += 2) {
                        int lidx = lettersAll[p];
                        int lHeight = Letters.letters[lidx].length;
                        int lrow = lettersAll[p + 1];
                        int lStartRow = rnum - lrow;
                        if (col - Letters.lettersWidth[lidx] >= 0
                                && lStartRow >= 0 && lStartRow + lHeight < H) {
                            int score = canPlace(lidx, rnum, lrow, i);
                            if (score > 0) {
                                possible[lStartRow][col].add(lidx, score);
                                // maxList.add(new MaxLetter(lStartRow, col,
                                // lidx, score));
                            }
                        }
                    }
                }
            }
        }
        // Collections.sort(maxList);
    }

    private int canPlace(int lidx, int rnum, int lrow, int col) {
        int s = Math.max(col - 32, 0);
        // rnum += STEP;
        // lrow += STEP;
        int bc = 0;
        while (lrow < Letters.letters[lidx].length) {
            int v = binToInt(img[rnum], s, col);
            //int v = imgValFull[rnum][col-1];
            //if (v!=v2)
            //    System.out.println(v + "!=" + v2);
            int lv = Letters.letters[lidx][lrow];
            if ((v & lv) != lv) {
                return -1;
            }
            int lv2 = binToInt(img2[rnum], s, col) & lv;
            //int lv2 = getImgVal(imgVal, rnum, col) & lv;
            bc += Integer.bitCount(lv2);
            if (v == lv) {
                bc += Integer.bitCount(lv2);
            }
            rnum += STEP;
            lrow += STEP;
        }
        return bc;
    }

    private void insertLetter(int lIdx, int top, int right) {
        numLetters++;
        debug(numLetters + ". insert " + Letters.lettersNames[lIdx] + " on "
                + top + "," + (right - Letters.lettersWidth[lIdx] + 1));
        int[] letter = Letters.letters[lIdx];
        for (int r = 0; r < letter.length; r++) {
            for (int c = 0; c < 32; c++) {
                if ((letter[r] & (1 << c)) > 0) {
                    // System.out.println("top " + (top+r) +",c" + (right-c));
                    int col = right - c;
                    if (img[top + r][col] == '0') {
                        numBlack++;
                        img[top + r][col] = '1';
                    }
                    img2[top + r][col] = '0';
                    col = W - col - 1;
                    int nbyte = col / 32;
                    int nbit = 1 << (col % 32);
                    imgVal[top + r][nbyte] = imgVal[top + r][nbyte] & ~nbit;
                }
            }
        }
        debugln(" (black=" + numBlack + ")");
    }

    public String[] restore(int H, int W, int nb, int nLetter) {
        time = System.currentTimeMillis();
        this.W = W;
        this.H = H;
        this.nLetter = nLetter;
        this.nb = nb;
        img = new char[H][W];
        img2 = new char[H][W];
        for (int i = 0; i < H; i++) {
            Arrays.fill(img[i], '0');
            Arrays.fill(img2[i], '0');
        }
        imgVal = new int[H][10];
        //imgValOrg = new int[H][10];
        //imgValFull = new int[H][W];
        // scannedRows = new String[H];
        isScanned = new boolean[H];
        possible = new FastIntArray[H][W];
        // maxLetters2 = new ArrayList<ArrayList<MaxLetter>>();
        for (int r = 0; r < H; r++) {
            for (int c = 0; c < W; c++) {
                possible[r][c] = new FastIntArray(100);
            }
            // maxLetters2.add(l);
        }
        placed = new ArrayList<Rectangle>();

        int startRow = 0;
        while (!scanRow(startRow++)) {
        }
        startRow--;
        // System.out.println("StartRow " + startRow);
        int row = startRow + STEP;
        while (row < H) {
            scanRow(row);
            row += STEP;
        }

        // System.out.println("Scanned count " + scannedCount);

        // countPossible();

        guess(startRow);

        // displayPossible(startRow);

        // simpleCopy(startRow);
        // simpleCopy2(startRow);
        // simpleCopy3(startRow);

        // insertLetter(850, 3, 26); // UB20 3,15 (850)
        // insertLetter(307, 7, 25); // HB23 7,13 (307)
        // insertLetter(912, 10, 14); // VP19 10,2 (912)

        String[] ret = new String[H];
        for (int i = 0; i < H; i++) {
            ret[i] = new String(img[i]);
            debug(isScanned[i] ? "*" : " ");
            debugln(ret[i]);
        }

        System.out.println("Time: " + (System.currentTimeMillis() - time));
        return ret;
    }

    private static final class MaxLetter implements Comparable<MaxLetter> {
        final int row;
        final int col;
        final int lidx;
        final int score;

        public MaxLetter(int row, int col, int lidx, int score) {
            this.row = row;
            this.col = col;
            this.lidx = lidx;
            this.score = score;
        }

        public int compareTo(MaxLetter o) {
            return o.score - this.score;
        }
    }

    public boolean placeNotOverlapping(int left, int top, int width,
            int height, int score) {
        Rectangle thisLetter = new Rectangle(left, top, width, height);
        if (/*width * height < 400 && */score < passScore) 
        {
            int thisIntSize = width + height;
            for (Rectangle r : placed) {
                Rectangle interRect = thisLetter.intersection(r);
                int intSize = (interRect.width + interRect.height) * 2;
                int otherSize = r.width + r.height;
                if (intSize > thisIntSize || intSize > otherSize)
                    return false;
            }
        }
        placed.add(thisLetter);
        return true;
    }

    private boolean isGuessed(int row) {
        for (int i = 0; i < 10; i++)
            if (imgVal[row][i] != 0)
                return false;
        return true;
    }

    private boolean tryPlace(int row, int col, int letter, int score) {
        int left = col - Letters.lettersWidth[letter];
        int width = Letters.lettersWidth[letter];
        int height = Letters.letters[letter].length;
        if (placeNotOverlapping(left, row, width, height, score)) {
            insertLetter(letter, row, col);
            //int bottom = row + height;
            // for (; row<bottom; row++)
            {
                for (int c = col - width + 1; c <= col; c++) {
                    possible[row][c].clear();
                }
            }
            return true;
        }
        return false;
    }

    private int prepareMaxInRow(int row) {
        maxLetters = new ArrayList<MaxLetter>();
        int minRow = Math.max(0, row - STEP + 1);
        for (int r = minRow; r <= row; r++) {
            for (int c = W - 1; c >= 0; c--) {
                FastIntArray possObj = possible[r][c];
                int[] poss = possObj.getArray();
                for (int p = 0; p < possObj.getSize(); p += 2) {
                    int s = poss[p + 1];
                    maxLetters.add(new MaxLetter(r, c, poss[p], s));
                    if (s > 10) {
                        passScoreSum += poss[p+1];
                        passScoreNum++;
                    }
                }
            }
        }
        Collections.sort(maxLetters);
        if (maxLetters.size() > 10) {
            int x = maxLetters.get(10).score;
            if (x < 20)
                return 20;         
            return x;
        }
        return 20;
    }

    private void guess(int startRow) {
        for (int row = startRow; row < H; row += STEP) {
            analyse(row, 0, row == startRow ? 0 : STEP - 1);
            if (!isGuessed(row)) {
                // List<MaxLetter> maxList = maxLetters2.get(row);
                passScore = prepareMaxInRow(row);
                
                //passScore = 20;
                //System.out.println(passScoreSum + " / " + passScoreNum + " = " + passScoreSum / passScoreNum);
                //passScore = passScoreSum / passScoreNum;
                
                List<MaxLetter> maxList = maxLetters;
                int maxIdx = 0;
                int placed = 0;
                while (!isGuessed(row)) {
                    if (maxIdx >= maxList.size())
                        break;
                    MaxLetter max = maxList.get(maxIdx++);
                    //MaxLetter max = maxList.remove(0);
                    if (tryPlace(max.row, max.col, max.lidx, max.score)) {
                        placed++;
                        passScore++;
                        if (W / placed < 2)
                            break;
                    }
//                    if (placed && !isGuessed(row)) {
//                        for (Iterator<MaxLetter> it = maxList.iterator(); it.hasNext();) {
//                            MaxLetter ml = it.next();
//                            ml.score = canPlace(ml.lidx, ml.row, 0, ml.col);
//                        }
//                        Collections.sort(maxList);
//                    }
                }
            }
            if (System.currentTimeMillis() - time > TIME_OFFSET) {
                simpleCopy2(row + STEP);
                break;
            }
        }
    }

    public static void main(String[] args) {
        for (int i = 3; i <= 3; i++) {
            System.out.println("Case " + i);
            new ImageScannerVisExt(new ImageScanner(), Integer.toString(i));
        }
    }

}
