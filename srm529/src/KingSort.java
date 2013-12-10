import java.util.Arrays;
import java.util.Comparator;


public class KingSort {
    public String[] getSortedList(String[] kings) {
        Arrays.sort(kings, new Comparator<String>() {
            public int compare(String s1, String s2) {
                String[] k1 = s1.split(" ");
                String[] k2 = s2.split(" ");
                int c1 = k1[0].compareTo(k2[0]);
                if (c1 == 0) {
                    int k1idx = romanToInt(k1[1]);
                    int k2idx = romanToInt(k2[1]);
                    return k1idx - k2idx;
                }
                return c1;
            }
        });
        return kings;
    }
    
    private String[] roman = { "XL", "IX", "IV", "L", "XXX", "XX",  "X", "VIII", "VII", "VI", "V", "III", "II", "I" };
    private int[] arab = { 40, 9, 4, 50, 30, 20, 10, 8, 7, 6, 5, 3, 2, 1 };

    private int romanToInt(String str) {
        int ret = 0;
        while (str.length() > 0) {
            for (int i=0; i<roman.length; i++) {
                if (str.endsWith(roman[i])) {
                    ret += arab[i];
                    str = str.substring(0, str.length() - roman[i].length());
                    break;
                }
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        long time;
        String[] answer;
        boolean errors = false;
        String[] desiredAnswer;

        boolean same;
        time = System.currentTimeMillis();
        answer = new KingSort().getSortedList(new String[] {
"A I",
"A II",
"A III",
"A IV",
"A V",
"A VI",
"A VII",
"A VIII",
"A IX",
"A X",
"A XI",
"A XII",
"A XIII",
"A XIV",
"A XV",
"A XVI",
"A XVII",
"A XVIII",
"A XIX",
"A XX",
"A XXI",
"A XXII",
"A XXIII",
"A XXIV",
"A XXV",
"A XXVI",
"A XXVII",
"A XXVIII",
"A XXIX",
"A XXX",
"A XXXI",
"A XXXII",
"A XXXIII",
"A XXXIV",
"A XXXV",
"A XXXVI",
"A XXXVII",
"A XXXVIII",
"A XXXIX",
"A XL",
"A XLI",
"A XLII",
"A XLIII",
"A XLIV",
"A XLV",
"A XLVI",
"A XLVII",
"A XLVIII",
"A XLIX",
"A L"
                });
        System.out.println("Time: " + (System.currentTimeMillis() - time) / 1000.0 + " seconds");
        desiredAnswer = new String[] { 
                "A I",
                "A II",
                "A III",
                "A IV",
                "A V",
                "A VI",
                "A VII",
                "A VIII",
                "A IX",
                "A X",
                "A XI",
                "A XII",
                "A XIII",
                "A XIV",
                "A XV",
                "A XVI",
                "A XVII",
                "A XVIII",
                "A XIX",
                "A XX",
                "A XXI",
                "A XXII",
                "A XXIII",
                "A XXIV",
                "A XXV",
                "A XXVI",
                "A XXVII",
                "A XXVIII",
                "A XXIX",
                "A XXX",
                "A XXXI",
                "A XXXII",
                "A XXXIII",
                "A XXXIV",
                "A XXXV",
                "A XXXVI",
                "A XXXVII",
                "A XXXVIII",
                "A XXXIX",
                "A XL",
                "A XLI",
                "A XLII",
                "A XLIII",
                "A XLIV",
                "A XLV",
                "A XLVI",
                "A XLVII",
                "A XLVIII",
                "A XLIX",
                "A L"
        };
        System.out.println("Your answer:");
        if (answer.length > 0) {
            System.out.print("\t{ \"" + answer[0] + "\"");
            for (int i = 1; i < answer.length; i++)
                System.out.print(",\n\t  \"" + answer[i] + "\"");
            System.out.println(" }");
        } else
            System.out.println("\t{ }");
        System.out.println("Desired answer:");
        if (desiredAnswer.length > 0) {
            System.out.print("\t{ \"" + desiredAnswer[0] + "\"");
            for (int i = 1; i < desiredAnswer.length; i++)
                System.out.print(",\n\t  \"" + desiredAnswer[i] + "\"");
            System.out.println(" }");
        } else
            System.out.println("\t{ }");
        same = desiredAnswer.length == answer.length;
        for (int i = 0; i < answer.length && same; i++)
            if (!answer[i].equals(desiredAnswer[i]))
                same = false;
        if (!same) {
            errors = true;
            System.out.println("DOESN'T MATCH!!!!");
        } else
            System.out.println("Match :-)");
        System.out.println();
        time = System.currentTimeMillis();
        answer = new KingSort().getSortedList(new String[] { "Louis IX", "Philippe II" });
        System.out.println("Time: " + (System.currentTimeMillis() - time) / 1000.0 + " seconds");
        desiredAnswer = new String[] { "Louis IX", "Philippe II" };
        System.out.println("Your answer:");
        if (answer.length > 0) {
            System.out.print("\t{ \"" + answer[0] + "\"");
            for (int i = 1; i < answer.length; i++)
                System.out.print(",\n\t  \"" + answer[i] + "\"");
            System.out.println(" }");
        } else
            System.out.println("\t{ }");
        System.out.println("Desired answer:");
        if (desiredAnswer.length > 0) {
            System.out.print("\t{ \"" + desiredAnswer[0] + "\"");
            for (int i = 1; i < desiredAnswer.length; i++)
                System.out.print(",\n\t  \"" + desiredAnswer[i] + "\"");
            System.out.println(" }");
        } else
            System.out.println("\t{ }");
        same = desiredAnswer.length == answer.length;
        for (int i = 0; i < answer.length && same; i++)
            if (!answer[i].equals(desiredAnswer[i]))
                same = false;
        if (!same) {
            errors = true;
            System.out.println("DOESN'T MATCH!!!!");
        } else
            System.out.println("Match :-)");
        System.out.println();
        time = System.currentTimeMillis();
        answer = new KingSort().getSortedList(new String[] { "Richard III", "Richard I",
                "Richard II" });
        System.out.println("Time: " + (System.currentTimeMillis() - time) / 1000.0 + " seconds");
        desiredAnswer = new String[] { "Richard I", "Richard II", "Richard III" };
        System.out.println("Your answer:");
        if (answer.length > 0) {
            System.out.print("\t{ \"" + answer[0] + "\"");
            for (int i = 1; i < answer.length; i++)
                System.out.print(",\n\t  \"" + answer[i] + "\"");
            System.out.println(" }");
        } else
            System.out.println("\t{ }");
        System.out.println("Desired answer:");
        if (desiredAnswer.length > 0) {
            System.out.print("\t{ \"" + desiredAnswer[0] + "\"");
            for (int i = 1; i < desiredAnswer.length; i++)
                System.out.print(",\n\t  \"" + desiredAnswer[i] + "\"");
            System.out.println(" }");
        } else
            System.out.println("\t{ }");
        same = desiredAnswer.length == answer.length;
        for (int i = 0; i < answer.length && same; i++)
            if (!answer[i].equals(desiredAnswer[i]))
                same = false;
        if (!same) {
            errors = true;
            System.out.println("DOESN'T MATCH!!!!");
        } else
            System.out.println("Match :-)");
        System.out.println();
        time = System.currentTimeMillis();
        answer = new KingSort()
                .getSortedList(new String[] { "John X", "John I", "John L", "John V" });
        System.out.println("Time: " + (System.currentTimeMillis() - time) / 1000.0 + " seconds");
        desiredAnswer = new String[] { "John I", "John V", "John X", "John L" };
        System.out.println("Your answer:");
        if (answer.length > 0) {
            System.out.print("\t{ \"" + answer[0] + "\"");
            for (int i = 1; i < answer.length; i++)
                System.out.print(",\n\t  \"" + answer[i] + "\"");
            System.out.println(" }");
        } else
            System.out.println("\t{ }");
        System.out.println("Desired answer:");
        if (desiredAnswer.length > 0) {
            System.out.print("\t{ \"" + desiredAnswer[0] + "\"");
            for (int i = 1; i < desiredAnswer.length; i++)
                System.out.print(",\n\t  \"" + desiredAnswer[i] + "\"");
            System.out.println(" }");
        } else
            System.out.println("\t{ }");
        same = desiredAnswer.length == answer.length;
        for (int i = 0; i < answer.length && same; i++)
            if (!answer[i].equals(desiredAnswer[i]))
                same = false;
        if (!same) {
            errors = true;
            System.out.println("DOESN'T MATCH!!!!");
        } else
            System.out.println("Match :-)");
        System.out.println();
        time = System.currentTimeMillis();
        answer = new KingSort().getSortedList(new String[] { "Philippe VI", "Jean II", "Charles V",
                "Charles VI", "Charles VII", "Louis XI" });
        System.out.println("Time: " + (System.currentTimeMillis() - time) / 1000.0 + " seconds");
        desiredAnswer = new String[] { "Charles V", "Charles VI", "Charles VII", "Jean II",
                "Louis XI", "Philippe VI" };
        System.out.println("Your answer:");
        if (answer.length > 0) {
            System.out.print("\t{ \"" + answer[0] + "\"");
            for (int i = 1; i < answer.length; i++)
                System.out.print(",\n\t  \"" + answer[i] + "\"");
            System.out.println(" }");
        } else
            System.out.println("\t{ }");
        System.out.println("Desired answer:");
        if (desiredAnswer.length > 0) {
            System.out.print("\t{ \"" + desiredAnswer[0] + "\"");
            for (int i = 1; i < desiredAnswer.length; i++)
                System.out.print(",\n\t  \"" + desiredAnswer[i] + "\"");
            System.out.println(" }");
        } else
            System.out.println("\t{ }");
        same = desiredAnswer.length == answer.length;
        for (int i = 0; i < answer.length && same; i++)
            if (!answer[i].equals(desiredAnswer[i]))
                same = false;
        if (!same) {
            errors = true;
            System.out.println("DOESN'T MATCH!!!!");
        } else
            System.out.println("Match :-)");
        System.out.println();
        time = System.currentTimeMillis();
        answer = new KingSort().getSortedList(new String[] { "Philippe II", "Philip II" });
        System.out.println("Time: " + (System.currentTimeMillis() - time) / 1000.0 + " seconds");
        desiredAnswer = new String[] { "Philip II", "Philippe II" };
        System.out.println("Your answer:");
        if (answer.length > 0) {
            System.out.print("\t{ \"" + answer[0] + "\"");
            for (int i = 1; i < answer.length; i++)
                System.out.print(",\n\t  \"" + answer[i] + "\"");
            System.out.println(" }");
        } else
            System.out.println("\t{ }");
        System.out.println("Desired answer:");
        if (desiredAnswer.length > 0) {
            System.out.print("\t{ \"" + desiredAnswer[0] + "\"");
            for (int i = 1; i < desiredAnswer.length; i++)
                System.out.print(",\n\t  \"" + desiredAnswer[i] + "\"");
            System.out.println(" }");
        } else
            System.out.println("\t{ }");
        same = desiredAnswer.length == answer.length;
        for (int i = 0; i < answer.length && same; i++)
            if (!answer[i].equals(desiredAnswer[i]))
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
// Powered by [KawigiEdit] 2.0!