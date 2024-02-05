import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[] arr;
	static int[] answer;
	static long MIN = Long.MAX_VALUE;
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	N = Integer.parseInt(br.readLine());
    	
    	arr = new int[N];
    	
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	for(int i = 0; i < N; i++) {
    		arr[i] = Integer.parseInt(st.nextToken());
    	}
    	
    	Arrays.sort(arr);
    	
    	for(int i = 0; i < N; i++) {
    		for(int j = N-1; j > i; j--) {
    			BinarySearch(i, j);
    		}
    	}
    	
    	Arrays.sort(answer);
    	System.out.println(answer[0] + " " + answer[1] + " " + answer[2]);
    }
    
    
    static void BinarySearch(int start, int end) {
    	int r = end - 1;
    	int l = start + 1;
    	
    	while(l <= r) {
    		int mid = (l + r) / 2;
    		long val = Math.abs((long)arr[start] + arr[mid] + arr[end]);
    		if(val < MIN) {
    			MIN = val;
    			answer = new int[]{arr[start], arr[mid], arr[end]};
    		}
    		if(arr[mid] > -(arr[start] + arr[end])) {
    			r = mid - 1;
    		}else {
    			l = mid + 1;
    		}
    	}
    }
}