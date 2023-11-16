import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int K = sc.nextInt();

        int answer = 0;
        int remain = 0;
        if(N > M * 2) {
            answer = M;
            N -= M * 2;
            M -= M;
        }
        if(N < M * 2) {
            answer = N / 2;
            M -= N / 2;
            N -= N;
        }

        if (N == M *  2) {
            answer = N / 2;
            M = 0;
            N = 0;
        }
        remain = M + N - K;

        while(remain < 0) {
            remain += 3;
            answer --;
        }

        System.out.println(answer);
    }
}
