import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class InterestingParty {
	
	private void incMap(Map<String, Integer> map, String key) {
		Integer val = map.get(key);
		if (val == null) {
			val = Integer.valueOf(0);
		}
		val = Integer.valueOf(val + 1); 
		map.put(key, val);
	}
	
	public int bestInvitation(String[] first, String[] second) {
		Map<String, Integer> topics = new HashMap<String, Integer>();
		for (int i=0; i<first.length; i++) {
			incMap(topics, first[i]);
			incMap(topics, second[i]);
		}
		Integer max = Collections.max(topics.values());
		return max;
	}

	public static void main(String[] args) {
		long time;
		int answer;
		boolean errors = false;
		int desiredAnswer;

		time = System.currentTimeMillis();
		answer = new InterestingParty().bestInvitation(new String[] {
				"fishing", "gardening", "swimming", "fishing" }, new String[] {
				"hunting", "fishing", "fishing", "biting" });
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
		time = System.currentTimeMillis();
		answer = new InterestingParty()
				.bestInvitation(new String[] { "variety", "diversity",
						"loquacity", "courtesy" }, new String[] { "talking",
						"speaking", "discussion", "meeting" });
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
		answer = new InterestingParty().bestInvitation(new String[] { "snakes",
				"programming", "cobra", "monty" }, new String[] { "python",
				"python", "anaconda", "python" });
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
		answer = new InterestingParty().bestInvitation(new String[] { "t", "o",
				"p", "c", "o", "d", "e", "r", "s", "i", "n", "g", "l", "e",
				"r", "o", "u", "n", "d", "m", "a", "t", "c", "h", "f", "o",
				"u", "r", "n", "i" },
				new String[] { "n", "e", "f", "o", "u", "r", "j", "a", "n",
						"u", "a", "r", "y", "t", "w", "e", "n", "t", "y", "t",
						"w", "o", "s", "a", "t", "u", "r", "d", "a", "y" });
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
