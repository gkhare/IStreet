import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Solution {

	class SuffixTree {
		class Node {
			String s;

		}

		public void add(String s) {

		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		int N = Integer.parseInt(line);

		Solution solution = new Solution();

		Set<String> strings = new HashSet<String>();

		for (int i = 0; i < N; i++) {
			line = br.readLine();
			solution.genSubString(line, strings);
		}
	}

	public void genSubString(String s, Set<String> strings) {

		if (s.length() != 0) {
			String toBeAdded = s.substring(0, s.length());
			strings.add(toBeAdded);
			genSubString(s.substring(1, s.length()), strings);
			genSubString(s.substring(0, s.length() - 1), strings);

		}

	}
}
