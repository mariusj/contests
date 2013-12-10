import java.util.ArrayList;
import java.util.Collections;

public class FoxListeningToMusic {
    
    private int[] length;
    private int T;
    private double res[];
    private ArrayList<ArrayList<Integer>> res2;
    
    private double sum(int i) {
        ArrayList<Integer> list = res2.get(i);
        double ret = 0.0;
        for (Integer d : list) {
            int pow = (int) Math.pow(length.length, d);
            
            ret += 1.0 / Math.pow(length.length, d);
        }
        return ret;
    }
    
    static long gcd(long a, long b) {
        if (a == 0)
            return b;
        if (b == 0)
            return a;
        if (a > b)
            return gcd(a % b, b);
        else
            return gcd(a, b % a);
    }
    
    static long lcm(int a, int b) {
        return a * b / gcd(a, b);
    }

    public double[] getProbabilities(int[] length, int T) {
        this.length = length;
        this.T = T;
        res = new double[length.length];
//        res2 = new ArrayList<ArrayList<Integer>>();
//        for (int i=0; i<length.length; i++) {
//            res2.add(new ArrayList<Integer>());
//        }
        int time = 0;
        double prob = 1.0 / length.length;
        int level = 1;
        for (int i=0; i<length.length; i++) {
            calc(time, i, prob, level);
        }
//        for (int i=0; i<length.length; i++) {
//            res[i] = sum(i);
//        }
        return res;
    }

