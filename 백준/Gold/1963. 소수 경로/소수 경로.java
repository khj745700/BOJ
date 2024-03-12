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
	static boolean[] aerathos;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		aerathos = new boolean[10000];
		setAeratos();
		
		int T = Integer.parseInt(br.readLine());
		while(T --> 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end =Integer.parseInt(st.nextToken());
			
			sb.append(bfs(start, end));
			sb.append('\n');
		}
		System.out.println(sb);
	}
	
	
	static int bfs(int start, int end) {
		boolean[] visited = new boolean[10000];
		Queue<Num> q = new ArrayDeque<>();
		Num startNum = new Num();
		startNum.num = start;
		q.add(startNum);
		visited[start] = true;
		
		while(!q.isEmpty()) {
			Num cur = q.poll();
			
			if(cur.num == end) {
				return cur.d;
			}
			
			for(int i = 1; i < 10; i++) {
				int curNum = cur.num % 1000;
				curNum = curNum + (i * 1000);
				if(!visited[curNum] && aerathos[curNum]) {
					visited[curNum] = true;
					
					Num n = new Num();
					n.d = cur.d + 1;
					n.num = curNum;
					q.add(n);
				}
			}
			
			for(int i = 0; i < 10; i++) {
				int curNum = cur.num % 100;
				curNum = curNum + (i * 100);
				curNum += (cur.num / 1000) * 1000;
				if(!visited[curNum] && aerathos[curNum]) {
					visited[curNum] = true;
					
					Num n = new Num();
					n.d = cur.d + 1;
					n.num = curNum;
					q.add(n);
				}
			}
			
			for(int i = 0; i < 10; i++) {
				int curNum = cur.num % 10;
				curNum = curNum + (i * 10);
				curNum += (cur.num / 100) * 100;
				if(!visited[curNum] && aerathos[curNum]) {
					visited[curNum] = true;
					
					Num n = new Num();
					n.d = cur.d + 1;
					n.num = curNum;
					q.add(n);
				}
			}
			
			for(int i = 0; i < 10; i++) {
				int curNum = 0;
				curNum = curNum + i;
				curNum += (cur.num / 10) * 10;
				if(!visited[curNum] && aerathos[curNum]) {
					visited[curNum] = true;
					
					Num n = new Num();
					n.d = cur.d + 1;
					n.num = curNum;
					q.add(n);
				}
			}
		}
		return -1;
	}
	
	static class Num {
		int num;
		int d;
	}
	
	static void setAeratos() {
		Arrays.fill(aerathos, true);
		aerathos[0] = false;
		aerathos[1] = false;
		for(int i = 2; i < 10000; i++) {
			if(aerathos[i]) {
				for(int j = i+i ; j < 10000; j+=i) {
					aerathos[j] = false;
				}
			}
		}
	}
}