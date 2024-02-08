import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
 
public class Main {
	static int N, M;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr);
		int val = (int) Math.round(N * 0.15);
		
		int[] ans = Arrays.copyOfRange(arr, val, N - val);
		
		int sum = 0;
		for(int i : ans) {
			sum += i;
		}

		System.out.println(Math.round((double)sum/(N - 2 * val)));
	}
}
