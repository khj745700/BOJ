import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] arr;
    static int min = Integer.MAX_VALUE;
    static int[] answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        answer = new int[2];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }


        for(int i = 0; i < N - 1; i++) {
            binarySearch(i);
        }

        Arrays.sort(answer);
        System.out.println(answer[0] + " " + answer[1]);
    }

    //음수쪽에서 판단 Limit x-->0-
    static void binarySearch(int start) {
        int r = N - 1;
        int l = start + 1;
        while(l <= r) {
            int mid = (l + r) / 2;
            int val = Math.abs(arr[start] + arr[mid]);
            if(arr[start] + arr[mid] == 0) {
                answer[0] = arr[start];
                answer[1] = arr[mid];
                break;
            }
            if(val < min ) {
                answer[0] = arr[start];
                answer[1] = arr[mid];
                min = val;
            }
            if(arr[mid] >= -arr[start]) {
                r = mid - 1;
            }else {
                l = mid + 1;
            }
        }
    }
}
