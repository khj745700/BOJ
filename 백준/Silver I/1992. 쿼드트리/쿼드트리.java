import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class Main {
	static int N;
	static int[][] arr;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			String input = br.readLine();
			for(int j = 0 ; j < N; j++) {
				arr[i][j] = input.charAt(j)-'0';
			}
		}
		
		recursive(0,0, N);
		System.out.println(sb);
	}
	
	static void recursive(int startX, int startY, int distance) {
		if(distance == 1) {
			sb.append(arr[startY][startX]);
			return;
		}

		if(check(startX, startY, distance)) {
			sb.append(arr[startY][startX]);
		}
		else {
			sb.append('(');
			recursive(startX, startY, distance/2);
			recursive(startX + distance/2, startY, distance/2);
			recursive(startX, startY + distance/2, distance/2);
			recursive(startX+ distance/2, startY + distance/2, distance/2);
			sb.append(')');
		}

		
		return ;
	}
	
	
	static boolean check(int startX, int startY, int distance) {
		for(int i = startY; i < startY + distance; i++) {
			for(int j = startX; j < startX + distance; j++) {
				if(arr[startY][startX] != arr[i][j]) {
					return false;
				}
			}
		}
		return true;
	}
}
