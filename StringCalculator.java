package TEST;

public class StringCalculator {

	static int Add(String s) {
		if (s.length() == 0)
			return 0;
      
		int res = 0;
		String num[] = s.split(",");
		for (String i : num) {
			res += Integer.parseInt(i);
		}
		return res;
	}
}
