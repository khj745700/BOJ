import java.util.*;

public class Main{
    static int[][] arr = new int[9][9];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringTokenizer st;
        int max = Integer.MIN_VALUE;
        int y = -1;
        int x = -1;
        for(int i = 0; i < 9; i++) {
            st = new StringTokenizer(sc.nextLine());
            for(int j = 0; j < 9; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (max < arr[i][j]) {
                    x = j+1;
                    y = i+1;
                    max = arr[i][j];
                }
            }
        }

        System.out.println(max);
        System.out.println(y+" "+x);
    }
}
