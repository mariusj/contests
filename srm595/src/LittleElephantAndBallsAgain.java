public class LittleElephantAndBallsAgain {
	public int getNumber(String S) {
		int minSteps = Integer.MAX_VALUE;
		
		String s = "";

		if (allSame(S))
			return 0;

		for (int i = 0; i < S.length(); i++) {
			String s2 = S.substring(i);
			if (allSame(s2)) {
				if (i < minSteps) {
					minSteps = i;
					s= s2;
				}
				break;
			}
			for (int j = s2.length() - 1; j > 0; j--) {
				String s3 = s2.substring(0, j);
				if (allSame(s3)) {
					if (i + s2.length() - j < minSteps) {
						minSteps = i + s2.length() - j;
						s = s3;
					}
					break;
				}
			}
		}
		
		System.out.println(s);

		return minSteps;
	}

	private boolean allSame(String S) {
		if (S.isEmpty() || S.length() == 1)
			return true;
		char c = S.charAt(0);
		for (int i = 0; i < S.length(); i++) {
			if (S.charAt(i) != c)
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		long time;
		int answer;
		boolean errors = false;
		int desiredAnswer;

		/*
		 * time = System.currentTimeMillis(); answer = new
		 * LittleElephantAndBallsAgain().getNumber("RRGGBB");
		 * System.out.println("Time: " +
		 * (System.currentTimeMillis()-time)/1000.0 + " seconds"); desiredAnswer
		 * = 4; System.out.println("Your answer:"); System.out.println("\t" +
		 * answer); System.out.println("Desired answer:");
		 * System.out.println("\t" + desiredAnswer); if (answer !=
		 * desiredAnswer) { errors = true;
		 * System.out.println("DOESN'T MATCH!!!!"); } else
		 * System.out.println("Match :-)"); System.out.println(); time =
		 * System.currentTimeMillis(); answer = new
		 * LittleElephantAndBallsAgain().getNumber("R");
		 * System.out.println("Time: " +
		 * (System.currentTimeMillis()-time)/1000.0 + " seconds"); desiredAnswer
		 * = 0; System.out.println("Your answer:"); System.out.println("\t" +
		 * answer); System.out.println("Desired answer:");
		 * System.out.println("\t" + desiredAnswer); if (answer !=
		 * desiredAnswer) { errors = true;
		 * System.out.println("DOESN'T MATCH!!!!"); } else
		 * System.out.println("Match :-)"); System.out.println(); time =
		 * System.currentTimeMillis(); answer = new
		 * LittleElephantAndBallsAgain().getNumber("RGBRGB");
		 * System.out.println("Time: " +
		 * (System.currentTimeMillis()-time)/1000.0 + " seconds"); desiredAnswer
		 * = 5; System.out.println("Your answer:"); System.out.println("\t" +
		 * answer); System.out.println("Desired answer:");
		 * System.out.println("\t" + desiredAnswer); if (answer !=
		 * desiredAnswer) { errors = true;
		 * System.out.println("DOESN'T MATCH!!!!"); } else
		 * System.out.println("Match :-)"); System.out.println(); time =
		 * System.currentTimeMillis(); answer = new
		 * LittleElephantAndBallsAgain().getNumber("RGGGBB");
		 * System.out.println("Time: " +
		 * (System.currentTimeMillis()-time)/1000.0 + " seconds"); desiredAnswer
		 * = 3; System.out.println("Your answer:"); System.out.println("\t" +
		 * answer); System.out.println("Desired answer:");
		 * System.out.println("\t" + desiredAnswer); if (answer !=
		 * desiredAnswer) { errors = true;
		 * System.out.println("DOESN'T MATCH!!!!"); } else
		 * System.out.println("Match :-)"); System.out.println();
		 * 
		 * time = System.currentTimeMillis(); answer = new
		 * LittleElephantAndBallsAgain
		 * ().getNumber("RGBRBRGRGRBBBGRBRBRGBGBBBGRGBBBBRGBGRRGGRRRGRBBBBR");
		 * System.out.println("Time: " +
		 * (System.currentTimeMillis()-time)/1000.0 + " seconds"); desiredAnswer
		 * = 46; System.out.println("Your answer:"); System.out.println("\t" +
		 * answer); System.out.println("Desired answer:");
		 * System.out.println("\t" + desiredAnswer); if (answer !=
		 * desiredAnswer) { errors = true;
		 * System.out.println("DOESN'T MATCH!!!!"); } else
		 * System.out.println("Match :-)"); System.out.println();
		 */

		time = System.currentTimeMillis();
		answer = new LittleElephantAndBallsAgain()
				.getNumber("GGGGGGRGGBRGBGBGBRRGBGBBBGRGRBBBBRGGRGGGRBGGRBGBBB");
		System.out.println("Time: " + (System.currentTimeMillis() - time)
				/ 1000.0 + " seconds");
		desiredAnswer = 44;
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
// Powered by [KawigiEdit] 2.0!