import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class Lottery {
	
	public static BigInteger factorial( BigInteger n )
    {
        if( n.longValue() <= 1 )     // base case
            return BigInteger.valueOf(1);
        else
            return n.multiply(factorial( n.subtract(BigInteger.valueOf(1)) ));
    }
	
	public static double factorial( double n )
    {
        if( (long)n <= 1 )     // base case
            return 1.0;
        else
            return n * factorial( n - 1.0);
    }
	
	public static long factorial( long n )
    {
        if (n <= 1)     // base case
            return 1;
        else
            return n * factorial(n - 1);
    }
	
/*
	public static long binomialCoefficient(long n, long k) {
		if (k == 0 || k == n)
			return 1;
		return  binomialCoefficient(n - 1, k - 1) + binomialCoefficient(n - 1, k);
	}
	*/
	
	public static long binomialCoefficient(long n, long k) {
		if (k == n)
			return 1;
		long res = 1;
		for (long i=0; i<k; i++) {
			res = res * (n - i) / (i+1);
		}
		return res;
	}
	
	private static class LotteryInner implements Comparable<LotteryInner> {
		public String name;
		public int choices;
		public int blanks;
		public boolean sorted;
		public boolean unique;
		public double chance;
		
		public LotteryInner(String params) {
			String[] p1 = params.split(":");
			name = p1[0];
			String[] p2 = p1[1].trim().split(" ");
			choices = Integer.parseInt(p2[0]);
			blanks = Integer.parseInt(p2[1]);
			sorted = "T".equals(p2[2]);
			unique = "T".equals(p2[3]);
			
			//System.out.println(params);
			if (!sorted && !unique) {
				chance = Math.pow(choices, blanks);
			} else if (!sorted && unique){
				//chance = factorial(choices) / factorial(choices - blanks);
				chance = binomialCoefficient(choices, blanks) * factorial(blanks);
			} else if (sorted && !unique) {
				//chance = factorial(choices + blanks - 1) / factorial(blanks) / factorial(choices - 1);
				chance = binomialCoefficient(choices + blanks - 1, blanks);
			} else if (sorted && unique) {
				//factorial(choices) / factorial(blanks) / factorial(choices - blanks)
				chance = binomialCoefficient(choices, blanks);
			}
			
			//System.out.println(name + " " + Double.toString(chance));
			
		}

		@Override
		public int compareTo(LotteryInner o) {
			if (this.chance > o.chance)
				return 1;
			if (this.chance < o.chance)
				return -1;
			return name.compareTo(o.name);
		}
	}
	
	public String[] sortByOdds(String[] rules) {
		List<LotteryInner> lotteries = new ArrayList<LotteryInner>();
		for (String rule : rules) {
			LotteryInner lottery = new LotteryInner(rule);
			lotteries.add(lottery);
		}
		Collections.sort(lotteries);
		String[] res = new String[rules.length];
		for (int i=0; i<rules.length; i++) {
			res[i] = lotteries.get(i).name;
		}
		return res;
	}
	
	public void test(int idx, String[] rules, String[] r1) {
		String[] tr = sortByOdds(rules);
		if (!Arrays.equals(r1, tr)) {
			System.out.println(idx);
			for (String r : tr)
				System.out.println(r);
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Lottery l = new Lottery();
		
		String[] t1 = {"PICK ANY TWO: 10 2 F F"
			,"PICK TWO IN ORDER: 10 2 T F"
			,"PICK TWO DIFFERENT: 10 2 F T"
			,"PICK TWO LIMITED: 10 2 T T"};
		String[] r1 = { "PICK TWO LIMITED",
			  "PICK TWO IN ORDER",
			  "PICK TWO DIFFERENT",
			  "PICK ANY TWO" };
		l.test(1, t1, r1);
		
		String[] t2 = {"INDIGO: 93 8 T F",
			 "ORANGE: 29 8 F T",
			 "VIOLET: 76 6 F F",
			 "BLUE: 100 8 T T",
			 "RED: 99 8 T T",
			 "GREEN: 78 6 F T",
			 "YELLOW: 75 6 F F"};
		String[] r2 = { "RED",  "ORANGE",  "YELLOW",  "GREEN",  "BLUE",  "INDIGO",  "VIOLET" };		
		l.test(2, t2, r2);
		
		String[] t3 = new String[0];
		String[] r4 = new String[0];
		l.test(3, t3, r4);
		
	}

}
