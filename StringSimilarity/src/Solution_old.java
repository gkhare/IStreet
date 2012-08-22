import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class Solution_old {
	
	class SuffixTree {
		class Node {
			String ch;
			
			List<Node> children;
			
			public Node(String ch) {
				this.ch = ch;
				this.children = new ArrayList<Solution_old.SuffixTree.Node>();
			}
			
			public List<Node> getChildren() {
				return children;
			}
			
			public Node findChild(String s) {
				for (Node n : children) {
					if (n.ch.equals(s)) {
						return n;
					}
				}
				return null;
			}
			
			public String getCh() {
				return ch;
			}
			
			public int addWord(String s) {
				int count = 0;
				Node n = this;
				for (int i = 0; i < s.length(); i++) {
					Node t = n.findChild(s.substring(i,i+1));
					if (t == null) {
						t = new Node(s.substring(i,i+1));
						n.children.add(t);
					} else {
						count++;
					}
					n = t;
				}
				return count;
			}
			
			@Override
			public boolean equals(Object obj) {
				return ch.equals(obj.toString());
			}
			
			@Override
			public String toString() {
				return ch+"->"+children;
			}
		}
		
		Node root = new Node(null);
		
		int addString(String s) {
			int sum = 0;
			Node node = root;
			for (int i = 0; i < s.length(); i++) {
				String suffix = s.substring(i);
				int count = node.addWord(suffix);
				if (i==0) 
					sum += s.length();
				else {
					if (suffix.startsWith(s.substring(0, 1))) {
						sum += count;
					}
				}
			}
			return sum;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		int N = Integer.parseInt(line);
		Solution_old solution = new Solution_old();
		SuffixTree suffixTree = solution.new SuffixTree();
		for (int i = 0; i < N; i++) {
			line = br.readLine().trim();
			//System.out.println(suffixTree.addString(line));
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
				}
			}
		}
		System.out.println(sum);
	}

}
