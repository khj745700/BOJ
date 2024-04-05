import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static HashMap<Integer, Node> bucket;
	static Node root;
	static int N;
	static int depth = 0;
    public static void main(String[] args) throws Exception{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	N = Integer.parseInt(br.readLine());
    	root = new Node(1);
    	bucket = new HashMap<>();
    	bucket.put(1, root);
    	for(int i = 2; i <= N; i++) {
    		bucket.put(i, new Node(i));
    	}
    	for(int i = 0 ; i < N-1; i++) {
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		int v1 = Integer.parseInt(st.nextToken());
    		int v2 = Integer.parseInt(st.nextToken());
    		Node v = bucket.get(v1);
    		Node u = bucket.get(v2);
    		v.childs.add(u);
    		u.childs.add(v);
    	}
    	
    	dfsCount(null, root, 0);
    	System.out.println(depth % 2 == 0 ? "No" : "Yes");
    }
    
    
    static void dfsCount(Node parent, Node cur, int count) {
    	
    	if(cur.childs.size() == 1 && cur != root) {
    		depth+= count;
    		return;
    	}
    	
    	for(Node v : cur.childs) {
    		if(parent == v) {
    			continue;
    		}
    		dfsCount(cur, v, count+1);
    	}
    	
    }

    static class Node {
    	int val;
    	List<Node> childs;
    	
    	Node(int a) {
    		val = a;
    		childs = new ArrayList<>();
    	}
    }
}