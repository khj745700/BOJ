import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
 
public class Main {
	static int[] set;
	static int N, M;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		set = new int[N];
		for(int i = 0; i < N; i++) {
			set[i] = i;
		}
		int answer = 0;
		for(int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			int val1 = Integer.parseInt(st.nextToken());
			int val2 = Integer.parseInt(st.nextToken());
			
			if(unionSet(val1, val2)) {
				answer = i;
				break;
			}
		}
		System.out.println(answer);
	}

	
	static int unionFind(int v) {
		if(set[v] == v) {
			return v;
		}
		return set[v] = unionFind(set[v]);
	}
	
	static boolean unionSet(int a, int b) {
		int a1 = unionFind(a);
		int b1 = unionFind(b);
		
		if(a1 == b1) {
			return true;
		}
		
		set[a1] = b1;
		return false;
	}
}
