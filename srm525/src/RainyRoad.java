public class RainyRoad {
    
    public String isReachable(String[] road) {
        for (int i=0; i<road[0].length(); i++) {
            if (road[0].charAt(i) == 'W' && road[1].charAt(i) == 'W')
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
        answer = new RainyRoad().isReachable(new String[] { ".W..", "...." });
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
        answer = new RainyRoad().isReachable(new String[] { ".W..", "..W." });
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
        answer = new RainyRoad().isReachable(new String[] { ".W..W..", "...WWW." });
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
        answer = new RainyRoad().isReachable(new String[] { "..", "WW" });
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
        answer = new RainyRoad().isReachable(new String[] { ".WWWW.", "WWWWWW" });
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
        answer = new RainyRoad().isReachable(new String[] { ".W.W.W.", "W.W.W.W" });
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
        answer = new RainyRoad().isReachable(new String[] {
                ".............................................W.",
                ".............................................W." });
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
