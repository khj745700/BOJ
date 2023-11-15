import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	static char[] chars;
	static char[] findChars;
	static int count;
	static int stoi(String str) { return Integer.parseInt(str);}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = 0;
		while( ++T <= 10) {
			int test_case = stoi(br.readLine());
			findChars = br.readLine().toCharArray();
			chars = br.readLine().toCharArray();
			count = 0;
			for(int i = 0; i < chars.length - findChars.length + 1; i++) {
				if(chars[i] == findChars[0]) {
					boolean isWord = true;
					for(int j = i; j < i + findChars.length; j++) {
						if(chars[j] != findChars[j-i]) {
							isWord = false;
						}
					}
					if(isWord) {
						count++;
					}
				}
			}
			
			System.out.printf("#%d %d \n", test_case, count);
		}
	}
}