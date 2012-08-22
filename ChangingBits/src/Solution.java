import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Solution {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		String[] inp = line.split(" ");
		int N = Integer.parseInt(inp[0]);
		int Q = Integer.parseInt(inp[1]);
		
		line = br.readLine();
		String A = line;
		int intA = Integer.parseInt(line, 2);
		line = br.readLine();
		String B = line;
		int intB = Integer.parseInt(line, 2);
		
		String output = "";
		
		for (int i = 0; i < Q; i++) {
			line = br.readLine().trim();
			if (line.startsWith("set_")) {
				String[] arr = line.split(" ");
				int idx = Integer.parseInt(arr[1]);
				int x = Integer.parseInt(arr[2]);
				
				if (line.startsWith("set_a")){
					A = A.substring(0,A.length()- idx-1)+x+A.substring(A.length() - idx);
					intA = Integer.parseInt(A, 2);
				} else {
					B = B.substring(0,B.length()- idx-1)+x+B.substring(B.length() - idx);
					intB = Integer.parseInt(A, 2);
				}
				
			} else if (line.startsWith("get_c")) {
				String[] arr = line.split(" ");
				int idx = Integer.parseInt(arr[1]);
				output += ((intA+intB)>>idx) & 1;
			}
		}
		System.out.println(output);
	}

}
