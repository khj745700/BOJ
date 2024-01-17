import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
 
public class Main {
	static int[] arr;
	static int K;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		do {
			StringTokenizer st = new StringTokenizer(br.readLine());
			K = Integer.parseInt(st.nextToken());
			if(K == 0) {
				return;
			}
			arr = new int[K];
			
			for(int i = 0 ; i < K; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			backtracking(0,0,new ArrayList<>());
			bw.flush();
			bw.newLine();
		}while(true);
	}
	
	
	
	static void backtracking(int start, int depth, List<Integer> list) throws IOException {
		if(depth == 6) {
			for(int i = 0 ; i < list.size(); i++) {
				bw.append(list.get(i).toString()).append(" ");
			}
			bw.newLine();
			return;
		}
		
		for(int i = start; i < K; i++) {
			list.add(arr[i]);
			backtracking(i+1, depth+1, list);
			list.remove(list.size() -1);
		}
	}
}
