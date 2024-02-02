import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static List<Node>[] list;
	static List<Node>[] reverseList;
	static int INF = 1_000_000_000;
	static int N, M, X;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		
		list = new List[N+1];
		reverseList = new List[N+1];
		
		for(int i = 0; i < list.length; i++) {
			list[i] = new ArrayList<>();
			reverseList[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			list[u].add(new Node(v, w));
			reverseList[v].add(new Node(u,w));
		}
		
		int[] dist = dijkstra(list);
		int[] reverseDist = dijkstra(reverseList);
		
		int max = Integer.MIN_VALUE;
		for(int i = 1; i < dist.length; i++) {
			max = Math.max(dist[i] + reverseDist[i], max);
		}
		
		System.out.println(max);
	}
	
	
	static int[] dijkstra(List<Node>[] find) {
		int[] dist = new int[N+1];
		boolean[] visited = new boolean[N+1];
		PriorityQueue<Node> q = new PriorityQueue<>();
		
		q.add(new Node(X, 0));
		Arrays.fill(dist, INF);
		dist[X] = 0;
		
		while(!q.isEmpty()) {
			Node curNode = q.poll();
			int cur = curNode.end;
			
			if(visited[cur]) {
				continue;
			}
			visited[cur] = true;
			for(Node e : find[cur]) {
				if(dist[e.end] > dist[cur] + e.weight)  {
					dist[e.end] = dist[cur] + e.weight;
					q.add(new Node(e.end, dist[e.end]));
				}
			}
		}

		return dist;
	}
	
	
	static class Node implements Comparable<Node> {
		int end;
		int weight;
		
		Node(int e, int w) {
			end = e;
			weight = w;
		}

		@Override
		public int compareTo(Main.Node o) {
			return weight - o.weight;
		}
		
		
	}
}