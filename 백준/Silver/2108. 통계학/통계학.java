import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;
 
public class Main {
	static int N, M;
	static int[] arr;
	static int[] count;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		arr = new int[N];
		count = new int[8001];
		int sum = 0;
		int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			count[arr[i] + 4000]++;
			sum += arr[i];
			min = Math.min(arr[i], min);
			max = Math.max(arr[i], max);
		}
		//산술 평균 ( sum / N )
		sb.append((int)Math.round((double)sum/N));
		sb.append('\n');
		//중앙값 (정렬 후 arr[N/2]
		Arrays.sort(arr);
		sb.append(arr[N/2]);
		sb.append('\n');
		//최빈값 ( 카운팅 정렬 후 max count 위치의 인덱스 return, 여러 개 있을 때에는 최빈값 중 두 번째로 작은 값을 출력 )
		int maxCount = 0;
		int maxVal = 0;
		//찾고 나서, 두번째 값 조회
		for(int i = 0; i < 8001; i++) {
			if(maxCount < count[i]) {
				maxVal = i - 4000;
				maxCount = count[i];
			}
		}
		
		boolean flag = false;
		for(int i = 0; i < 8001; i++) {
			if(flag && maxCount == count[i]) {
				maxVal = i - 4000;
				break;
			}	
			if(!flag && maxCount == count[i]) {
				flag = true;
			}
		}
		
		sb.append(maxVal);
		sb.append('\n');
		
		//범위 N개의 수들 중 최댓값과 최솟값 차이
		sb.append(max - min);
		System.out.println(sb);
	}
}
