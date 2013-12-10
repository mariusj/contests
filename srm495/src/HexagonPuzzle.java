
public class HexagonPuzzle {
	private final int MOD = 1000000007;
	private int N;
	private boolean[][] visited;
	private char[][] board;
	

	
	public int theCount(String[] board) {
		N = board.length;
		visited = new boolean[N][N];
		this.board = new char[N][N];
		for (int y=0; y<N; y++) {
			for (int x=0; x<=y; x++) {
				this.board[y][x] = board[y].charAt(x);
			}
		}
		
		long[] ways = new long [N*N+5];
		// ways[x] will be x!/2 or 1 for values of x lower than 3.
	    ways[0] = ways[1] = ways[2] = 1;
	    for (int i=3; i<=N*N; i++) {
	        ways[i] = (i * ways[i-1]) % MOD;
	    }
		
		
		long res = 1;
		for (int y=0; y<N; y++) {
			for (int x=0; x<=y; x++) {
				int cnt = dfs(x, y);
				if (cnt > 1) {
					res = (res * ways[cnt]) % MOD;
				}
			}
		}
	 	
		return (int) (res % MOD);
	}

	private int dfs(int x, int y) {
		if (visited[y][x])
			return 0;
		if (board[y][x] == 'X')
			return 0;
		visited[y][x] = true;
		int cnt = 0;
		if (y+1<N && board[y+1][x] == '.' && x<=y+1 && board[y+1][x+1] == '.') {
			cnt++;
			if (!visited[y+1][x]) {
				visited[y+1][x] = true;
				cnt++;
			}
			if (visited[y+1][x+1]) {
				visited[y+1][x+1] = true;
				cnt++;
			}
		} else 
		if (x+1<=y && board[y][x+1] == '.' && y+1<N && board[y+1][x+1] == '.') {
			cnt++;
			if (!visited[y][x+1]) {
				visited[y][x+1] = true;
				cnt++;
			}
			if (visited[y+1][x+1]) {
				visited[y+1][x+1] = true;
				cnt++;
			}
		}
		
		if (y+1<N)
			cnt += dfs(y+1, x);
		if (x+1<=y)
			cnt += dfs(y, x+1);
		
		return cnt;
	}

	public static void main(String[] args) {
		long time;
		int answer;
		boolean errors = false;
		int desiredAnswer;

		time = System.currentTimeMillis();
		answer = new HexagonPuzzle().theCount(new String[] { ".", ".X", "X..",
				".X.X" });
		System.out.println("Time: " + (System.currentTimeMillis() - time)
				/ 1000.0 + " seconds");
		desiredAnswer = 3;
		System.out.println("Your answer:");
		System.out.println("\t" + answer);
		System.out.println("Desired answer:");
		System.out.println("\t" + desiredAnswer);
		if (answer != desiredAnswer) {
			errors = true;
			System.out.println("DOESN'T MATCH!!!!");
		} else
			System.out.println("Match :-)");
		System.out.println();
		time = System.currentTimeMillis();
		answer = new HexagonPuzzle().theCount(new String[] { "X" });
		System.out.println("Time: " + (System.currentTimeMillis() - time)
				/ 1000.0 + " seconds");
		desiredAnswer = 1;
		System.out.println("Your answer:");
		System.out.println("\t" + answer);
		System.out.println("Desired answer:");
		System.out.println("\t" + desiredAnswer);
		if (answer != desiredAnswer) {
			errors = true;
			System.out.println("DOESN'T MATCH!!!!");
		} else
			System.out.println("Match :-)");
		System.out.println();
		time = System.currentTimeMillis();
		answer = new HexagonPuzzle().theCount(new String[] { ".", "..", "...",
				".X.." });
		System.out.println("Time: " + (System.currentTimeMillis() - time)
				/ 1000.0 + " seconds");
		desiredAnswer = 20160;
		System.out.println("Your answer:");
		System.out.println("\t" + answer);
		System.out.println("Desired answer:");
		System.out.println("\t" + desiredAnswer);
		if (answer != desiredAnswer) {
			errors = true;
			System.out.println("DOESN'T MATCH!!!!");
		} else
			System.out.println("Match :-)");
		System.out.println();
		time = System.currentTimeMillis();
		answer = new HexagonPuzzle().theCount(new String[] { ".", "..", "XXX",
				"..X.", ".X..X", "XXXX..", "..X.X.X", "..X.XX.." });
		System.out.println("Time: " + (System.currentTimeMillis() - time)
				/ 1000.0 + " seconds");
		desiredAnswer = 108;
		System.out.println("Your answer:");
		System.out.println("\t" + answer);
		System.out.println("Desired answer:");
		System.out.println("\t" + desiredAnswer);
		if (answer != desiredAnswer) {
			errors = true;
			System.out.println("DOESN'T MATCH!!!!");
		} else
			System.out.println("Match :-)");
		System.out.println();
		time = System.currentTimeMillis();
		answer = new HexagonPuzzle().theCount(new String[] { ".", "..", "...",
				"....", ".....", "......", ".......", "........" });
		System.out.println("Time: " + (System.currentTimeMillis() - time)
				/ 1000.0 + " seconds");
		desiredAnswer = 261547992;
		System.out.println("Your answer:");
		System.out.println("\t" + answer);
		System.out.println("Desired answer:");
		System.out.println("\t" + desiredAnswer);
		if (answer != desiredAnswer) {
			errors = true;
			System.out.println("DOESN'T MATCH!!!!");
		} else
			System.out.println("Match :-)");
		System.out.println();

		if (errors)
			System.out.println("Some of the test cases had errors :-(");
		else
			System.out
					.println("You're a stud (at least on the test data)! :-D ");
	}
}
