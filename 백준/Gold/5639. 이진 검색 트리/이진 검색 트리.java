import java.util.*;
import java.io.*;

public class Main {
    static Node root;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        root = new Node();
        root.val = Integer.parseInt(br.readLine());
        String input;
        while((input = br.readLine()) != null) {
            dfs(Integer.parseInt(input), root);
        }
        StringBuilder sb = new StringBuilder();
        postOrder(root, sb);
        System.out.println(sb);
    }

    static void postOrder(Node cur, StringBuilder sb) {
        if(cur == null) {
            return;
        }

        postOrder(cur.left, sb);
        postOrder(cur.right, sb);
        sb.append(cur.val).append(' ');
    }
    static void dfs(int val, Node cur) {
        if(val > cur.val) {
            if(cur.right == null) {
                cur.right = new Node();
                cur.right.val = val;
                return;
            }
            dfs(val, cur.right);
        }
        else if(val < cur.val) {
            if(cur.left == null) {
                cur.left = new Node();
                cur.left.val = val;
                return;
            }

            dfs(val, cur.left);
        }
    }
    static class Node {
        int val;
        Node left;
        Node right;
    }
}
