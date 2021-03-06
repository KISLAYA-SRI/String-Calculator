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
		String pattern = "";
		if (multipleDelimiters(str)) {
			pattern = findDelimiters(str);
		} else {
			pattern = str.substring(2, idx);
		}
		String newstr = str.substring(idx + 1);
		String nums[] = newstr.split(pattern);
		// System.out.println(Arrays.toString(nums));
		return nums;
	}

	public static boolean multipleDelimiters(String str) {
		if (str.indexOf('[') == -1)
			return false;
		else
			return true;
	}

	public static String findDelimiters(String str) {
		String pattern = "";
		int strt = 0, end = 0;
		while (true) {
			strt = str.indexOf("[", strt);
			end = str.indexOf("]", strt);
			if (strt == -1)
				break;
			String p = str.substring(++strt, end);
			if (specialDelimiter(p)) {
				pattern = pattern + "\\" + p + "|";
			} else {
				pattern = pattern + p + "|";
			}
		}
		// System.out.println(pattern.substring(0, pattern.length() - 1));
		return pattern.substring(0, pattern.length() - 1);
	}

	public static boolean specialDelimiter(String p) {
		if (p.charAt(0) == '*' || p.charAt(0) == '+' || p.charAt(0) == '.' || p.charAt(0) == '$')
			return true;
		return false;
	}

}
