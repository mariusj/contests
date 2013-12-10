
public class OneRegister {

    private int t;
    private String solution;

    public String getProgram(int s, int t) {
        if (s == t)
            return "";
        if (t == 1)
            return "/";
        this.t = t;
        genProg("", s);
        genProg("/", 1);
        if (solution == null)
            return ":-(";
        return solution;
    }

    public int compare(String o1, String o2) {
        if (o1.length() != o2.length())
            return o1.length() - o2.length();
        return o1.compareTo(o2);
    }

    private void genProg(String current, long v) {
        long mv = v * v;
        long av = v + v;
        String currentm = current + "*";
        String currenta = current + "+";
        if (mv == t) {
            addSolution(currentm);
        } else if (mv != 1 && mv < t) {
            genProg(currentm, mv);
        }
        if (av == t) {
            addSolution(currenta);
        } else if (av < t) {
            genProg(currenta, av);
        }
    }

    private void addSolution(String sol) {
        if (solution == null) {
            solution = sol;
        } else {
            if (compare(sol, solution) < 0)
                solution = sol;
        }
    }

    public static void main(String[] args) {
        long time;
        String answer;
        boolean errors = false;
        String desiredAnswer;

        time = System.currentTimeMillis();
        answer = new OneRegister().getProgram(7, 392);
        System.out.println("Time: " + (System.currentTimeMillis() - time)
                / 1000.0 + " seconds");
        desiredAnswer = "+*+";
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
        answer = new OneRegister().getProgram(7, 256);
        System.out.println("Time: " + (System.currentTimeMillis() - time)
                / 1000.0 + " seconds");
        desiredAnswer = "/+***";
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
        answer = new OneRegister().getProgram(4, 256);
        System.out.println("Time: " + (System.currentTimeMillis() - time)
                / 1000.0 + " seconds");
        desiredAnswer = "**";
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
        answer = new OneRegister().getProgram(7, 7);
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
        answer = new OneRegister().getProgram(7, 9);
        System.out.println("Time: " + (System.currentTimeMillis() - time)
                / 1000.0 + " seconds");
        desiredAnswer = ":-(";
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
        answer = new OneRegister().getProgram(10, 1);
        System.out.println("Time: " + (System.currentTimeMillis() - time)
                / 1000.0 + " seconds");
        desiredAnswer = "/";
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
        answer = new OneRegister().getProgram(1000000000, 536870912);
        System.out.println("Time: " + (System.currentTimeMillis() - time)
                / 1000.0 + " seconds");
        desiredAnswer = "/+*+*+**+";
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
        answer = new OneRegister().getProgram(1, 1000000000);
        System.out.println("Time: " + (System.currentTimeMillis() - time)
                / 1000.0 + " seconds");
        desiredAnswer = ":-(";
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
