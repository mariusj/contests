public class RedAndGreen {
    
    public int minPaints(String row) {
        int res = Integer.MAX_VALUE;
        for (int i=0; i<=row.length(); i++) {
            int changes = redTo(row, i);
            res = Math.min(res, changes);
        }
        return res;
    }

    private int redTo(String row, int to) {
        int changes = 0;
        for (int i=0; i<to; i++) {
            if (row.charAt(i) == 'G')
                changes++;
        }
        for (int i=to; i<row.length(); i++) {
            if (row.charAt(i) == 'R')
                changes++;
        }
        return changes;
    }

    public static void main(String[] args)
    {
        long time;
        int answer;
        boolean errors = false;
        int desiredAnswer;
        
        time = System.currentTimeMillis();
        answer = new RedAndGreen().minPaints("R");
        System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
        desiredAnswer = 0;
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
        answer = new RedAndGreen().minPaints("RRRGGGGG");
        System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
        desiredAnswer = 0;
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
        answer = new RedAndGreen().minPaints("GGGGRRR");
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
        answer = new RedAndGreen().minPaints("RGRGRGRGRGRGRGRGR");
        System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
        desiredAnswer = 8;
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
        answer = new RedAndGreen().minPaints("RRRGGGRGGGRGGRRRGGRRRGR");
        System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
        desiredAnswer = 9;
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
