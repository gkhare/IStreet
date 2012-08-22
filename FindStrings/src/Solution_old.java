import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Solution_old {
	
	class SortedSets {
		
		Set<String> uniqueStrings = new HashSet<String>();
		
		String[] stringArray;
		
		List<String> strings = new ArrayList<String>();
		
		int count = 0;
		
		public SortedSets(int size) {
			stringArray = new String[size];
		}
		
		public void add(String s) {
			if (uniqueStrings.add(s)) {
				strings.add(s);
			}
		}
		
		public void permute(String s) {
			if (s.length() > 0) {
				String str = s.substring(0);
				add(str);
				permute(s.substring(0, s.length()-1));
				permute(s.substring(1, s.length()));
			}
		}
		
		public void sort() {
			Collections.sort(strings);
		}
		
		public void printKth(int k) {
			System.out.println(strings.get(k-1));
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		int N = Integer.parseInt(line);
		
		Solution_old solution = new Solution_old();
		SortedSets sortedSets = solution.new SortedSets(N);
		
		for (int i = 0; i < N; i++) {
			line = br.readLine().trim();
			sortedSets.permute(line);
		}
		sortedSets.sort();
		line = br.readLine();
		N = Integer.parseInt(line);
		for (int i = 0; i < N; i++) {
			line = br.readLine();
			int k = Integer.parseInt(line);
			if (k > sortedSets.strings.size()) {
				System.out.println("INVALID");
			} else {
				sortedSets.printKth(k);
			}
		}
	}
	
}
