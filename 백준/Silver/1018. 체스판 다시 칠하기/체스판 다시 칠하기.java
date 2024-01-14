import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static boolean[][] graph;
    static boolean[][] wStart;
    static boolean[][] bStart;
    static final boolean BLACK = false;
    static final boolean WHITE = true;
    static int height;
    static int width;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        height = Integer.parseInt(st.nextToken());
        width = Integer.parseInt(st.nextToken());

        graph = new boolean[height][width];
        wStart = new boolean[8][8];
        bStart = new boolean[8][8];

        boolean white = WHITE;
        boolean black =  BLACK;

        for(int i = 0; i < height; i++) {
            String str = br.readLine();
            for(int j = 0; j < width; j++) {
                if(str.charAt(j) == 'W') {
                    graph[i][j] = WHITE;
                }else {
                    graph[i][j] = BLACK;
                }
            }
        }

        for(int i = 0; i < 8; i++) {
            for(int j = 0 ; j < 8; j++) {
                wStart[i][j] = white;
                bStart[i][j] = black;
                white = !white;
                black = !black;
            }
            white = !white;
            black = !black;
        }

        int min = Integer.MAX_VALUE;
        int col = Math.max(0, height - 8);
        int row = Math.max(0, width - 8);
        for(int i = 0 ; i <= col; i++) {
            for(int j = 0; j <= row; j++) {
                min = Math.min(min, Math.min(countDiff(graph, wStart, j, i), countDiff(graph, bStart, j, i)));
            }
        }
        System.out.println(min);
    }

    static int countDiff(boolean[][] graph1, boolean[][] graph2, int startIdxX, int startIdxY) {
        int count = 0;
        for(int i = 0 ; i < 8; i++) {
            for(int j = 0; j <  8; j++) {
                if(graph1[i+ startIdxY][j + startIdxX] != graph2[i][j]){
                    count++;
                }
            }
        }
        return count;
    }

}
