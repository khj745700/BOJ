import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Main {
	static class Edge implements Comparable<Edge>{
		public Edge(int u, int v, int w) {
			this.u = u;
			this.v = v;
			this.w = w;
		}
		int u;
		int v;
		int w;
		@Override
		public int compareTo(Edge o) {
			return this.w - o.w;
		}
	}
	
	
	static boolean[] selected;
	static int result;
	static int cnt = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = br.readLine().split(" ");
		int vn = Integer.parseInt(temp[0]); // 노드갯수
		int en = Integer.parseInt(temp[1]); // 갯수
		PriorityQueue<Edge> pq = new PriorityQueue<>(en); //가중치 비용 뽑기 위함.
		boolean[] selected = new boolean[vn];
		for(int i=0; i<en; i++) {
			temp = br.readLine().split(" ");
			int u = Integer.parseInt(temp[0])-1;
			int v = Integer.parseInt(temp[1])-1;
			int w = Integer.parseInt(temp[2]);
			pq.add(new Edge(u,v,w));
		}
		ArrayList<Edge> list = new ArrayList<Edge>();
		Edge edge = pq.poll();
		selected[edge.u] = true;
		selected[edge.v] = true;
		result += edge.w;

		
		
		//
		cnt=2; // 노드를 두가지를 넣음.
		while(cnt != vn) {
			edge = pq.poll(); // 우선순위중 가중치 젤 낮은 거 뽑음.
			int u = edge.u;
			int v = edge.v;

			if(selected[u] ^ selected[v]) { // 둘 다 선택되어있는 경우 사이클이 생기므로...
				if(!selected[u]) {selected[u] = true; } 
				if(!selected[v]) {selected[v] = true; }
				cnt++;
				result += edge.w;
				pq.addAll(list);
				list.clear();
			}
			else
				if(selected[u] & selected[v]) {
					continue;
				}
				list.add(edge);
		}
		System.out.println(result);
	}
}