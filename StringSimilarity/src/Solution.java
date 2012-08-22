import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Solution {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		int N = Integer.parseInt(line);
		for (int i = 0; i < N; i++) {
			line = br.readLine().trim();
			check(line);
		}
	}
	
	public static void check(String s) {
		char[] c = s.toCharArray();
		int sum = c.length;
		for (int i = 1; i < c.length; i++) {
			for (int j = 0; j < c.length-i; j++) {
				if (c[j] == c[j+i]) {
					sum++;
				} else {
					break;
				}
			}
		}
		System.out.println(sum);
	}

}