    private void calc(int time, int idx, double prob, int level) {
        int len = length[idx];
        if (time + len > T) {
            //System.out.println("add " + idx + " " + prob);
            res[idx] += prob;
            //res2[idx][level]++;
            //res2.get(idx).add(level);
        } else {
            time = time + len;
            prob = prob / length.length;
            level++;
            for (int i=0; i<length.length; i++) {
                calc(time, i, prob, level);
            }
        }
    }
    
    
    public static void main(String[] args)
    {
        long time;
        double[] answer;
        boolean errors = false;
        double[] desiredAnswer;
        
        boolean same;
        time = System.currentTimeMillis();
        answer = new FoxListeningToMusic().getProbabilities(new int[]{1, 2}, 1);
        System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
        desiredAnswer = new double[]{0.25D, 0.75D };
        System.out.println("Your answer:");
        if (answer.length > 0)
        {
            System.out.print("\t{ " + answer[0]);
            for (int i=1; i<answer.length; i++)
                System.out.print(", " + answer[i]);
            System.out.println(" }");
        }
        else
            System.out.println("\t{ }");
        System.out.println("Desired answer:");
        if (desiredAnswer.length > 0)
        {
            System.out.print("\t{ " + desiredAnswer[0]);
            for (int i=1; i<desiredAnswer.length; i++)
                System.out.print(", " + desiredAnswer[i]);
            System.out.println(" }");
        }
        else
            System.out.println("\t{ }");
        same = desiredAnswer.length == answer.length;
        for (int i=0; i<answer.length && same; i++)
            if (answer[i] != desiredAnswer[i])
                same = false;
        if (!same)
        {
            errors = true;
            System.out.println("DOESN'T MATCH!!!!");
        }
        else
            System.out.println("Match :-)");
        System.out.println();
        time = System.currentTimeMillis();
        answer = new FoxListeningToMusic().getProbabilities(new int[]{1, 10, 100, 1000, 10000}, 0);
        System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
        desiredAnswer = new double[]{0.2D, 0.2D, 0.2D, 0.2D, 0.2D };
        System.out.println("Your answer:");
        if (answer.length > 0)
        {
            System.out.print("\t{ " + answer[0]);
            for (int i=1; i<answer.length; i++)
                System.out.print(", " + answer[i]);
            System.out.println(" }");
        }
        else
            System.out.println("\t{ }");
        System.out.println("Desired answer:");
        if (desiredAnswer.length > 0)
        {
            System.out.print("\t{ " + desiredAnswer[0]);
            for (int i=1; i<desiredAnswer.length; i++)
                System.out.print(", " + desiredAnswer[i]);
            System.out.println(" }");
        }
        else
            System.out.println("\t{ }");
        same = desiredAnswer.length == answer.length;
        for (int i=0; i<answer.length && same; i++)
            if (answer[i] != desiredAnswer[i])
                same = false;
        if (!same)
        {
            errors = true;
            System.out.println("DOESN'T MATCH!!!!");
        }
        else
            System.out.println("Match :-)");
        System.out.println();
        time = System.currentTimeMillis();
        answer = new FoxListeningToMusic().getProbabilities(new int[]{5, 8, 4, 7}, 10);
        System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
        desiredAnswer = new double[]{0.1875D, 0.3125D, 0.1875D, 0.3125D };
        System.out.println("Your answer:");
        if (answer.length > 0)
        {
            System.out.print("\t{ " + answer[0]);
            for (int i=1; i<answer.length; i++)
                System.out.print(", " + answer[i]);
            System.out.println(" }");
        }
        else
            System.out.println("\t{ }");
        System.out.println("Desired answer:");
        if (desiredAnswer.length > 0)
        {
            System.out.print("\t{ " + desiredAnswer[0]);
            for (int i=1; i<desiredAnswer.length; i++)
                System.out.print(", " + desiredAnswer[i]);
            System.out.println(" }");
        }
        else
            System.out.println("\t{ }");
        same = desiredAnswer.length == answer.length;
        for (int i=0; i<answer.length && same; i++)
            if (answer[i] != desiredAnswer[i])
                same = false;
        if (!same)
        {
            errors = true;
            System.out.println("DOESN'T MATCH!!!!");
        }
        else
            System.out.println("Match :-)");
        System.out.println();
        time = System.currentTimeMillis();
        answer = new FoxListeningToMusic().getProbabilities(new int[]{10, 1}, 9);
        System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
        desiredAnswer = new double[]{0.9990234375D, 9.765625E-4D };
        System.out.println("Your answer:");
        if (answer.length > 0)
        {
            System.out.print("\t{ " + answer[0]);
            for (int i=1; i<answer.length; i++)
                System.out.print(", " + answer[i]);
            System.out.println(" }");
        }
        else
            System.out.println("\t{ }");
        System.out.println("Desired answer:");
        if (desiredAnswer.length > 0)
        {
            System.out.print("\t{ " + desiredAnswer[0]);
            for (int i=1; i<desiredAnswer.length; i++)
                System.out.print(", " + desiredAnswer[i]);
            System.out.println(" }");
        }
        else
            System.out.println("\t{ }");
        same = desiredAnswer.length == answer.length;
        for (int i=0; i<answer.length && same; i++)
            if (answer[i] != desiredAnswer[i])
                same = false;
        if (!same)
        {
            errors = true;
            System.out.println("DOESN'T MATCH!!!!");
        }
        else
            System.out.println("Match :-)");
        System.out.println();
        time = System.currentTimeMillis();
        answer = new FoxListeningToMusic().getProbabilities(new int[]{58, 47, 36, 25, 14, 3}, 100);
        System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
        desiredAnswer = new double[]{0.32895835374381194D, 0.26291497538241776D, 0.18463894970453887D, 0.1312301113062895D, 0.07518634032025856D, 0.017071269542683242D };
        System.out.println("Your answer:");
        if (answer.length > 0)
        {
            System.out.print("\t{ " + answer[0]);
            for (int i=1; i<answer.length; i++)
                System.out.print(", " + answer[i]);
            System.out.println(" }");
        }
        else
            System.out.println("\t{ }");
        System.out.println("Desired answer:");
        if (desiredAnswer.length > 0)
        {
            System.out.print("\t{ " + desiredAnswer[0]);
            for (int i=1; i<desiredAnswer.length; i++)
                System.out.print(", " + desiredAnswer[i]);
            System.out.println(" }");
        }
        else
            System.out.println("\t{ }");
        same = desiredAnswer.length == answer.length;
        for (int i=0; i<answer.length && same; i++)
            if (answer[i] != desiredAnswer[i])
                same = false;
        if (!same)
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
