import java.util.Arrays;

public class CoinMachinesGame {
    
    private static class Game implements Comparable<Game> {
        int need;
        int cost;
        
        public Game(int need, int give) {
            this.need = need;
            this.cost = need - give;
        }

        public int compareTo(Game o) {
            if (cost - o.cost == 0)
                return need - o.need;
            return cost - o.cost;
        }        
    }
    
    
    public int maxGames(int coins, int[] need, int[] give) {
        Game[] game = new Game[need.length];
        for (int i=0; i<need.length; i++) {
            game[i] = new Game(need[i], give[i]);
        }
        Arrays.sort(game);
        int res = 0;
        int idx = 0;
        while (idx < game.length && coins > 0) {
            while (coins >= game[idx].need) {
                int games = coins / game[idx].need;
                res += games;
                coins -= game[idx].cost * games;
            }
            idx++;
        }
        return res;
    }

    public static void main(String[] args) {
        long time;
        int answer;
        boolean errors = false;
        int desiredAnswer;

        time = System.currentTimeMillis();
        answer = new CoinMachinesGame().maxGames(10, new int[] { 5, 3 },
                new int[] { 4, 1 });
        System.out.println("Time: " + (System.currentTimeMillis() - time)
                / 1000.0 + " seconds");
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
        answer = new CoinMachinesGame().maxGames(1000, new int[] { 16, 14, 11,
                7 }, new int[] { 15, 12, 8, 3 });
        System.out.println("Time: " + (System.currentTimeMillis() - time)
                / 1000.0 + " seconds");
        desiredAnswer = 988;
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
        answer = new CoinMachinesGame().maxGames(1000000000, new int[] { 1000,
                900, 800, 700, 600, 500, 400, 300, 200, 100 }, new int[] { 701,
                802, 503, 604, 405, 306, 107, 208, 1, 1 });
        System.out.println("Time: " + (System.currentTimeMillis() - time)
                / 1000.0 + " seconds");
        desiredAnswer = 10869564;
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
        answer = new CoinMachinesGame().maxGames(12345678, new int[] { 342,
                234, 65, 76, 85, 734, 67, 345, 70, 234 }, new int[] { 45, 78,
                3, 10, 45, 12, 45, 57, 1, 230 });
        System.out.println("Time: " + (System.currentTimeMillis() - time)
                / 1000.0 + " seconds");
        desiredAnswer = 3086370;
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
        answer = new CoinMachinesGame().maxGames(1000000000, 
                new int[] { 2 }, 
                new int[] { 1 });
        System.out.println("Time: " + (System.currentTimeMillis() - time)
                / 1000.0 + " seconds");
        desiredAnswer = 999999999;
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
        answer = new CoinMachinesGame().maxGames(100, 
                new int[] { 5, 2, 4 }, 
                new int[] { 4, 1, 3 });
        System.out.println("Time: " + (System.currentTimeMillis() - time)
                / 1000.0 + " seconds");
        desiredAnswer = 99;
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
