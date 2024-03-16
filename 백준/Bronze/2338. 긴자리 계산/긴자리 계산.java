import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        BigInteger i1 = new BigInteger(br.readLine());
        BigInteger i2 = new BigInteger(br.readLine());

        System.out.println(i1.add(i2));
        System.out.println(i1.add(i2.negate()));
        System.out.println(i1.multiply(i2));
    }
}
