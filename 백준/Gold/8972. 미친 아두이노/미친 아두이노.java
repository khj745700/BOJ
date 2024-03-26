import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;


public class Main {
	static int N, M;
	static int iX;
	static int iY;
	static int[][] map;
	static List<Crazy> crazys;
	static int[] dx = {-1,0,1,-1,0,1,-1,0,1};
	static int[] dy = {1,1,1,0,0,0,-1,-1,-1};
	static List<Integer> moving;
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	N = Integer.parseInt(st.nextToken());
    	M = Integer.parseInt(st.nextToken());
    	map = new int[N][M];
    	
    	crazys = new ArrayList<>();
    	moving = new ArrayList<>();
    	
    	int idx = 1;
    	for(int i = 0 ; i < N; i++) {
    		String input = br.readLine();
    		for(int j = 0 ; j < M; j++) {
    			
    			if(input.charAt(j) == 'I') {
    				iX = j;
    				iY = i;
    			}
    			
    			if(input.charAt(j) == 'R') {
    				crazys.add(new Crazy(j,i, idx++));
    			}
    		}
    	}
    	
    	String move = br.readLine();
    	for(int i = 0 ; i < move.length(); i++) {
    		moving.add(move.charAt(i) - '1');
    	}
    	
    	int val = simulation();
    	
    	StringBuilder sb = new StringBuilder();
    	if(val == moving.size()) {
    		char[][] printMap = new char[N][M];
    		for(int i = 0 ; i < N; i++) {
    			Arrays.fill(printMap[i], '.');
    		}
    		printMap[iY][iX] = 'I';
    		for(Crazy c : crazys) {
    			printMap[c.y][c.x] = 'R';
    		}
    		
    		for(int i = 0; i < N; i++) {
    			sb.append(printMap[i]).append('\n');
    		}
    		
    	}else {
    		sb.append("kraj ");
    		sb.append(val);
    	}
    	System.out.println(sb);
    }
    static int simulation() {
    	int count = 0;
    	boolean win = true;
    	for(int d : moving) {
    		iX +=dx[d];
    		iY +=dy[d];
    		count++;
    		for(int i = crazys.size() -1 ; i >= 0; i--) {
    			Crazy cur = crazys.get(i);
    			
    			int direct = getCrazyToIDirection(cur.x, cur.y);
    			
    			int newX = cur.x + dx[direct];
    			int newY = cur.y + dy[direct];
    			
    			if(newX == iX && newY == iY) {
    				win = false;
    				break;
    			}
    			
    			if(map[newY][newX] != 0) {
    				if(map[newY][newX] != -1) { //이미 폭발했다면, 중첩될 수 있으므로.
    					crazys.remove(new Crazy(0,0,map[newY][newX])); // 먼저 두었으므로 먼저 지우고 나를 지워야 순서가 맞음.
    				}
    				crazys.remove(new Crazy(0,0,cur.idx));
					map[newY][newX] = -1;
    				continue;
    			}
    			
    			cur.x = newX;
    			cur.y = newY;
    			map[newY][newX] = cur.idx;
    		}
    		if(!win) {
    			break;
    		}
    		map = new int[N][M];


    	}
    	return count;
    }
    
    static void print() {
		char[][] printMap = new char[N][M];
		for(int i = 0 ; i < N; i++) {
			Arrays.fill(printMap[i], '.');
		}
		printMap[iY][iX] = 'I';
		for(Crazy c : crazys) {
			printMap[c.y][c.x] = 'R';
			System.out.println(c.y + " " + c.x);
		}
		
		for(int i = 0; i < N; i++) {
			System.out.println(printMap[i]);
		}
		System.out.println();
    }
    

    static int getCrazyToIDirection(int x, int y) {
    	int direction = -1;
    	int min = Integer.MAX_VALUE;
    	for(int i =0 ; i < 9; i++) {
    		int curX = x + dx[i];
    		int curY = y + dy[i];
    		
    		if(isNotBoundary(curX, curY)) {
    			continue;
    		}
    		
    		int d = getDistance(curX, curY);
    		if(d < min) {
    			min = d;
    			direction = i;
    		}
    	}
    	
    	return direction;
    }
    
    static int getDistance(int x, int y) {
    	return Math.abs(x - iX) + Math.abs(y - iY);
    }
    
    static boolean isNotBoundary(int x, int y ) {
    	return x == -1 || x == M || y == -1 || y == N;
    }
    
    //바로 지우려면...
    // List에 인덱스를 바로 접근 할 수 있어야 함.
    // 혹은 좌표를 미리 계산하고 넣어도 되지 않을까?
    // 그럼 공간복잡도 이슈가 발생할까? -> rescan 발생하면서 다시 Crazy를 넣어주어야 함.
    // 10000 -> 맵을 새롭게 만들어 주어도 됨.
    
    static class Crazy {
    	int x;
    	int y;
    	int idx;
    	
    	Crazy(int a, int b, int c) { 
    		x = a;
    		y = b;
    		idx = c;
    	}

    	@Override
    	public boolean equals(Object o) {
    		return idx == ((Crazy) o).idx;
    	}
    }
}