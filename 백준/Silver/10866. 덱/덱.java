import java.util.*;
import java.io.*;

public class Main{
    static int N;
    static Deque<Integer> deque = new LinkedList<>();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());

        while(N --> 0) {
            methods(br.readLine().split(" "));
        }

        bw.flush();
    }


    private static void methods(String[] command) throws IOException{
        if(command.length > 1) {
            Integer i = Integer.parseInt(command[1]);
            switch(command[0]) {
                case "push_back":
                    deque.addLast(i);
                    break;
                case "push_front":
                    deque.addFirst(i);
            }
        }

        else {
            Integer val = null;
            switch(command[0]){
                case "front":
                    val = deque.peekFirst();
                    break;
                case "back":
                    val = deque.peekLast();
                    break;
                case "empty":
                    val = deque.isEmpty() ? 1 : 0;
                    break;
                case "size":
                    val = deque.size();
                    break;
                case "pop_back":
                    val = deque.isEmpty() ? -1 : deque.pollLast();
                    break;
                case "pop_front":
                    val = deque.isEmpty() ? -1 : deque.pollFirst();
            }
            if(val == null) {
                val = -1;
            }
            bw.append(String.valueOf(val));
            bw.newLine();
        }

    }
}
