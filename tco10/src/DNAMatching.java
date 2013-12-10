public class DNAMatching {
	
	public int getMaxSize(String[] dna) {
		int res = 0;
		for (int i=0; i<dna.length; i++) {
			boolean found = false;
			
			StringBuilder rev = new StringBuilder(dna[i]);
			rev.reverse();
			for (int j=0; j<rev.length(); j++) {
				switch (rev.charAt(j)) {
				case 'A':
					rev.setCharAt(j, 'T');
					break;
				case 'C':
					rev.setCharAt(j, 'G');
					break;
				case 'T':
					rev.setCharAt(j, 'A');
					break;
				case 'G':
					rev.setCharAt(j, 'C');
					break;
				}
			}
			String revs = rev.toString();
			
			for (int j=0; j<i; j++) {
				if (dna[j].equals(revs)) {
					found = true;
					break;
				}
			}
			if (!found)
				res++;
		}
		return res;
	}

	public static void main(String[] args) {
		long time;
		int answer;
		boolean errors = false;
		int desiredAnswer;

		time = System.currentTimeMillis();
		answer = new DNAMatching().getMaxSize(new String[] { "ACGCGCGTA",
				"GTCGATGCA", "ACGTAGCT", "TACGCGCGT" });
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
		answer = new DNAMatching()
				.getMaxSize(new String[] { "A", "C", "T", "G" });
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
		answer = new DNAMatching().getMaxSize(new String[] { "ATTA", "ATCG",
				"CGAT", "ATCGCGAT", "CCCGGG" });
		System.out.println("Time: " + (System.currentTimeMillis() - time)
				/ 1000.0 + " seconds");
		desiredAnswer = 4;
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
