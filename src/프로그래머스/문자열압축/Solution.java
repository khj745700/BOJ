package 프로그래머스.문자열압축;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    private List<String> split(String source, int length) {
        List<String> tokens = new ArrayList<>();
        for (int startIdx = 0; startIdx < source.length(); startIdx += length) {
            int endIdx = startIdx + length;
            if (endIdx > source.length()) endIdx = source.length();
            tokens.add(source.substring(startIdx, endIdx));
        }

        return tokens;
    }

    private int compress(String source, int length) {
        StringBuilder sb = new StringBuilder();

        String last = "";
        int count = 0;
        for (String token : split(source, length)) {
            if(token.equals(last)){
                count++;
            } else {
                if(count > 1) sb.append(count);
                sb.append(last);
                last = token;
                count = 1;
            }
        }
        if(count > 1) sb.append(count);
        sb.append(last);

        return sb.length();
    }

    public int solution(String s) {
        int min = Integer.MAX_VALUE;
        for(int length = 1 ; length <= s.length(); length++){
            int compressed = compress(s, length);
            if(compressed < min){
                min = compressed;
            }
        }
        return min;

    }
}
