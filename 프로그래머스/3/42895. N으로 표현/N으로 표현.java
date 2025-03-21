import java.util.*;
import java.io.*;

class Solution {
    static Set[] dp;
    public int solution(int N, int number) {
        dp = new HashSet[9];
        
        for(int i = 0 ; i < 9; i++) {
            dp[i] = new HashSet<Integer>();
        }
        
        dp[1].add(N);
        
        for(int i = 1; i < 9; i++) {
            dp[i].add(Integer.parseInt(Integer.toString(N).repeat(i)));
        }
        
        for(int i = 1 ; i < 9; i++) {
            Set<Integer> target1 = dp[i];
            for(Integer targetNum : target1) {
                for(int j = 1 ; i + j < 9; j++) {
                    Set<Integer> target = dp[j];
                
                    for(Integer num : target) {
                        dp[i+j].add(num + targetNum);
                        dp[i+j].add(num * targetNum);
                        dp[i+j].add(num - targetNum);
                        if(targetNum != 0) {
                            dp[i+j].add(num / targetNum);
                        }
                    }
                }
            }
        }
        
        for(int i = 1; i < 9 ; i++) {
            if(dp[i].contains(number)){
                return i;
            }
        }
        
        return -1;
    }
    
}