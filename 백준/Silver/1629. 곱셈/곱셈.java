import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static long A;
	static long B;
	static long C;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		long ans = compute(A, B);
		System.out.println(ans);
	}
	
	static long compute(long a, long b) {
		long d = 1;
		
		if(b == 1) {
			return a % C;
		}
		
		long temp = compute(a, b/2);
		
		if(b % 2 == 1) {
			d *= a % C;
		}
		
		return (temp * temp % C) * d % C;
	}
}