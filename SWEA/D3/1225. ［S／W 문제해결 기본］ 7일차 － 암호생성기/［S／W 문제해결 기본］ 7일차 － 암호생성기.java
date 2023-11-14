import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static Queue<Integer> arr;
	public static void main(String[] args) throws IOException{
		int T = 10;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(T --> 0) {
			int test_case = Integer.parseInt(br.readLine());
			arr = new ArrayDeque<>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0 ;i < 8; i++) {
				arr.add(Integer.parseInt(st.nextToken()));
			}
			int a = -1;
			int count = 0;
			while (a != 0) {
				a = arr.poll();
				a = a - ++count;
				if(count == 5) {
					count = 0;
				}
				if(a <= 0)
					a = 0;
				arr.add(a);
			}
			String str = "#" + test_case;
			for(Integer val : arr) {
				str += " " + val;
			}
		
			System.out.println(str);
		}
	}
}
