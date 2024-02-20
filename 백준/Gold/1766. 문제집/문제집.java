import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main{
	static int N, M;
	static int[] degree;
	static List<Integer>[] map;
	static List<Integer> answer;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new ArrayList[N+1];
		degree = new int[N+1];
		for(int i = 1 ; i <= N; i++) {
			map[i] = new ArrayList<>();
		}
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a1 = Integer.parseInt(st.nextToken());
			int a2 = Integer.parseInt(st.nextToken());
			
			map[a1].add(a2);
			degree[a2]++;
		}
		
		answer = new ArrayList<>();
		setAns();
		StringBuilder sb = new StringBuilder();
		for(int i : answer) {
			sb.append(i).append(' ');
		}
		System.out.println(sb);
	}
	
	
	
	static void setAns() {
		PriorityQueue<Integer> q = new PriorityQueue<>();
		for(int i = 1; i <= N; i++) {
			if(degree[i] == 0) {
				q.add(i);
			}
		}
		
		while(!q.isEmpty()) {
			int val = q.poll();
			if(degree[val] == 0) {
				answer.add(val);
			}
			
			for(int i : map[val]) {
				if(--degree[i] == 0) {
					q.add(i);
				}
			}
		}
	}
}