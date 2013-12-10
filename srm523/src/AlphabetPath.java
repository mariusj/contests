
public class AlphabetPath {
    public String doesItExist(String[] letterMaze) {
        
        int dx = letterMaze[0].length();
        int dy = letterMaze.length;
        
        int x=0;
        int y=0;
        
        yLoop: for (y=0; y<dy; y++) {
            for (x=0; x<dx; x++) {
                if (letterMaze[y].charAt(x) == 'A')
                    break yLoop;
            }
        }
        
        char l = 'B';
        while (l<='Z') {
            if (x-1>=0 && letterMaze[y].charAt(x-1) == l) {
                x--;
                l++;
                continue;
            }
            if (x+1<dx && letterMaze[y].charAt(x+1) == l) {
                x++;
                l++;
                continue;
            }
            if (y-1>=0 && letterMaze[y-1].charAt(x) == l) {
                y--;
                l++;
                continue;
            }
            if (y+1<dy && letterMaze[y+1].charAt(x) == l) {
                y++;
                l++;
                continue;
            }
            return "NO";
        }
        return "YES";
    }

    public static void main(String[] args) {
        long time;
        String answer;
        boolean errors = false;
        String desiredAnswer;

        time = System.currentTimeMillis();
        answer = new AlphabetPath().doesItExist(new String[] { "ABCDEFGHIJKLMNOPQRSTUVWXYZ" });
        System.out.println("Time: " + (System.currentTimeMillis() - time) / 1000.0 + " seconds");
        desiredAnswer = "YES";
        System.out.println("Your answer:");
        System.out.println("\t\"" + answer + "\"");
        System.out.println("Desired answer:");
        System.out.println("\t\"" + desiredAnswer + "\"");
        if (!answer.equals(desiredAnswer)) {
            errors = true;
            System.out.println("DOESN'T MATCH!!!!");
        } else
            System.out.println("Match :-)");
        System.out.println();
        time = System.currentTimeMillis();
        answer = new AlphabetPath().doesItExist(new String[] { "ADEHI..Z", "BCFGJK.Y", ".PONML.X",
                ".QRSTUVW" });
        System.out.println("Time: " + (System.currentTimeMillis() - time) / 1000.0 + " seconds");
        desiredAnswer = "YES";
        System.out.println("Your answer:");
        System.out.println("\t\"" + answer + "\"");
        System.out.println("Desired answer:");
        System.out.println("\t\"" + desiredAnswer + "\"");
        if (!answer.equals(desiredAnswer)) {
            errors = true;
            System.out.println("DOESN'T MATCH!!!!");
        } else
            System.out.println("Match :-)");
        System.out.println();
        time = System.currentTimeMillis();
        answer = new AlphabetPath().doesItExist(new String[] { "ACBDEFGHIJKLMNOPQRSTUVWXYZ" });
        System.out.println("Time: " + (System.currentTimeMillis() - time) / 1000.0 + " seconds");
        desiredAnswer = "NO";
        System.out.println("Your answer:");
        System.out.println("\t\"" + answer + "\"");
        System.out.println("Desired answer:");
        System.out.println("\t\"" + desiredAnswer + "\"");
        if (!answer.equals(desiredAnswer)) {
            errors = true;
            System.out.println("DOESN'T MATCH!!!!");
        } else
            System.out.println("Match :-)");
        System.out.println();
        time = System.currentTimeMillis();
        answer = new AlphabetPath().doesItExist(new String[] { "ABC.......", "...DEFGHIJ",
                "TSRQPONMLK", "UVWXYZ...." });
        System.out.println("Time: " + (System.currentTimeMillis() - time) / 1000.0 + " seconds");
        desiredAnswer = "NO";
        System.out.println("Your answer:");
        System.out.println("\t\"" + answer + "\"");
        System.out.println("Desired answer:");
        System.out.println("\t\"" + desiredAnswer + "\"");
        if (!answer.equals(desiredAnswer)) {
            errors = true;
            System.out.println("DOESN'T MATCH!!!!");
        } else
            System.out.println("Match :-)");
        System.out.println();
        time = System.currentTimeMillis();
        answer = new AlphabetPath().doesItExist(new String[] { "..............", "..............",
                "..............", "...DEFGHIJK...", "...C......L...", "...B......M...",
                "...A......N...", "..........O...", "..ZY..TSRQP...", "...XWVU.......",
                ".............." });
        System.out.println("Time: " + (System.currentTimeMillis() - time) / 1000.0 + " seconds");
        desiredAnswer = "YES";
        System.out.println("Your answer:");
        System.out.println("\t\"" + answer + "\"");
        System.out.println("Desired answer:");
        System.out.println("\t\"" + desiredAnswer + "\"");
        if (!answer.equals(desiredAnswer)) {
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
