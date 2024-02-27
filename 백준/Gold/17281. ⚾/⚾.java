import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int[][] player;
	static boolean[] visited;
	static int[] lineUp;
	static int max;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		player = new int[9][N];
		visited = new boolean[9];
		lineUp = new int[9];
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 9; j++) {
				player[j][i] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		visited[3] = true;
		lineUp[3] = 0;
		
		permutation(1);
		System.out.println(max);
	}
	
	
	static void permutation(int cnt) {
		if(cnt == 9) {
			
			int score = simulation();
			max = Math.max(score, max);
			return;
		}

		//현재 선수를 1번 자리부터 9번 자리까지 넣어보며 재귀 호출
		for(int i = 0; i < 9; i++) {
			if(visited[i] == true) {
				continue;
			}
			visited[i] = true;
			lineUp[i] = cnt;
			permutation(cnt+1);
			visited[i] = false;
		}
	}
	
	
	
	static int simulation() {
		int score = 0;
		int out = 0;
		int inning = 0;
		int i = 0;
		while(inning < N) {
			
			boolean[] block = new boolean[4];
			while(out < 3) {
				switch(player[lineUp[i++]][inning]) {
				case 0:
					out++;
					break;
				case 1:
					score+=blockMove(1, block);
					block[1] = true;
					break;
				case 2:
					score+=blockMove(2, block);
					block[2] = true;
					break;
				case 3:
					score+=blockMove(3, block);
					block[3] = true;
					break;
				case 4:
					score+=blockMove(4, block);
					score++;
					break;
				}
				if(i == 9) {
					i = 0;
				}
			}
			out = 0;
			inning++;
		}
		return score;
	}
	
	
	static int blockMove(int size, boolean[] block) {
		int score = 0;
		for(int i = 3; i >= 0; i--) {
			if(block[i]) {
				if((i + size) > 3) {
					block[i] = false;
					score++;
				}else {
					block[i+size] = true;
					block[i] = false;
				}
			}
		}
		
		return score;
	}
}