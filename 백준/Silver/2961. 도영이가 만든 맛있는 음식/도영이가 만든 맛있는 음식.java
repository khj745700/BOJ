import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] food;
	static int MIN = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		food = new int[N][2];
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int sour = Integer.parseInt(st.nextToken());
			int fuxk = Integer.parseInt(st.nextToken());
			food[i][0] = sour;
			food[i][1] = fuxk;
		}
		
		
		for(int i = 1; i < (1 << N); i++) {
			int sour = 1;
			int fuxk = 0;
			for(int j = 0; j < N; j++) {
				if((i & (1 << j)) != 0) {
					sour *= food[j][0];
					fuxk += food[j][1];
				}
			}
			MIN = Math.min(Math.abs(sour-fuxk), MIN);
		}
		
		System.out.println(MIN);
	}
}