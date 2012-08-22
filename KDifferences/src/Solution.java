import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;


public class Solution {
	
	static class Node {
		int x, y;
		
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		@Override
		public boolean equals(Object obj) {
			String target = ((Node)obj).toString();
			return this.toString().startsWith(target) || this.toString().endsWith(target);
		}
		
		@Override
		public int hashCode() {
			if (x<y)
				return (""+x+y).hashCode();
			else
				return (""+y+x).hashCode();
		}
		
		@Override
		public String toString() {
			if (x<y)
				return (""+x+y);
			else
				return (""+y+x);
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		String[] arr = line.split(" ");
		
		Set<Node> kDiffSet = new HashSet<Solution.Node>();
		
		HashSet<Integer> integers = new HashSet<Integer>();
		
		int N = Integer.parseInt(arr[0]);
		int K = Integer.parseInt(arr[1]);
		
		line = br.readLine();
		arr = line.split(" ");
		for (int i = 0; i < N; i++) {
			int x = Integer.parseInt(arr[i]);
			integers.add(x);
		}
		
		for (Integer integer : integers) {
			if (integers.contains(integer-K)) {
				kDiffSet.add(new Node(integer, integer-K));
			} else if (integers.contains(integer+K)) {
				kDiffSet.add(new Node(integer, integer+K));
			}
		}		
		
		System.out.println(kDiffSet.size());
		
	}

}
