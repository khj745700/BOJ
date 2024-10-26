import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Node implements Comparable<Node>{
        int x;
        int y;
        int step;

        public Node(int x, int y, int step){
            this.x = x;
            this.y = y;
            this.step = step;
        }

        public int compareTo(Node o){
            if(this.step != o.step){
                return this.step - o.step;
            }
            if(this.y == o.y){
                return this.x - o.x;
            }

            return this.y - o.y;
        }
    }

    static int n, t;
    static List<Integer>[] list;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

        list = new List[t+1];

        for(int i=0;i<list.length;i++){
            list[i] = new ArrayList<>();
        }

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[b].add(a);
        }

//        for(int i=0;i<list.length;i++){
//            System.out.println(list[i]);
//        }

        for(int i=0;i<list.length;i++){
            Collections.sort(list[i]);
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0, 0, 0));
        int answer = -1;


        List<Integer> visitedList;
        while(!queue.isEmpty()){
            Node currentNode = queue.poll();
            int x = currentNode.x;
            int y = currentNode.y;
//            System.out.println("=======================");
//            System.out.println("x = " + x + " y = " + y);

            if(y == t){
//                System.out.println(currentNode.step);
                answer = currentNode.step;
                break;
            }

            //y축 기준으로 찾기
            for(int i=y-2;i<=y+2;i++){
                if(i < 0 || i > t) {
//                    System.out.println("continue");
                    continue;
                }

//                System.out.println("y 값 = " + i);
                visitedList = new ArrayList<>();
                for(int j=0;j<list[i].size();j++){
                    if(list[i].get(j) < x-2 || list[i].get(j) > x+2) continue;

                    visitedList.add(list[i].get(j));
                    queue.add(new Node(list[i].get(j), i, currentNode.step + 1));
                }

                for(Integer j : visitedList){
                    list[i].remove(j);
                }

            }

//            for(int i=0;i<list.length;i++){
//                System.out.println(list[i]);
//            }


        }

        System.out.println(answer);



    }
}