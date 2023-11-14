import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	static int[][] arr;
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		String rowInput;
		for(int test_case = 1; test_case <=T; test_case++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N][N];
			for(int i = 0; i < N; i++) {
				rowInput = br.readLine();
				for(int j = 0 ; j < N; j++) {
					arr[i][j] = rowInput.charAt(j) - '0';
				}
			}
			int answer = 0;
			int start = N/2;
			int end = N/2;
			for(int i = 0 ; i < N; i++) {
				for(int j = start; j <= end; j++) {
					answer += arr[i][j];
				}
				if(i < N/2) {
					start -= 1;
					end += 1;
				}else {
					start += 1;
					end -= 1;
				}
			}
			
			System.out.printf("#%d %d \n", test_case, answer);
		}
	}
	

}
