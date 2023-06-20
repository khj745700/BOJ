package 프로그래머스.이진변환반복;

public class Solution {
    private int countZero(String s) {
        int count = 0;
        for (char c : s.toCharArray()){
            if(c == '0'){
                count ++;
            }
        }
        return count;
    }

    public int[] solution(String s) {
        int zeroCount = 0;
        int loopCount = 0;


        while (!s.equals("1")){
            int zero = countZero(s);
            zeroCount += zero;
            loopCount += 1;

            int ones = s.length() - zero;
            s = Integer.toString(ones, 2);
        }

        return new int[] {loopCount, zeroCount};
    }
}
