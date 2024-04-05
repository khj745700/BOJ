import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static List<List<Integer>> bucket;
	static ArrayList<Integer> root;
	static int N;
	static int depth = 0;
    public static void main(String[] args) throws Exception{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	N = Integer.parseInt(br.readLine());
    	bucket = new ArrayList<>(N+1);
    	for(int i = 0; i <= N; i++) {
    		bucket.add(new ArrayList<>());
    	}
    	for(int i = 0 ; i < N-1; i++) {
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		int v1 = Integer.parseInt(st.nextToken());
    		int v2 = Integer.parseInt(st.nextToken());
    		bucket.get(v1).add(v2);
    		bucket.get(v2).add(v1);
    	}
    	
    	dfsCount(null, 1, 0);
    	System.out.println(depth % 2 == 0 ? "No" : "Yes");
    }
    
    static void dfsCount(Integer parent, Integer cur, int count) {
    	List<Integer> target = bucket.get(cur);
    	if(target.size() == 1 && cur != 1) {
    		depth+= count;
    		return;
    	}
    	
    	for(Integer v : target) {
     		if(v.equals(parent)) {
    			continue;
    		}
    		dfsCount(cur, v, count+1);
    	}
    	
    }

}