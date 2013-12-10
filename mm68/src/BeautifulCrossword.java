import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class BeautifulCrossword {

	private char cw[][];
	private int N;
	private int xx;
	private int yy;
	private int midScore;
	boolean horizVert = true;
	
	private void insertWord(String word, int x, int y, boolean horiz) {
		//System.out.println("insert " + word + "@" + x + "," + y);
		if (horiz) {
			for (int i=0; i<word.length(); i++) {
				cw[y][x + i] = word.charAt(i);
			}
		} else {
			for (int i=0; i<word.length(); i++) {
				cw[y + i][x] = word.charAt(i);
			}
		}
	}

	public String[] generateCrossword(int N, String[] words, int[] weights) {
		long time = System.currentTimeMillis();
		
		
		this.N = N;
		cw = new char[N][N];
		for (int i = 0; i < N; i++) {
			Arrays.fill(cw[i], '.');
		}
		
		List<String> words2 = new ArrayList<String>(Arrays.asList(words));
		for (Iterator<String> i = words2.iterator(); i.hasNext(); ) {
			if (i.next().length() > N) {
				i.remove();
			}
		}
		
		Set<String>[] letters = new HashSet[26];
		for (int i=0; i<26; i++) {
			letters[i] = new HashSet<String>();
		}
		
		for (String word : words2) {
			for (int j=0; j<word.length(); j++) {
				char c = word.charAt(j);
				letters[c - 'A'].add(word);
			}
		}
		
		final Map<String, Integer> scores = new HashMap<String, Integer>();
		for (String word: words2) {
			int s = 0;
			for (int ci = 0; ci < word.length(); ci++) {
				s += letters[word.charAt(ci) - 'A'].size();
			}
			scores.put(word, Integer.valueOf(s));
		}
				
		Collections.sort(words2, new Comparator<String>() {
			public int compare(String o1, String o2) {
				return scores.get(o2).intValue() - scores.get(o1).intValue();
			}
		});

		boolean used[] = new boolean[words2.size()];

		String word = words2.get(0);
		used[0] = true;
		insertWord(word, (N - word.length()) / 2, N/2, true);

		/*int exit = 0;
		while (true) {
			exit++;
			int maxScore = Integer.MIN_VALUE;
			int maxWord = -1;
			int maxX = -1;
			int maxY = -1;
			for (int w=1; w<words2.size(); w++) {
				if (!used[w]) {
					word = words2.get(w);
					int s = tryInsert(word);
					if (s > maxScore) {
						maxScore = s;
						maxWord = w;
						maxX = xx;
						maxY = yy;
						break;
					}
				}
			}
			
			if (maxScore != Integer.MIN_VALUE) {
				used[maxWord] = true;
				insertWord(words2.get(maxWord), maxX, maxY, horizVert);
				exit = 0;
				horizVert = !horizVert;
			}
			
			if (exit == 2)
				break;
			if (exit == 1)
				horizVert = !horizVert;
		}
		*/
		
		for (int t=0; t<2; t++) {
			horizVert = (t % 2 == 1);
			for (int w=0; w<words2.size(); w++) {
				if (!used[w]) {
					word = words2.get(w);
					int s = tryInsert(word);
					if (s != Integer.MIN_VALUE) {
						used[w] = true;
						insertWord(words2.get(w), xx, yy, horizVert);
						horizVert = !horizVert;
					}
				}
			}
		}

		/*for (int t=0; t<2; t++) {
			horizVert = (t % 2 == 1);
			for (int w=0; w<words2.size(); w++) {
				if (!used[w]) {
					word = words2.get(w);
					int s = tryInsert(word);
					if (s != Integer.MIN_VALUE) {
						used[w] = true;
						insertWord(words2.get(w), xx, yy, horizVert);
					}
				}
			}
		}*/
		
		
		String[] res = new String[N];
		for (int i = 0; i < N; i++) {
			res[i] = new String(cw[i]);
			//System.out.println(res[i]);
		}

		
/*		int i=0;
		res[i++] = "BORER.BOTAS";
		res[i++] = "R......V..I";
		res[i++] = "A....C.E..N";
		res[i++] = "S.F..O.R..E";
		res[i++] = "H.U..C..T.W";
		res[i++] = "..STACKER..";
		res[i++] = "..E..O..A..";
		res[i++] = "S.L..I..Y.U";
		res[i++] = "I..INDEX..M";
		res[i++] = "M.........P";
		res[i++] = "AHED..SINUS";*/

//		System.out.println("Time: " + (System.currentTimeMillis() - time)
//				/ 1000.0 + " seconds");

		return res;
	}
	

	private int tryInsert(String word) {
		xx = Integer.MAX_VALUE;
		yy = Integer.MAX_VALUE;
		midScore = Integer.MIN_VALUE;
		
		if (horizVert) {
			tryInsertHoriz(word);
		} else {
			tryInsertVert(word);
		}
		
		return midScore; 
	}

	private void tryInsertVert(String word) {
		for (int x=0; x<N; x++) {
			for (int y=0; y<=N-word.length(); y++) {
				int currScore = 0;
				boolean fit = true;
				for (int c=0; c<word.length(); c++) {
					if (cw[y+c][x] != '.' && cw[y+c][x] != word.charAt(c)) {
						fit = false;
						break;
					}
					if (cw[y+c][x] == '.') {
						if (x > 0 && cw[y+c][x-1] != '.') {
							fit = false;
							break;
						}
						if (x < N - 1 && cw[y+c][x+1] != '.') {
							fit = false;
							break;
						}
					} else {
						currScore += 10000;
					}
				}
				int c = word.length();
				if (y > 0 && cw[y-1][x] != '.')
					fit = false;
				if (y+c < N && cw[y+c][x] != '.')
					fit = false;
				if (fit) {
					int s = currScore;
					//s += (N/2 - Math.abs(N/2 - x))*100 + N/2 - Math.abs(N/2 - y);
					s += calcSym(x, y, x+1, y+word.length()); 
					if (s > midScore) {
						midScore = s;
						xx = x;
						yy = y;
					}
				}
			}
		}
	}
	
	private void tryInsertHoriz(String word) {
		for (int y=0; y<N; y++) {
			for (int x=0; x<=N-word.length(); x++) {
				int currScore = 0;
				boolean fit = true;
				for (int c=0; c<word.length(); c++) {
					if (cw[y][x+c] != '.' && cw[y][x+c] != word.charAt(c)) {
						fit = false;
						break;
					}
					if (cw[y][x+c] == '.') {
						if (y > 0 && cw[y-1][x+c] != '.') {
							fit = false;
							break;
						}
						if (y < N - 1 && cw[y+1][x+c] != '.') {
							fit = false;
							break;
						}
					} else {
						currScore += 10000;
					}
				}
				int c = word.length();
				if (x > 0 && cw[y][x-1] != '.')
					fit = false;
				if (x+c < N && cw[y][x+c] != '.')
					fit = false;
				if (fit) {
					int s = currScore;
					//s += (N/2 - Math.abs(N/2 - y))*100 + N/2 - Math.abs(N/2 - x); 
					s += calcSym(x, y, x+word.length(), y+1); 
					if (s > midScore) {
						midScore = s;
						xx = x;
						yy = y;
					}
				}
			}
		}
	}
	
	
	int calcSym(int x1, int y1, int x2, int y2) {
		for (int y=y1; y<y2; y++) {
			for (int x=x1; x<x2; x++) {
				if (cw[y][x] == '.')
					cw[y][x] = '@';
			}
		}
		double s = symmetry() * 100000;
		for (int y=y1; y<y2; y++) {
			for (int x=x1; x<x2; x++) {
				if (cw[y][x] == '@')
					cw[y][x] = '.';
			}
		}
		//System.out.println(s);
		return (int) s;
	}
	
	double symmetry() {
		double symmetryScore = 0.0, nc = 0, cellScore;
		int nEqual;
		for (int i = 0; i < (N + 1) / 2; i++)
			for (int j = 0; j <= i; j++) {
				nEqual = (cw[i][j] == '.' ? 1 : 0)
						+ (cw[i][N - j - 1] == '.' ? 1 : 0)
						+ (cw[N - i - 1][j] == '.' ? 1 : 0)
						+ (cw[N - i - 1][N - j - 1] == '.' ? 1 : 0)
						+ (cw[j][i] == '.' ? 1 : 0)
						+ (cw[j][N - i - 1] == '.' ? 1 : 0)
						+ (cw[N - j - 1][i] == '.' ? 1 : 0)
						+ (cw[N - j - 1][N - i - 1] == '.' ? 1 : 0);
				nEqual = Math.max(nEqual, 8 - nEqual);
				cellScore = 0;
				if (nEqual == 8)
					cellScore = 1;
				if (nEqual == 7)
					cellScore = 0.5;
				if (nEqual == 6)
					cellScore = 0.1;
				symmetryScore += cellScore;
				nc++;
				// System.out.println(i+" "+j+" "+nEqual+": "+board[i][j]+board[i][N-j-1]+board[N-i-1][j]+board[N-i-1][N-j-1]+board[j][i]+board[j][N-i-1]+board[N-j-1][i]+board[N-j-1][N-i-1]+" -> "+cellScore);
			}
		symmetryScore /= nc;
		return symmetryScore;
	}
	
	
}
