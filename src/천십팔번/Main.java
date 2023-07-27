package 천십팔번;

import java.io.*;

public class Main {

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int width, height = 0;

        char[][] inputs;

        try {
            String[] sizes = br.readLine().split(" ");
            width = Integer.parseInt(sizes[0]);
            height = Integer.parseInt(sizes[1]);

            inputs = new char[height][];

            for(int i = 0; i < height; i++){
                inputs[i] = br.readLine().toCharArray();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
