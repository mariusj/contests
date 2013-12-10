public class GogoXCake {
    public String solve(String[] cake, String[] cutter) {
        int h = cake.length;
        int w = cake[0].length();
        int cw = cutter[0].length();
        int cstart = 0;
        
        char[][] cake2 = new char[h][];
        for (int y=0; y<h; y++)
            cake2[y] = cake[y].toCharArray();
        
        for (int x=0; x<cw; x++)
            if (cutter[0].charAt(x) == '.') {
                cstart = x;
                break;
            }
        
        for (int y=0; y<h; y++)
            for (int x=0; x<w; x++)
                if (cake2[y][x] == '.') {
                    if (x < cstart)
                        continue;
                    int xstart = x - cstart;
                    if (xstart + cw > w)
                        continue;
                    if (y + cutter.length > h)
                        continue;
                    for (int yy=0; yy<cutter.length; yy++) 
                        for (int xx=0; xx<cw; xx++)
                            if (cutter[yy].charAt(xx) == '.') {
                                if (cake2[y+yy][xstart+xx] == 'X')
                                    return "NO";
                                cake2[y+yy][xstart+xx] = 'X';
                            }
                }
        
        
        for (int y=0; y<h; y++)
            for (int x=0; x<w; x++)
                if (cake2[y][x] == '.')
                    return "NO";
        return "YES";
    }

    public static void main(String[] args) {
        long time;
        String answer;
        boolean errors = false;
        String desiredAnswer;

        time = System.currentTimeMillis();
        answer = new GogoXCake().solve(new String[] { "X.X", "...", "...", "X.X" }, new String[] {
                ".X", "..", "X." });
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
        answer = new GogoXCake().solve(new String[] { "..XX", "...X", "X...", "XX.." },
                new String[] { "..", ".." });
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
        answer = new GogoXCake().solve(new String[] { "...X..." }, new String[] { "..." });
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
        answer = new GogoXCake().solve(new String[] { ".X.", "X.X", ".X." }, new String[] { "." });
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
        answer = new GogoXCake().solve(new String[] { "XXXXXXX", "X.....X", "X.....X", "X.....X",
                "XXXXXXX" }, new String[] { ".X.", "XXX", ".X." });
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
        answer = new GogoXCake().solve(new String[] { "..", "X.", ".X" }, new String[] { "..",
                ".X", "X." });
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
        answer = new GogoXCake().solve(new String[] { "X..", ".XX", ".XX" }, new String[] { ".XX",
                ".XX", "X.." });
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

        if (errors)
            System.out.println("Some of the test cases had errors :-(");
        else
            System.out.println("You're a stud (at least on the test data)! :-D ");
    }
}
// Powered by [KawigiEdit] 2.0!