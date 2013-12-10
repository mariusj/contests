import java.util.ArrayList;

public class PlatypusPaternity {
    public int maxFamily(String[] femaleCompatibility, String[] maleCompatibility,
            String[] siblingGroups) {
        int res = 0;
        for (int i=0; i<siblingGroups.length; i++) {
            int grouplen = 0;
            ArrayList<Integer> females = new ArrayList<Integer>();
            ArrayList<Integer> males = new ArrayList<Integer>();
            for (int j=0; j<siblingGroups[i].length(); j++) {
                if (siblingGroups[i].charAt(j) == 'Y') {
                    ArrayList<Integer> groupFemales = getCompatible(femaleCompatibility, j);
                    ArrayList<Integer> groupMales = getCompatible(maleCompatibility, j);
                    if (grouplen==0) {
                        females.addAll(groupFemales);
                        males.addAll(groupMales);
                    } else {
                        females.retainAll(groupFemales);
                        males.retainAll(groupMales);
                    }
                    grouplen++;
                }
            }
            if (!females.isEmpty() && !males.isEmpty() && grouplen > res)
                res = grouplen;
        }
        if (res > 0)
            res += 2;
        return res;
    }
    
    private ArrayList<Integer> getCompatible(String[] from, int idx) {
        ArrayList<Integer> ret = new ArrayList<Integer>();
        for (int i=0; i<from.length; i++)
            if (from[i].charAt(idx) == 'Y')
                ret.add(i);
        return ret;
    }
    

    public static void main(String[] args) {
        long time;
        int answer;
        boolean errors = false;
        int desiredAnswer;

        time = System.currentTimeMillis();
        answer = new PlatypusPaternity().maxFamily(new String[] { "YYYY", "YYYY" }, new String[] {
                "NNYN", "YYYN" }, new String[] { "YYYN", "NNNY" });
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
        answer = new PlatypusPaternity().maxFamily(new String[] { "NNYYY" },
                new String[] { "YYNNN" }, new String[] { "YYNNN", "NNYYY" });
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
        answer = new PlatypusPaternity().maxFamily(new String[] { "YYYYYYYYN" },
                new String[] { "YYYYYYYYY" },
                new String[] { "YNYNYNYNY", "NNNYNYNNN", "NYNNNNNYN" });
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
        answer = new PlatypusPaternity().maxFamily(new String[] { "YY" }, new String[] { "YY" },
                new String[] { "YN", "NY" });
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
        answer = new PlatypusPaternity().maxFamily(new String[] { "YYNNYYNNYYNN", "YNYNYNYNYNYN",
                "YYYNNNYYYNNN" }, new String[] { "NYYNNYYNNYYN", "YYNYYYNYYYNY", "NNNNNNYYYYYY" },
                new String[] { "NYNNNYNNNNNN", "NNNNNNNNYNNN", "NNYNNNNNNNYN", "YNNNNNNYNNNN",
                        "NNNNNNNNNYNY", "NNNYYNYNNNNN" });
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

        if (errors)
            System.out.println("Some of the test cases had errors :-(");
        else
            System.out.println("You're a stud (at least on the test data)! :-D ");
    }
}
// Powered by [KawigiEdit] 2.0!