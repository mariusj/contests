

public class MysteriousRestaurant {
    public int maxDays(String[] prices, int budget) {
        int N = prices.length;
        int dishes = prices[0].length();
        int p[][] = new int[prices.length][dishes];
        
        for (int i=0; i<prices.length; i++) {
            for (int j=0; j<dishes; j++) {
                char c = prices[i].charAt(j);
                if (c >='0' && c <= '9')
                    p[i][j] = c - '0';
                else if (c >= 'A' && c <='Z')
                    p[i][j] = 10 + c - 'A';
                else
                    p[i][j] = 36 + c - 'a';
            }
        }
        
        int choisen[] = new int[7];
        
        int weeks = (N+6) / 7;
        for (int week=0; week < weeks; week++) {
            //System.out.println("week " + week);
            
            for (int day=0; day<7; day++) {
                //System.out.println("day " + day);
                if (week*7 + day >= N)
                    break;
                int min = Integer.MAX_VALUE;
                for (int dish = 0; dish<dishes; dish++) {
                    int price = 0;
                    for (int w=0; w<=week; w++) {
                        price += p[w*7 + day][dish];
                    }
                    if (price < min)
                        min = price;
                }
                choisen[day] = min;
                int b = budget;
                for (int i=0; i<7; i++)
                    b -= choisen[i];
                if (b < 0)
                    return week * 7 + day;
            }
        }
        
        return N;
    }

    public static void main(String[] args) {
        long time;
        int answer;
        boolean errors = false;
        int desiredAnswer;

/*        time = System.currentTimeMillis();
        answer = new MysteriousRestaurant().maxDays(new String[] { "26", "14", "72", "39", "32",
                "85", "06" }, 13);
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
        answer = new MysteriousRestaurant().maxDays(new String[] { "26", "14", "72", "39", "32",
                "85", "06", "91" }, 20);
        System.out.println("Time: " + (System.currentTimeMillis() - time) / 1000.0 + " seconds");
        desiredAnswer = 8;
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
        answer = new MysteriousRestaurant().maxDays(new String[] { "SRM", "512" }, 4);
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
        answer = new MysteriousRestaurant().maxDays(new String[] { "Dear", "Code", "rsHa", "veFu",
                "nInT", "heCh", "alle", "ngeP", "hase", "andb", "ecar", "eful" }, 256);
        System.out.println("Time: " + (System.currentTimeMillis() - time) / 1000.0 + " seconds");
        desiredAnswer = 10;
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
*/        
        time = System.currentTimeMillis();
        answer = new MysteriousRestaurant().maxDays(new String[] { 
                "00000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000",
                "00123000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000",
                "00000000000000000000005670000000000000000000000000",
                "00000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000",
                "00000000000123000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000",
                "00000000000000000000056780000000000000000000000000",
                "00000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000001110000000",
                "00000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000",
                "00000000000000000111000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000001230000000000000000",
                "00000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000",
                }, 0);
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
