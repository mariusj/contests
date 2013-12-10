public class CheatingQuiz {

    public int[] howMany(String answers) {
        int a=0,b=0,c=0;
        for (int i=0; i<answers.length(); i++) {
            switch (answers.charAt(i)) {
            case 'A': a++; break;
            case 'B': b++; break;
            case 'C': c++; break;
            }
        }
        int res[] = new int[answers.length()];
        for (int i=0; i<answers.length(); i++) {
            int ch = 0;
            if (a>0) ch++;
            if (b>0) ch++;
            if (c>0) ch++;
            res[i] = ch;
            switch (answers.charAt(i)) {
            case 'A': a--; break;
            case 'B': b--; break;
            case 'C': c--; break;
            }
            
        }
        return res;
    }

    public static void main(String[] args) {
        long time;
        int[] answer;
        boolean errors = false;
        int[] desiredAnswer;

        boolean same;
        time = System.currentTimeMillis();
        answer = new CheatingQuiz().howMany("AAAAA");
        System.out.println("Time: " + (System.currentTimeMillis() - time) / 1000.0 + " seconds");
        desiredAnswer = new int[] { 1, 1, 1, 1, 1 };
        System.out.println("Your answer:");
        if (answer.length > 0) {
            System.out.print("\t{ " + answer[0]);
            for (int i = 1; i < answer.length; i++)
                System.out.print(", " + answer[i]);
            System.out.println(" }");
        } else
            System.out.println("\t{ }");
        System.out.println("Desired answer:");
        if (desiredAnswer.length > 0) {
            System.out.print("\t{ " + desiredAnswer[0]);
            for (int i = 1; i < desiredAnswer.length; i++)
                System.out.print(", " + desiredAnswer[i]);
            System.out.println(" }");
        } else
            System.out.println("\t{ }");
        same = desiredAnswer.length == answer.length;
        for (int i = 0; i < answer.length && same; i++)
            if (answer[i] != desiredAnswer[i])
                same = false;
        if (!same) {
            errors = true;
            System.out.println("DOESN'T MATCH!!!!");
        } else
            System.out.println("Match :-)");
        System.out.println();
        time = System.currentTimeMillis();
        answer = new CheatingQuiz().howMany("AAABBB");
        System.out.println("Time: " + (System.currentTimeMillis() - time) / 1000.0 + " seconds");
        desiredAnswer = new int[] { 2, 2, 2, 1, 1, 1 };
        System.out.println("Your answer:");
        if (answer.length > 0) {
            System.out.print("\t{ " + answer[0]);
            for (int i = 1; i < answer.length; i++)
                System.out.print(", " + answer[i]);
            System.out.println(" }");
        } else
            System.out.println("\t{ }");
        System.out.println("Desired answer:");
        if (desiredAnswer.length > 0) {
            System.out.print("\t{ " + desiredAnswer[0]);
            for (int i = 1; i < desiredAnswer.length; i++)
                System.out.print(", " + desiredAnswer[i]);
            System.out.println(" }");
        } else
            System.out.println("\t{ }");
        same = desiredAnswer.length == answer.length;
        for (int i = 0; i < answer.length && same; i++)
            if (answer[i] != desiredAnswer[i])
                same = false;
        if (!same) {
            errors = true;
            System.out.println("DOESN'T MATCH!!!!");
        } else
            System.out.println("Match :-)");
        System.out.println();
        time = System.currentTimeMillis();
        answer = new CheatingQuiz().howMany("CAAAAAC");
        System.out.println("Time: " + (System.currentTimeMillis() - time) / 1000.0 + " seconds");
        desiredAnswer = new int[] { 2, 2, 2, 2, 2, 2, 1 };
        System.out.println("Your answer:");
        if (answer.length > 0) {
            System.out.print("\t{ " + answer[0]);
            for (int i = 1; i < answer.length; i++)
                System.out.print(", " + answer[i]);
            System.out.println(" }");
        } else
            System.out.println("\t{ }");
        System.out.println("Desired answer:");
        if (desiredAnswer.length > 0) {
            System.out.print("\t{ " + desiredAnswer[0]);
            for (int i = 1; i < desiredAnswer.length; i++)
                System.out.print(", " + desiredAnswer[i]);
            System.out.println(" }");
        } else
            System.out.println("\t{ }");
        same = desiredAnswer.length == answer.length;
        for (int i = 0; i < answer.length && same; i++)
            if (answer[i] != desiredAnswer[i])
                same = false;
        if (!same) {
            errors = true;
            System.out.println("DOESN'T MATCH!!!!");
        } else
            System.out.println("Match :-)");
        System.out.println();
        time = System.currentTimeMillis();
        answer = new CheatingQuiz().howMany("BBCA");
        System.out.println("Time: " + (System.currentTimeMillis() - time) / 1000.0 + " seconds");
        desiredAnswer = new int[] { 3, 3, 2, 1 };
        System.out.println("Your answer:");
        if (answer.length > 0) {
            System.out.print("\t{ " + answer[0]);
            for (int i = 1; i < answer.length; i++)
                System.out.print(", " + answer[i]);
            System.out.println(" }");
        } else
            System.out.println("\t{ }");
        System.out.println("Desired answer:");
        if (desiredAnswer.length > 0) {
            System.out.print("\t{ " + desiredAnswer[0]);
            for (int i = 1; i < desiredAnswer.length; i++)
                System.out.print(", " + desiredAnswer[i]);
            System.out.println(" }");
        } else
            System.out.println("\t{ }");
        same = desiredAnswer.length == answer.length;
        for (int i = 0; i < answer.length && same; i++)
            if (answer[i] != desiredAnswer[i])
                same = false;
        if (!same) {
            errors = true;
            System.out.println("DOESN'T MATCH!!!!");
        } else
            System.out.println("Match :-)");
        System.out.println();
        time = System.currentTimeMillis();
        answer = new CheatingQuiz().howMany("BACACABCBBBBCAAAAACCCABBCAA");
        System.out.println("Time: " + (System.currentTimeMillis() - time) / 1000.0 + " seconds");
        desiredAnswer = new int[] { 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3,
                3, 3, 3, 2, 1, 1 };
        System.out.println("Your answer:");
        if (answer.length > 0) {
            System.out.print("\t{ " + answer[0]);
            for (int i = 1; i < answer.length; i++)
                System.out.print(", " + answer[i]);
            System.out.println(" }");
        } else
            System.out.println("\t{ }");
        System.out.println("Desired answer:");
        if (desiredAnswer.length > 0) {
            System.out.print("\t{ " + desiredAnswer[0]);
            for (int i = 1; i < desiredAnswer.length; i++)
                System.out.print(", " + desiredAnswer[i]);
            System.out.println(" }");
        } else
            System.out.println("\t{ }");
        same = desiredAnswer.length == answer.length;
        for (int i = 0; i < answer.length && same; i++)
            if (answer[i] != desiredAnswer[i])
                same = false;
        if (!same) {
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
