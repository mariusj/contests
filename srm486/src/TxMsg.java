
public class TxMsg {
    
    public String getMessage(String original) {
        StringBuilder res = new StringBuilder();
        
        StringBuilder word = new StringBuilder();
        boolean consonant = false;
        boolean vovelsOnly = true;
        int wordStart = 0;
        for (int i=0; i<original.length(); i++) {
            char c = original.charAt(i); 
            switch (c) {
            case ' ':
                if (vovelsOnly)
                    res.append(original.substring(wordStart, i));
                else
                    res.append(word);
                word = new StringBuilder();
                consonant = false;
                vovelsOnly = true;
                wordStart = i + 1;
                res.append(' ');
                break;
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
                consonant = false;
                break;
            default:
                vovelsOnly = false;
                if (!consonant) {
                    word.append(c);
                    consonant = true;
                }
            }
        }
        if (vovelsOnly)
            res.append(original.substring(wordStart));
        else
            res.append(word);
        
        return res.toString();
    }
    
    public static void main(String[] args) {
        long time;
        String answer;
        boolean errors = false;
        String desiredAnswer;

        time = System.currentTimeMillis();
        answer = new TxMsg().getMessage("text message");
        System.out.println("Time: " + (System.currentTimeMillis() - time)
                / 1000.0 + " seconds");
        desiredAnswer = "tx msg";
        System.out.println("Your answer:");
        System.out.println("\t" + answer);
        System.out.println("Desired answer:");
        System.out.println("\t" + desiredAnswer);
        if (!answer.equals(desiredAnswer)) {
            errors = true;
            System.out.println("DOESN'T MATCH!!!!");
        } else
            System.out.println("Match :-)");
        System.out.println();
        time = System.currentTimeMillis();
        answer = new TxMsg().getMessage("ps i love u");
        System.out.println("Time: " + (System.currentTimeMillis() - time)
                / 1000.0 + " seconds");
        desiredAnswer = "p i lv u";
        System.out.println("Your answer:");
        System.out.println("\t" + answer);
        System.out.println("Desired answer:");
        System.out.println("\t" + desiredAnswer);
        if (!answer.equals(desiredAnswer)) {
            errors = true;
            System.out.println("DOESN'T MATCH!!!!");
        } else
            System.out.println("Match :-)");
        System.out.println();
        time = System.currentTimeMillis();
        answer = new TxMsg().getMessage("please please me");
        System.out.println("Time: " + (System.currentTimeMillis() - time)
                / 1000.0 + " seconds");
        desiredAnswer = "ps ps m";
        System.out.println("Your answer:");
        System.out.println("\t" + answer);
        System.out.println("Desired answer:");
        System.out.println("\t" + desiredAnswer);
        if (!answer.equals(desiredAnswer)) {
            errors = true;
            System.out.println("DOESN'T MATCH!!!!");
        } else
            System.out.println("Match :-)");
        System.out.println();
        time = System.currentTimeMillis();
        answer = new TxMsg().getMessage("back to the ussr");
        System.out.println("Time: " + (System.currentTimeMillis() - time)
                / 1000.0 + " seconds");
        desiredAnswer = "bc t t s";
        System.out.println("Your answer:");
        System.out.println("\t" + answer);
        System.out.println("Desired answer:");
        System.out.println("\t" + desiredAnswer);
        if (!answer.equals(desiredAnswer)) {
            errors = true;
            System.out.println("DOESN'T MATCH!!!!");
        } else
            System.out.println("Match :-)");
        System.out.println();
        time = System.currentTimeMillis();
        answer = new TxMsg().getMessage("aeiou bcdfghjklmnpqrstvwxyz");
        System.out.println("Time: " + (System.currentTimeMillis() - time)
                / 1000.0 + " seconds");
        desiredAnswer = "aeiou b";
        System.out.println("Your answer:");
        System.out.println("\t" + answer);
        System.out.println("Desired answer:");
        System.out.println("\t" + desiredAnswer);
        if (!answer.equals(desiredAnswer)) {
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
