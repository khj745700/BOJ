import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] val = br.readLine().split("/");

        int k = Integer.parseInt(val[0]);
        int d = Integer.parseInt(val[1]);
        int a = Integer.parseInt(val[2]);

        if(k + a < d || d == 0)
            System.out.println("hasu");
        else {
            System.out.println("gosu");
        }
    }
}
