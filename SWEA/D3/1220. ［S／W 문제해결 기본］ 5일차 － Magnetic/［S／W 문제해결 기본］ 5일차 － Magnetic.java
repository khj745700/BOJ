import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	static int N;
	static int[][] arr;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = 0;
		while(T++ < 10) {
			N = Integer.parseInt(br.readLine());
			StringTokenizer st ;
			arr = new int[N][N];
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0 ; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int count = 0;
			for(int i = 0 ; i < N; i++) {
				
				List<Integer> list = new ArrayList<>();
				for(int j = 0; j < N; j++) {
					if(arr[j][i] == 0) {
						continue;
					}
					list.add(arr[j][i]);
				}
				
				for(int j = 0 ; j < list.size() - 1; j++) {
					if(list.get(j) == 1 && list.get(j + 1) == 2) {
						count++;
					}
				}
			}
			System.out.printf("#%d %d \n", T, count);
		}
	}
}
