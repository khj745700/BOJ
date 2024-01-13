import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static String[] files;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(br.readLine());
        files = new String[size];

        for(int i = 0 ; i < size; i++) {
            files[i] = br.readLine();
        }

        System.out.println(dirPatterBuilder());
    }

    static String dirPatterBuilder() {
        StringBuilder sb = new StringBuilder();

        char target;
        boolean flag = false;
        for(int i = 0; i < files[0].length(); i++) {
            target = files[0].charAt(i);
            flag = false;
            for (int j = 0; j < files.length; j++) {
                if(target != files[j].charAt(i)) {
                    sb.append("?");
                    flag = true;
                    break;
                }
            }
            if(!flag) {
                sb.append(target);
            }
        }

        return sb.toString();
    }
}
