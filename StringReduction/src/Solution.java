import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;


public class Solution {
	
	enum replacer {
		ab ("c"),
		ba ("c"),
		bc ("a"),
		cb ("a"),
		ac ("b"),
		ca ("b");
		
		private String val;
		
		replacer(String val) {
			this.val = val;
		}
		
		public String getVal() {
			return val;
		}
		
	}
	
	Stack<String> stack;
	
	public void reduceString(String s) {
		stack = new Stack<String>();
		s = s.toLowerCase();
		for (int i = 0; i < s.length(); i++) {
			push(s.charAt(i)+"");
		}
	}
	
	public void push(String s) {
		if (stack.isEmpty()) {
			stack.push(s);
		} else if (stack.peek().contains(s)) {
			stack.push(s);
		} else {
			push(replacer.valueOf(stack.pop()+s).getVal());
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		int N = Integer.parseInt(line);
		
		Solution solution = new Solution();
		
		for (int i = 0; i < N; i++) {
			line = br.readLine().trim();
			solution.reduceString(line);
			System.out.println(solution.stack.size());
		}
	}

}
