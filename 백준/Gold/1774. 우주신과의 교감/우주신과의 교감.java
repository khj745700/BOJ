import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[] set;
	static int[][] gods;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		set = new int[N+1];
		
		for(int i = 1 ; i <= N; i++) {
			set[i] = i;
		}
		
		gods = new int[N][2];
		
		for(int i = 0 ; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			gods[i][0] = Integer.parseInt(st.nextToken());
			gods[i][1] = Integer.parseInt(st.nextToken());
		}
		
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		
		for(int i = 0 ; i <N; i++) {
			for(int j = i + 1; j < N; j++) {
				pq.add(new Edge(i+1,j+1,getDistance(gods[i][0], gods[j][0],gods[i][1], gods[j][1])));
			}
		}
		int count = 0;
		for(int i = 0 ; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			if(union(u,v)) {
				count++;
			}
		}

		double ans = 0;
		while(!pq.isEmpty()) {
			if(count == N-1) {
				break;
			}
			Edge cur = pq.poll();
			if(union(cur.u, cur.v)) {
				ans+=cur.d;
				count++;
			}
		}
		ans = Math.round(ans*100)/100.0;
		System.out.printf("%.2f", ans);
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
	
	static double getDistance(int x1, int x2, int y1, int y2) {
		return Math.sqrt(Math.pow((x1-x2), 2) + Math.pow(y1-y2, 2));
	}
	
	static class Edge implements Comparable<Edge> {
		int u;
		int v;
		double d;
		
		Edge(int a, int b, double c) {
			u = a; v = b; d = c;
		}
		
		@Override
		public int compareTo(Main.Edge o) {
			// TODO Auto-generated method stub
			if(d > o.d) {
				return 1;
			}
			if(d < o.d) {
				return -1;
			}
			
			return 0;
		}
	}
}