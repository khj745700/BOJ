import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] lis = new int[N+1];
        Arrays.fill(lis, Integer.MIN_VALUE);
        int[] tracking = new int[N + 1];
        lis[0] = arr[0];
        int length = 1;
        int maxIdx = 0;
        for(int i = 1; i < N; i++) {
            int l = 0;
            int r = length;
            int cur = arr[i];
            while(l < r) {
                int mid = (l + r) >>> 1;
                if (lis[mid] < cur) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }
            if(lis[length-1] < cur) {
                length++;
            }
            lis[l] = cur;
            tracking[i] = l;
            maxIdx = Math.max(maxIdx, l);
        }
        StringBuilder sb = new StringBuilder();
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        for(int i = N-1 ; i >= 0; i--) {
            if(maxIdx == tracking[i]) {
                deque.add(arr[i]);
                maxIdx--;
            }
            if(maxIdx == -1) {
                break;
            }
        }
        sb.append(deque.size()).append('\n');
        for(int i = deque.size(); i >= 1; i--) {
            sb.append(deque.pollLast()).append(' ');
        }
        System.out.println(sb);
    }
}
