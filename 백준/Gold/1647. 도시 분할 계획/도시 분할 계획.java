import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
	static int N, M;
	static int[] set;
	static List<Edge> edges;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		set = new int[N + 1];
		for(int i = 1 ; i <= N; i++) {
			set[i] = i;
		}
		edges = new ArrayList<>();
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			edges.add(new Edge(u, v, d));
		}
		
		edges.sort(null);
		
		int count = 0;
		int sum =0;
		for(Edge e : edges) {
			if(count == N-2) {
				break;
			}
			if(union(e.u, e.v)) {
				sum += e.d;
				count++;
			}
		}
		
		System.out.println(sum);
	}
	
	static int find(int v) {
		if(set[v] == v) {
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
		int d;
		Edge(int a, int b, int c) {
			u = a; v = b; d = c;
		}
		
		public int compareTo(Edge e) {
			return d - e.d;
		}
	}
}