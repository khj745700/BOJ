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
		PriorityQueue<Integer> maxQ = new PriorityQueue<>((i1, i2) -> i2 - i1);
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < N; i++) {
			minQ.add(Integer.parseInt(st.nextToken()));
		}
	
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < N; i++) {
			maxQ.add(Integer.parseInt(st.nextToken()));
		}
		
		int sum = 0;
		
		while(!minQ.isEmpty()) {
			int minVal = minQ.poll();
			int maxVal = maxQ.poll();
			
			sum += minVal * maxVal;
		}
		
		System.out.println(sum);
	}
	
}
