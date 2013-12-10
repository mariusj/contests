public class BadVocabulary {
	public int count(String badPrefix, String badSuffix, String badSubstring,
			String[] vocabulary) {
		int res = 0;
		for (String s : vocabulary) {
			boolean prefix = s.startsWith(badPrefix);
			boolean suffix = s.endsWith(badSuffix);
			int idx = s.indexOf(badSubstring, 1);
			boolean contains = (idx > -1) && (idx + badSubstring.length() < s.length());
			if ((prefix || suffix) && !contains)
				res++;
			else if (contains)
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
		answer = new BadVocabulary().count("bug", "bug", "bug", new String[] {
				"buggy", "debugger", "debug" });
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
		answer = new BadVocabulary().count("a", "b", "c", new String[] { "a",
				"b", "tco" });
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
		answer = new BadVocabulary().count("cut", "sore", "scar", new String[] {
				"scary", "oscar" });
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
		answer = new BadVocabulary().count("bar", "else", "foo", new String[] {
				"foofoofoo", "foobar", "elsewhere" });
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
		answer = new BadVocabulary().count("pre", "s", "all", new String[] {
				"all", "coders", "be", "prepared", "for", "the", "challenge",
				"phase" });
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
		answer = new BadVocabulary().count("u", "z", "n", 
				new String[] {
				"nvsgybnwaxjjoezgvqxtlvhhwwpdqfogxptazonrhcihhjhcfz", 
				"lvmotrtlxmiaiocgkodjcjubntvzyziucvtishdwbsycemdalz", 
				"jqihhvlpmnnzplcgbmbagekgkzlbrfnapfbqqccymieoktpsxc", 
				"uujvsckvywxizluhqksqtepezhynvvasskpmoahpwgzxutekdw", 
				"tsgfauwtvnaskxhytzcqykojxqfnqokjisqionemaeelenjzmn", 
				"eoqqxdpzgdclddkatohtgjmioptzrhuvxnnuqcvyixlncvnxjx", 
				"jzqwnhjiossfehkfzcjcavkhlwccobfxaxvqehyszrzdajkant", 
				"uycsdbbdrwaroudggugpjewkdsdjciighkymobrfytyoocuwyc", 
				"ixqsrldcvoxngapcowqencbnefjqqkuqddpppodggvweltkijz", 
				"vwyfefsbdwleheescnwlhjjguznjxhihildqunzijnkerqlxdk"});
		System.out.println("Time: " + (System.currentTimeMillis() - time)
				/ 1000.0 + " seconds");
		desiredAnswer = 10;
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
