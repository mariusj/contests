public class ColoredStrokes {
	private int maxY;
	private int maxX;
	private char[][] pic;

	public int getLeast(String[] picture) {
		maxY = picture.length;
		maxX = picture[0].length();
		pic = new char[maxY][maxX];
		for (int y = 0; y < maxY; y++) {
			pic[y] = picture[y].toCharArray();
		}
		int lines = 0;
		for (int y = 0; y < maxY; y++) {
			for (int x = 0; x < maxX; x++) {
				switch (pic[y][x]) {
				case 'R':
					lines++;
					eraseHLine(y, x);
					break;
				case 'B':
					lines++;
					eraseVLine(y, x);
					break;
				case 'G':
					lines += 2;
					eraseHLine(y, x);
					eraseVLine(y, x);
					break;
				}
			}
		}
		return lines;
	}

	private void eraseHLine(int y, int x) {
		while (x < maxX) {
			switch (pic[y][x]) {
			case 'R':
				pic[y][x] = '.';
				break;
			case 'G':
				pic[y][x] = 'B';
				break;
			default:
				return;
			}
			x++;
		}
	}

	private void eraseVLine(int y, int x) {
		while (y < maxY) {
			switch (pic[y][x]) {
			case 'B':
				pic[y][x] = '.';
				break;
			case 'G':
				pic[y][x] = 'R';
				break;
			default:
				return;
			}
			y++;
		}
	}

	public static void main(String[] args) {
		long time;
		int answer;
		boolean errors = false;
		int desiredAnswer;

		time = System.currentTimeMillis();
		answer = new ColoredStrokes().getLeast(new String[] { "...", "..." });
		System.out.println("Time: " + (System.currentTimeMillis() - time)
				/ 1000.0 + " seconds");
		desiredAnswer = 0;
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
		answer = new ColoredStrokes().getLeast(new String[] { "..B.", "..B." });
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
		answer = new ColoredStrokes().getLeast(new String[] { ".BB." });
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
		answer = new ColoredStrokes().getLeast(new String[] { "...B..",
				".BRGRR", ".B.B.." });
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
		answer = new ColoredStrokes().getLeast(new String[] { "...B..",
				".BRBRR", ".B.B.." });
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
		answer = new ColoredStrokes().getLeast(new String[] { "GR", "BG" });
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

		if (errors)
			System.out.println("Some of the test cases had errors :-(");
		else
			System.out
					.println("You're a stud (at least on the test data)! :-D ");
	}

}
