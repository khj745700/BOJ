import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static Map<String, Node> nodes;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        nodes = new HashMap<>();

        for(int i = 0 ; i < n; i++) {
            String input = br.readLine();
            String[] paths = input.split("\\\\");

            Node node = new Node();
            nodes.putIfAbsent(paths[0], node);
            node = nodes.get(paths[0]);
            for(int j = 1 ; j < paths.length ; j++) {
                node.childs.putIfAbsent(paths[j], new Node());
                node = node.childs.get(paths[j]);

            }
        }

        List<String> res = new ArrayList<>(nodes.keySet());
        Collections.sort(res);
        for(String s : res) {
            System.out.println(s);
            print(nodes.get(s).childs, " ");
        }
    }

    static void print(Map<String, Node> nodes, String depth) {
        List<String> res = new ArrayList<>(nodes.keySet());
        Collections.sort(res);
        String nextDepth = depth + " ";
        for(String s : res) {
            System.out.println(depth + s);
            Node node = nodes.get(s);
            print(node.childs, nextDepth);
        }
    }
    static class Node {
        private Map<String, Node> childs;

        public Node() {
            childs = new HashMap<>();
        }
    }
}