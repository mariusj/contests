import java.math.BigInteger;


public class kombinacje {

	// n!
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
	
	public static long binomialCoefficientRec(long n, long k) {
		if (k == 0 || k == n)
			return 1;
		return  binomialCoefficientRec(n - 1, k - 1) + binomialCoefficientRec(n - 1, k);
	}
	
	// n po k
	// n! / (k! / (n-k)!)
	public static long binomialCoefficient(long n, long k) {
		if (k == n)
			return 1;
		long res = 1;
		for (long i=0; i<k; i++) {
			res = res * (n - i) / (i+1);
		}
		return res;
	}
	
	
}
