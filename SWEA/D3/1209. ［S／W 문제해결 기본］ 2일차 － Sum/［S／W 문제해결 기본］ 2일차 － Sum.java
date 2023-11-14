import java.util.Scanner;

public class Solution {
	static int[][] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = 10;
		arr = new int[100][100];
		for(int test_case = 1; test_case <=T; test_case++) {
			sc.nextInt();
			for(int i = 0; i < 100; i++) {
				for(int j = 0; j < 100; j++) {
					arr[i][j] =sc.nextInt();
				}
			}
			
			int max = 0;
			for(int i = 0 ; i < 100; i++) {
				max = Math.max(max, sumRow(i));
				max = Math.max(max, sumCol(i));
			}
			max = Math.max(max, sumLeftDiagnal());
			max = Math.max(max, sumRightDiagnal());
			
			System.out.printf("#%d %d \n", test_case, max);
		}
	}
	
	
	
	static int sumRow(int i) {
		int sum = 0;
		for(int j = 0; j < 100; j++) {
			sum += arr[i][j];
		}
		
		return sum;
	}
	
	static int sumCol(int j) {
		int sum = 0;
		for(int i = 0; i < 100; i++) {
			sum += arr[i][j];
		}
		
		return sum;
	}
	
	static int sumLeftDiagnal() {
		int sum =0;
		for(int i = 0; i < 100; i++) {
			sum += arr[i][i];
		}
		
		return sum;
	}
	
	static int sumRightDiagnal() {
		int sum = 0;
		for(int i = 99; i >= 0; i--) {
			sum += arr[i][i];
		}
		
		return sum;
	}
			
}
