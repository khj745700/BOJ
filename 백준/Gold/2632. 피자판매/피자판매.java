import java.io.*;

import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int target;
    static int n, m;
    static int[] left;
    static int[] right;
    static int[] leftPrefixSum;
    static int[] rightPrefixSum;


    static void setPrefixSum(int[] arr, int[] sums) {
        for(int i = 0; i < arr.length; i++) {
            int sum = 0;
            for(int j = 1; j < arr.length; j++) {
                int val = arr[(i + j) % arr.length];
                if(sum + val > target) {
                    break;
                }
                sum += val;
                sums[sum]++;
            }
        }

    }
    static int solution() {
        int result = 0;
        for(int i = 0 ; i <= target; i++) {
            result += (leftPrefixSum[i] * rightPrefixSum[target - i]);
        }
        return result;
    }

    static void init(BufferedReader br) throws IOException {
        left = new int[n];
        right = new int[n];

        input(br);
        int leftMax = Arrays.stream(left).sum();
        int rightMax = Arrays.stream(right).sum();
        leftPrefixSum = new int[Math.max(leftMax, target) + 1];
        leftPrefixSum[0] = 1;
        leftPrefixSum[leftMax] = 1;
        rightPrefixSum = new int[Math.max(rightMax, target) + 1];
        rightPrefixSum[0] = 1;
        rightPrefixSum[rightMax] = 1;
        setPrefixSum(left, leftPrefixSum);
        setPrefixSum(right, rightPrefixSum);

    }

    static void input(BufferedReader br) throws IOException {
        target = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        left = new int[n];
        right = new int[m];

        for(int i = 0 ; i < n ; i++){
            left[i] = Integer.parseInt(br.readLine());
        }
        for(int i = 0 ; i < m ; i++){
            right[i] = Integer.parseInt(br.readLine());
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader( System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        init(br);
        int val = solution();

        System.out.println(val);
    }


}