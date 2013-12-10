

public class SlimeXSlimeRancher2 {
    
    public int train(int[] attributes) {
        int max = 0;
        for (int v : attributes) {
            if (v > max)
                max = v;
        }
        int res = 0;
        for (int v : attributes) {
            res += max - v; 
        }
        return res;
    }
    
    public static void main(String[] args) {
        long time;
        int answer;
        boolean errors = false;
        int desiredAnswer;

        time = System.currentTimeMillis();
        answer = new SlimeXSlimeRancher2().train(new int[] {1,2,3});
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
        answer = new SlimeXSlimeRancher2().train(new int[] { 5, 5 });
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
        answer = new SlimeXSlimeRancher2().train(new int[] {900,500,100});
        System.out.println("Time: " + (System.currentTimeMillis() - time)
                / 1000.0 + " seconds");
        desiredAnswer = 1200;
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
