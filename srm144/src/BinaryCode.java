
public class BinaryCode {
	
	private String decode1(String message, char start) {
		StringBuffer res = new StringBuffer(message.length()); 
		char prev2 = start;
		res.append(prev2);
		char prev1 = (char) (message.charAt(0) - prev2 + '0');
		if (prev1 != '0' && prev1 != '1')
			return "NONE";
		if (message.length() > 1) {
			res.append(prev1);
			for (int i=2; i<message.length(); i++) {
				char x = (char) (message.charAt(i-1) - prev2 - prev1 + '0' + '0');
				if (x != '0' && x != '1')
					return "NONE";
				res.append(x);
				prev2 = prev1;
				prev1 = x;
			}
			if (message.charAt(message.length() - 1) != (prev1 + prev2 - '0'))
				return "NONE";
		} else {
			if (message.charAt(0) != prev2)
				return "NONE";
		}
				
		return res.toString();
	}
	
	public String[] decode(String message) {
		return new String[] { decode1(message, '0'), decode1(message, '1') };
	}
	
	public void test(String message, String r1, String r2) {
		String[] res = decode(message);
		if (!res[0].equals(r1) || !res[1].equals(r2)) {
			System.out.println(message);
			System.out.println(res[0]);
			System.out.println(res[1]);
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		BinaryCode bc = new BinaryCode();
		
		bc.test("123210122", "011100011", "NONE");
		bc.test("11", "01", "10");
		bc.test("22111", "NONE", "11001");
		bc.test("123210120", "NONE", "NONE");
		bc.test("3", "NONE", "NONE");
		bc.test("12221112222221112221111111112221111", "01101001101101001101001001001101001", "10110010110110010110010010010110010");
				
		bc.test("1", "NONE", "1");
		bc.test("00", "00", "NONE");

	}

}
