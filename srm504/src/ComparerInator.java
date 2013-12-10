public class ComparerInator {
	
	public int makeProgram(int[] A, int[] B, int[] wanted) {
		
		boolean p1 = true;
		boolean p2 = true;
		boolean p3 = true;
		boolean p4 = true;
		
		for (int i=0; i<A.length; i++) {
			if (A[i] != wanted[i])
				p1 = false;
			
			if (B[i] != wanted[i])
				p2 = false;
			
			if (A[i] < B[i] && wanted[i] != A[i])
				p3 = false;
			if (A[i] >= B[i] && wanted[i] != B[i])
				p3 = false;

			if (A[i] < B[i] && wanted[i] != B[i])
				p4 = false;
			if (A[i] >= B[i] && wanted[i] != A[i])
				p4 = false;
		}
		
		if (p1 || p2)
			return 1;
		if (p3 || p4)
			return 7;
		return -1;
	}

	public static void main(String[] args) {
		long time;
		int answer;
		boolean errors = false;
		int desiredAnswer;

		time = System.currentTimeMillis();
		answer = new ComparerInator().makeProgram(new int[] { 1 },
				new int[] { 2 }, new int[] { 2 });
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
		answer = new ComparerInator().makeProgram(new int[] { 1, 3 },
				new int[] { 2, 1 }, new int[] { 2, 3 });
		System.out.println("Time: " + (System.currentTimeMillis() - time)
				/ 1000.0 + " seconds");
		desiredAnswer = 7;
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
		answer = new ComparerInator().makeProgram(new int[] { 1, 3, 5 },
				new int[] { 2, 1, 7 }, new int[] { 2, 3, 5 });
		System.out.println("Time: " + (System.currentTimeMillis() - time)
				/ 1000.0 + " seconds");
		desiredAnswer = -1;
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
		answer = new ComparerInator().makeProgram(new int[] { 1, 3, 5 },
				new int[] { 2, 1, 7 }, new int[] { 1, 3, 5 });
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
		answer = new ComparerInator().makeProgram(new int[] { 1, 2, 3, 4, 5, 6,
				7, 8, 9, 10, 11 },
				new int[] { 5, 4, 7, 8, 3, 1, 1, 2, 3, 4, 6 }, new int[] { 1,
						2, 3, 4, 3, 1, 1, 2, 3, 4, 6 });
		System.out.println("Time: " + (System.currentTimeMillis() - time)
				/ 1000.0 + " seconds");
		desiredAnswer = 7;
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
		answer = new ComparerInator().makeProgram(new int[] { 1, 5, 6, 7, 8 },
				new int[] { 1, 5, 6, 7, 8 }, new int[] { 1, 5, 6, 7, 8 });
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
		
		answer = new ComparerInator().makeProgram(new int[] 
              {448, 247, 440, 198, 465, 216, 985, 989, 271, 297, 608, 461, 854, 432, 4, 586, 871, 861, 804, 175, 759, 512, 358, 66, 306, 340, 943},
				new int[] 
	          {933, 305, 461, 244, 245, 770, 720, 577, 803, 543, 107, 629, 600, 260, 610, 287, 977, 629, 329, 472, 671, 42, 35, 818, 339, 864, 644}, 
				new int[] 
	          {448, 247, 440, 198, 465, 216, 985, 989, 271, 297, 23, 461, 854, 432, 4, 586, 871, 861, 804, 175, 759, 512, 358, 66, 306, 340, 943});
		System.out.println("Time: " + (System.currentTimeMillis() - time)
				/ 1000.0 + " seconds");
		desiredAnswer = -1;
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
