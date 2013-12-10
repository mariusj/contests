public class MathContest {
    
    public int countBlack(String ballSequence, int repetitions) {
        /*char[] balls = new char[ballSequence.length() * repetitions];
        for (int i=0; i<repetitions; i++) {
            for (int j=0; j<ballSequence.length(); j++) {
                balls[j + i*ballSequence.length()] = ballSequence.charAt(j);
            }
        }*/
        
        int black = 0;
        int start = 0;
        int end = ballSequence.length() * repetitions;
        boolean forward = true;
        boolean inverted = false;
        
        while (start < end) {
            char ball;
            if (forward) { 
                ball = ballSequence.charAt(start % ballSequence.length());
                start++;
            } else {
                end--;
                ball = ballSequence.charAt(end % ballSequence.length());
            }
            if (inverted)
                ball = ball=='W' ? 'B' : 'W';
            if (ball=='W') {
                forward = !forward;
            } else {
                black++;
                inverted = !inverted;
            }
        }
        return black;
    }
    
    public static void main(String[] args) {
        long time;
        int answer;
        boolean errors = false;
        int desiredAnswer;

        time = System.currentTimeMillis();
        answer = new MathContest().countBlack("BBWWB", 1);
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
        time = System.currentTimeMillis();
        answer = new MathContest().countBlack("BBB", 10);
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
        answer = new MathContest().countBlack("BW", 10);
        System.out.println("Time: " + (System.currentTimeMillis() - time)
                / 1000.0 + " seconds");
        desiredAnswer = 20;
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
        answer = new MathContest().countBlack("WWWWWWWBWWWWWWWWWWWWWW", 1);
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
