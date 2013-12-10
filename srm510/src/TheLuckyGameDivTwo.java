import java.util.ArrayList;
import java.util.List;


public class TheLuckyGameDivTwo {
    public int find(int a, int b, int jLen, int bLen) {
        List<Integer> lucky = new ArrayList<Integer>();
        num: for (int i=a; i<=b; i++) {
            String num = Integer.toString(i);
            for (int d=0; d<num.length(); d++) {
                if (num.charAt(d) != '4' && num.charAt(d) != '7')  
                    continue num;
            }
            lucky.add(i);
        }
        System.out.println(lucky);
        int max = Integer.MIN_VALUE;
        int maxStart = 0;
        int maxEnd = 0;
        for (int i=a; i<b; i++) {
            if (i + jLen - 1 > b)
                break;
            int cnt = 0;
            for (int j=i; j<i + jLen; j++) {
                if (lucky.contains(j))
                    cnt++;
            }
            if (cnt > max) {
                max = cnt;
                maxStart = i;
                maxEnd = i + jLen;
            }
        }
        System.out.println(maxStart);
        System.out.println(maxEnd);
        System.out.println(max);
        
        int min = Integer.MAX_VALUE;
        int minStart = 0;
        int minEnd = 0;
        for (int i=maxStart; i<maxEnd; i++) {
            if (i + bLen - 1 > b)
                break;
            int cnt = 0;
            for (int j=i; j<i+bLen; j++) {
                if (lucky.contains(j))
                    cnt++;
            }
            if (cnt < min) {
                min = cnt;
                minStart = i;
                minEnd = i + bLen;
            }
        }
        
        System.out.println(minStart);
        System.out.println(minEnd);
        System.out.println(min);

        return min;
    }

    public static void main(String[] args) {
        long time;
        int answer;
        boolean errors = false;
        int desiredAnswer;

        time = System.currentTimeMillis();
        answer = new TheLuckyGameDivTwo().find(1, 10, 2, 1);
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
        answer = new TheLuckyGameDivTwo().find(1, 100, 100, 100);
        System.out.println("Time: " + (System.currentTimeMillis() - time) / 1000.0 + " seconds");
        desiredAnswer = 6;
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
        answer = new TheLuckyGameDivTwo().find(4, 8, 3, 2);
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
        answer = new TheLuckyGameDivTwo().find(1, 100, 75, 50);
        System.out.println("Time: " + (System.currentTimeMillis() - time) / 1000.0 + " seconds");
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
            System.out.println("You're a stud (at least on the test data)! :-D ");
    }

}
// Powered by [KawigiEdit] 2.0!

// 4 7 47 74 44 77
