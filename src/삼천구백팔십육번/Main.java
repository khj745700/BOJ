package 삼천구백팔십육번;

import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int testCase = Integer.parseInt(br.readLine());
        int count = 0;
        for(int i = 0 ; i < testCase; i++){
            Stack<Character> stack = new Stack<>();

            char[] data = br.readLine().toCharArray();
            for(int j = 0 ; j < data.length; j++){
                if(stack.isEmpty()){
                    stack.add(data[j]);
                }
                else if(stack.peek() != data[j]){
                    stack.add(data[j]);
                }else if(stack.peek() == data[j]){
                    stack.pop();
                }
            }
            if(stack.isEmpty()){
               count++;
            }
        }
        bw.append(Integer.toString(count));
        bw.flush();
    }
}
