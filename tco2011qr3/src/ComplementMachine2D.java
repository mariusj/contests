
public class ComplementMachine2D
{
	public int largestSubmatrix(String[] matrix) {
	    int w = matrix[0].length();
	    boolean[][] m = new boolean[matrix.length][w];
	    for (int y=0; y<m.length; y++) {
	        for (int x=0; x<w; x++) {
	            m[y][x] = matrix[y].charAt(x) == '1';
	        }
	    }
		int res = 0;
		
		for (int y1=0; y1<m.length; y1++) {
		    for (int y2=y1; y2<m.length; y2++) {
		        for (int x1=0; x1<w; x1++) {
		            for (int x2=x1; x2<w; x2++) {
		                
		                if ((x2-x1+1) * (y2-y1+1) > res) {
		                    
		                    boolean ok = true;
                            int z = 0;
	                        for (int y=y1; y<=y2; y++) {
	                            for (int x=x1; x<=x2; x++) {
	                                if (!m[y][x])
	                                    z++;
	                            }
	                        }

                            if (z % 2 != 0) {
                                ok = false;
                                //break;
                            }
	                        
	                        
/*	                        if (ok) {
                                for (int x=x1; x<=x2; x++) {
                                    int z = 0;
                                    for (int y=y1; y<=y2; y++) {
                                        if (!m[y][x])
                                            z++;
                                    }
                                    if (z % 2 != 0) {
                                        ok = false;
                                        break;
                                    }
                                }
	                        }*/
	                        if (ok) {
	                            res = (x2-x1+1) * (y2-y1+1);
                                System.out.println(res);
	                        }
	                        
		                }
		                
		            }
		        }
		    }
		}
		
		return res;
	}
	
	public static void main(String[] args)
    {
        long time;
        int answer;
        boolean errors = false;
        int desiredAnswer;
        
        time = System.currentTimeMillis();
        answer = new ComplementMachine2D().largestSubmatrix(new String[]{"0011", "0011", "1100", "0111"});
        System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
        desiredAnswer = 12;
        System.out.println("Your answer:");
        System.out.println("\t" + answer);
        System.out.println("Desired answer:");
        System.out.println("\t" + desiredAnswer);
        if (answer != desiredAnswer)
        {
            errors = true;
            System.out.println("DOESN'T MATCH!!!!");
        }
        else
            System.out.println("Match :-)");
        System.out.println();
        time = System.currentTimeMillis();
        answer = new ComplementMachine2D().largestSubmatrix(new String[]{"0011", "1011", "0101", "1010"});
        System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
        desiredAnswer = 9;
        System.out.println("Your answer:");
        System.out.println("\t" + answer);
        System.out.println("Desired answer:");
        System.out.println("\t" + desiredAnswer);
        if (answer != desiredAnswer)
        {
            errors = true;
            System.out.println("DOESN'T MATCH!!!!");
        }
        else
            System.out.println("Match :-)");
        System.out.println();
        time = System.currentTimeMillis();
        answer = new ComplementMachine2D().largestSubmatrix(new String[]{"1011", "0011", "0101", "1010"});
        System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
        desiredAnswer = 8;
        System.out.println("Your answer:");
        System.out.println("\t" + answer);
        System.out.println("Desired answer:");
        System.out.println("\t" + desiredAnswer);
        if (answer != desiredAnswer)
        {
            errors = true;
            System.out.println("DOESN'T MATCH!!!!");
        }
        else
            System.out.println("Match :-)");
        System.out.println();
        time = System.currentTimeMillis();
        answer = new ComplementMachine2D().largestSubmatrix(new String[]{"0000110101010", "0111101010111", "1110110111011"});
        System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
        desiredAnswer = 13;
        System.out.println("Your answer:");
        System.out.println("\t" + answer);
        System.out.println("Desired answer:");
        System.out.println("\t" + desiredAnswer);
        if (answer != desiredAnswer)
        {
            errors = true;
            System.out.println("DOESN'T MATCH!!!!");
        }
        else
            System.out.println("Match :-)");
        System.out.println();
        time = System.currentTimeMillis();
        answer = new ComplementMachine2D().largestSubmatrix(new String[]{"11000000000110101101", "00111111011101101101", "00110011110111100010", "10011110111110000111", "00111010000000110111", "00001101011011010110", "11010010100100101100", "11101101011011000001", "11000010100100111001", "11011010100100101010", "10110010100100110110", "01100010100100111001", "10110010100100110011", "01110101011011001010", "01111101011011001011", "00001000010010101011", "11100101100100110001", "10100100111001010101", "11111000001010011110", "01110100001110011111"});
        System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
        desiredAnswer = 100;
        System.out.println("Your answer:");
        System.out.println("\t" + answer);
        System.out.println("Desired answer:");
        System.out.println("\t" + desiredAnswer);
        if (answer != desiredAnswer)
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
