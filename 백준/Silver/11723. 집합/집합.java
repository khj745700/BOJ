import java.io.*;
import java.util.*;

public class Main {
    static int T;
    static Set<Integer> hashSet = new HashSet<>();
    static Integer stoi(String str) {return Integer.parseInt(str);}
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        T = Integer.parseInt(br.readLine());
        String[] inputs;
        while(T --> 0) {
            inputs = br.readLine().split(" ");

            if(inputs[0].equals("all")) {
                hashSet.clear();
                for(int i = 1; i <= 20; i++) {
                    hashSet.add(i);
                }
                continue;
            }

            if(inputs[0].equals("remove")) {
                hashSet.remove(stoi(inputs[1]));
            }

            if(inputs[0].equals("add")) {
                hashSet.add(stoi(inputs[1]));
                continue;
            }

            if(inputs[0].equals("check")) {
                if(hashSet.contains(stoi(inputs[1]))) {
                    bw.append("1");
                }else {
                    bw.append("0");
                }
                bw.newLine();
                continue;
            }

            if(inputs[0].equals("toggle")) {
                if(hashSet.contains(stoi(inputs[1]))) {
                    hashSet.remove(stoi(inputs[1]));
                }else {
                    hashSet.add(stoi(inputs[1]));
                }
                continue;
            }

            if(inputs[0].equals("empty")){
                hashSet.clear();

            }
        }
        bw.flush();
    }
}
