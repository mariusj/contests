public class Painting {

	public int largestBrush(String[] picture) {

		int maxBrush = picture.length;
		int maxY = picture.length;
		int maxX = picture[0].length();
		
		for (int y=0; y<maxY; y++) {
			int cur = 0;
			for (int x=0; x<maxX; x++) {
				if (picture[y].charAt(x) == 'B') {
					cur++;
				} else {
					if (cur > 0 && cur < maxBrush)
						maxBrush = cur;
					cur = 0;
				}
			}
			if (cur > 0 && cur < maxBrush)
				maxBrush = cur;
		}

		for (int x=0; x<maxX; x++) {
			int cur = 0;
			for (int y=0; y<maxY; y++) {
				if (picture[y].charAt(x) == 'B') {
					cur++;
				} else {
					if (cur > 0 && cur < maxBrush)
						maxBrush = cur;
					cur = 0;
				}
			}
			if (cur > 0 && cur < maxBrush)
				maxBrush = cur;
		}

		return maxBrush;
	}

	public static void main(String[] args) {
		long time;
		int answer;
		boolean errors = false;
		int desiredAnswer;


		time = System.currentTimeMillis();
		answer = new Painting().largestBrush(new String[] { "BBBB", "BBBB",
				"BBBB", "BBBB" });
		System.out.println("Time: " + (System.currentTimeMillis() - time)
				/ 1000.0 + " seconds");
		desiredAnswer = 4;
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
		answer = new Painting().largestBrush(new String[] { "BBBB", "BWWB",
				"BWWB", "BBBB" });
		System.out.println("Time: " + (System.currentTimeMillis() - time)
				/ 1000.0 + " seconds");
		desiredAnswer = 1;
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
		answer = new Painting().largestBrush(new String[] { 
				"WBBBBB", 
				"BBBBBB",
				"BBBBBB", 
				"BBBBBB" });
		System.out.println("Time: " + (System.currentTimeMillis() - time)
				/ 1000.0 + " seconds");
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
		answer = new Painting().largestBrush(new String[] { "BBBB", "BBBB",
				"WBBB", "BBBB", "BBBB", "BBBB" });
		System.out.println("Time: " + (System.currentTimeMillis() - time)
				/ 1000.0 + " seconds");
		desiredAnswer = 2;
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
		answer = new Painting().largestBrush(new String[] { "WBBBBBWWWWWWWWW",
				"WBBBBBBWWWWWWWW", "WBBBBBBBBBBBWWW", "WBBBBBBBBBBBWWW",
				"BBBBBBBBBBBBBBB", "BBBBBBBBBBBBBBB", "BBBBBBBBBBBBBBB",
				"BBBBBBBBWWBBBBB", "BBBBBBBBWBBBBBB", "WBBBBBBBWBBBBBW",
				"BBBBBBBWWBBBBBW", "BBBBBBBWWBBBBBW", "BBBBBBWWWBBBBBW",
				"BBBBBWWWWWWWWWW", "BBBBBWWWWWWWWWW" });
		System.out.println("Time: " + (System.currentTimeMillis() - time)
				/ 1000.0 + " seconds");
		desiredAnswer = 5;
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
		answer = new Painting().largestBrush(new String[] { 
				"BBBBBBBBBBBBW",
				"BBBBBBBBBBBBW", 
				"BBBBBBBBBBBBW", 
				"BBBBBBBBBBBBW",
				"BBBBBBBBBBBBW", 
				"BBBBBBBBBBBBW", 
				"BBBBBBBBBBBBW",
				"BBBBBBBBBBBBW", 
				"BBBBBBBBBBBBW", 
				"BBBBBBBBBBBBW",
				"BBBBBBBBBBBBW", 
				"WWWBBBBBBBBWW" });
		System.out.println("Time: " + (System.currentTimeMillis() - time)
				/ 1000.0 + " seconds");
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
		answer = new Painting().largestBrush(new String[] { "WBBB", "BBBB",
				"BBBW", "BBBB", "BBBB", "BBBB", "BBBB", "BBBB", "BBBB", "WBBB",
				"WBBB", "BBBB", "BBBB", "BBBB", "BBBB", "BBBB", "BBBB", "BBBB",
				"BBBB", "BBBB", "BBBB", "BBBB", "BBBB", "WBBB" });
		System.out.println("Time: " + (System.currentTimeMillis() - time)
				/ 1000.0 + " seconds");
		desiredAnswer = 2;
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
		answer = new Painting().largestBrush(new String[] { 
				"BBWW", 
				"BBWW",
				"WBBW", 
				"WWBB", 
				"WWBB" });
		System.out.println("Time: " + (System.currentTimeMillis() - time)
				/ 1000.0 + " seconds");
		desiredAnswer = 1;
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


/*		char pic[][] = new char[maxY][maxX];
		for (int y = 0; y < maxY; y++) {
			for (int x = 0; x < maxX; x++) {
				pic[y][x] = picture[y].charAt(x);
			}
		}

		for (int y = 0; y < maxY; y++) {
			for (int x = 0; x < maxX; x++) {
				if (pic[y][x] == 'B') {
					pic[y][x] = 'X';
					int brush = 1;
					while (x + brush < maxX && y + brush < maxY) {
						boolean jump = false;
						for (int xx = x; xx < x + brush; xx++) {
							if (pic[y + brush][xx] == 'W') {
								jump = true;
								break;
							}
						}
						for (int yy = y; yy < y + brush; yy++) {
							if (pic[yy][x + brush] == 'W') {
								jump = true;
								break;
							}
						}
						if (jump)
							break;
						for (int xx = x; xx <= x + brush; xx++) {
							pic[y + brush][xx] = 'X';
						}
						for (int yy = y; yy <= y + brush; yy++) {
							pic[yy][x + brush] = 'X';
						}
						brush++;
					}
					if (brush < maxBrush)
						maxBrush = brush;
				} else if (pic[y][x] == 'X') {
					if (y + maxBrush - 1 < maxY && x + maxBrush - 1 < maxX) {
						boolean fill = true;
						for (int yy = y; yy < y + maxBrush; yy++) {
							for (int xx = x; xx < x + maxBrush; xx++) {
								if (pic[yy][xx] == 'W') {
									fill = false;
									break;
								}
								if (!fill)
									break;
							}
						}
						if (fill) {
							for (int yy = y; yy < y + maxBrush; yy++) {
								for (int xx = x; xx < x + maxBrush; xx++) {
									pic[yy][xx] = 'X';
								}					
							}
						}
					}
				}
			}
		}*/
