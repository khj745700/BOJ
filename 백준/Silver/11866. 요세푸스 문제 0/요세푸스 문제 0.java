import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;
 
public class Main {
	static int N, K;
	static List<Integer> list;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		list = new LinkedList<>();
		
		for(int i = 1; i <= N; i++) {
			list.add(i);
		}
		
		sb.append('<');
		int i = K - 1;
		while(!list.isEmpty()) {
			sb.append(list.remove(i));
			i += K - 1;
			if(!list.isEmpty()) {
				sb.append(',').append(' ');
			}else {
				break;
			}
			i = i % list.size();
		}
		sb.append('>');
		System.out.println(sb);
	}
}
