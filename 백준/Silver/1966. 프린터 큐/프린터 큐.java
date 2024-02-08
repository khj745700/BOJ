import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;
 
public class Main {
	static int N, M;
	static List<int[]> q;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		
		int T = Integer.parseInt(br.readLine());
		while(T --> 0) {
			q = new LinkedList<>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0;  i < N; i++) {
				q.add(new int[] {i, Integer.parseInt(st.nextToken())});
			}
			
			int count = 0;
			while(!q.isEmpty()) {
				int[] cur = q.remove(0);
				
				boolean isMax = true;
				for(int i = 0; i < q.size(); i++) {
					if(q.get(i)[1] > cur[1]) {
						isMax = false;
						q.add(cur);
						break;
					}
				}
				if(isMax)
					count++;
				if(isMax && cur[0] == M) {
					System.out.println(count);
					break;
				}
			}
		}
	}
}
