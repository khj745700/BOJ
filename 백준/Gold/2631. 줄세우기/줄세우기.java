import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		int[] lisArr = new int[N];
		int lis = 1;
		lisArr[0] = arr[0];
		for (int i = 1; i < N; i++) {
			int l = 0;
			int r = lis;
			while (l < r) {
				int mid = (l + r) / 2;
				if (arr[i] < lisArr[mid]) {
					r = mid;
				} else {
					l = mid + 1;
				}
			}

			if (lisArr[lis-1] < arr[i]) {
				lis++;
			}
			lisArr[l] = arr[i];
			
		}
		System.out.println(N - lis);
	}
}