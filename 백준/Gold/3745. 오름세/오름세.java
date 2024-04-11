import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String input = null;
		while((input = br.readLine())!=null) {
			int N = Integer.parseInt(input.trim());
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int[] arr = new int[N];
			
			for(int i = 0 ; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			int[] lis = new int[N];
			
			int length = 1;
			lis[0] = arr[0];
			for(int i = 1; i < N; i++) {
				int l = 0;
				int r = length;
				while(l < r) {
					int mid = (l + r) / 2;
					if(lis[mid] >= arr[i]) {
						r = mid;
					}else {
						l = mid + 1;
					}
				}
				
				if(lis[length - 1] < arr[i]) {
					length ++;
				}
				lis[l] = arr[i];
			}
			sb.append(length).append('\n');
		}
		System.out.println(sb);
	}
}