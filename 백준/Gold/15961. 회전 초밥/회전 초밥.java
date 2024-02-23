import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	static int N, D , K , C;
	static int[] arr;
	static int[] bucket;
	static int count;
	static int MAX = Integer.MIN_VALUE;
	static boolean isExist;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		bucket = new int[D+1];
		
		arr = new int[N];
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			if(arr[i] == C) {
				isExist = true;
			}
		}
		
		for(int i = 0; i < K; i++) {
			bucket[arr[i]]++;
			if(bucket[arr[i]] == 1) {
				count++;
			}
 		}
		int before = 0;
		int after = K-1;
		for(int i = 0; i < N; i++) {
			if(bucket[C] == 0 ) {
				MAX = Math.max(count + 1, MAX);
			}else {
				MAX = Math.max(count, MAX);
			}
			int beforeVal = arr[before++];
			int afterVal = arr[after = (after + 1) % N];
			if(--bucket[beforeVal] == 0) {
				count --;
			}
			if(++bucket[afterVal] == 1) {
				count++;
			}
		}
		
		System.out.println(MAX);
	}
	
}