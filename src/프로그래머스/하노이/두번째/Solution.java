package 프로그래머스.하노이.두번째;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    /**
     * 1번 솔루션과는 다르게, 2번 솔루션에서는 List를 파라미터로 받았음.
     * 1번 솔루션에서는 List가 계속 생성되며, 안에 각각마다 다시 더하고 더하고 하는 머지가 발생.
     * @param n
     * @param from
     * @param to
     * @param process
     *
     */
    private void hanoi(int n, int from, int to, List<int[]> process){
        if (n == 1) {
            process.add(new int[] {from, to});
            return;
        }

        int empty = 6 - from - to;

        hanoi(n - 1, from , empty, process);
        hanoi(1, from, to, process);
        hanoi(n - 1, empty , to, process);
    }

    public int[][] solution(int n) {
        List<int[]> process = new ArrayList<>();
        hanoi(n, 1, 3, process);
        return process.toArray(new int[0][]);
    }
}
