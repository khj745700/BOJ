import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
    static TreeNode root;
    static int nodeSize;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        nodeSize = Integer.parseInt(br.readLine());
        root = new TreeNode();
        root.val = 'A';

        StringTokenizer st;
        while(nodeSize --> 0) {
            st = new StringTokenizer(br.readLine());

            char target = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);

            insert(target, left != '.' ? left : null, right != '.' ? right : null);
        }

        preSearch(root);
        System.out.println();
        midSearch(root);
        System.out.println();
        postSearch(root);
    }

    static void insert(char target, Character left, Character right) {
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        TreeNode cur = null;
        while(!q.isEmpty()){
            cur = q.poll();
            if(cur.val == target){
                break;
            }
            if(cur.left != null) q.add(cur.left);
            if(cur.right != null) q.add(cur.right);
        }
        if(left != null){
            cur.left = new TreeNode();
            cur.left.val = left;
        }

        if(right != null)   {
            cur.right = new TreeNode();
            cur.right.val = right;
        }

    }

    static void preSearch(TreeNode next) {
        if(next == null) {
            return;
        }
        System.out.print(next.val);
        preSearch(next.left);
        preSearch(next.right);

    }

    static void midSearch(TreeNode next) {
        if(next == null) {
            return;
        }

        midSearch(next.left);
        System.out.print(next.val);
        midSearch(next.right);
    }

    static void postSearch(TreeNode next) {
        if(next == null) {
            return;
        }

        postSearch(next.left);
        postSearch(next.right);
        System.out.print(next.val);
    }



    static class TreeNode{
        char val;
        TreeNode left;
        TreeNode right;
    }
}
