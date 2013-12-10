public class EasyHomework {
	public String determineSign(int[] A) {
		int sign = 1;

		for (int i = 0; i < A.length; i++) {
			sign *= Math.signum(A[i]);
		}
		switch (sign) {
		case -1:
			return "NEGATIVE";
		case 0:
			return "ZERO";
		case 1:
			return "POSITIVE";
		}
		return null;
	}

	public static void main(String[] args) {
		long time;
		String answer;
		boolean errors = false;
		String desiredAnswer;

		time = System.currentTimeMillis();
		answer = new EasyHomework().determineSign(new int[] { 5, 7, 2 });
		System.out.println("Time: " + (System.currentTimeMillis() - time)
				/ 1000.0 + " seconds");
		desiredAnswer = "POSITIVE";
		System.out.println("Your answer:");
		System.out.println("\t\"" + answer + "\"");
		System.out.println("Desired answer:");
		System.out.println("\t\"" + desiredAnswer + "\"");
		if (!answer.equals(desiredAnswer)) {
			errors = true;
			System.out.println("DOESN'T MATCH!!!!");
		} else
			System.out.println("Match :-)");
		System.out.println();
		time = System.currentTimeMillis();
		answer = new EasyHomework().determineSign(new int[] { -5, 7, 2 });
		System.out.println("Time: " + (System.currentTimeMillis() - time)
				/ 1000.0 + " seconds");
		desiredAnswer = "NEGATIVE";
		System.out.println("Your answer:");
		System.out.println("\t\"" + answer + "\"");
		System.out.println("Desired answer:");
		System.out.println("\t\"" + desiredAnswer + "\"");
		if (!answer.equals(desiredAnswer)) {
			errors = true;
			System.out.println("DOESN'T MATCH!!!!");
		} else
			System.out.println("Match :-)");
		System.out.println();
		time = System.currentTimeMillis();
		answer = new EasyHomework().determineSign(new int[] { 5, 7, 2, 0 });
		System.out.println("Time: " + (System.currentTimeMillis() - time)
				/ 1000.0 + " seconds");
		desiredAnswer = "ZERO";
		System.out.println("Your answer:");
		System.out.println("\t\"" + answer + "\"");
		System.out.println("Desired answer:");
		System.out.println("\t\"" + desiredAnswer + "\"");
		if (!answer.equals(desiredAnswer)) {
			errors = true;
			System.out.println("DOESN'T MATCH!!!!");
		} else
			System.out.println("Match :-)");
		System.out.println();
		time = System.currentTimeMillis();
		answer = new EasyHomework()
				.determineSign(new int[] { 3, -14, 159, -26 });
		System.out.println("Time: " + (System.currentTimeMillis() - time)
				/ 1000.0 + " seconds");
		desiredAnswer = "POSITIVE";
		System.out.println("Your answer:");
		System.out.println("\t\"" + answer + "\"");
		System.out.println("Desired answer:");
		System.out.println("\t\"" + desiredAnswer + "\"");
		if (!answer.equals(desiredAnswer)) {
			errors = true;
			System.out.println("DOESN'T MATCH!!!!");
		} else
			System.out.println("Match :-)");
		System.out.println();
		time = System.currentTimeMillis();
		answer = new EasyHomework().determineSign(new int[] { -1000000000 });
		System.out.println("Time: " + (System.currentTimeMillis() - time)
				/ 1000.0 + " seconds");
		desiredAnswer = "NEGATIVE";
		System.out.println("Your answer:");
		System.out.println("\t\"" + answer + "\"");
		System.out.println("Desired answer:");
		System.out.println("\t\"" + desiredAnswer + "\"");
		if (!answer.equals(desiredAnswer)) {
			errors = true;
			System.out.println("DOESN'T MATCH!!!!");
		} else
			System.out.println("Match :-)");
		System.out.println();
		time = System.currentTimeMillis();
		answer = new EasyHomework().determineSign(new int[] { 123, -456, 789,
				-101112, 131415, 161718, 192021, 222324, 252627, 282930,
				313233, 343536, 373839, 404142, 434445, 464748, 495051, 525354,
				555657 });
		System.out.println("Time: " + (System.currentTimeMillis() - time)
				/ 1000.0 + " seconds");
		desiredAnswer = "POSITIVE";
		System.out.println("Your answer:");
		System.out.println("\t\"" + answer + "\"");
		System.out.println("Desired answer:");
		System.out.println("\t\"" + desiredAnswer + "\"");
		if (!answer.equals(desiredAnswer)) {
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
