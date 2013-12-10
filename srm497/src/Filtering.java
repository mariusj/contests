
public class Filtering {

	private static final int[] NO_RES = new int[0];
	
	public int[] designFilter(int[] sizes, String outcome) {
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for (int i=0; i<sizes.length; i++) {
			if (outcome.charAt(i) == 'A') {
				if (sizes[i] < min)
					min = sizes[i];
				if (sizes[i] > max)
					max = sizes[i];
			}
		}
		for (int i=0; i<sizes.length; i++) {
			if (outcome.charAt(i) == 'R') {
				if (sizes[i] > min && sizes[i] < max)
					return NO_RES;
			}
		}
		int[] res = new int[2];
		res[0] = min;
		res[1] = max;
		return res;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
