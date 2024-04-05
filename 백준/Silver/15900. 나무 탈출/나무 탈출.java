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
	static boolean[] visited;
    public static void main(String[] args) throws Exception{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	N = Integer.parseInt(br.readLine());
    	root = new Node(1);
    	bucket = new HashMap<>();
    	bucket.put(1, root);
    	visited = new boolean[N+1];
    	for(int i = 0 ; i < N-1; i++) {
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		int v1 = Integer.parseInt(st.nextToken());
    		int v2 = Integer.parseInt(st.nextToken());
    		bucket.putIfAbsent(v1, new Node(v1));
    		bucket.putIfAbsent(v2, new Node(v2));
    		Node v = bucket.get(v1);
    		Node u = bucket.get(v2);
    		v.childs.add(u);
    		u.childs.add(v);
    	}
    	
    	dfsCount(root, 0);
    	System.out.println(depth % 2 == 0 ? "No" : "Yes");
    }
    
    
    static void dfsCount(Node cur, int count) {
    	visited[cur.val] = true;
    	
    	if(cur.childs.size() == 0) {
    		depth+= count;
    		return;
    	}
    	
    	boolean flag = false;
    	for(Node v : cur.childs) {
    		if(visited[v.val]) {
    			continue;
    		}
    		dfsCount(v, count+1);
    		flag = true;
    	}
    	
    	if(!flag) {
    		depth+= count;
    		return;
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