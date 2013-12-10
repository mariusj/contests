import java.util.ArrayList;
import java.util.List;


public class TheBoringStoreDivTwo {
	
	public String find(String J, String B) {
		// A+C = B+D
		// 123456789012345
		List<String> a = new ArrayList<String>();
		List<String> b = new ArrayList<String>();
		for (int as=0; as<J.length() - 1; as++) {
			for (int ae=as+1; ae<=J.length(); ae++) {
				for (int bs=ae; bs<J.length(); bs++) {
					for (int be=bs + 1; be<=J.length(); be++) {
						if (J.charAt(as) != J.charAt(bs)) 
							continue;
						String A = J.substring(as, ae);
						String BS = J.substring(bs, be);
						a.add(A);
						b.add(BS);
//						System.out.println("" + as + "-" + ae + ", " + bs + "-" + be + " = " + A + "-" + BS);
					}
				}
			}
		}
		List<String> c = new ArrayList<String>();
		List<String> d = new ArrayList<String>();
		for (int cs=0; cs<B.length() - 1; cs++) {
			for (int ce=cs+1; ce<=B.length(); ce++) {
				for (int ds=ce; ds<B.length(); ds++) {
					for (int de=ds + 1; de<=B.length(); de++) {
						if (B.charAt(ce-1) != B.charAt(de-1)) 
							continue;
						String C = B.substring(cs, ce);
						String D = B.substring(ds, de);
						c.add(C);
						d.add(D);
//						System.out.println("" + cs + "-" + ce + ", " + ds + "-" + de + " = " + C + "-" + D);
					}
				}
			}
		}
		
		String res = "";
		
		for (int i=0; i<a.size(); i++) {
			for (int j=0; j<c.size(); j++) {
				String aa = a.get(i);
				String bb = b.get(i);
				String cc = c.get(j);
				String dd = d.get(j);
				if (aa.length() + cc.length() ==
					bb.length() + dd.length()) {
					String s1 = aa + cc;
					String s2 = bb + dd;
					if (s1.equals(s2)) {
						if (s1.length() > res.length()) {
							res = s1;
						} else if (s1.length() == res.length() && s1.compareTo(res) < 0) {
							res = s1;
						}
					}
				}
				if (aa.length() + dd.length() ==
					bb.length() + cc.length()) {
					String s1 = aa + dd;
					String s2 = bb + cc;
					if (s1.equals(s2)) {
						if (s1.length() > res.length()) {
							res = s1;
						} else if (s1.length() == res.length() && s1.compareTo(res) < 0) {
							res = s1;
						}
					}
				}
			}
		}
		
		return res;
	}
	
	public static void main(String[] args) {
		long time;
		String answer;
		boolean errors = false;
		String desiredAnswer;

/*		time = System.currentTimeMillis();
		answer = new TheBoringStoreDivTwo().find("StoreOfJohn", "StoreOfBrus");
		System.out.println("Time: " + (System.currentTimeMillis() - time)
				/ 1000.0 + " seconds");
		desiredAnswer = "or";
		System.out.println("Your answer:");
		System.out.println("\t" + answer);
		System.out.println("Desired answer:");
		System.out.println("\t" + desiredAnswer);
		if (!answer.equals(desiredAnswer)) {
			errors = true;
			System.out.println("DOESN'T MATCH!!!!");
		} else
			System.out.println("Match :-)");
		System.out.println();
		
		time = System.currentTimeMillis();
		answer = new TheBoringStoreDivTwo().find("JohnAndJohn", "John");
		System.out.println("Time: " + (System.currentTimeMillis() - time)
				/ 1000.0 + " seconds");
		desiredAnswer = "";
		System.out.println("Your answer:");
		System.out.println("\t" + answer);
		System.out.println("Desired answer:");
		System.out.println("\t" + desiredAnswer);
		if (!answer.equals(desiredAnswer)) {
			errors = true;
			System.out.println("DOESN'T MATCH!!!!");
		} else
			System.out.println("Match :-)");
		System.out.println();

		time = System.currentTimeMillis();
		answer = new TheBoringStoreDivTwo().find("JohnPlaysGames", "BrusAlsoPlays");
		System.out.println("Time: " + (System.currentTimeMillis() - time)
				/ 1000.0 + " seconds");
		desiredAnswer = "ays";
		System.out.println("Your answer:");
		System.out.println("\t" + answer);
		System.out.println("Desired answer:");
		System.out.println("\t" + desiredAnswer);
		if (!answer.equals(desiredAnswer)) {
			errors = true;
			System.out.println("DOESN'T MATCH!!!!");
		} else
			System.out.println("Match :-)");
		System.out.println();
		
		time = System.currentTimeMillis();
		answer = new TheBoringStoreDivTwo().find("abacaba", "abacabadabacaba");
		System.out.println("Time: " + (System.currentTimeMillis() - time)
				/ 1000.0 + " seconds");
		desiredAnswer = "abaabacaba";
		System.out.println("Your answer:");
		System.out.println("\t" + answer);
		System.out.println("Desired answer:");
		System.out.println("\t" + desiredAnswer);
		if (!answer.equals(desiredAnswer)) {
			errors = true;
			System.out.println("DOESN'T MATCH!!!!");
		} else
			System.out.println("Match :-)");
		System.out.println();

		time = System.currentTimeMillis();
		answer = new TheBoringStoreDivTwo().find("aaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaa");
		System.out.println("Time: " + (System.currentTimeMillis() - time)
				/ 1000.0 + " seconds");
		desiredAnswer = "aaaaaaaaaaaaaaa";
		System.out.println("Your answer:");
		System.out.println("\t" + answer);
		System.out.println("Desired answer:");
		System.out.println("\t" + desiredAnswer);
		if (!answer.equals(desiredAnswer)) {
			errors = true;
			System.out.println("DOESN'T MATCH!!!!");
		} else
			System.out.println("Match :-)");
		System.out.println();
*/		
		time = System.currentTimeMillis();
		answer = new TheBoringStoreDivTwo().find("MWaSyaMgqyVOaWS", "yiAxCyvCaRA");
		System.out.println("Time: " + (System.currentTimeMillis() - time)
				/ 1000.0 + " seconds");
		desiredAnswer = "MA";
		System.out.println("Your answer:");
		System.out.println("\t" + answer);
		System.out.println("Desired answer:");
		System.out.println("\t" + desiredAnswer);
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
