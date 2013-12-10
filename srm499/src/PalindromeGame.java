import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class PalindromeGame {
	
	private boolean isPalindrom(String s) {
		int len = s.length();
		if (len == 1)
			return true;
		int mid = (len+1) / 2;
		for (int i=0; i<=mid; i++) {
			if (s.charAt(i) != s.charAt(len-i-1)) {
				return false;
			}
		}
		return true;
	}
	
	private boolean arePalindroms(String s1, String s2) {
		if (s1.length() != s2.length())
			return false;
		for (int i=0; i<s1.length(); i++) {
			if (s1.charAt(i) != s2.charAt(s1.length() - i - 1))
				return false;
		}
		return true;
	}
	
	private static class PaliPair implements Comparable<PaliPair> {
		public PaliPair(int idx1, int idx2, int val1, int val2) {
			this.idx1 = idx1;
			this.idx2 = idx2;
			this.val1 = val1;
			this.val2 = val2;
		}
		
		int idx1;
		int idx2;
		int val1;
		int val2;
		
		int sum() {
			if (idx1 == idx2)
				return val1;
			return val1 + val2;
		}
		
		public int compareTo(PaliPair o) {
			return o.sum() - sum();
		}
		
	}

	public int getMaximum(String[] front, int[] back) {
		int res = 0;
		List<PaliPair> palis = new ArrayList<PaliPair>();
		for (int i=0; i<front.length; i++) {
			if (isPalindrom(front[i])) {
				palis.add(new PaliPair(i, i, back[i], back[i]));
			}
			for (int j=i+1; j<front.length; j++) {
				if (arePalindroms(front[i], front[j])) {
					palis.add(new PaliPair(i, j, back[i], back[j]));
				}
			}
		}
		Collections.sort(palis);
		boolean middle = false;
		while (!palis.isEmpty()) {
			PaliPair p = palis.remove(0);
			if (p.idx1 == p.idx2) {
				if (!middle) {
					middle = true;
					res += p.sum();
				}
			} else {
				res += p.sum();
			}
			for (Iterator<PaliPair> i=palis.iterator(); i.hasNext(); ) {
				PaliPair next = i.next();
				if (next.idx1 == p.idx1 || next.idx2 == p.idx1 || 
						next.idx1 == p.idx2 || next.idx2 == p.idx2) {
					i.remove();
				}
			}
		}
		return res;
	}

	public static void main(String[] args) {
		long time;
		int answer;
		boolean errors = false;
		int desiredAnswer;

		time = System.currentTimeMillis();
		answer = new PalindromeGame().getMaximum(new String[] { "topcoder",
				"redcoder", "redocpot" }, new int[] { 7, 5, 3 });
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
		time = System.currentTimeMillis();
		answer = new PalindromeGame().getMaximum(new String[] { "rabbit" },
				new int[] { 1000000 });
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
		answer = new PalindromeGame().getMaximum(new String[] { "abc", "abc",
				"def", "cba", "fed" }, new int[] { 24, 7, 63, 222, 190 });
		System.out.println("Time: " + (System.currentTimeMillis() - time)
				/ 1000.0 + " seconds");
		desiredAnswer = 499;
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
		answer = new PalindromeGame().getMaximum(new String[] 
                {"xyx", "xyx", "xyx", "zzz", "zzz", "zzz"}, 
				new int[] 
		        {5, 7, 2, 1, 6, 4}
		);
		System.out.println("Time: " + (System.currentTimeMillis() - time)
				/ 1000.0 + " seconds");
		desiredAnswer = 24;
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
		answer = new PalindromeGame().getMaximum(new String[] 
		        {"aaaaaaaaaaaa", "nopalindrome", "steponnopets", 
				"emordnilapon", "aaaaaaaaaaaa", "steponnopets", 
				"nopalindrome", "steponnopets", "nopalindrome", 
				"bbbbbbbbbbbb", "cannotbeused", "cannotbeused", 
				"steponnopets", "aaaaaaaaaaaa", "nopalindrome", 
				"aaaaaaaaaaaa", "nopalindrome", "emordnilapon", 
				"steponnopets", "nopalindrome"}, 
				new int[] 
		        {4096, 131072, 64, 
				262144, 512, 1024, 
				65536, 2048, 32768, 
				1, 524288, 16384, 
				32, 4, 16, 
				2, 8, 128, 
				8192, 256}		        
		);
		System.out.println("Time: " + (System.currentTimeMillis() - time)
				/ 1000.0 + " seconds");
		desiredAnswer = 474854;
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
		answer = new PalindromeGame().getMaximum(new String[] 
                {"dkksrtirsbmfnqksxqydjgfsqvqehisiweslikfwatdqfumfhl", "lhfmufqdtawfkilsewisiheqvqsfgjdyqxskqnfmbsritrskkd", "dkksrtirsbmfnqksxqydjgfsqvqehisiweslikfwatdqfumfhl", "lhfmufqdtawfkilsewisiheqvqsfgjdyqxskqnfmbsritrskkd", "lhfmufqdtawfkilsewisiheqvqsfgjdyqxskqnfmbsritrskkd", "dkksrtirsbmfnqksxqydjgfsqvqehisiweslikfwatdqfumfhl", "lhfmufqdtawfkilsewisiheqvqsfgjdyqxskqnfmbsritrskkd", "dkksrtirsbmfnqksxqydjgfsqvqehisiweslikfwatdqfumfhl", "dkksrtirsbmfnqksxqydjgfsqvqehisiweslikfwatdqfumfhl", "lhfmufqdtawfkilsewisiheqvqsfgjdyqxskqnfmbsritrskkd", "lhfmufqdtawfkilsewisiheqvqsfgjdyqxskqnfmbsritrskkd", "lhfmufqdtawfkilsewisiheqvqsfgjdyqxskqnfmbsritrskkd", "dkksrtirsbmfnqksxqydjgfsqvqehisiweslikfwatdqfumfhl", "dkksrtirsbmfnqksxqydjgfsqvqehisiweslikfwatdqfumfhl", "lhfmufqdtawfkilsewisiheqvqsfgjdyqxskqnfmbsritrskkd", "lhfmufqdtawfkilsewisiheqvqsfgjdyqxskqnfmbsritrskkd", "dkksrtirsbmfnqksxqydjgfsqvqehisiweslikfwatdqfumfhl", "lhfmufqdtawfkilsewisiheqvqsfgjdyqxskqnfmbsritrskkd", "lhfmufqdtawfkilsewisiheqvqsfgjdyqxskqnfmbsritrskkd", "lhfmufqdtawfkilsewisiheqvqsfgjdyqxskqnfmbsritrskkd", "dkksrtirsbmfnqksxqydjgfsqvqehisiweslikfwatdqfumfhl", "dkksrtirsbmfnqksxqydjgfsqvqehisiweslikfwatdqfumfhl", "dkksrtirsbmfnqksxqydjgfsqvqehisiweslikfwatdqfumfhl", "lhfmufqdtawfkilsewisiheqvqsfgjdyqxskqnfmbsritrskkd", "lhfmufqdtawfkilsewisiheqvqsfgjdyqxskqnfmbsritrskkd", "lhfmufqdtawfkilsewisiheqvqsfgjdyqxskqnfmbsritrskkd", "dkksrtirsbmfnqksxqydjgfsqvqehisiweslikfwatdqfumfhl", "dkksrtirsbmfnqksxqydjgfsqvqehisiweslikfwatdqfumfhl", "lhfmufqdtawfkilsewisiheqvqsfgjdyqxskqnfmbsritrskkd", "dkksrtirsbmfnqksxqydjgfsqvqehisiweslikfwatdqfumfhl", "lhfmufqdtawfkilsewisiheqvqsfgjdyqxskqnfmbsritrskkd", "lhfmufqdtawfkilsewisiheqvqsfgjdyqxskqnfmbsritrskkd", "lhfmufqdtawfkilsewisiheqvqsfgjdyqxskqnfmbsritrskkd", "dkksrtirsbmfnqksxqydjgfsqvqehisiweslikfwatdqfumfhl", "dkksrtirsbmfnqksxqydjgfsqvqehisiweslikfwatdqfumfhl", "lhfmufqdtawfkilsewisiheqvqsfgjdyqxskqnfmbsritrskkd", "dkksrtirsbmfnqksxqydjgfsqvqehisiweslikfwatdqfumfhl", "dkksrtirsbmfnqksxqydjgfsqvqehisiweslikfwatdqfumfhl", "lhfmufqdtawfkilsewisiheqvqsfgjdyqxskqnfmbsritrskkd", "lhfmufqdtawfkilsewisiheqvqsfgjdyqxskqnfmbsritrskkd", "dkksrtirsbmfnqksxqydjgfsqvqehisiweslikfwatdqfumfhl", "dkksrtirsbmfnqksxqydjgfsqvqehisiweslikfwatdqfumfhl", "lhfmufqdtawfkilsewisiheqvqsfgjdyqxskqnfmbsritrskkd", "dkksrtirsbmfnqksxqydjgfsqvqehisiweslikfwatdqfumfhl", "lhfmufqdtawfkilsewisiheqvqsfgjdyqxskqnfmbsritrskkd", "dkksrtirsbmfnqksxqydjgfsqvqehisiweslikfwatdqfumfhl", "dkksrtirsbmfnqksxqydjgfsqvqehisiweslikfwatdqfumfhl", "lhfmufqdtawfkilsewisiheqvqsfgjdyqxskqnfmbsritrskkd", "dkksrtirsbmfnqksxqydjgfsqvqehisiweslikfwatdqfumfhl", "dkksrtirsbmfnqksxqydjgfsqvqehisiweslikfwatdqfumfhl"}, 
				new int[] 
		        {1861, 2376, 1125, 86, 797, 2613, 2140, 1679, 1421, 2034, 92, 2111, 412, 2445, 772, 628, 23, 249, 1733, 847, 2649, 1239, 2347, 211, 2218, 1111, 1401, 1688, 2406, 397, 2693, 1025, 842, 197, 2670, 2068, 1143, 1769, 2226, 973, 2673, 1767, 738, 750, 920, 213, 1998, 2667, 936, 1707}
		);
		System.out.println("Time: " + (System.currentTimeMillis() - time)
				/ 1000.0 + " seconds");
		desiredAnswer = 71086;
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
