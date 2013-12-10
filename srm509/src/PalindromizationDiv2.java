public class PalindromizationDiv2 {
    int c;
    public int getMinimumCost(int X) {
        String a = "";
        for (int i=0; i<10000; i++) {
            StringBuffer n = new StringBuffer(Integer.toString(X));
            n.reverse();
            a = n.toString();
            if (Integer.parseInt(a) == X) {
                c++;
            }
        }
        System.out.println(c);
        if (X<10)
            return 0;
        String n = Integer.toString(X);
        int res = 0;
        int mid = n.length() / 2;
        String m1a = n.substring(0, mid);
        String m2;
        if (n.length() % 2 == 1)
            m2 = n.substring(mid+1);
        else
            m2 = n.substring(mid);
        String m1 = "";
        for (int i=0; i<m1a.length(); i++) {
            m1 += m1a.charAt(m1a.length() - i - 1);
        }
        System.out.println(m1 + "@" + m2);
        
        res = Math.abs(Integer.parseInt(m1) - Integer.parseInt(m2));
        
        return res;
    }

    public static void main(String[] args) {
        long time;
        int answer;
        boolean errors = false;
        int desiredAnswer;

        time = System.currentTimeMillis();
        answer = new PalindromizationDiv2().getMinimumCost(25);
        System.out.println("Time: " + (System.currentTimeMillis() - time) / 1000.0 + " seconds");
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
        answer = new PalindromizationDiv2().getMinimumCost(12321);
        System.out.println("Time: " + (System.currentTimeMillis() - time) / 1000.0 + " seconds");
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
        answer = new PalindromizationDiv2().getMinimumCost(40);
        System.out.println("Time: " + (System.currentTimeMillis() - time) / 1000.0 + " seconds");
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
        answer = new PalindromizationDiv2().getMinimumCost(2011);
        System.out.println("Time: " + (System.currentTimeMillis() - time) / 1000.0 + " seconds");
        desiredAnswer = 9;
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
        answer = new PalindromizationDiv2().getMinimumCost(0);
        System.out.println("Time: " + (System.currentTimeMillis() - time) / 1000.0 + " seconds");
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

        if (errors)
            System.out.println("Some of the test cases had errors :-(");
        else
            System.out.println("You're a stud (at least on the test data)! :-D ");
    }
}
