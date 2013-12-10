

public class AdditionGame {
	
	
	public int getMaximumPoints(int A, int B, int C, int N) {
		int res = 0;
		int idx = 0;
		while (idx < N) {
			int choice = Math.max(Math.max(A, B), C);
			if (choice == 0)
				break;
			if (A == choice)
				A--;
			else if (B == choice)
				B--;
			else if (C == choice)
				C--;
			res += choice;
			idx++;
		}
		return res;
	}
	
	
	public void test(int idx, int A, int B, int C, int N, int res) {
		int r = getMaximumPoints(A, B, C, N);
		if (r != res) {
			System.out.println(idx);
			System.out.println(res);
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		AdditionGame main = new AdditionGame();
		
		main.test(1, 3, 4, 5, 3, 13);
		main.test(2, 1, 1, 1, 8, 3);
		main.test(3, 3, 5, 48, 40, 1140);
		main.test(10, 50, 50, 50, 150, 1140);
	}

}
