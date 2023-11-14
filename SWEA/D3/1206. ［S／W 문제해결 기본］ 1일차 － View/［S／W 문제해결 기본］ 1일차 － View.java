import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.Scanner;

public class Solution
{
    static int[] buildings = new int[1000];
    static int N;
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T = 10;
        StringTokenizer st;
        for(int test_case = 1; test_case <= T; test_case++)
        {
            N = sc.nextInt();
            for(int i = 0 ; i < N; i++) {
                buildings[i] = sc.nextInt();
            }
            System.out.printf("#%d %d \n", test_case, 조망권판단());
        }

    }


    private static int 조망권판단() {
        int count = 0;
        int cur = 0;
        for(int i = 2; i < N-2; i++) {
            cur = buildings[i];
            int max = 0;
            max = Math.max(max, buildings[i-2]);
            max = Math.max(max, buildings[i-1]);
            max = Math.max(max, buildings[i+1]);
            max = Math.max(max, buildings[i+2]);
            if(max < cur){
                count += cur - max;
            }
        }
        return count;
    }
}
