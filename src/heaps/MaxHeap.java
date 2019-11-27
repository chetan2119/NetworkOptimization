package heaps;

public class MaxHeap {

	private static int[] H;
	private static int[] D;
	private static int heapNumber;

	public MaxHeap(int size) {
		H = new int[size];
		D = new int[size];
		heapNumber = 0;
	}

	public static int getHeapNumber() {
		return heapNumber;
	}

	public static int getIndex(int index) {
		return  H[index];
	}

	public static void insert(int vertex, int bw) {
	H[heapNumber] = vertex;
		D[vertex] = bw;
		int pos = heapNumber;
		heapifyUp(pos); 
		heapNumber++;
	}
	
	private static void heapifyUp(int pos) {
		while (D[H[pos]] > D[H[parent(pos)]]) { 
			swap(pos, parent(pos)); 
			pos = parent(pos); 
		} 
	}	

	private static int parent(int pos) 
	{ 
		return (pos-1) / 2; 
	}

	public static int maximum() {
		return H[0];
	}

	public static void delete(int i) {
		heapNumber--;
		H[i] = H[heapNumber];
		H[heapNumber]=0;
		heapifyUp(i);
	}
	public static void delete() {
		heapNumber--;
		H[0] = H[heapNumber];
		H[heapNumber]=0;
		heapfyDown(0);
	}

	private static void heapfyDown(int k) {
		int left = (2 * k) + 1;
		int right = (2 * k) + 2;

		if(left<5000 && right < 5000) {
			if (D[H[k]] < D[H[left]]) {
	
				if (D[H[left]] > D[H[right]]) { 
					swap(k, left); 
					heapfyDown(left); 
				} 
				else { 
					swap(k, right); 
					heapfyDown(right); 
				} 
			} 
		}
	}
	
	public void updateHeap(int vertex, int bw) {
		D[vertex] = bw;
		int j;
		for(j=0; j<heapNumber; j++) {
			if(H[j] == vertex)
				break;
		}
		heapifyUp(j);
	}
	
	private static void swap(int pos1, int pos2) {
		int tempVertices = H[pos1];
		H[pos1] = H[pos2];
		H[pos2] = tempVertices;
	}

	public static void printH() {
		for (int i = 0; i < heapNumber; i++) {
			System.out.print(H[i] + " ");
		}
		System.out.println();
	}

	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		MaxHeap newHeap = new MaxHeap(10);
		int max;
		newHeap.insert(1,23);
		max = newHeap.maximum();
		System.out.println("TEST " + max);
		newHeap.insert(3,12);
		max = newHeap.maximum();
		System.out.println("TEST " + max);
		newHeap.insert(6,121);
		max = newHeap.maximum();
		System.out.println("TEST " + max);
		newHeap.delete();
		newHeap.insert(4,29);
		max = newHeap.maximum();
		System.out.println("TEST " + max);
		newHeap.insert(2,30);
		System.out.println("TEST " + max);
		printH();
	}
}