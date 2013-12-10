import java.util.Arrays;


public class ColorfulCards {
	
	private boolean[] primes = new boolean[1000];
	
	private boolean primesGenerated = false;

	private void genPrimes() {
		if (primesGenerated )
			return;
		Arrays.fill(primes, true);
		primes[1] = false;
		for (int i=2; i<primes.length; i++) {
			if (primes[i]) {
				for (int j=i+i; j<primes.length; j+=i) {
					primes[j] = false;
				}
			}
		}
		primesGenerated = true;
	}
	
/*
	Stack<Integer> nums;
	private int[] rets;
	
	public void genSeq(int start) {
		int pos = nums.size();
		int lastPos = colors.length();
		int toFind = lastPos - pos;
		boolean last = toFind == 1; 
		char c = colors.charAt(pos);
		for (int i=start; i<=N - toFind + 1; i++) {
			if ((c == 'R' && primes[i]) ||
				(c == 'B' && !primes[i])) {
				nums.add(i);
				if (last) {
					for (int x=0; x<rets.length; x++) {
						if (rets[x] == 0) {
							rets[x] = nums.get(x);
						} else if (rets[x] != nums.get(x)) {
							rets[x] = -1;
						}
					}
				} else {
					genSeq(i + 1);
				}
				nums.pop();
			}
			if (rets[pos] == -1)
				break;
		}
	}
	
*/	
	private int getNextNum(int start, int max, boolean prime) {
		int i = start + 1;
		while (i<=max) {
			if (prime == primes[i])
				return i;
			i++;
		}
		return -1;
	}
	
	public int[] theCards(int N, String colors) {
		genPrimes();
		int c = colors.length();
		int[] rets = new int[c];
		int start = 0;
		for (int i=0; i<c; i++) {
			start = getNextNum(start, N, colors.charAt(i) == 'R');
			rets[i] = start;
			int altStart = start;
			for (int j=i; j<c; j++) {
				altStart = getNextNum(altStart, N, colors.charAt(j) == 'R');
				if (altStart == -1)
					break;
			}
			if (altStart != -1)
				rets[i] = -1;
		}
		
		return rets;
	}

