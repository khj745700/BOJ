import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(br.readLine());
        arr = new int[size];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < size; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        
        long sum = 0;
        long answer = 0;
        for(int i = 0; i < size; i++) {
            sum += arr[i];
            answer += sum;
        }
        System.out.println(answer);
    }

}
