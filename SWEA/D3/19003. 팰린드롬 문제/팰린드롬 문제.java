import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	static int N;
	static int M;
	static List<String> palindrome;
	static List<String> notPalindrome;
	static int max;
	static int count;
	public static int stoi(String str) { return Integer.parseInt(str); } 
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = stoi(br.readLine());
		StringTokenizer st;
		
		for(int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			N = stoi(st.nextToken());
			M = stoi(st.nextToken());
			max = 0;
			count = 0;
			palindrome = new ArrayList<>();
			notPalindrome = new ArrayList<>();
			for(int i = 0 ; i < N; i++) {
				String input = br.readLine();
				
				if(isPalindrome(input)) {
					palindrome.add(input);
				}else  {
					notPalindrome.add(input);
				}
			}
			StringBuilder sb;
			while(!notPalindrome.isEmpty()) {
				sb = new StringBuilder(notPalindrome.get(0));
				sb.reverse();
				if(notPalindrome.contains(sb.toString())) {
					count += 2;
				}
				notPalindrome.remove(0);
			}
			
			
			if(palindrome.size() > 0) {
				max += M;
			}
			max += count * M;
			
			System.out.printf("#%d %d \n", test_case, max);
		}
	}
	
	
	static boolean isPalindrome(String str) {
		for(int i =  0 ; i < str.length() / 2; i++) {
			if(str.charAt(i) != str.charAt(str.length() - i - 1)) {
				return false;
			}
		}
		return true;
	}
	
}
