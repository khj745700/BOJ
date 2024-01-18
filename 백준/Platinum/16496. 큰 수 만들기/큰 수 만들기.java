import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static List<Nums> list;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		list = new ArrayList<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			list.add(new Nums(st.nextToken()));
		}

		Collections.sort(list);
		StringBuilder sb = new StringBuilder();
		for(Nums s : list) {
			sb.append(s.num);
		}
		
		BigDecimal i = new BigDecimal(sb.toString());
		System.out.println(i.toString());
	}
	
	
	static class Nums implements Comparable<Nums> {
		String num;
		
		Nums(String num) {
			this.num = num;
		}
		
		@Override
		public int compareTo(Nums o2) {
			return (o2.num + num).compareTo(num+o2.num); 
		}
	}
}
