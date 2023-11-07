import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();
        List<String> prefixs = new ArrayList<>();

        for(int i = 0 ; i < str.length(); i++) {
            prefixs.add(str.substring(i));
        }

        Collections.sort(prefixs);

        for (String prefix : prefixs) {
            System.out.println(prefix);
        }
    }
}
