
public class MuddyRoad {
    
    public double getExpectedValue(int[] road) {
        double res = 0.0;
        double mprob[] = new double[road.length];
        for (int i=1; i<road.length-1; i++) {
            double prob = (road[i] * road[i+1]) / 10000.0;
            int j = i - 1;
            while (j > 0 && road[j] > 0) {
                prob *= (road[j] / 100.0);
                j--;
            }
            mprob[i] = prob;
        }
        return res;
    }

    public static void main(String[] args) {
        long time;
        double answer;
        boolean errors = false;
        double desiredAnswer;

        time = System.currentTimeMillis();
        answer = new MuddyRoad().getExpectedValue(new int[] { 0, 60, 60, 0 });
        System.out.println("Time: " + (System.currentTimeMillis() - time) / 1000.0 + " seconds");
        desiredAnswer = 0.36D;
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
        answer = new MuddyRoad().getExpectedValue(new int[] { 0, 50, 50, 50, 50, 0 });
        System.out.println("Time: " + (System.currentTimeMillis() - time) / 1000.0 + " seconds");
        desiredAnswer = 0.5625D;
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
        answer = new MuddyRoad().getExpectedValue(new int[] { 0, 0, 100, 100, 100, 100, 100, 100,
                0, 0, 100, 0 });
        System.out.println("Time: " + (System.currentTimeMillis() - time) / 1000.0 + " seconds");
        desiredAnswer = 3.0D;
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
        answer = new MuddyRoad().getExpectedValue(new int[] { 0, 12, 34, 56, 78, 91, 23, 45, 67,
                89, 0 });
        System.out.println("Time: " + (System.currentTimeMillis() - time) / 1000.0 + " seconds");
        desiredAnswer = 1.7352539420031923D;
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
        answer = new MuddyRoad().getExpectedValue(new int[] { 0, 50, 50, 100, 50, 100, 50, 50, 100,
                66, 0 });
        System.out.println("Time: " + (System.currentTimeMillis() - time) / 1000.0 + " seconds");
        desiredAnswer = 2.288125D;
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
