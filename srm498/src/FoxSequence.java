
public class FoxSequence {
	
	public String isValid(int[] seq) {
		int N = seq.length;
		if (N < 2)
			return "NO";
		int difA = seq[1] - seq[0];
		if (difA <= 0)
			return "NO";
		int a = 1;
		while (a + 1 < N && seq[a + 1] == seq[a] + difA)
			a++;
		if (a + 1 >= N)
			return "NO";
		int b = a + 1;
		int difB = seq[b] - seq[a];
		if (difB >= 0)
			return "NO";
		while (b + 1 < N && seq[b + 1] == seq[b] + difB)
			b++;
		if (b + 1 >= N)
			return "NO";
		int c = b;
		while (c + 1 < N && seq[c + 1] == seq[b])
			c++;
		if (c + 1 >= N)
			return "NO";
		int d = c + 1;
		int difD = seq[d] - seq[c];
		if (difD <= 0)
			return "NO";
		while (d + 1 < N && seq[d + 1] == seq[d] + difD)
			d++;
		if (d + 1 >= N)
			return "NO";
		int e = d + 1;
		int difE = seq[e] - seq[d];
		if (difE >= 0)
			return "NO";
		while (e + 1 < N && seq[e + 1] == seq[e] + difE)
			e++;
		if (e+1 != N)
			return "NO";
		return "YES";
	}
	
	
	public void test(int idx, int[] seq, boolean valid) {
		String res = isValid(seq);
		String expected = valid ? "YES" : "NO";
		if (!expected.equals(res)) {
			System.out.println(idx);
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FoxSequence main = new FoxSequence();
		
		int[] a = {1,3,5,7,5,3,1,1,1,3,5,7,5,3,1};
		main.test(0, a, true);
		
		int[] b = {1,2,3,4,5,4,3,2,2,2,3,4,5,6,4};
		main.test(1, b, true);

		int[] c = {3,6,9,1,9,5,1};
		main.test(2, c, true);

		int[] d = {1,2,3,2,1,2,3,2,1,2,3,2,1};
		main.test(3, d, false);

		int[] e = {1,3,4,3,1,1,1,1,3,4,3,1};
		main.test(4, e, false);
		
		int[] f = {6,1,6};
		main.test(5, f, false);
	
		int[] g = {6,1};
		main.test(6, g, false);

		int[] h = {1};
		main.test(7, h, false);

	
	}
	
	
}
