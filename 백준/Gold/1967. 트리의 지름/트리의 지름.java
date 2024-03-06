import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int N;	
	static Map<Integer, Integer>[] tree;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		tree = new HashMap[N+1];
		
		for(int i = 0 ; i <= N; i++) {
			tree[i] = new HashMap<>();
		}
		
		for(int i = 0; i < N-1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			tree[u].put(v, d);
			tree[v].put(u, d);
			//양방향으로 연결을 잡는다.
		}
		int max = 0;
		for(int i = 1; i <= N; i++) {
			PriorityQueue<Integer> pq = new PriorityQueue<>((i1,i2) -> (i2 - i1));
			if(tree[i].size() <= 1) {
				continue;
			}
			int sum = 0;
			for(Map.Entry<Integer, Integer> entry : tree[i].entrySet()) {				
				pq.add(findMax(entry.getKey(), entry.getValue(), i));
			}
			sum += pq.poll();
			sum += pq.poll();
			max = Math.max(sum, max);
		}
		System.out.println(max);
	}
	
	
	
	static int findMax(int u, int d, int before) {
		if(tree[u].size() == 1) {
			return d;
		}
		
		int max = 0;
		for(Map.Entry<Integer, Integer> entry : tree[u].entrySet()) {
			if(entry.getKey().intValue() == before) {
				continue;
			}
			max = Math.max(findMax(entry.getKey(), d + entry.getValue(), u), max);
		}
		
		return max;
	}
}

