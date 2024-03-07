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
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> minQ = new PriorityQueue<>();
		
		for(int i = 0; i < N; i++) {
			minQ.add(Integer.parseInt(br.readLine()));
		}
		int sum = 0;
		
		
		while(minQ.size() != 1) {
			int first = minQ.poll();
			int second = minQ.poll();
			
			sum += first + second;
			minQ.add(first+second);
		}
		
		System.out.println(sum);
	}
	
}
