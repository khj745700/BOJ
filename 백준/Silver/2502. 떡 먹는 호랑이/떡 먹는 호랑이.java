import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Hello world!
 *
 */
public class Main {
	static int[] dp;
    public static void main( String[] args ) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	int N = Integer.parseInt(st.nextToken());
    	int target = Integer.parseInt(st.nextToken());
    	dp = new int[N + 1];
    	int l = 0;
    	int r = 0;
    	boolean flag = false;
    	for(int i = 1; i < 100000; i++) {
    		for(int j = i + 1; j < 100000; j++) {
    			dp[1] = i;
    			dp[2] = j;
    			for(int k = 3; k <= N; k++) {
    				dp[k] = dp[k-1] + dp[k-2];
    			}
    			if(dp[N] > target) {
    				break;
    			}
    			if(dp[N] == target) {
    				flag =true;
    				l = i;
    				r = j;
    			}
    		}
    		if(flag) {
    			break;
    		}
    	}
    	System.out.println(l);
    	System.out.println(r);
    }
}