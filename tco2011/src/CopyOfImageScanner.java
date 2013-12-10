//import java.awt.Rectangle;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//
//public class CopyOfImageScanner {
//	
//	private char[][] img;
//	private int W;
//	private int H;
//	private FastIntArray[][] possible;
//	private int numBlack = 0;
//	int numLetters = 0;
//	int scannedCount = 0;
//	private String[] scannedRows;
//	private boolean[] isScanned;
//	private List<Rectangle> placed;
//	
//	private static final class FastIntArray {
//		int size = 0;
//		int[] array;
//		
//		public FastIntArray(int capacity) {
//			array = new int[capacity];
//		}
//		
//		public void add(int i) {
//			if (size == array.length) {
//				array = Arrays.copyOf(array, array.length*2);
//			}
//			array[size++] = i;
//		}
//		
//		public int get(int i) {
//			return array[i];
//		}
//		
//		public int[] getArray() {
//			return array;
//		}
//		
//		public int getSize() {
//			return size;
//		}
//		
//	}
//	
//	private void simpleCopy(int startRow) {
//		for (int row=startRow+2; row<H; row+=2) {
//			scanRow(row);
//		}
//		
//		for (int row=startRow+1; row<H; row+=2) {
//			for (int c=0; c<W; c++) {
//				if (img[row-1][c] == '1') {
//					if (row+1 >= H) {
//						img[row][c] = '1';
//					} else if (img[row+1][c] == '1') {
//						img[row][c] = '1';
//					} 
//				} else {
//					if (c+1<W && row+1 < H && img[row+1][c] == '1') {
//						if (img[row-1][c+1] == '1') {
//							img[row][c] = '1';
//						}
//					}
//				}
//			}
//		}
//	}
//	
//	private void simpleCopy2(int startRow) {
//		for (int row=startRow; row<H; row+=3) {
//			scanRow(row);
//		}
//		for (int row=startRow; row<H-1; row+=3) {
//			for (int c=0; c<W; c++) {
//				if (img[row][c] == '1') {
//					img[row+1][c] = '1';
//				} 
//				if (row+3 < H && img[row+3][c] == '1') {
//					img[row+2][c] = '1';
//				} 
//			}
//		}
//	}
//	
//	private void simpleCopy3(int startRow) {
//		for (int row=startRow; row<H; row+=4) {
//			scanRow(row);
//		}
//		for (int row=startRow; row<H-1; row+=4) {
//			for (int c=0; c<W; c++) {
//				if (img[row][c] == '1') {
//					img[row+1][c] = '1';
//				} 
//				if (row+4 < H && img[row+4][c] == '1') {
//					img[row+3][c] = '1';
//					if (img[row+1][c] == '1') {
//						img[row+2][c] = '1';
//					}
//				} 
//			}
//		}
//	}
//
//	private void displayPossible(int r) {
//		int maxbc = 0;
//		int maxbcidx = 0;
//		for (int i=0; i<W; i++) {
//			int[] arr1 = possible[r][i];
//			if (arr1 != null) {
//				int cnt = 0;
//				for (int p=0; p<arr1.length; p+=2) {
//					if (arr1[p] < 0)
//						break;
//					int bc = Letters.letters[arr1[p]][arr1[p+1]];
//					bc = Integer.bitCount(bc);
//					if (bc >= maxbc) {
//						maxbc = bc;
//						maxbcidx = arr1[p];
//					}
//					//System.out.println("row=" + r + ", col=" + i + ", pos=" + p + " : " + arr1[p] + "," + arr1[p+1] + "," + bc);
//					cnt = p / 2;
//				}
//				if (cnt > 0) {
//					System.out.println("possible in " + i + "=" + cnt);
//					System.out.println("maxbc " + maxbc + "," + maxbcidx);
//				}
//			}
//		}
//	}
//	
//    public static void noop() {}
//	
//	private void countPossible() {
//		int row;
//		int possibleCount = 0;
//		for (row = 0; row<H; row++) {
//			for (int c=0; c<W; c++) {
//				int[] poss = possible[row][c]; 
//				if (poss != null) {
//					for (int p=0; p<poss.length && poss[p]>=0; p+=2) {
//						possibleCount++;
//					}
//				}
//			}
//		}
//		System.out.println("Possible count " + possibleCount);
//	}
//
//	
//	private static int binToInt(char[] s, int start, int end) {
//		int res = 0;
//		int bn = 0;
//		for (int i=end-1; i>=start; i--) {
//			if (s[i] == '1') {
//				res |= (1 << bn);
//			}
//			bn++;
//		}
//		return res;
//	}
//
//	public boolean scanRow(int rnum) {
//		if (isScanned[rnum])
//			return scannedRows[rnum].indexOf('1') >= 0;
//		String row = ImageToScan.scan(rnum);
//		boolean hasBlack = false;
//		for (int c=0; c<row.length(); c++) {
//			img[rnum][c] = row.charAt(c);
//			if (img[rnum][c] == '1') { 
//				numBlack++;
//				hasBlack = true;
//			}
//		}
//		scannedRows[rnum] = row;
//		isScanned[rnum] = true;
//		scannedCount++;
//		return hasBlack;
//	}
//	
//	private void analyse(int rnum, int lRow) {
//		for (int i=W; i>0; i--) {
//			int s = Math.max(i-32, 0);
//			//String ss = scannedRows[rnum].substring(s, i);
////			int v = (int)Long.parseLong(ss, 2);
//			//int v = binToInt(ss);
//			int v = binToInt(img[rnum], s, i);
//			for (Integer bm : Letters.lettersMap.keySet()) {
//				if ((v & bm.intValue()) == bm.intValue()) {
//					int[] lettersAll = Letters.lettersMap.get(bm);
//					int start = 0;
//					while (start < lettersAll.length && lettersAll[start+1] < lRow) {
//						start+=2;
//					}
//					int end = start;
//					while (end < lettersAll.length && (lRow==-1 || lettersAll[end+1] == lRow)) {
//						end+=2;
//					}
//					
//					if (end > start) {
//						int[] letters2;
//						if (possible[rnum][i-1] == null) {
//							 letters2 = Arrays.copyOfRange(lettersAll, start, end);
//						} else {
//							int llen = possible[rnum][i-1].length;
//							letters2 = new int[llen + end - start];
//							System.arraycopy(possible[rnum][i-1], 0, letters2, 0, llen);
//							System.arraycopy(lettersAll, start, letters2, llen, end - start);
//						}
//						possible[rnum][i-1] = letters2;
//					}
//				}
//			}
//			removeIncorrect(rnum, i-1);
//		}
//	}
//	
//	private void removeIncorrect(int row, int col) {
//		int[] letters = possible[row][col];
//		if (letters == null)
//			return;
//		int end = letters.length;
//		
//		for (int i=0; i<letters.length; i+=2) {
//			int lidx = letters[i];
//			if (lidx == 479 && row==11) {
//				noop();
//			}
//		}
//		
//		
//		for (int i=0; i<end; i+=2) {
//			int lidx = letters[i];
//			int lrow = letters[i+1];
//			int lHeight = Letters.letters[lidx].length;
//			if (lidx == 479 && row==11 && lrow==0) {
//				noop();
//			}
//			if (col-Letters.lettersWidth[lidx] < 0 || row - lrow < 0 || row + lHeight - lrow >= H) {
//				letters[i] = letters[end-2];
//				letters[i+1] = letters[end-1];
//				letters[end-1] = -1;
//				letters[end-2] = -1;
//				end -= 2;
//				i -= 2;
//			}
//		}
//		
//		for (int i=0; i<letters.length; i+=2) {
//			int lidx = letters[i];
//			int lrow = letters[i+1];
//			if (lidx == 479 && row==11 && lrow==0) {
//				noop();
//			}
//		}
//		
//	}
//	
//	private void removeNotCommon(int row1, int row2) {
//		for (int c=0; c<W; c++) {
//			int arr1[] = possible[row1][c];
//			int arr2[] = possible[row2][c];
//			if (arr1 != null) {
//				int end = arr1.length;
//				while (end>0 && arr1[end-1] < 0) 
//					end-=2;
//				for (int a1=0; a1<end; a1+=2) {
//					int lIdx = arr1[a1];
//					if (lIdx < 0)
//						break;
//					int lRow = arr1[a1 + 1];
//					int lHeight = Letters.letters[lIdx].length;
//					if (row2 < row1-lRow || row2 > row1-lRow+lHeight)
//						continue;
//					if (arr2 == null) {
//						arr1[a1] = arr1[end-2];
//						arr1[a1+1] = arr1[end-1];
//						arr1[end-1] = -2;
//						arr1[end-2] = -2;
//						end -= 2;
//						a1 -= 2;
//					} else {
//						boolean found = false;
//						int sr = lRow + row2 - row1;
//						for (int a2=0; a2<arr2.length; a2+=2) {
//							if (arr2[a2] < 0)
//								break;
//							if (lIdx == arr2[a2] && sr == arr2[a2+1]) {
//								found = true;
//								break;
//							}
//						}
//						if (!found) {
//							arr1[a1] = arr1[end-2];
//							arr1[a1+1] = arr1[end-1];
//							arr1[end-1] = -2;
//							arr1[end-2] = -2;
//							end -= 2;
//							a1 -= 2;
//						}
//					}
//				}
//			}
//		}
//	}
//	
//	private void insertLetter(int lIdx, int top, int right) {
//		numLetters++;
//		System.out.println("insert " + lIdx + " on " + top + "," + right);
//		int[] letter = Letters.letters[lIdx];
//		for (int r = 0; r<letter.length; r++) {
//			for (int c=0; c<32; c++) {
//				if ((letter[r] & (1 << c)) > 0) {
////					System.out.println("top " + (top+r) +",c" + (right-c));
//					if (img[top + r][right-c] == '0') {
//						numBlack++;
//						img[top + r][right-c] = '1';
//					}
//				}
//			}
//		}
//	}
//	
//	public String[] restore(int H, int W, int nb, int nLetter) {
//		long time = System.currentTimeMillis();
//		this.W = W;
//		this.H = H;
//		img = new char[H][W];
//		for (int i=0; i<H; i++) {
//			Arrays.fill(img[i], '0');
//		}
//		scannedRows = new String[H];
//		isScanned = new boolean[H];
//		possible = new FastIntArray[H][W];
//		for (int r=0; r<H; r++) {
//			for (int c=0; c<W; c++) {
//				possible[r][c] = new FastIntArray(100);
//			}
//		}
//		placed = new ArrayList<Rectangle>();
//		
//		int startRow = 0;
//		while (!scanRow(startRow++)) { }
//		startRow--;
//		System.out.println("StartRow " + startRow);
//		
////		analyse(startRow, 0);
////		
////		int STEP = 3;
////		
////		int row = startRow + STEP;
////		while (row < H) {
////			scanRow(row);
////			analyse(row, -1);
////			int another = row-STEP;
////			while (another > 0 && row-another<=22) {
////				removeNotCommon(row, another);
////				removeNotCommon(another, row);
////				another -= STEP;
////			}
////			row += STEP;
////		}
////		
////		System.out.println("Scanned count " + scannedCount);
////		
////		countPossible();
//
////		guess(startRow, STEP);
//		
////		simpleCopy(startRow);
////		simpleCopy2(startRow);
//		simpleCopy3(startRow);
//
//
//		
////		insertLetter(912, 10, 14);
////		insertLetter(850, 3, 26);
////		insertLetter(307, 7, 25);
//		
//		String[] ret = new String[H];
//		for (int i=0; i<H; i++) {
//			ret[i] = new String(img[i]);
//			//System.out.println(ret[i]);
//		}
//
//		// VP19 10,2 (912)
//		// UB20 3,15 (850)
//		// HB23 7,13 (307)
//		
////		H = 30
////		W = 30
////		Number of letters = 3
////		Number of black pixels = 221
////		000000000000000000000000000000
////		000000000000000000000000000000
////		000000000000000000000000000000
////		000000000000000111000000111000  <-										
////		000000000000000111000000111000
////		000000000000000111000000111000
////		000000000000000111000000111000
////		000000000000011111000001111000
////		000000000000011111000001111000
////		000000000000011111000001111000
////		001100000000011111000001111000
////		001100000000011111000001111000
////		000110000000111111000001111000
////		000110000000111111000001111000
////		000110000000111111111111111000
////		000011000001111111111111110000 15	0011000001100 1548
////		000011000001111111111111110000
////		000001100011011100111111110000
////		000001100011011100000001110000
////		000001100011011100000001110000
////		000000110110011100000001110000
////		000000110110011100000001110000
////		000000011100011100000001110000
////		000000011100011100000001110000
////		000000000000000000000000000000
////		000000000000000000000000000000
////		000000000000000000000000000000
////		000000000000000000000000000000
////		000000000000000000000000000000
////		000000000000000000000000000000
//		
//		System.out.println("Time: " + (System.currentTimeMillis() - time));
//		return ret;
//	}
//	
//	public boolean placeNotOverlapping(int left, int top, int width, int height) {
//		Rectangle thisLetter = new Rectangle(left, top, width, height);
//		int thisIntSize = width + height;
//		for (Rectangle r : placed) {
//            Rectangle interRect = thisLetter.intersection(r);
//            int intSize = (interRect.width+interRect.height) * 2;
//            int otherSize = r.width + r.height;
//            if (intSize > thisIntSize || intSize > otherSize) 
//            	return false;
//		}
//		placed.add(thisLetter);
//		return true;
//	}
//
//	private void guess(int startRow, int STEP) {
//		int row;
//		for (row = startRow; row<H; row+=STEP) {
//			for (int c=W-1; c>=0; c--) {
//				int[] poss = possible[row][c]; 
//				if (poss != null) {
//					
//					int maxIdx = -1;
//					int maxBC = -1;
//					for (int p=0; p<poss.length && poss[p]>=0; p+=2) {
//						int lIdx = poss[p];
//						int lRow = poss[p+1];
//						int bc = Integer.bitCount(Letters.letters[lIdx][lRow]);
//						if (bc > maxBC) {
//							maxIdx = p;
//							maxBC = bc;
//						}
//					}
//					if (maxIdx == -1)
//						continue;
//					
//					//for (int p=0; p<poss.length && poss[p]>=0; p+=2) {
//						int p = maxIdx;
//						
//						int lIdx = poss[p];
//						int lRow = poss[p+1];
//						
//						
//						int left = c-Letters.lettersWidth[lIdx];
//						int top = row-lRow;
//						int width = Letters.lettersWidth[lIdx];
//						int height = Letters.letters[lIdx].length;
//							
//						if (placeNotOverlapping(left, top, width, height)) {
//							insertLetter(lIdx, top, c);
//						}
//					//}
//				}
//			}
//		}
//	}
//	
//    public static void main(String[] args) {
//    	for (int i=1; i<11; i++) {
//    		System.out.println("Case " + i);
//    		new ImageScannerVisExt(new CopyOfImageScanner(), Integer.toString(i));
//    	}
//    }
//    
//    /*
//     * XXXXX
//     * CCCCC
//     * XXXXX
//     * 
//     * simple copy 1
//     * 0.40271493212669685
//     * 0.30787925300588387
//     * 0.2904836193447738
//     * 0.31473038830372585
//     * 0.3016594680609229
//     * 0.2781204644412192
//     * 0.28544975029459624
//     * 0.2847051597051597
//     * 0.31082398829839103
//     * 0.3014022638959284
//     * 
//     * XXXXXX
//     * CCCCCC
//     * CCCCCC
//     * XXXXXX
//     * 
//     * 
//     * simple copy 2
//     * 0.5520361990950227
//     * 0.40035814786390383
//     * 0.3497659906396256
//     * 0.3741550070743594
//     * 0.3882700613775858
//     * 0.32202467343976776
//     * 0.3624375736490657
//     * 0.3444922194922195
//     * 0.39517308629936615
//     * 0.36729177225882753
//     * 
//     * XXXXXXXXXX
//     * CCCCCCCCCC
//     * CCCCCCCCCC
//     * CCCCCCCCCC
//     * XXXXXXXXXX
//     * 
//     * simple copy 3
//     * 0.5475113122171946
//     * 0.3704272192376567
//     * 0.34477379095163807
//     * 0.40465335639050465
//     * 0.37917708570129577
//     * 0.3387155297532656
//     * 0.342180573480725
//     * 0.3249385749385749
//     * 0.3817649926864944
//     * 0.3662780875147829
//     * 
//     * guess
//     *
//     */
//    
//}
