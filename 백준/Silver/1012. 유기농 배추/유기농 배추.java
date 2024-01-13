import java.util.Scanner;

public class Main {
    private static int n;
    private static int m;
    private static int[][] graph;
    //DFS로 특정 노드를 방문하고 연결된 모든 노드들도 방문
    static boolean dfs (int x, int y){
        //주어진 범위를 벗어나는 즉시 종료
        if(x <= -1 || x>= n || y <= -1 || y >= m){
            return false;
        }

        //현재 노드를 방문하지 않았다면
        if(graph[x][y] == 1){
            //해당 노드 방문 처리
            graph[x][y] = 0;
            dfs(x - 1, y);
            dfs( x, y - 1);
            dfs(x+1, y);
            dfs(x, y+1);
            return true;
        }
        return false;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();

        for(int k = 0 ; k < testCase; k++) {
            n = sc.nextInt();
            m = sc.nextInt();
            int size = sc.nextInt();
            graph = new int[n][m];
            for (int i = 0; i < size; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                    graph[a][b] = 1;
            }
            int result = 0;
            for(int i = 0 ; i < n; i++){
                for(int j = 0 ; j < m; j++){
                    if(dfs(i,j)){
                        result++;
                    }
                }
            }
            System.out.println(result);
        }
    }
}