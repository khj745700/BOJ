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
	static long N, M, S;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		PriorityQueue<Exam> pq = new PriorityQueue<>();
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			pq.add(new Exam(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		
		int before = 0;
		int answer = -1;
		while(!pq.isEmpty()) {
			if(before + M <= pq.peek().start) {
				answer = before;
				break;
			}
			before = pq.poll().end;
		}
		
		if(pq.isEmpty() && before + M <= S) {
			answer = before;
		}
		System.out.println(answer);
	}
	
	static class Exam implements Comparable<Exam> {
		int start;
		int end;
		Exam(int s, int e) {
			start = s;
			end = e + s;
		}
		
		public int compareTo(Exam e) {
			return end - e.end;
		}
	}
}