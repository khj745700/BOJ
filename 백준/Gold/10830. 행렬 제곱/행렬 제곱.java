
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static long A, B;
	static int[][] arr;
	
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		B = Long.parseLong(st.nextToken());
		
		arr = new int[(int)A][(int)A];
		
		for(int i = 0; i < A; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < A; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken()) % 1000;
			}
		}
		
		int[][] ans = pow(B);
		for(int i = 0; i < A; i++) {
			for(int j = 0 ; j < A; j++) {
				bw.append(Integer.toString(ans[i][j])).append(" ");
			}
			bw.newLine();
		}
		
		bw.flush();
	}
	
	
	static int[][] pow(long b) {
		if(b == 1) {
			return arr;
		}
		
		int[][] temp = pow(b/2);
		
		temp = multiple(temp, temp);
		if(b % 2 == 1) {
			temp = multiple(temp, arr);
		}
		
		return temp;
	}
	
	static int[][] multiple(int[][] mat1, int[][] mat2) {
		int[][] temp = new int[(int)A][(int)A];
		for(int i = 0; i < A; i++) {
			for(int j = 0; j < A; j++) {
				for(int k = 0 ; k < A; k++) {
					temp[i][j] += (mat1[i][k] * mat2[k][j]) % 1000;
				}
				temp[i][j] %= 1000;
			}
		}
		return temp;
		
	}
}
