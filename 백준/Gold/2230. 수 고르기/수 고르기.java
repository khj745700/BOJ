import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
	static int N, M;
	static TreeMap<Integer, Integer> map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new TreeMap<>();
		for(int i = 0 ; i < N; i++) {
			int val = Integer.parseInt(br.readLine());
			map.put(val, map.getOrDefault(val, 0) + 1);
		}
		
		int MIN = Integer.MAX_VALUE;
		
		for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
			int val = entry.getKey();
			
			
			Map.Entry<Integer, Integer> target = map.ceilingEntry(val+M);
			if(target == null) {
				break;
			}
			if(target.getKey() == val && target.getValue() == 1) {
				target = map.ceilingEntry(val + M + 1);
			}
			if(target == null) {
				break;
			}
			
			MIN = Math.min(MIN, target.getKey() - val);
			
			
		}
		
		System.out.println(MIN);
	}
}