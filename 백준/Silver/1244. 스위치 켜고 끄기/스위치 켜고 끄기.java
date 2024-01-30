
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {	
	static int N;
	static boolean[] switches;
	static int people;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		switches = new boolean[N+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++) {
			switches[i] = st.nextToken().equals("1") ? true : false;
		}
		
		people = Integer.parseInt(br.readLine());
		for(int i = 0; i < people; i++) {
			st = new StringTokenizer(br.readLine());
			int sort = Integer.parseInt(st.nextToken());
			int idx = Integer.parseInt(st.nextToken());
			switch(sort) {
			case 1: 
				manAction(idx);
				break;
			case 2:
				womanAction(idx);
				break;
			}
		}
		
		for(int i = 1 ; i < switches.length; i++ ) {
			System.out.printf("%d ", switches[i] ? 1 : 0);
			if(i % 20 == 0) {
				System.out.println();
			}
		}
	}
	
	
	static void manAction(int start) {
		int idx = start;
		while(start < switches.length) {
			switches[start] = !switches[start];
			start += idx;
		}
	}
	
	static void womanAction(int start) {
		switches[start] = !switches[start];
		for(int i = 1; i < switches.length/2; i++) {
			if(!isBoundary(start -i) || !isBoundary(start + i)) {
				break;
			}
			
			if(switches[start - i] != switches[start + i])
				break;
			
			switches[start - i] = !switches[start - i];
			switches[start + i] = !switches[start + i];
		}
	}
	
	
	static boolean isBoundary(int x) {
		return 1 <= x && x < switches.length;
	}
}