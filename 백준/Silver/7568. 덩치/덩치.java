import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Main {
	static int N;
	static int[][] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		arr = new int[N][2];
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			arr[i][0] = w;
			arr[i][1] = t;
		}
		
		for(int i = 0 ; i < N; i++) {
			int rank = 1;
			for(int j = 0 ; j < N; j++) {
				if(i == j) {
					continue;
				}
				
				if(arr[i][0] < arr[j][0] && arr[i][1] < arr[j][1]) {
					rank++;
				}
			}
			
			sb.append(rank).append(' ');
		}
		
		System.out.println(sb);
	}

}
