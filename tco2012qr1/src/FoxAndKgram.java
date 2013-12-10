import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FoxAndKgram {
    public int maxK(int[] len) {
        Arrays.sort(len);
        int res = 0;
        for (int k = 1; k <= len.length; k++) {
            List<Integer> lenList = new ArrayList<Integer>();
            for (int i = 0; i < len.length; i++)
                lenList.add(len[i]);
            boolean correctRow = false;
            rowLab: for (int row = 1; row <= k; row++) {
                correctRow = false;
                if (lenList.remove(Integer.valueOf(k))) {
                    correctRow = true;
                } else {
                    for (int p = 1; p <= k / 2; p++) {
                        int p1 = lenList.indexOf(p);
                        int p2 = lenList.lastIndexOf(k - p - 1);
                        if (p1 > -1 && p2 > -1 && p1 != p2) {
                            lenList.remove(p2);
                            lenList.remove(p1);
                            correctRow = true;
                            break;
                        }
                    }
                }
                if (!correctRow)
                    break rowLab;
            }
            if (correctRow)
                res = k;
        }
        return res;
    }

    public static void main(String[] args) {
        long time;
        int answer;
        boolean errors = false;
        int desiredAnswer;

        time = System.currentTimeMillis();
        answer = new FoxAndKgram().maxK(new int[] { 1, 1, 1, 1, 3 });
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
        answer = new FoxAndKgram().maxK(new int[] { 2, 2, 1, 3, 5, 5, 5 });
        System.out.println("Time: " + (System.currentTimeMillis() - time) / 1000.0 + " seconds");
        desiredAnswer = 5;
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
        answer = new FoxAndKgram().maxK(new int[] { 1 });
        System.out.println("Time: " + (System.currentTimeMillis() - time) / 1000.0 + " seconds");
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
        answer = new FoxAndKgram().maxK(new int[] { 2, 2, 2, 2, 2, 2, 2, 2, 2, 2 });
        System.out.println("Time: " + (System.currentTimeMillis() - time) / 1000.0 + " seconds");
        desiredAnswer = 5;
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
        answer = new FoxAndKgram().maxK(new int[] { 1, 2, 3, 1, 2, 4, 2, 3, 1 });
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
        answer = new FoxAndKgram().maxK(new int[] { 50,50,50,50,50,50,50,50,50,50,
                50,50,50,50,50,50,50,50,50,50,
                50,50,50,50,50,50,50,50,50,50,
                50,50,50,50,50,50,50,50,50,50,
                50,50,50,50,50,50,50,50,50,50
                });
        System.out.println("Time: " + (System.currentTimeMillis() - time) / 1000.0 + " seconds");
        desiredAnswer = 50;
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