public class FoxPlayingGame {
	
	public double theMax(int nA, int nB, int paramA, int paramB) {
		double as = paramA / 1000.0;
		double bs = paramB / 1000.0;

		double bMax = Math.pow(bs, nB);
		double bMax1 = Math.pow(bs, nB - 1);
		
		if (nB == 0)
			return nA * paramA / 1000.0;
		
		if (nA == 0) 
			return 0.0;

		if (paramA > 0) {
			if (paramB >= 1000) {
				return nA * paramA / 1000.0 * bMax;
			} else 
			if (paramB <= -1000) {
				if (nB % 2 == 0) {
					return nA * paramA / 1000.0 * bMax;
				} else {
					return nA * paramA / 1000.0 * bMax1;
				}
			} else
			return nA * paramA / 1000.0;
		} else {
			if (paramB >= 1000) {
				return nA * paramA / 1000.0;
			} else
			if (paramB <= -1000) {
				if (nB % 2 == 0) {
					return nA * paramA / 1000.0 * bMax1;
				} else {
					return nA * paramA / 1000.0 * bMax;
				}
			} else
			if (paramB >= 0) {
				return nA * paramA / 1000.0 * bMax;
			} else {
				return nA * paramA / 1000.0 * paramB / 1000.0;
			}
		}
	}

	public static void main(String[] args) {
		long time;
		double answer;
		boolean errors = false;
		double desiredAnswer;

		time = System.currentTimeMillis();
		answer = new FoxPlayingGame().theMax(2, 10, -2000, 1500);
		System.out.println("Time: " + (System.currentTimeMillis() - time)
				/ 1000.0 + " seconds");
		desiredAnswer = -4.0D;
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
		answer = new FoxPlayingGame().theMax(3, 3, 2000, 100);
		System.out.println("Time: " + (System.currentTimeMillis() - time)
				/ 1000.0 + " seconds");
		desiredAnswer = 6.0D;
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
		answer = new FoxPlayingGame().theMax(4, 3, -2000, 2000);
		System.out.println("Time: " + (System.currentTimeMillis() - time)
				/ 1000.0 + " seconds");
		desiredAnswer = -8.0D;
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
		answer = new FoxPlayingGame().theMax(5, 5, 2000, -2000);
		System.out.println("Time: " + (System.currentTimeMillis() - time)
				/ 1000.0 + " seconds");
		desiredAnswer = 160.0D;
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
		answer = new FoxPlayingGame().theMax(50, 50, 10000, 2000);
		System.out.println("Time: " + (System.currentTimeMillis() - time)
				/ 1000.0 + " seconds");
		desiredAnswer = 5.62949953421312E17D;
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
		answer = new FoxPlayingGame().theMax(41, 34, 9876, -1234);
		System.out.println("Time: " + (System.currentTimeMillis() - time)
				/ 1000.0 + " seconds");
		desiredAnswer = 515323.9982341775D;
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
