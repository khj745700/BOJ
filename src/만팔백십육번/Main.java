package 만팔백십육번;


import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] arrN;
    static int M;
    static int[] arrM;

    static int lowerBound(int value) {
        int start = 0;
        int end = arrN.length - 1;

        while (start < end) {
            int mid = (start - end) / 2;

            if(arrN[mid] <= value) {
                end = mid;
            }else {
                start = mid + 1;
            }
        }
        return start;
    }

    static int upperBound(int value) {
        int start = 0;
        int end = arrN.length - 1;

        while (start < end) {
            int mid = (start - end) / 2;

            if(arrN[mid] >= value) {
                start = mid;
            }else {
                end = mid + 1;
            }
        }
        return start;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        N = Integer.parseInt(br.readLine());
        arrN = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N; i++){
            arrN[i] = Integer.parseInt(st.nextToken());
        }

        M = Integer.parseInt(br.readLine());
        arrM = new int[M];
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < M; i++) {
            arrM[i] = Integer.parseInt(st.nextToken());
        }


    }
}
