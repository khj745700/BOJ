import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Main {
	static int N;
	static boolean[] aerathos;
	static Queue<Integer> sums;
	static int answer;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		aerathos = new boolean[N + 3];
		sums = new ArrayDeque<>();
		setAerathos();
		twoPointer();
		System.out.println(answer);
	}
	
	
	static void twoPointer() {
		int sum = 0;
		int l = 0;
		int r = 0;
		
		while(l <= r) {
			while(sum < N) {
				if(r > N) {
					break;
				}
				if(aerathos[r]) {
					sum += r;
					sums.add(r);

				}
				r++;

			}
			if(sum == N) {
				answer++;
			}

			if(!sums.isEmpty()) {
				sum -= sums.poll();
			}else {
				break;
			}
			l++;
		}
	}
	
	
	static void setAerathos() {
		Arrays.fill(aerathos, true);
		aerathos[0] = false;
		aerathos[1] = false;
		aerathos[2] = true;
		for(int i = 2 ; i <= Math.sqrt(N); i++) {
			if(aerathos[i]) {
				for(int j = i + i; j <= N; j+=i) {
					aerathos[j] = false;
				}
			}
		}
	}
}
