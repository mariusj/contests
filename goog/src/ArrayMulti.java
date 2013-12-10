import java.util.Arrays;

public class ArrayMulti {

	public static void main(String[] args) {
		int[] input = new int[] { 1, 2, 3, 4, 5 };

		int n = input.length;
		long[] res = new long[input.length];
		Arrays.fill(res, 1);

		int left = 1;
		int right = 1;

		for (int i = 0; i < n; i++) {
			res[i] = res[i] * left;
			res[n - i - 1] = res[n - i - 1] * right;

			left *= input[i];
			right *= input[n - i - 1];
		}

//		long runningProduct = 1;
//
//		for (int i = 0; i < input.length; i++) {
//			res[i] = runningProduct;
//			runningProduct *= input[i];
//		}
//
//		runningProduct = 1;
//		for (int i = input.length - 1; i >= 0; i--) {
//			res[i] *= runningProduct;
//			runningProduct *= input[i];
//		}

		System.out.println(Arrays.toString(res));

	}

}
