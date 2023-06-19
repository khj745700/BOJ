package 프로그래머스.소수찾기;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {

    private static List<int []> hanoi(int n, int from, int to ){
        if (n == 1) return List.of(new int[] {from, to});

        int empty = 6 - to - from;

        List<int []> result = new ArrayList<>();
        result.addAll(hanoi(n - 1, from, empty));
        result.addAll(hanoi(1, from, to));
        result.addAll(hanoi(n-1, empty, to));
        return result;
    }

    public static void main(String[] args) {
        int[][] ans = hanoi(8, 1, 3).toArray(new int[100][]);

        System.out.println(ans.length);
        System.out.println(ans[0].length);
        System.out.println(ans[1].length);
        System.out.println(ans[1][0]+""+ans[1][1]);
    }
}
