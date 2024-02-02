import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.PriorityQueue;

public class Main {

    static class Node implements Comparable<Node>{
        Node(int v, int w) {this.v = v; this.w = w;}
        int v;
        int w;
        @Override
        public int compareTo(Node o) {
            return this.w - o.w;
        }
        @Override
        public int hashCode() {
            return v;
        }
        @Override
        public boolean equals(Object obj) {
            return this.hashCode() == obj.hashCode();
        }
    }
    static int[] costs;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 처음 노드의 갯수, 간선의 갯수, 시작점
        String[] temp = br.readLine().split(" ");
        int n = Integer.parseInt(temp[0]);
        int e = Integer.parseInt(temp[1]);
        int start = Integer.parseInt(br.readLine())-1;
        
        //최소 비용
        costs = new int[n];
        
        //방문 처리용 배열
        visited = new boolean[n];
        
        //그래프 저장용 배열리스트
        ArrayList<Node>[] graph = new ArrayList[n];

        
        //간선의 갯수만큼 값 저장
        for(int i = 0; i<e; i++) {
            temp = br.readLine().split(" ");
            int u = Integer.parseInt(temp[0])-1;
            int v = Integer.parseInt(temp[1])-1;
            int w = Integer.parseInt(temp[2]);

            //만약 그래프가 생성안되었다면 그래프 노드 간선 생성
            if(graph[u] == null) graph[u] = new ArrayList<Node>();

            Node node = new Node(v,w);

            /**
             * 안써도 되는 이유?
             * pq가 먼저 compareTo로 우선순위에서 하위로 밀리기때문에 그냥 추가하는게 좋음.
             * indexOf는 O(N)의 탐색속도가 걸림.
             * 모든 노드마다 체크하는 경우이므로, N^N의 시간복잡도 소요됨.
             */
//            //해당 노드의 번호 찾고
//            int idx = graph[u].indexOf(node);
//
//            
//            //만약 인덱스가 -1이 아니라면
//            if(idx != -1)
//            	//해당 노드의 최솟값 갱신
//                node.w = Math.min(graph[u].get(idx).w, w);
//            else
//            	//만약 존재하지 않다면 저장
                graph[u].add(node);
        }

        //최댓값을 넣어주고
        Arrays.fill(costs, 1_000_000_000);
        
        //출발점의 가중치는 0. 자기 자신으로 가는 최단경로는 0
        costs[start] = 0;
        //그래프 시작 dist 초기화
        for(Node node : graph[start])
            costs[node.v] = Math.min(node.w, costs[node.v]);
        
        //pq 안에서 처리 해줌.
//        visited[start] = true;
        
        
        // start와 연결된 pq
        PriorityQueue<Node> pq = new PriorityQueue<>(graph[start]);
        Node node = null;
        while(!pq.isEmpty()) {
            node = pq.poll();
            
            //for문 안에 있으면, 무조건 반복문을 거쳐야함. 시간복잡도 소요들게 됨.
            if(visited[node.v])
                continue;
            visited[node.v] = true;
      
            //만약 graph[node.v]가 출발하는 간선이 존재하지 않는다면,
            if(graph[node.v] == null)
                continue;
            

            for(Node next: graph[node.v]) {
            	//우선 방문 

                if(costs[next.v] == 0) { //만약 비용이 0이라면, 방문한 적이 없었던 것이므로..
                	
                    costs[next.v] = costs[node.v] + next.w;
                    pq.add(new Node(next.v, costs[next.v])); 
                }
                else
                    if(costs[next.v] > costs[node.v] + next.w) {
                        costs[next.v] = costs[node.v] + next.w;
                        
//						pq.remove(next) => 이 연산도 시간복잡도 O(N) 만큼 소요됨. 따라서 제거 대상.
                        pq.add(new Node(next.v, costs[next.v])); // 제거를 하지 못하므로, 새로운 레퍼런스 객체를 추가한다.
                    }
            }
        }
        for(int i=0; i<n; i++) {
            if(i == start)
                System.out.println(0);
            else if(costs[i] == 1_000_000_000)
                System.out.println("INF");
            else
                System.out.println(costs[i]);
        }
    }
}

