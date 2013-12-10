
public class RectangleArea {
    public int minimumQueries(String[] known) {
        return 0;
    }

    public static void main(String[] args) {
        long time;
        int answer;
        boolean errors = false;
        int desiredAnswer;

        time = System.currentTimeMillis();
        answer = new RectangleArea()
                .minimumQueries(new String[] { "NN", "NN" });
        System.out.println("Time: " + (System.currentTimeMillis() - time)
                / 1000.0 + " seconds");
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
        answer = new RectangleArea().minimumQueries(new String[] { "YNY",
                "NYN", "YNY" });
        System.out.println("Time: " + (System.currentTimeMillis() - time)
                / 1000.0 + " seconds");
        desiredAnswer = 1;
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
        answer = new RectangleArea().minimumQueries(new String[] { "YY", "YY",
                "YY", "YY" });
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
        answer = new RectangleArea()
                .minimumQueries(new String[] { "NNNNNNNNNN" });
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
        answer = new RectangleArea().minimumQueries(new String[] { "NNYYYNN",
                "NNNNNYN", "YYNNNNY", "NNNYNNN", "YYNNNNY" });
        System.out.println("Time: " + (System.currentTimeMillis() - time)
                / 1000.0 + " seconds");
        desiredAnswer = 2;
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
// Powered by [KawigiEdit] 2.0!