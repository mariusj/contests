
public class LuckyRemainder {
    private char[] digits;
    private int res;

    public int getLuckyRemainder(String X) {
        if (X.length() == 1) {
            return Integer.parseInt(X) % 9;
        }
        digits = X.toCharArray();
        res += mod9();
        for (int i=1; i<digits.length; i++) {
            long n = 0;
            for (int j=0; j<=i; j++) {
                
            }
            res += n % 9;
        }
        //rec();
        return res % 9;
    }
    
    private void rec() {
        boolean quit = true;
        for (int i=0; i<digits.length; i++) {
            if (digits[i] != '0') {
                quit = false;
                break;
            }
        }
        if (quit)
            return;
        res = res + mod9();
        for (int i=0; i<digits.length; i++) {
            if (digits[i] != '0') {
                char tmp = digits[i];
                digits[i] = '0';
                rec(); 
                digits[i] = tmp;
            }
        }
    }
    
    private int mod9() {
        long sum = 0;
        for (int i=0; i<digits.length; i++) {
            sum += digits[i] - 48;
        }
        int res = (int) (sum % 9);
        return res;
    }

    public static void main(String[] args) {
        long time;
        int answer;
        boolean errors = false;
        int desiredAnswer;

        time = System.currentTimeMillis();
        answer = new LuckyRemainder().getLuckyRemainder("123");
        System.out.println("Time: " + (System.currentTimeMillis() - time) / 1000.0 + " seconds");
        desiredAnswer = 6;
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
        answer = new LuckyRemainder().getLuckyRemainder("24816");
        System.out.println("Time: " + (System.currentTimeMillis() - time) / 1000.0 + " seconds");
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
        answer = new LuckyRemainder().getLuckyRemainder("8");
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
        answer = new LuckyRemainder().getLuckyRemainder("11235813213455");
        System.out.println("Time: " + (System.currentTimeMillis() - time) / 1000.0 + " seconds");
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

        if (errors)
            System.out.println("Some of the test cases had errors :-(");
        else
            System.out.println("You're a stud (at least on the test data)! :-D ");
    }
}
// Powered by [KawigiEdit] 2.0!