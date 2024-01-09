import java.util.*;
import java.io.*;

class Solution
{
	static List<List<Integer>> chain;
	static int N;
	static int M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		int answer = 0;
		int test_case = 1;
		while(T --> 0) {
			answer = 0;
			chain = new ArrayList<>();
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			for(int i = 0; i <= N; i++ ) {
				chain.add(new ArrayList<>());
                chain.get(i).add(i);
			}
			
			int target;
			int val;
			for(int i = 0 ; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				target = Integer.parseInt(st.nextToken());
				val = Integer.parseInt(st.nextToken());
				chain.get(target).add(val);
				chain.get(val).add(target);
			}
			
			for(int i = 1 ; i <= N; i++) {
				if(chain.get(i).size() > 0) {
					bfs(i);
					answer++;
				}
			}
			
			System.out.printf("#%d %d\n", test_case++, answer);
		}
	}
	
	
	static void bfs(int start) {
		Queue<int[]> q = new ArrayDeque<>();
		List<Integer> startNodeList = chain.get(start);
		
		for(int i = 0 ; i < startNodeList.size(); i++) {
			q.add(new int[] {start, startNodeList.get(i)});
		}
		int target;
		int val;
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			target = cur[0];
			val = cur[1];
			
			chain.get(target).remove((Integer) val);
			chain.get(val).remove((Integer) target);
			
			startNodeList = chain.get(val);
			for(int i = 0 ; i < startNodeList.size(); i++) {
				q.add(new int[] {val, startNodeList.get(i)});
			}
		}
	}
}