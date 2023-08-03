package 만팔백십사번;
import java.util.*;
import java.io.*;

class Member implements Comparable<Member>{
    String username;
    int old;

    public int compareTo(Member m) {
        if(old > m.old){
            return 1;
        }else if(old == m.old){
            return 0;
        }else {
            return -1;
        }
    }

    public String toString() {
        return old + " " + username;
    }
}

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCase = Integer.parseInt(br.readLine());
        List<Member> list = new ArrayList<>();

        for(int i = 0; i < testCase; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            Member member = new Member();
            member.old = Integer.parseInt(st.nextToken());
            member.username = st.nextToken();
            list.add(member);
        }

        Collections.sort(list);

        list.stream().forEach(System.out::println);
    }
}
