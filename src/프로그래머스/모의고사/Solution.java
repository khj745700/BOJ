package 프로그래머스.모의고사;

import java.util.*;

public class Solution {
    public ArrayList<Integer> solution(int[] answers) {
        int[] firstMem = {1,2,3,4,5};
        int[] secondMem = {2,1,2,3,2,4,2,5};
        int[] thirdMem = {3,3,1,1,2,2,4,4,5,5};


        int[] countArr = new int[3];
        for(int i = 0 ; i < answers.length; i++){
            if(firstMem[i % firstMem.length] == answers[i]){
                countArr[0]++;
            }
            if(secondMem[i % secondMem.length] == answers[i]){
                countArr[1]++;
            }
            if(thirdMem[i % thirdMem.length] == answers[i]){
                countArr[2]++;
            }
        }

        OptionalInt max = Arrays.stream(countArr).max();
        int maxVal = max.orElse(0);

        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = 0; i < 3; i++){
            if(maxVal == countArr[i]) ans.add(i);
        }


        return ans;
    }

    public static void main(String[] args) {

    }
}
