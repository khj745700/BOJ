import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M, K;
	static Smell[][] smellMap;
	static Shark[][] sharkMap;
	static Map<Integer, Shark> sharkList = new HashMap<>();
	static Queue<Smell> smells;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		smellMap = new Smell[N][N];
		sharkMap = new Shark[N][N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				int n = Integer.parseInt(st.nextToken());
				sharkMap[i][j] = new Shark(n, j, i);
				if(sharkMap[i][j].num != 0) {
					sharkList.put(sharkMap[i][j].num, sharkMap[i][j]);
				}
				smellMap[i][j] = new Smell();
			}
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= M; i++) {
			sharkList.get(i).d = Integer.parseInt(st.nextToken()) -1;
		}
		
		for(int i = 1; i <= M; i++) {
			
			Shark cur = sharkList.get(i);
			cur.priorityD = new int[4][4];
			for(int j = 0; j < 4; j++) {
				st = new StringTokenizer(br.readLine());
				for(int k = 0; k < 4; k++) {
					cur.priorityD[j][k] = Integer.parseInt(st.nextToken()) - 1; 
				}
			}
		}
		int day = bfs();
		System.out.println(day == 1001 ? -1 : day);
	}
	//1.먼저 상어들을 맵에 저장시킨다.
	//2.상어들이 이동하기 전, 냄새를 뿌린다.
	//3.상어들이 이동하다가 같은 장소에 상어가 있다면 죽는다.   
	//4. 이동이 끝난 후, 냄새들의 텀을 1 줄인다.
	
	
	
	static int bfs() {
		PriorityQueue<Shark> pq = new PriorityQueue<>();
		Queue<Smell> smellJobQ = new ArrayDeque<>();
		int day = 0;
		while(putPQ(pq) != 1 && day != 1001) {
			//냄새 저장.
			for(Map.Entry<Integer, Shark> entry : sharkList.entrySet()) {
				Shark target = entry.getValue();
				if(smellMap[target.y][target.x].liveTime == 0) {
					smellJobQ.add(smellMap[target.y][target.x]);
				}
				smellMap[target.y][target.x].liveTime = K;
				smellMap[target.y][target.x].num = target.num;
			}
			int size = pq.size();
			day++;

			while(size --> 0) {
				Shark cur = pq.poll();
				
				int x = cur.x;
				int y = cur.y;
				int d = cur.d;
				
				boolean cantGo = true;
				boolean isDead = false;
				for(int i = 0; i < 4; i++) {
					int curD = cur.priorityD[d][i];
					int curX = x + dx[curD];
					int curY = y + dy[curD];
					
					if(!isBoundary(curX, curY)) {
						continue;
					}
					
					if(smellMap[curY][curX].liveTime > 0) {
						continue;
					}
					
					if(sharkMap[curY][curX].num < cur.num && sharkMap[curY][curX].num > 0) {
						sharkList.remove(cur.num);
						cur.num = 0;
						isDead = true;
						break;
					}
					
					Shark target = sharkMap[curY][curX];
					target.num = cur.num;
					target.d = curD;
					target.priorityD = cur.priorityD;
					cur.num = 0;
					cur.priorityD = null;
					sharkList.replace(target.num, target);
					cantGo = false;
					break;
				}
				
				if(isDead) {
					continue;
				}
				
				if(cantGo) {
					for(int i = 0; i < 4; i++) {
						int curD = cur.priorityD[d][i];
						int curX = x + dx[curD];
						int curY = y + dy[curD];
						
						if(!isBoundary(curX, curY)) {
							continue;
						}
						
						
						if(smellMap[curY][curX].num == cur.num) {
							Shark target = sharkMap[curY][curX];
							target.num = cur.num;
							target.d = curD;
							target.priorityD = cur.priorityD;
							cur.num = 0;
							cur.priorityD = null;
							sharkList.replace(target.num, target);
							cantGo = false;
							break;
						}
					}
				}

			}
			int smellSize = smellJobQ.size();
			while(smellSize --> 0) {
				Smell cur = smellJobQ.poll();
				cur.liveTime--;
				if(cur.liveTime == 0) {
					cur.num = 0;
				}
				if(cur.liveTime > 0) {
					smellJobQ.add(cur);
				}
			}
		}
		
		return day;
	}
	
	static boolean isBoundary(int x, int y) {
		return 0 <= x && x < N && 0 <= y && y < N;
	}
	
	static int putPQ(PriorityQueue<Shark> pq) {
		for(Map.Entry<Integer, Shark> entry : sharkList.entrySet()) {
			pq.add(entry.getValue());
		}
		
		return sharkList.size();
	}
	
	static class Shark implements Comparable<Shark> {
		int num;
		int x, y;
		int[][] priorityD;
		int d;
		
		Shark(int num, int x, int y) {
			this.num = num;
			this.x = x;
			this.y = y;
		}
		
		Shark(int num, int d) {
			this.num = num;
			this.d = d;
		}
		
		public int compareTo(Shark s) {
			return num - s.num;
		}
		
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return num + " " + d;
		}
	}
	
	
	static class Smell {
		int num;
		int liveTime;
		
		Smell(){};
		
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return num + " " + liveTime;
		}
	}
}