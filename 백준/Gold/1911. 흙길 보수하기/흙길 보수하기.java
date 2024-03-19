import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N, L;
	static List<Node> list;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());

		list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			list.add(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}

		list.sort(null);
		
		int remainIdx = 0;
		int count = 0;
		for(int i = 0 ; i < list.size(); i++) {
			Node now = list.get(i);
			if(now.s <= remainIdx) {
				now.s = remainIdx + 1;
			}
			
			int distance = now.e - now.s;
			
			if(distance <= 0) {
				continue;
				
			}
			int val = (int)Math.ceil(distance/(double)L);
			count += val;
			remainIdx = now.s + val * L - 1;
		}
		
		System.out.println(count);
	}

	
	
	static class Node implements Comparable<Node> {
		int s;
		int e;

		Node(int a, int b) {
			s = a;
			e = b;
		}

		public int compareTo(Node e) {
			return s - e.s;
		}
	}
}
