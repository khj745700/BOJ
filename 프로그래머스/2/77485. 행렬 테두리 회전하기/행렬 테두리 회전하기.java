import java.util.*;

class Solution {
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static int[][] queries;
    static int[][] arr;
    
    static int rows, columns;
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        this.queries = queries;
        arr = new int[rows][columns];
        this.rows = rows;
        this.columns = columns;
        int temp = 1;
        for(int i = 0 ; i < rows; i++) {
            for(int j = 0 ; j < columns; j++) {
                arr[i][j] = temp++;
            }
        }
        
        for(int i = 0 ; i < queries.length; i++) {
            
            int val = rotate(queries[i][1] - 1, queries[i][0] - 1, queries[i][3] -1 , queries[i][2] - 1);
            
            answer[i] = val;
            
        }
        return answer;
    }
    
    
    public int rotate(int startX, int startY, int endX, int endY) {
        int d = 0 ;
        int beforeX = startX;
        int beforeY = startY;
        int min = arr[startY][startX];
        for(int i = 0 ; i < ((endX - startX) * 2 + (endY - startY) * 2) - 1 ; i++) {
            
            if(!isBoundary(beforeX + dx[d], beforeY + dy[d], endX, endY, startX, startY)) {
                d ++ ;
                d %= 4;
            }
            
            int curX = beforeX + dx[d];
            int curY = beforeY + dy[d];
            min = Math.min(arr[curY][curX], min);
            int temp = arr[beforeY][beforeX];
            arr[beforeY][beforeX] = arr[curY][curX];
            
            arr[curY][curX] = temp;
            
            
            beforeX = curX;
            beforeY = curY;
            
            
        }
        System.out.println("===");
        return min;
    }
    
    public static boolean isBoundary(int x, int y, int endX, int endY, int startX, int startY) {
        return startX <= x && x <= endX && startY <= y && y <= endY;
    }
    
    public void printArr() {
        for(int i = 0; i < arr.length; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
        System.out.println();
    }
}