import java.util.HashSet;
import java.util.Set;


public class Zoo {
    
    static class Answer {
        int cats;
        int rabbits;
        
        public int hashCode() {
            return cats + rabbits;
        }
        
        public boolean equals(Object obj) {
            Answer other = (Answer) obj;
            return cats == other.cats && rabbits == other.rabbits;
        }
    }
    
    public long theCount(int[] answers) {
        int max = 0;
        int len = answers.length;
        for (int i=0; i<len; i++) {
            if (answers[i] > len)
                return 0;
            if (answers[i] > max)
                max = answers[i];
        }
        
        int other = len - max;
        for (int i=0; i<len; i++) {
            
        }
        
        return 0;
    }

    public static void main(String[] args) {
        long time;
        long answer;
        boolean errors = false;
        long desiredAnswer;

        time = System.currentTimeMillis();
        answer = new Zoo().theCount(new int[] { 0, 1, 2, 3, 4 });
        System.out.println("Time: " + (System.currentTimeMillis() - time) / 1000.0 + " seconds");
        desiredAnswer = 2L;
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
        answer = new Zoo().theCount(new int[] { 5, 8 });
        System.out.println("Time: " + (System.currentTimeMillis() - time) / 1000.0 + " seconds");
        desiredAnswer = 0L;
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
        answer = new Zoo().theCount(new int[] { 0, 0, 0, 0, 0, 0 });
        System.out.println("Time: " + (System.currentTimeMillis() - time) / 1000.0 + " seconds");
        desiredAnswer = 0L;
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
        answer = new Zoo().theCount(new int[] { 1, 0, 2, 0, 1 });
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
        answer = new Zoo().theCount(new int[] { 1, 0, 1 });
        System.out.println("Time: " + (System.currentTimeMillis() - time) / 1000.0 + " seconds");
        desiredAnswer = 0L;
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
