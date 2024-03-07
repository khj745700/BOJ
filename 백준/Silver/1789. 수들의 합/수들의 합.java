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
	static long N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Long.parseLong(br.readLine());
		long sum = 0;
		int i;
		for(i = 1; ;i++) {
			sum += i;
			if(sum >= N) {
				break;
			}
		}
		
		System.out.println(sum == N ? i : i-1);
	}
	
}
