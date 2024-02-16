import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
 
public class Main {
	static int N, M;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int l = 0;
		int r = 0;
		int sum = 0;
		int min = Integer.MAX_VALUE;
		while(l != N) {
			while(sum < M) {
				if(r < N) {
					sum += arr[r++];
				}else {
					break;
				}
			}
			
			if(sum >= M) {
				min = Math.min(r-l, min);
			}
			sum -= arr[l++];
		}
		System.out.println(min == Integer.MAX_VALUE ? 0 : min);
	}
}
