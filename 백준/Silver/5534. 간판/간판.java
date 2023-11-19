
import java.io.*;

public class Main {
    public static boolean method(char[] data, String target){
        boolean result = false;
        String temp = new String(data);
        result = temp.contains(target);
        if(result == true){
            return true;
        }
        for(int i = 0 ; i < data.length; i++){
            for(int j = 2; j < data.length; j++){
                result = method(data, target, j,i);
                if(result == true) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean method(char[] data, String target, int space, int start){
        boolean result = false;
        StringBuilder sb = new StringBuilder();
        for(int i = start; i<data.length; i+=space){
            sb.append(data[i]);
        }
        result = sb.toString().contains(target);
        return result;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int loop = Integer.parseInt(br.readLine());
        String target = br.readLine();
        int count = 0;
        for(int i = 0 ; i < loop; i++){
            char[] data = br.readLine().toCharArray();
            if(method(data, target)){
                count++;
            }
        }
        bw.append(Integer.toString(count));
        bw.flush();
    }
}
