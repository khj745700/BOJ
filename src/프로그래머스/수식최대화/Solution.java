package 프로그래머스.수식최대화;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

    //경우의 수가 크지 않은 경우에는 이처럼 직접 넣는게 더 빠름.
    private static final String[][] precedences = {
            "+-*".split(""),
            "+*-".split(""),
            "-+*".split(""),
            "-*+".split(""),
            "*+-".split(""),
            "*-+".split(""),

    };

    private long calculate(long lhs, long rhs, String op) {
        return switch (op) {
            case "+" -> lhs + rhs;
            case "-" -> lhs - rhs;
            case "*" -> lhs * rhs;
            default -> 0;
        };
    }

    private long calculate(List<String> tokens, String[] precedence){
        for(String op : precedence) {
            for (int i = 0 ; i < tokens.size(); i++) {
                if (tokens.get(i).equals(op)) {
                    long lhs = Long.parseLong(tokens.get(i - 1));
                    long rhs = Long.parseLong(tokens.get(i + 1));
                    long result = calculate(lhs, rhs, op);

                    // i - 1 을 지우면 i 에 있던 녀석이 i로 채워짐.
                    tokens.remove(i - 1);
                    tokens.remove(i - 1);
                    tokens.remove(i - 1);

                    //그 위치에 결과를 저장
                    tokens.add(i - 1, String.valueOf(result));

                    // 리스트의 뒷부분을 앞으로 당겼기 때문에 순회하는 인덱스 i 또한 앞으로 당겨와야함.
                    i -= 2;

                }
            }
        }
        return Long.parseLong(tokens.get(0));
    }

    public long solution (String expression) {
        StringTokenizer st = new StringTokenizer(expression, "+-*", true);
        List<String> tokens = new ArrayList<>();
        while (st.hasMoreTokens()){
            tokens.add(st.nextToken());
        }

        long max = 0;
        for (String[] precedence : precedences) {
            long value = Math.abs(calculate(new ArrayList<>(tokens), precedence));
            if( value > max) {
                max = value;
            }
        }
        return max;
    }
}
