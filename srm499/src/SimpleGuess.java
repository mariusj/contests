public class SimpleGuess {
	
	public int getMaximum(int[] hints) {
		int max = 0;
		for (int i=0; i<hints.length; i++) {
			for (int j=0; j<hints.length; j++) {
				if (i == j)
					continue;
				int sum = hints[i];
				int sub = hints[j];
				int y = (sum - sub);
				if (y <= 0 || y % 2 != 0)
					continue;
				y = y / 2;
				int x = sum - y;
				if (x<=0)
					continue;
				int res = x * y;
				if (res > max)
					max = res;
			}
		}
		return max;
	}

	public static void main(String[] args) {
		long time;
		int answer;
		boolean errors = false;
		int desiredAnswer;

		time = System.currentTimeMillis();
		answer = new SimpleGuess().getMaximum(new int[] { 1, 4, 5 });
		System.out.println("Time: " + (System.currentTimeMillis() - time)
				/ 1000.0 + " seconds");
		desiredAnswer = 6;
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
		answer = new SimpleGuess().getMaximum(new int[] { 1, 4, 5, 8 });
		System.out.println("Time: " + (System.currentTimeMillis() - time)
				/ 1000.0 + " seconds");
		desiredAnswer = 12;
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
		answer = new SimpleGuess().getMaximum(new int[] { 9, 8, 7, 6, 5, 4, 3,
				2, 1 });
		System.out.println("Time: " + (System.currentTimeMillis() - time)
				/ 1000.0 + " seconds");
		desiredAnswer = 20;
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
		answer = new SimpleGuess().getMaximum(new int[] { 2, 100 });
		System.out.println("Time: " + (System.currentTimeMillis() - time)
				/ 1000.0 + " seconds");
		desiredAnswer = 2499;
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
		//answer = new SimpleGuess().getMaximum(new int[] { 50, 58, 47, 57, 40 });
		answer = new SimpleGuess().getMaximum(new int[] { 50, 58, 47, 57, 40, 58, 47, 57, 40, 58, 47, 57, 40, 58, 47, 57, 40, 58, 47, 57, 40, 58, 47, 57, 40, 58, 47, 57, 40, 58, 47, 57, 40, 58, 47, 57, 40, 58, 47, 57, 40 });
		System.out.println("Time: " + (System.currentTimeMillis() - time)
				/ 1000.0 + " seconds");
		desiredAnswer = 441;
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
