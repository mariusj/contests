public class MinskyMysteryDiv2 {
    public long computeAnswer(long N) {
        long[] bags = { N, 0, 0, 0, 0 };
        bags[1]++;
        while (true) {
            bags[1]++;
            bags[4] = 0;
            while (bags[0] > 0) {
                if (bags[0] > 0 && bags[1] > 0) {
                    long num = Math.min(bags[0], bags[1]);
                    bags[0] -= num;
                    bags[1] -= num;
                    bags[2] += num;
                    bags[3] += num;
                }
                bags[4]++;
                if (bags[0] == 0 && bags[1] == 0) {
                    bags[4] += bags[3];
                    return bags[4];
                }
                bags[1] += bags[3];
                bags[3] = 0;
            }
            bags[0] += bags[2];
            bags[2] = 0;
            if (bags[0] == 0 && bags[2] == 0)
                return -1;
        }
    }

    public static void main(String[] args) {
        long time;
        long answer;
        boolean errors = false;
        long desiredAnswer;

        // time = System.currentTimeMillis();
        // answer = new MinskyMysteryDiv2().computeAnswer(2L);
        // System.out.println("Time: " + (System.currentTimeMillis() - time) /
        // 1000.0 + " seconds");
        // desiredAnswer = 3L;
        // System.out.println("Your answer:");
        // System.out.println("\t" + answer);
        // System.out.println("Desired answer:");
        // System.out.println("\t" + desiredAnswer);
        // if (answer != desiredAnswer) {
        // errors = true;
        // System.out.println("DOESN'T MATCH!!!!");
        // } else
        // System.out.println("Match :-)");
        // System.out.println();
        time = System.currentTimeMillis();
        answer = new MinskyMysteryDiv2().computeAnswer(1000000000000L);
        System.out.println("Time: " + (System.currentTimeMillis() - time) / 1000.0 + " seconds");
        desiredAnswer = -1L;
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
        answer = new MinskyMysteryDiv2().computeAnswer(4L);
        System.out.println("Time: " + (System.currentTimeMillis() - time) / 1000.0 + " seconds");
        desiredAnswer = 4L;
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
        answer = new MinskyMysteryDiv2().computeAnswer(15L);
        System.out.println("Time: " + (System.currentTimeMillis() - time) / 1000.0 + " seconds");
        desiredAnswer = 8L;
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
        answer = new MinskyMysteryDiv2().computeAnswer(24L);
        System.out.println("Time: " + (System.currentTimeMillis() - time) / 1000.0 + " seconds");
        desiredAnswer = 14L;
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
// Powered by [KawigiEdit] 2.0!