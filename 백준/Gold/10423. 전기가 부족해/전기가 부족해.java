import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N, M, K;
	static int[] set;
	static List<Edge> list;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		set = new int[N+1];
		
		for(int i = 1; i <= N; i++) {
			set[i] = i;
		}
		
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < K; i++) {
			int n = Integer.parseInt(st.nextToken());
			set[n] = 0;
		}
		
		list = new ArrayList<>();
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			list.add(new Edge(u,v,w));
		}
		
		list.sort(null);
		
		int count = K-1;
		int idx = 0;
		int sum = 0;
		while(count != N-1) {
			Edge cur = list.get(idx);
			
			if(union(cur.u, cur.v)) {
				sum+=cur.w;
				count++;
			}
			
			idx++;
		}
		
		System.out.println(sum);
	}
	
	static int find(int v) {
		if(v == set[v])
		{
			return v;
		}
		return set[v] = find(set[v]);
	}
	
	static boolean union(int a, int b) {
		a = find(a);
		b = find(b);
		
		if(a == b) {
			return false;
		}
		
		set[a] = b;
		return true;
	}
	
	
	static class Edge implements Comparable<Edge> {
		int u;
		int v;
		int w;
		Edge(int a, int b, int c) {
			u = a; v = b; w = c;
		}
		
		@Override
		public int compareTo(Main.Edge o) {
			return w - o.w;
		}
	}
}
