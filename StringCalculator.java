package TEST;

public class StringCalculator {

	static int Add(String s) {
		if (s.length() == 0)
			return 0;
      		
		int res = 0;
		String nums[];
		if (s.startsWith("//")) {
			nums = startWithSlash(s);
		} else {
			nums = s.split("[,\n]");
		}

		for (String i : nums) {
			res += Integer.parseInt(i);
		}
		return res;
	}

	public static String[] startWithSlash(String str) {
		int idx = str.indexOf("\n");
		String newstr = str.substring(idx + 1);
		String pattern = str.substring(2, idx);
		String nums[] = newstr.split(pattern);
		return nums;
	}

}
