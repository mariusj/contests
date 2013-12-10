import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class MafiaGame {

	public double check(int N, int[] decisions, boolean[] vulnerable, int vulCnt) {
		int votes[] = new int[N];
		double prob[] = new double[N];
		for (int i=0; i<decisions.length; i++) {
			votes[decisions[i]]++;
		}
		for (int i=0; i<N; i++) {
			prob[i] = (double) votes[i] / N;
		}
		for (int i=decisions.length; i<N; i++) {
			int min = Integer.MAX_VALUE;
			int minIdx = -1;
			for (int j=0; j<N; j++) {
				if (vulnerable[j] && votes[j] < min) {
					min = votes[j];
					minIdx = j;
				}
			}
			votes[minIdx]++;
		}
		int max = Integer.MIN_VALUE;
		int maxCnt = 0;
		List<Integer> maxIdx = new ArrayList<Integer>();
		for (int j=0; j<N; j++) {
			if (votes[j] > max) {
				max = votes[j];
				maxCnt = 1;
				maxIdx.clear();
				maxIdx.add(j);
			} else if (votes[j] == max) {
				maxCnt++;
				maxIdx.add(j);
			}
		}
		if (maxCnt == 1)
			return 1.0;
		if (maxCnt == vulCnt)
			return 0.0;
		Arrays.fill(vulnerable, false);
		for (Integer i : maxIdx) {
			vulnerable[i] = true;
		}
		List<Integer> newDec = new ArrayList<Integer>();
		for (int d : decisions) {
			if (maxIdx.contains(d)) {
				newDec.add(d);
			}
		}
		int[] newDecInt = new int[newDec.size()];
		for (int i=0; i<newDec.size(); i++) {
			newDecInt[i] = newDec.get(i);
		}
		return check(N, newDecInt, vulnerable, maxCnt);
	}
	
	public double probabilityToLose(int N, int[] decisions) {
		boolean[] vulnerable = new boolean[N];
		Arrays.fill(vulnerable, true);
		return check(N, decisions, vulnerable, N);
	}

	public static void main(String[] args) {
		long time;
		double answer;
		boolean errors = false;
		double desiredAnswer;

/*		time = System.currentTimeMillis();
		answer = new MafiaGame().probabilityToLose(3, new int[] { 1, 1, 1 });
		System.out.println("Time: " + (System.currentTimeMillis() - time)
				/ 1000.0 + " seconds");
		desiredAnswer = 1.0D;
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
		answer = new MafiaGame().probabilityToLose(5, new int[] { 1, 2, 3 });
		System.out.println("Time: " + (System.currentTimeMillis() - time)
				/ 1000.0 + " seconds");
		desiredAnswer = 0.0D;
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
		answer = new MafiaGame().probabilityToLose(20, new int[] { 1, 2, 3, 4,
				5, 6, 7, 1, 2, 3, 4, 5, 6, 7, 18, 19, 0 });
		System.out.println("Time: " + (System.currentTimeMillis() - time)
				/ 1000.0 + " seconds");
		desiredAnswer = 0.0D;
		System.out.println("Your answer:");
		System.out.println("\t" + answer);
		System.out.println("Desired answer:");
		System.out.println("\t" + desiredAnswer);
		if (answer != desiredAnswer) {
			errors = true;
			System.out.println("DOESN'T MATCH!!!!");
		} else
			System.out.println("Match :-)");
		System.out.println();*/
		time = System.currentTimeMillis();
		answer = new MafiaGame().probabilityToLose(23, new int[] { 17, 10, 3,
				14, 22, 5, 11, 10, 22, 3, 14, 5, 11, 17 });
		System.out.println("Time: " + (System.currentTimeMillis() - time)
				/ 1000.0 + " seconds");
		desiredAnswer = 0.14285714285714285D;
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
