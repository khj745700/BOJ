import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		boolean flag = np();
		if(flag) {
			for(int i : arr) {
				sb.append(i);
				sb.append(' ');
			}
		}else {
			sb.append(-1);
		}
		System.out.println(sb);
	}
	
	
	
	
	
	static boolean np() {
		//find top;
		int i = N-1;
		while(i > 0 && arr[i] > arr[i-1]) i--;
		
		if(i == 0) {
			return false;
		}
		
		// find top까지 i-1 보다 큰 가장 최솟값.
		int K = N-1;
		while(arr[K]>arr[i-1]) K--;
		swap(i-1,K);
		
		
		int j = N-1;
		while(i < j) swap(i++, j--);
		
		return true;
	}
	
	
	static void swap(int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
