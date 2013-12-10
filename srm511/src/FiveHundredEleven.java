import java.util.ArrayList;

public class FiveHundredEleven {
    
    public String theWinner(int[] cards) {
        int t = 0;
        int mem = 0;
        ArrayList<Integer> c = new ArrayList<Integer>();
        for (int i=0; i<cards.length; i++)
            c.add(cards[i]);
        while (c.size() > 0) {
            int idx = 0;
            for (int i=0; i<c.size(); i++) {
                int mbc = Integer.bitCount(mem);
                int newmem = mem | c.get(0);
                if (newmem != 511) {
                    int nbc = Integer.bitCount(newmem);
                    if (nbc >= mbc) {
                        mbc = nbc;
                        idx = i;
                    }
                }
            }
            mem |= c.get(idx);
            if (mem == 511) {
                return t == 0 ? "Toastman" : "Fox Ciel";
            }
            c.remove(idx);            
            t = 1 - t;
        }
        return t == 0 ? "Toastman" : "Fox Ciel";
    }

    public static void main(String[] args)
    {
        long time;
        String answer;
        boolean errors = false;
        String desiredAnswer;
        
        time = System.currentTimeMillis();
        answer = new FiveHundredEleven().theWinner(new int[]{3, 5, 7, 9, 510});
        System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
        desiredAnswer = "Fox Ciel";
        System.out.println("Your answer:");
        System.out.println("\t\"" + answer + "\"");
        System.out.println("Desired answer:");
        System.out.println("\t\"" + desiredAnswer + "\"");
        if (!answer.equals(desiredAnswer))
        {
            errors = true;
            System.out.println("DOESN'T MATCH!!!!");
        }
        else
            System.out.println("Match :-)");
        System.out.println();
        time = System.currentTimeMillis();
        answer = new FiveHundredEleven().theWinner(new int[]{0, 0, 0, 0});
        System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
        desiredAnswer = "Toastman";
        System.out.println("Your answer:");
        System.out.println("\t\"" + answer + "\"");
        System.out.println("Desired answer:");
        System.out.println("\t\"" + desiredAnswer + "\"");
        if (!answer.equals(desiredAnswer))
        {
            errors = true;
            System.out.println("DOESN'T MATCH!!!!");
        }
        else
            System.out.println("Match :-)");
        System.out.println();
        time = System.currentTimeMillis();
        answer = new FiveHundredEleven().theWinner(new int[]{511});
        System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
        desiredAnswer = "Toastman";
        System.out.println("Your answer:");
        System.out.println("\t\"" + answer + "\"");
        System.out.println("Desired answer:");
        System.out.println("\t\"" + desiredAnswer + "\"");
        if (!answer.equals(desiredAnswer))
        {
            errors = true;
            System.out.println("DOESN'T MATCH!!!!");
        }
        else
            System.out.println("Match :-)");
        System.out.println();
        time = System.currentTimeMillis();
        answer = new FiveHundredEleven().theWinner(new int[]{5, 58, 192, 256});
        System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
        desiredAnswer = "Fox Ciel";
        System.out.println("Your answer:");
        System.out.println("\t\"" + answer + "\"");
        System.out.println("Desired answer:");
        System.out.println("\t\"" + desiredAnswer + "\"");
        if (!answer.equals(desiredAnswer))
        {
            errors = true;
            System.out.println("DOESN'T MATCH!!!!");
        }
        else
            System.out.println("Match :-)");
        System.out.println();
        
        if (errors)
            System.out.println("Some of the test cases had errors :-(");
        else
            System.out.println("You're a stud (at least on the test data)! :-D ");
    }
}
