import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.annotation.Target;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static List<Coord> list;
	static int[] dist;
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		while(T --> 0) {
			N = Integer.parseInt(br.readLine());
			list = new ArrayList<>();

			for(int i = 0; i < N+2; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				list.add(new Coord(x,y, i));
			}
			
			sb.append(bfs() ? "happy" : "sad").append('\n');
		}
		System.out.println(sb);
	}
	
	static boolean bfs() {
		Queue<Coord> q = new ArrayDeque<>();
		boolean[] visited = new boolean[N+2];
		q.add(list.get(0));
		visited[0] = true;
		
		while(!q.isEmpty()) {
			Coord cur = q.poll();
			
			for(int i = 1; i < N+2; i++) {
				Coord target = list.get(i);
				if(visited[target.idx]) {
					continue;
				}
				
				if(cur.getDistance(target) > 1000) {
					continue;
				}
				
				if(target.idx == N+1) {
					return true;
				}
				
				visited[target.idx] = true;
				q.add(target);
			}
		}
		
		return false;
		
	}
	
	static class Coord {
		int x;
		int y;
		int idx;
		Coord(int a, int b, int c) {
			x = a;
			y = b;
			idx = c;
		}
		
		public int getDistance(Coord t) {
			return Math.abs(x - t.x) + Math.abs(y - t.y);
		}
	}
}