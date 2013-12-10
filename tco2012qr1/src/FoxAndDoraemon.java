import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


public class FoxAndDoraemon {
    
    public int minTime(int[] workCost, int splitCost) {
        if (workCost.length == 1)
            return workCost[0];
        int time = 0;
        Arrays.sort(workCost);
        ArrayList<Integer> work = new ArrayList<Integer>();
        for (int i=0; i<workCost.length; i++)
            work.add(workCost[i]);
        ArrayList<Integer> foxes = new ArrayList<Integer>();
        
        time += splitCost;

        int last = work.remove(work.size()-1);
        foxes.add(time + last);
        
        while (work.size() > 1) {
            Collections.sort(foxes);
            int first = work.remove(0);
            int minFox = foxes.get(0); 
            if (minFox < time) {
                time = minFox + splitCost;
                foxes.add(time + first);
            } else {
                time += splitCost;
                foxes.add(time + first);
            }
        }

        last = work.remove(work.size()-1);
        foxes.add(time + last);
        
        return Collections.max(foxes);
    }

    public static void main(String[] args) {
        long time;
        int answer;
        boolean errors = false;
        int desiredAnswer;

        time = System.currentTimeMillis();
        answer = new FoxAndDoraemon().minTime(new int[] { 1, 2 }, 1000);
        System.out.println("Time: " + (System.currentTimeMillis() - time) / 1000.0 + " seconds");
        desiredAnswer = 1002;
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
        answer = new FoxAndDoraemon().minTime(new int[] { 3, 6, 9, 12 }, 1000);
        System.out.println("Time: " + (System.currentTimeMillis() - time) / 1000.0 + " seconds");
        desiredAnswer = 2012;
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
        answer = new FoxAndDoraemon().minTime(new int[] { 1000, 100, 10, 1 }, 1);
        System.out.println("Time: " + (System.currentTimeMillis() - time) / 1000.0 + " seconds");
        desiredAnswer = 1001;
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
        answer = new FoxAndDoraemon()
                .minTime(new int[] { 1712, 1911, 1703, 1610, 1697, 1612 }, 100);
        System.out.println("Time: " + (System.currentTimeMillis() - time) / 1000.0 + " seconds");
        desiredAnswer = 2012;
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
        answer = new FoxAndDoraemon().minTime(new int[] { 3000, 3000, 3000, 3000, 3000, 3000, 3000,
                3000, 3000, 3000 }, 3000);
        System.out.println("Time: " + (System.currentTimeMillis() - time) / 1000.0 + " seconds");
        desiredAnswer = 15000;
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
        answer = new FoxAndDoraemon().minTime(new int[] { 58 }, 3600);
        System.out.println("Time: " + (System.currentTimeMillis() - time) / 1000.0 + " seconds");
        desiredAnswer = 58;
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