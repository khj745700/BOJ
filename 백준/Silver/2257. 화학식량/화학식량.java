import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for(int i = 0 ; i < input.length(); i++) {
            char c = input.charAt(i);

            if(c == ')') {
                int num = 0;
                while (true) {
                    if(stack.peekLast() == 0) {
                        stack.removeLast();
                        stack.addLast(num);
                        break;
                    }
                    num += stack.removeLast();
                }
            }
            else if(c == '(') {
                stack.addLast(0);
            }
            else if(c == 'C') {
                stack.addLast(12);
            }
            else if(c == 'H') {
                stack.addLast(1);
            }
            else if(c == 'O') {
                stack.addLast(16);
            }
            else if(Character.isDigit(c)) {
                stack.addLast(stack.removeLast() * (c - '0'));
            }
        }
        int answer = 0;
        while(!stack.isEmpty()) {
            answer += stack.removeLast();
        }
        System.out.println(answer);
    }
}