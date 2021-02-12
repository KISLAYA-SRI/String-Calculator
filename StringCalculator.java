package TEST;

import java.util.ArrayList;
import java.util.List;

public class StringCalculator {

	static int Add(String s) throws Exception {
		if (s.length() == 0)
			return 0;

		int res = 0;
		String nums[];
		if (s.startsWith("//")) {
			nums = startWithSlash(s);
		} else {
			nums = s.split("[,\n]");
		}
		
		List<Integer> list = new ArrayList<>();
		for (String i : nums) {
			int x = Integer.parseInt(i);
			if (x < 0) {
				list.add(x);
			} else if (x > 1000) {
				continue;
			} else {
				res += x;
			}
		}
		if (list.size() > 0) {
			throw new Exception("negatives not allowed " + list.toString().replace("[", "").replace("]", ""));
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
