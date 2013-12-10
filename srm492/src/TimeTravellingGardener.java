public class TimeTravellingGardener {
	
	public int determineUsage(int[] distance, int[] height) {
		int trees = height.length;
		int x[] = new int[trees];
		int y[] = height;
		int xx = 0;
		x[0] = 0;
		for (int i=1; i<trees; i++) {
			xx += distance[i - 1];
			x[i] = xx;
		}
		
		int minChange = trees - 1;
		
		for (int i=0; i<trees-1; i++) {
			for (int j=i + 1; j<trees; j++) {
				double A = y[i] - y[j];
				double B = x[j] - x[i];
				double C = -A*x[i] - B*y[i];

				int match = 2;
				boolean imposible = false;
				for (int k=0; k<trees; k++) {
					if (k == i || k == j)
						continue;
					if (A * x[k] + B * y[k] + C == 0) {
						match++;
					} else {
						double newy = (-A * x[k] - C) / B;
						if (newy<0 || newy > y[k]) {
							imposible = true;
							break;
						}
					}
				}
				if (!imposible) {
					int toChange = trees - match;
					if (toChange < minChange) {
						minChange = toChange;
					}
				}
			}
		}
		
		return minChange;

	}

	public static void main(String[] args) {
		long time;
		int answer;
		boolean errors = false;
		int desiredAnswer;

		time = System.currentTimeMillis();
		answer = new TimeTravellingGardener().determineUsage(
				new int[] { 2, 2 }, new int[] { 1, 3, 10 });
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
		answer = new TimeTravellingGardener().determineUsage(
				new int[] { 3, 3 }, new int[] { 3, 1, 3 });
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
		answer = new TimeTravellingGardener().determineUsage(
				new int[] { 1, 3 }, new int[] { 4, 4, 4 });
		System.out.println("Time: " + (System.currentTimeMillis() - time)
				/ 1000.0 + " seconds");
		desiredAnswer = 0;
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
		answer = new TimeTravellingGardener().determineUsage(
				new int[] { 4, 2 }, new int[] { 9, 8, 5 });
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
		answer = new TimeTravellingGardener().determineUsage(new int[] { 476,
				465, 260, 484 }, new int[] { 39, 13, 8, 72, 80 });
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
		answer = new TimeTravellingGardener().determineUsage(new int[] { 173,
				36, 668, 79, 26, 544 }, new int[] { 488, 743, 203, 446, 444,
				91, 453 });
		System.out.println("Time: " + (System.currentTimeMillis() - time)
				/ 1000.0 + " seconds");
		desiredAnswer = 5;
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
		answer = new TimeTravellingGardener().determineUsage(new int[] { 2, 4,
				2, 2, 4, 2, 4, 2, 2, 4 }, new int[] { 2, 2, 10, 10, 10, 16, 16,
				22, 22, 28, 28 });
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

		if (errors)
			System.out.println("Some of the test cases had errors :-(");
		else
			System.out
					.println("You're a stud (at least on the test data)! :-D ");
	}
}
