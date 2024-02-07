import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Main {
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		int twoCount = 0;
		int fiveCount = 0;
		
		for(int i = 1; i <= N; i++) {
			int val = i;
			while(val % 2 == 0) {
				twoCount ++;
				val /= 2;
			}
			
			val = i;
			while(val % 5 == 0) {
				fiveCount ++;
				val /= 5;
			}
		}
		System.out.println(Math.min(twoCount, fiveCount));
	}

}
