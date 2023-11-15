import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int ingredient;
	static int max_calorie;
	static int[][] ingredients;
	static int answer;
	static int stoi(String str) { return Integer.parseInt(str);}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = stoi(br.readLine());
		
		int test_case = 0;
		StringTokenizer st;
		while (++test_case <= T) {
			st = new StringTokenizer(br.readLine());
			ingredient = stoi(st.nextToken());
			max_calorie = stoi(st.nextToken());
			ingredients = new int[ingredient][2];
			answer = 0;
			for(int i = 0; i < ingredient; i++) {
				st = new StringTokenizer(br.readLine());
				ingredients[i][0] = stoi(st.nextToken());
				ingredients[i][1] = stoi(st.nextToken());
			}
			
			maxScore(0, 0, 0);
			
			System.out.printf("#%d %d \n", test_case, answer);
		}
	}
	
	
	static void maxScore(int score, int calorie, int start) {
		if(calorie > max_calorie) {
			return;
		}
		answer = Math.max(score, answer);
	
		
		for(int i = start; i < ingredient; i++) {
			int[] cur = ingredients[i];
			maxScore(score + cur[0], calorie + cur[1], i+1);
		}
	}
}