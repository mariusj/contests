
public class TimeTravellingCellar {
	
	public int determineProfit(int[] profit, int[] decay) {
/* 		O(n*n)
		int p = 0;
		for (int i=0; i<profit.length; i++) {
			for (int j=0; j<profit.length; j++) {
				if (i == j)
					continue;
				int a = profit[i] - decay[j];;
				if (a > p)
					p = a;
			}
		}
		if (true)
			return p;
*/
		
		// O(n)
		int maxVal = Integer.MIN_VALUE;
		int maxVal2 = Integer.MIN_VALUE;
		int maxIdx = -1;
		int maxIdx2 = -1;
		int minVal = Integer.MAX_VALUE;
		int minVal2 = Integer.MAX_VALUE;
		int minIdx = -1;
		int minIdx2 = -1;
		for (int i=0; i<profit.length; i++) {
			if (profit[i] >= maxVal) {
				maxIdx2 = maxIdx;
				maxVal2 = maxVal;
				maxIdx = i;
				maxVal = profit[i];
			} else if (profit[i] >= maxVal2) {
				maxIdx2 = i;
				maxVal2 = profit[i];
			}
			if (decay[i] <= minVal) {
				minIdx2 = minIdx;
				minVal2 = minVal;
				minIdx = i;
				minVal = decay[i];
			} else if (decay[i] <= minVal2) {
				minIdx2 = i;
				minVal2 = decay[i];
			}
		}
		if (maxIdx != minIdx || maxIdx2 == -1 || minIdx2 == -1)
			return maxVal - minVal;
		int p1 = maxVal - minVal2;
		int p2 = maxVal2 - minVal;
		return p1 > p2 ? p1 : p2;
	}
	
	public static void main(String[] args) {
		long time;
		int answer;
		boolean errors = false;
		int desiredAnswer;

		time = System.currentTimeMillis();
		answer = new TimeTravellingCellar().determineProfit(
				new int[] { 1, 2, 3 }, new int[] { 3, 1, 2 });
		System.out.println("Time: " + (System.currentTimeMillis() - time)
				/ 1000.0 + " seconds");
		desiredAnswer = 2;
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
		answer = new TimeTravellingCellar().determineProfit(new int[] { 3, 2 },
				new int[] { 1, 2 });
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
		answer = new TimeTravellingCellar().determineProfit(
				new int[] { 3, 3, 3 }, new int[] { 1, 1, 1 });
		System.out.println("Time: " + (System.currentTimeMillis() - time)
				/ 1000.0 + " seconds");
		desiredAnswer = 2;
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
		answer = new TimeTravellingCellar().determineProfit(new int[] { 1000,
				500, 250, 125 }, new int[] { 64, 32, 16, 8 });
		System.out.println("Time: " + (System.currentTimeMillis() - time)
				/ 1000.0 + " seconds");
		desiredAnswer = 992;
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
