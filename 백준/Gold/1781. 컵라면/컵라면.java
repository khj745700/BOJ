import java.io.*;

import java.util.*;

public class Main {
    static int N;
    static List<Cupramen> cupramens;

    static int solution() {
        PriorityQueue<Cupramen> pq = new PriorityQueue<>(cupramens);

        int sum = 0;

        PriorityQueue<Integer> select = new PriorityQueue<>();
        while(!pq.isEmpty()) {
            Cupramen c = pq.poll();
            if(select.size() < c.deadLine) {
                select.add(c.count);
            }else {
                if(select.peek() < c.count) {
                    select.poll();
                    select.add(c.count);
                }
            }
        }
        while(!select.isEmpty()) {
            sum += select.poll();
        }
        return sum;
    }

    static void input(BufferedReader br) throws IOException {
        N = Integer.parseInt(br.readLine());

        cupramens = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int deadLine = Integer.parseInt(st.nextToken());
            int count = Integer.parseInt(st.nextToken());
            cupramens.add(new Cupramen(deadLine, count));
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader( System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input(br);
        System.out.println(solution());
    }


    static class Cupramen implements Comparable<Cupramen> {
        int deadLine;
        int count;

        Cupramen(int deadLine, int count) {
            this.deadLine = deadLine;
            this.count = count;
        }

        @Override
        public int compareTo(Cupramen o) {
            if(deadLine != o.deadLine) {
                return deadLine - o.deadLine;
            }
            return o.count - count;
        }
    }
}