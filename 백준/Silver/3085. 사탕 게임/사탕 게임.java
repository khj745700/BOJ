import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



public class Main {
	static char[][] candies;
	static int N;
	static int max;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		candies = new char[N][N];
		
		for(int i = 0 ; i < N; i ++) {
			candies[i] = br.readLine().toCharArray();
		}
		
		for(int i = 0 ; i < N; i++) {
			for(int j = 0 ; j < N; j++) {
				if(i + 1 < N) {
					// 아래 위로 변환
					swap(i,j, i+1, j);
					findMax();
					swap(i,j, i+1, j);
				}
				if(j + 1 < N) {
					//오른쪽 한칸과 변환
					swap(i,j, i, j + 1);
					findMax();
					swap(i,j, i, j + 1);
				}

			}
		}
		System.out.println(max);
	}
	
	
	static void findMax() {
		for(int i = 0 ; i < N; i++) {
			
			//오른쪽으로 이동하면서 갯수 검사
			char c = candies[i][0];
			int sum = 0;
			for(int j = 0 ; j < N; j++) {
				if(c != candies[i][j]) {
					c = candies[i][j];
					max = Math.max(max, sum);
					sum = 1;
				}else {
					sum++;
				}
			}
			
			//아래로 이동하면서 갯수 검사
			max = Math.max(max, sum);
			sum = 0;
			c = candies[0][i];
			for(int j = 0 ; j < N; j++) {
				if(c != candies[j][i]) {
					c = candies[j][i];
					max = Math.max(max, sum);
					sum = 1;
				}else {
					sum++;
				}
			}
			max = Math.max(max, sum);
		}
	}
	
	static void swap(int i1, int j1, int i2, int j2) {
		char c = candies[i1][j1];
		candies[i1][j1] = candies[i2][j2];
		candies[i2][j2] = c;
	}
	
}