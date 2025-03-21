import java.util.*;
import java.io.*;

class Solution {
    static int[][] dp;
    static int size;
    static int[][] triangle;
    
    public int solution(int[][] triangle) {
        size = triangle.length;
        this.triangle = triangle;        
        dp = new int[size][size];
        
        int max = 0;
        for(int i = 0; i < size; i++) {
            max = Math.max(max, findMax(size - 1, i));
        }
        
        return max;
    }
    
    
    static int findMax(int height, int i) {
        if(height == 0) {
            return triangle[0][0];
        }
        if(dp[height][i] != 0) {
            return dp[height][i];
        }
        
        if(i == 0) {
            dp[height][i] = findMax(height - 1, i) + triangle[height][i];
        }else if(i == height) {
            dp[height][i] = findMax(height - 1, i - 1) + triangle[height][i];
        }else {
            dp[height][i] = Math.max(findMax(height - 1, i - 1), findMax(height - 1, i)) + triangle[height][i];
        }
        
        return dp[height][i];
    }
    
    static boolean isBoundary(int height, int i) {
        return 0 <= i && i <= height;
    }
}