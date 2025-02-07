import java.io.*;
import java.util.*;

public class Main {

    static String text;
    static String pattern;
    static int[] lps;
    static List<Integer> resultPositions = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        text = br.readLine();
        pattern = br.readLine();
        lps = new int[pattern.length()];
        findPattern();
        bw.append(Integer.toString(resultPositions.size()));
        bw.append("\n");
        for (Integer position : resultPositions) {
            bw.append(Integer.toString(position));
            bw.append("\n");
        }
        bw.flush();
    }

    private static void findPattern() {
        buildLPS();
        int textLength = text.length();
        int patternLength = pattern.length();
        int idx = 0;
        for (int i = 0; i < textLength; i++) {
            while (idx > 0 && text.charAt(i) != pattern.charAt(idx)) {
                idx = lps[idx - 1];
            }
            if (text.charAt(i) == pattern.charAt(idx)) {
                if (idx == patternLength - 1) {
                    resultPositions.add(i - idx + 1);
                    idx = lps[idx];
                } else {
                    idx++;
                }
            }
        }
    }

    private static void buildLPS() {
        int idx = 0;
        for (int i = 1; i < pattern.length(); i++) {
            while (idx > 0 && pattern.charAt(i) != pattern.charAt(idx)) {
                idx = lps[idx - 1];
            }
            if (pattern.charAt(i) == pattern.charAt(idx)) {
                idx++;
                lps[i] = idx;
            }
        }
    }
}