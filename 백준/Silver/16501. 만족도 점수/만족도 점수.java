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
	static int[] arr;
	static int[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new int[8];
		for(int i = 0; i < 8; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		visited = new int[8];
		
		backtracking(0, new ArrayList<>());
		System.out.println(MAX);
	}
	
	
	static void backtracking(int depth, List<Integer> list) {
		if(depth == 8) {
			getSum();
			for(int i = 1; i <= 4; i++) {
				list.add(count[i]);
			}
			maxBacktracking(list);
			list.clear();
			
			return;
		}
		
		for(int i = 0; i < 8; i++) {
			if(visited[i] != 0) {
				continue;
			}
			
			visited[i] = (depth/2) + 1;
			backtracking(depth+1, list);
			visited[i] = 0;
		}
	}
	
	static int[] count = new int[5];
	static void getSum() {
		Arrays.fill(count, 0);
		for(int i = 0; i < 8; i++) {
			count[visited[i]] += arr[i];
		}
	}
	
	static float MAX = 0;
	static void maxBacktracking(List<Integer> list) {
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++) {
				if(i == j) {
					continue;
				}
				for(int k = 0; k < 4; k++) {
					if(k == i || k == j) {
						continue;
					}
					for(int l = 0; l < 4; l++ ) {
						if(l == i || l == j || l == k) {
							continue;
						}
						
						float team1 = getHappy(getAvg(list.get(i)), getAvg(list.get(j)));
						float team2 = getHappy(getAvg(list.get(k)), getAvg(list.get(l)));
//						System.out.println(team1 + " " + team2);
						MAX = Math.max(Math.min(team1, team2), MAX);
					}
				}
			}
		}
	}
	
	static float getAvg(int val) {
		return val / 2.0f;
	}
	
	static float getHappy(float t1, float t2) {
		return 1- Math.abs(t1 - t2)/10;
	}
}


//LIST ? 