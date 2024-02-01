
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
public class Main {
	static int N;
	static int M;
	static int[] arr;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[M];
		rec(0);
		bw.flush();
	}
	
	static void rec(int n) throws IOException {
		if(n == M) {
			for(int val : arr) {
				bw.append(Integer.toString(val)).append(" ");
			}
			bw.newLine();
			return;
		}
		for(int i = 1; i <= N; i++) {
			arr[n] = i;
			rec(n + 1);
		}
	
	}
}
