import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;
import java.awt.geom.*;

public class CasketOfStar
{
	public int maxEnergy(int[] weight)
	{
		return 0;
	}
	
	public static void main(String[] args)
    {
        long time;
        int answer;
        boolean errors = false;
        int desiredAnswer;
        
        time = System.currentTimeMillis();
        answer = new CasketOfStar().maxEnergy(new int[]{1,2,3,4});
        System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
        desiredAnswer = 12;
        System.out.println("Your answer:");
        System.out.println("\t" + answer);
        System.out.println("Desired answer:");
        System.out.println("\t" + desiredAnswer);
        if (answer != desiredAnswer)
        {
            errors = true;
            System.out.println("DOESN'T MATCH!!!!");
        }
        else
            System.out.println("Match :-)");
        System.out.println();
        time = System.currentTimeMillis();
        answer = new CasketOfStar().maxEnergy(new int[]{100,2,1,3,100});
        System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
        desiredAnswer = 10400;
        System.out.println("Your answer:");
        System.out.println("\t" + answer);
        System.out.println("Desired answer:");
        System.out.println("\t" + desiredAnswer);
        if (answer != desiredAnswer)
        {
            errors = true;
            System.out.println("DOESN'T MATCH!!!!");
        }
        else
            System.out.println("Match :-)");
        System.out.println();
        time = System.currentTimeMillis();
        answer = new CasketOfStar().maxEnergy(new int[]{2,2,7,6,90,5,9});
        System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
        desiredAnswer = 1818;
        System.out.println("Your answer:");
        System.out.println("\t" + answer);
        System.out.println("Desired answer:");
        System.out.println("\t" + desiredAnswer);
        if (answer != desiredAnswer)
        {
            errors = true;
            System.out.println("DOESN'T MATCH!!!!");
        }
        else
            System.out.println("Match :-)");
        System.out.println();
        time = System.currentTimeMillis();
        answer = new CasketOfStar().maxEnergy(new int[]{477,744,474,777,447,747,777,474});
        System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
        desiredAnswer = 2937051;
        System.out.println("Your answer:");
        System.out.println("\t" + answer);
        System.out.println("Desired answer:");
        System.out.println("\t" + desiredAnswer);
        if (answer != desiredAnswer)
        {
            errors = true;
            System.out.println("DOESN'T MATCH!!!!");
        }
        else
            System.out.println("Match :-)");
        System.out.println();
        time = System.currentTimeMillis();
        answer = new CasketOfStar().maxEnergy(new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1});
        System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
        desiredAnswer = 13;
        System.out.println("Your answer:");
        System.out.println("\t" + answer);
        System.out.println("Desired answer:");
        System.out.println("\t" + desiredAnswer);
        if (answer != desiredAnswer)
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