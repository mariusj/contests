
public class TeamsSelection
{
	public String simulate(int[] preference1, int[] preference2)
	{
		char[] res = new char[preference1.length];
		boolean[] taken = new boolean[preference1.length];
		
		int first = 0;
		int second = 0;
		
		for (int i=0; i<preference1.length; i++) {
			int p = -1;
			while (p==-1 || taken[p]) {
				p = i % 2 == 0 ? preference1[first++] : preference2[second++];
				p--;
			}
			res[p] = i % 2 == 0 ? '1' : '2';
			taken[p] = true;
		}
		return new String(res);
	}
	
	public static void main(String[] args)
	{
		long time;
		String answer;
		boolean errors = false;
		String desiredAnswer;
		
		time = System.currentTimeMillis();
		answer = new TeamsSelection().simulate(new int[]{1, 2, 3, 4}, new int[]{1, 2, 3, 4});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = "1212";
		System.out.println("Your answer:");
		System.out.println("\t\"" + answer + "\"");
		System.out.println("Desired answer:");
		System.out.println("\t\"" + desiredAnswer + "\"");
		if (!answer.equals(desiredAnswer))
		{
			errors = true;
			System.out.println("DOESN'T MATCH!!!!");
		}
		else
			System.out.println("Match :-)");
		System.out.println();
		time = System.currentTimeMillis();
		answer = new TeamsSelection().simulate(new int[]{3, 2, 1}, new int[]{1, 3, 2});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = "211";
		System.out.println("Your answer:");
		System.out.println("\t\"" + answer + "\"");
		System.out.println("Desired answer:");
		System.out.println("\t\"" + desiredAnswer + "\"");
		if (!answer.equals(desiredAnswer))
		{
			errors = true;
			System.out.println("DOESN'T MATCH!!!!");
		}
		else
			System.out.println("Match :-)");
		System.out.println();
		time = System.currentTimeMillis();
		answer = new TeamsSelection().simulate(new int[]{6, 1, 5, 2, 3, 4}, new int[]{1, 6, 3, 4, 5, 2});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = "212211";
		System.out.println("Your answer:");
		System.out.println("\t\"" + answer + "\"");
		System.out.println("Desired answer:");
		System.out.println("\t\"" + desiredAnswer + "\"");
		if (!answer.equals(desiredAnswer))
		{
			errors = true;
			System.out.println("DOESN'T MATCH!!!!");
		}
		else
			System.out.println("Match :-)");
		System.out.println();
		time = System.currentTimeMillis();
		answer = new TeamsSelection().simulate(new int[]{8, 7, 1, 2, 4, 5, 6, 3, 9}, new int[]{7, 2, 4, 8, 1, 5, 9, 6, 3});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = "121121212";
		System.out.println("Your answer:");
		System.out.println("\t\"" + answer + "\"");
		System.out.println("Desired answer:");
		System.out.println("\t\"" + desiredAnswer + "\"");
		if (!answer.equals(desiredAnswer))
		{
			errors = true;
			System.out.println("DOESN'T MATCH!!!!");
		}
		else
			System.out.println("Match :-)");
		System.out.println();
		
		if (errors)
			System.out.println("Some of the test cases had errors :-(");
		else
			System.out.println("You're a stud (at least on the test data)! :-D ");
	}
}
//Powered by [KawigiEdit] 2.0!