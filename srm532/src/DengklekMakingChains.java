import java.util.Arrays;


public class DengklekMakingChains {
    public int maxBeauty(String[] chains) {
        int ret = 0;
        int n = chains.length;
        int startValue[] = new int[n];
        int endValue[] = new int[n];
        int midValue[] = new int[n];
        
        int maxStart = -1;
        int maxEnd = -1;
        int maxStartIdx = -1;
        int maxEndIdx = -1;
        
        for (int i=0; i<n; i++) {
            int dots = countDots(chains[i]);
            if (dots == 0) {
                ret += value(chains[i], 0, 2);
            } else {
                int start = 0;
                int end = -1;
                while (end < 2 && chains[i].charAt(end+1) != '.')
                    end++;
                startValue[i] = value(chains[i], start, end);
                start = 3;
                end = 2;
                while (start > 0 && chains[i].charAt(start-1) != '.')
                    start--;
                endValue[i] = value(chains[i], start, end);
                if (endValue[i] >= maxEnd) {
                    maxEnd = endValue[i];
                    maxEndIdx = i;
                }
                if (startValue[i] > maxStart) {
                    maxStart = startValue[i];
                    maxStartIdx = i;
                }
                midValue[i] = chains[i].charAt(1) - 48;
            }
        }
        
        if (maxStart != -1 && maxStartIdx==maxEndIdx) {
            int ret1 = ret + maxStart;
            int ret2 = ret + maxEnd;
            
            maxStart = 0;
            maxEnd = 0;
            startValue[maxStartIdx] = 0;
            endValue[maxEndIdx] = 0;
            
            for (int i=0; i<n; i++) {
                if (startValue[i] > maxStart) {
                    maxStart = startValue[i];
                }
                if (endValue[i] > maxEnd) {
                    maxEnd = endValue[i];
                }
            }
            
            ret1 += maxEnd;
            ret2 += maxStart;            
            ret = Math.max(ret1, ret2);            
        } else {
            if (maxStart != -1)
                ret += maxStart;
            
            if (maxEnd != -1)
                ret += maxEnd;
        }
        
        Arrays.sort(midValue);
        int maxMid = midValue[midValue.length - 1];
        if (maxMid > ret)
            return maxMid;
        
        return ret;        
    }
    
    private int countDots(String chain) {
        int dots = 0;
        for (int j=0; j<3; j++)
            if (chain.charAt(j) == '.')
                dots++;
        return dots;
    }
    
    private int value(String chain, int start, int end) {
        int v = 0;
        for (int i=start; i<=end; i++) {
            v += chain.charAt(i) - 48;
        }
        return v;
    }

    public static void main(String[] args) {
        long time;
        int answer;
        boolean errors = false;
        int desiredAnswer;

        time = System.currentTimeMillis();
        answer = new DengklekMakingChains().maxBeauty(new String[] { ".15", "7..", "402", "..3" });
        System.out.println("Time: " + (System.currentTimeMillis() - time) / 1000.0 + " seconds");
        desiredAnswer = 19;
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
        answer = new DengklekMakingChains().maxBeauty(new String[] { "..1", "7..", "567", "24.",
                "8..", "234" });
        System.out.println("Time: " + (System.currentTimeMillis() - time) / 1000.0 + " seconds");
        desiredAnswer = 36;
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
        answer = new DengklekMakingChains().maxBeauty(new String[] { "...", "..." });
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
        answer = new DengklekMakingChains().maxBeauty(new String[] { "36.", "9.8", ".24", "52.",
                "3.1", "532", "4.4", "111" });
        System.out.println("Time: " + (System.currentTimeMillis() - time) / 1000.0 + " seconds");
        desiredAnswer = 30;
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
        answer = new DengklekMakingChains().maxBeauty(new String[] { "..1", "3..", "2..", ".7." });
        System.out.println("Time: " + (System.currentTimeMillis() - time) / 1000.0 + " seconds");
        desiredAnswer = 7;
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
        answer = new DengklekMakingChains().maxBeauty(new String[] { "412", "..7", ".58", "7.8",
                "32.", "6..", "351", "3.9", "985", "...", ".46" });
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