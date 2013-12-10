
public class LeftOrRight
{
	public int maxDistance(String program)
	{
		int pos = 0;
		int maxPos = 0;
		
		
		for (int i=0; i<program.length(); i++) {
		    if (program.charAt(i) == 'L') {
		        pos--;
		    }  else if (program.charAt(i) == 'R') {
		        pos++;
		    } else {
		        pos++;
		    }
		    if (Math.abs(pos) > maxPos) {
		        maxPos = Math.abs(pos);
		    }
		}

		pos = 0;
        for (int i=0; i<program.length(); i++) {
            if (program.charAt(i) == 'L') {
                pos--;
            }  else if (program.charAt(i) == 'R') {
                pos++;
            } else {
                pos--;
            }
            if (Math.abs(pos) > maxPos) {
                maxPos = Math.abs(pos);
            }
        }
        
        return maxPos;
		
	}
	
	public static void main(String[] args)
    {
        long time;
        int answer;
        boolean errors = false;
        int desiredAnswer;
        
        time = System.currentTimeMillis();
        answer = new LeftOrRight().maxDistance("LLLRLRRR");
        System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
        desiredAnswer = 3;
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
        answer = new LeftOrRight().maxDistance("R???L");
        System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
        desiredAnswer = 4;
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
        answer = new LeftOrRight().maxDistance("??????");
        System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
        desiredAnswer = 6;
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
        answer = new LeftOrRight().maxDistance("LL???RRRRRRR???");
        System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
        desiredAnswer = 11;
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
        answer = new LeftOrRight().maxDistance("L?L?");
        System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
        desiredAnswer = 4;
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