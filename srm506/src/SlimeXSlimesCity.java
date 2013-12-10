import java.util.Arrays;


public class SlimeXSlimesCity {
    
    public int merge(int[] population) {
        int res = 0;
        Arrays.sort(population);
        
        for (int i=0; i<population.length; i++) {
            
            long sum = 0;
            for (int is=0; is<=i; is++) {
                sum += population[is];
            }
            
            boolean noname = false;
            for (int is=i+1; is<population.length; is++) {
                if (population[is] > sum) {
                    noname = true;
                    break;
                }
                sum += population[is];
            }
            
            if (!noname) {
                res++;
            }
        }
        return res;        
    }

    public static void main(String[] args) {
        long time;
        int answer;
        boolean errors = false;
        int desiredAnswer;

        time = System.currentTimeMillis();
        answer = new SlimeXSlimesCity().merge(new int[] {8388608, 1024, 131072, 4, 268435456, 4096, 262144, 65536, 16384, 67108864, 33554432, 16777216, 8, 2097152, 128, 1, 32, 32768, 64, 134217728, 524288, 4194304, 2, 512, 8192, 256, 536870912, 2048, 1048576, 16, 31053630, 558490010, 549284480, 339007660, 490637317, 919639275, 114667712, 279564429, 254418094, 566351725, 218125422, 724033571, 908038454, 548245735, 320625104, 99884110, 912249545, 982895294, 242429798, 645592008});
        System.out.println("Time: " + (System.currentTimeMillis() - time)
                / 1000.0 + " seconds");
        desiredAnswer = 26;
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
/*        time = System.currentTimeMillis();
        answer = new SlimeXSlimesCity().merge(new int[] { 1, 2, 3});
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
        answer = new SlimeXSlimesCity().merge(new int[] {8,2,3,8});
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
        answer = new SlimeXSlimesCity().merge(new int[] {1, 2, 3, 4});
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
        answer = new SlimeXSlimesCity().merge(new int[] {1,1,1});
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
        answer = new SlimeXSlimesCity().merge(new int[] {1, 2, 4, 6, 14, 16, 20});
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
        System.out.println();*/


        if (errors)
            System.out.println("Some of the test cases had errors :-(");
        else
            System.out
                    .println("You're a stud (at least on the test data)! :-D ");
    }

}
