package 프로그래머스.모음사전.두번째;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    private static final char[] CHARS = "AEIOU".toCharArray();

    /**
     * 1번 솔루션과는 다르게, 2번 솔루션에서는 List를 파라미터로 받았음.
     * 1번 솔루션에서는 List가 계속 생성되며, 안에 각각마다 다시 더하고 더하고 하는 머지가 발생.
     * @param word
     * @param data
     */
    private void generate(String word, List<String> data) {
        if(word.length() == 5) {
            return;
        }

        data.add(word);

        for(char c : CHARS) {
            generate(word + c, data);
        }
    }

    public int solution(String word) {
        List<String> data = new ArrayList<>();
        generate("", data);
        return data.indexOf(word);
    }
}
