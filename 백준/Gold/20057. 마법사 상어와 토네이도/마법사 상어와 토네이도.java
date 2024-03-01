import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] sand;
	static int curX;
	static int curY;
	static int d;
	//상하좌우 --> 좌하오상
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	
	//1,1,7,7,2,2,10,10,5,a
	static int[][] sandDx = {
			{1,1,0,0,0,0,-1,-1,-2,-1},// 좌
			{-1,1,-1,1,-2,2,-1,1,0,0},// 하
			{-1,-1,0,0,0,0,1,1,2,1},  //우
			{-1,1,-1,1,-2,2,-1,1,0,0}// 상
	};
	static int[][] sandDy = {
			{-1,1,-1,1,-2,2,-1,1,0,0}, //좌
			{-1,-1,0,0,0,0,1,1,2,1},  //하
			{-1,1,-1,1,-2,2,-1,1,0,0}, //우
			{1,1,0,0,0,0,-1,-1,-2,-1}//상
	};
	
	static double[] rate = {0.01,0.01,0.07,0.07,0.02,0.02,0.1,0.1,0.05};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		sand = new int[N][N];
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j  = 0; j < N; j++) {
				sand[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		curX = N/2;
		curY = N/2;
		int moveCount = 0;
		int range = 1;
		d = 0;
		int date = 0;
		int sandSum = 0;
		int count = 0;
		while(curX != 0 || curY != 0) {
			date++;
			int nextX = curX + dx[d];
			int nextY = curY + dy[d];
			int sendDummy = sand[nextY][nextX];
			int remainSum = 0;
			int windSum = 0;
			for(int i = 0; i < 9; i++) {
				int goSandDx = nextX + sandDx[d][i];
				int goSandDy = nextY + sandDy[d][i];
				int value = (int) (sendDummy * rate[i]);
				if(!isBoundary(goSandDx, goSandDy)) {
					windSum += value;
					remainSum += value;
					continue;
				}
				remainSum += value;
				sand[goSandDy][goSandDx] += value;
			}
			sand[nextY][nextX] = 0;
			sandSum += windSum;

			int goSandDx = nextX + sandDx[d][9];
			int goSandDy = nextY + sandDy[d][9];
			if(!isBoundary(goSandDx, goSandDy)) {
				sandSum += sendDummy - remainSum;
			}else {
				sand[goSandDy][goSandDx] += sendDummy - remainSum;
			}
			moveCount++;
			if(moveCount == range) {
				moveCount = 0;
				count++;
				d = (d + 1) % 4;
			}
			if(count == 2) {
				count = 0;
				range++;
			}

			curX = nextX;
			curY = nextY;

		}
		System.out.println(sandSum);
	}
	static boolean isBoundary(int x, int y) {
		return 0<=x&&x<N&&0<=y&&y<N;
	}
	//토네이도가 한칸으로 이동할 때마다 모래가 일정한 비율로 날라감.
	//모래가 이미 있는 칸으로 모래가 이동하면, 모래양은 +만 됨.
	
	//격자밖으로 나간 모래의 양을 구하시오.
}
