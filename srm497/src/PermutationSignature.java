import java.util.Arrays;


public class PermutationSignature {

	public int[] reconstruct(String signature) {
		int[] res = new int[signature.length() + 1];
		for (int i=0; i<res.length; i++)
			res[i] = i + 1;
		for (int i=0; i<signature.length(); i++) {
			int j=i;
			while (j >= 0 && signature.charAt(j) == 'D') {
				int tmp = res[j + 1];
				res[j + 1] = res[j];
				res[j] = tmp;
				j--;
			}
		}
		return res;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PermutationSignature p = new PermutationSignature();
		int[] a = p.reconstruct("DD");
		System.out.println(Arrays.toString(a));

	}

}