	public static void main(String[] args) {
		long time;
		int[] answer;
		boolean errors = false;
		int[] desiredAnswer;

		boolean same;

		time = System.currentTimeMillis();
		answer = new ColorfulCards().theCards(5, "RRR");
		System.out.println("Time: " + (System.currentTimeMillis() - time)
				/ 1000.0 + " seconds");
		desiredAnswer = new int[] { 2, 3, 5 };
		System.out.println("Your answer:");
		if (answer.length > 0) {
			System.out.print("\t{ " + answer[0]);
			for (int i = 1; i < answer.length; i++)
				System.out.print(", " + answer[i]);
			System.out.println(" }");
		} else
			System.out.println("\t{ }");
		System.out.println("Desired answer:");
		if (desiredAnswer.length > 0) {
			System.out.print("\t{ " + desiredAnswer[0]);
			for (int i = 1; i < desiredAnswer.length; i++)
				System.out.print(", " + desiredAnswer[i]);
			System.out.println(" }");
		} else
			System.out.println("\t{ }");
		same = desiredAnswer.length == answer.length;
		for (int i = 0; i < answer.length && same; i++)
			if (answer[i] != desiredAnswer[i])
				same = false;
		if (!same) {
			errors = true;
			System.out.println("DOESN'T MATCH!!!!");
		} else
			System.out.println("Match :-)");
		System.out.println();
		time = System.currentTimeMillis();
		answer = new ColorfulCards().theCards(7, "BBB");
		System.out.println("Time: " + (System.currentTimeMillis() - time)
				/ 1000.0 + " seconds");
		desiredAnswer = new int[] { 1, 4, 6 };
		System.out.println("Your answer:");
		if (answer.length > 0) {
			System.out.print("\t{ " + answer[0]);
			for (int i = 1; i < answer.length; i++)
				System.out.print(", " + answer[i]);
			System.out.println(" }");
		} else
			System.out.println("\t{ }");
		System.out.println("Desired answer:");
		if (desiredAnswer.length > 0) {
			System.out.print("\t{ " + desiredAnswer[0]);
			for (int i = 1; i < desiredAnswer.length; i++)
				System.out.print(", " + desiredAnswer[i]);
			System.out.println(" }");
		} else
			System.out.println("\t{ }");
		same = desiredAnswer.length == answer.length;
		for (int i = 0; i < answer.length && same; i++)
			if (answer[i] != desiredAnswer[i])
				same = false;
		if (!same) {
			errors = true;
			System.out.println("DOESN'T MATCH!!!!");
		} else
			System.out.println("Match :-)");
		System.out.println();
		time = System.currentTimeMillis();
		answer = new ColorfulCards().theCards(6, "RBR");
		System.out.println("Time: " + (System.currentTimeMillis() - time)
				/ 1000.0 + " seconds");
		desiredAnswer = new int[] { -1, 4, 5 };
		System.out.println("Your answer:");
		if (answer.length > 0) {
			System.out.print("\t{ " + answer[0]);
			for (int i = 1; i < answer.length; i++)
				System.out.print(", " + answer[i]);
			System.out.println(" }");
		} else
			System.out.println("\t{ }");
		System.out.println("Desired answer:");
		if (desiredAnswer.length > 0) {
			System.out.print("\t{ " + desiredAnswer[0]);
			for (int i = 1; i < desiredAnswer.length; i++)
				System.out.print(", " + desiredAnswer[i]);
			System.out.println(" }");
		} else
			System.out.println("\t{ }");
		same = desiredAnswer.length == answer.length;
		for (int i = 0; i < answer.length && same; i++)
			if (answer[i] != desiredAnswer[i])
				same = false;
		if (!same) {
			errors = true;
			System.out.println("DOESN'T MATCH!!!!");
		} else
			System.out.println("Match :-)");
		System.out.println();
		time = System.currentTimeMillis();
		answer = new ColorfulCards().theCards(58, "RBRRBRBBRBRRBBRRBBBRRBBBRR");
		System.out.println("Time: " + (System.currentTimeMillis() - time)
				/ 1000.0 + " seconds");
		desiredAnswer = new int[] { -1, -1, -1, -1, -1, -1, -1, -1, 17, 18, 19,
				23, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 47, 53 };
		System.out.println("Your answer:");
		if (answer.length > 0) {
			System.out.print("\t{ " + answer[0]);
			for (int i = 1; i < answer.length; i++)
				System.out.print(", " + answer[i]);
			System.out.println(" }");
		} else
			System.out.println("\t{ }");
		System.out.println("Desired answer:");
		if (desiredAnswer.length > 0) {
			System.out.print("\t{ " + desiredAnswer[0]);
			for (int i = 1; i < desiredAnswer.length; i++)
				System.out.print(", " + desiredAnswer[i]);
			System.out.println(" }");
		} else
			System.out.println("\t{ }");
		same = desiredAnswer.length == answer.length;
		for (int i = 0; i < answer.length && same; i++)
			if (answer[i] != desiredAnswer[i])
				same = false;
		if (!same) {
			errors = true;
			System.out.println("DOESN'T MATCH!!!!");
		} else
			System.out.println("Match :-)");
		System.out.println();
		time = System.currentTimeMillis();
		answer = new ColorfulCards()
				.theCards(495, "RBRRBRBBRBRRBBRRBBBRRBBBRR");
		System.out.println("Time: " + (System.currentTimeMillis() - time)
				/ 1000.0 + " seconds");
		desiredAnswer = new int[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
				-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 };
		System.out.println("Your answer:");
		if (answer.length > 0) {
			System.out.print("\t{ " + answer[0]);
			for (int i = 1; i < answer.length; i++)
				System.out.print(", " + answer[i]);
			System.out.println(" }");
		} else
			System.out.println("\t{ }");
		System.out.println("Desired answer:");
		if (desiredAnswer.length > 0) {
			System.out.print("\t{ " + desiredAnswer[0]);
			for (int i = 1; i < desiredAnswer.length; i++)
				System.out.print(", " + desiredAnswer[i]);
			System.out.println(" }");
		} else
			System.out.println("\t{ }");
		same = desiredAnswer.length == answer.length;
		for (int i = 0; i < answer.length && same; i++)
			if (answer[i] != desiredAnswer[i])
				same = false;
		if (!same) {
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
