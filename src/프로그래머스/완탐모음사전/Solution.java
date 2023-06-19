package 프로그래머스.완탐모음사전;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int solution(String word) {
        ArrayList<String> data = new ArrayList<>();

        addString("", data);
        return data.indexOf(word)-1;
    }

    public void addString(String word, List<String> data ){
        if(word.length() > 5){
            return;
        }
        data.add(word);

        addString(word+"A", data);
        addString(word+"E", data);
        addString(word+"I", data);
        addString(word+"O", data);
        addString(word+"U", data);

    }
}
