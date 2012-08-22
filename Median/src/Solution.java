import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution {
	
	class MedianManager {
		
		class myInt {
			private int x;
			
			public myInt(int x) {
				this.x = x;
			}
			
			public int getX() {
				return x;
			}
			
			@Override
			public String toString() {
				return x+"";
			}
			
			@Override
			public boolean equals(Object obj) {
				return this.x == ((myInt)obj).getX();
			}
		}
		
		int size = 0;
		
		PriorityQueue<myInt> minHeap = new PriorityQueue<myInt>(1, new Comparator<myInt>() {
			@Override
			public int compare(myInt o1, myInt o2) {
				return o1.getX() - o2.getX();
			}
		});
		
		PriorityQueue<myInt> maxHeap = new PriorityQueue<myInt>(1, new Comparator<myInt>() {
			@Override
			public int compare(myInt o1, myInt o2) {
				return o2.getX() - o1.getX();
			}
		});
		
		Map<Integer, List<myInt>> intSet = new HashMap<Integer, List<myInt>>();
		
		public void printMedian() {
			if (size % 2 == 0) {
				int x = minHeap.peek().getX();
				int y = maxHeap.peek().getX();
				double out = (x+y)/2.0;
				Double d = out;
				if (out - d.intValue() == 0)
					System.out.println(d.intValue());
				else
					System.out.println(out);
			} else {
				System.out.println(minHeap.peek().getX());
			}
		}
		
		public void add(int x) {
			insertIntoHeap(new myInt(x));
			size++;
			printMedian();
		}
		
		public void remove(int x) {
			removeFromHeap(new myInt(x));
			if (size > 0) printMedian(); 
			else System.out.println("Wrong!");
		}
		
		private void removeFromHeap(myInt m) {
			if (minHeap.contains(m)) {
				if (m.getX() < minHeap.peek().getX()) {
					maxHeap.remove(m);
					maxHeap.offer(minHeap.poll());
				} else {
					minHeap.remove(m);
					if (size % 2 == 0)
						minHeap.offer(maxHeap.poll());
				}
				size--;
			}
		}
		
		public void insertIntoHeap(myInt x) {
			if (minHeap.size() == 0)
				minHeap.offer(x);
			else if (maxHeap.size() == 0) {
				if (x.getX() > minHeap.peek().getX()) {
					minHeap.offer(x);
					maxHeap.offer(minHeap.poll());
				} else {
					maxHeap.offer(x);
				}
			} else {
				if (size % 2 == 0) {
					if(x.getX() <= maxHeap.peek().getX()) {
						maxHeap.offer(x);
						minHeap.offer(maxHeap.poll());
					} else if (x.getX() >= minHeap.peek().getX()){
						minHeap.offer(x);
					}
				} else {
					if (x.getX() <= minHeap.peek().getX()) {
						maxHeap.offer(x);
					} else if (x.getX() > minHeap.peek().getX()){
						minHeap.offer(x);
						maxHeap.offer(minHeap.poll());
					}
				}
			}
		}
		
	}
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		int N = Integer.parseInt(line);
		Solution solution = new Solution();
		MedianManager manager = solution.new MedianManager();
		for (int i = 0; i < N; i++) {
			line = br.readLine();
			if (line.startsWith("a ")) {
				int x = Integer.parseInt(line.split(" ")[1]);
				manager.add(x);
			} else if (line.startsWith("r ")) {
				int x = Integer.parseInt(line.split(" ")[1]);
				manager.remove(x);
			} 
//			System.out.println("MaxHeap:"+manager.maxHeap);
//			System.out.println("MinHeap:"+manager.minHeap);
		}
	}

}
