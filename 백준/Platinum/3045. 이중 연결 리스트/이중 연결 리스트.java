import java.io.*;
import java.util.*;

public class Main {
    static final int INF = 987654321;

    static class Node {
        int num;
        Node prev, next;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Node[] node = new Node[N + 2];
        for (int i = 0; i <= N + 1; i++) {
            node[i] = new Node();
        }

        Node head = node[0];
        Node tail = node[N + 1];

        for (int i = 1; i <= N; i++) {
            node[i].num = i;
            node[i].prev = node[i - 1];
            node[i].next = node[i + 1];
        }
        head.next = node[1];
        tail.prev = node[N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            char cmd = st.nextToken().charAt(0);
            int X = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());

            node[X].prev.next = node[X].next;
            node[X].next.prev = node[X].prev;

            if (cmd == 'A') {
                node[X].prev = node[Y].prev;
                node[X].next = node[Y];
                node[Y].prev.next = node[X];
                node[Y].prev = node[X];
            } else {
                node[X].prev = node[Y];
                node[X].next = node[Y].next;
                node[Y].next.prev = node[X];
                node[Y].next = node[X];
            }
        }

        ArrayList<Integer> arr = new ArrayList<>();
        Node cur = head;
        while ((cur = cur.next) != node[N + 1]) {
            arr.add(cur.num);
        }

        int[] minLast = new int[N];
        Arrays.fill(minLast, INF);
        ArrayList<Integer> location = new ArrayList<>();
        int lisLength = 0;

        for (int i = 0; i < arr.size(); i++) {
            int val = arr.get(i);
            int idx = lowerBound(minLast, val, lisLength);
            minLast[idx] = val;
            location.add(idx + 1);
            if (idx + 1 > lisLength) {
                lisLength = idx + 1;
            }
        }

        int[] lis = new int[lisLength + 1];
        lis[0] = 0;
        int len = lisLength;
        for (int i = location.size() - 1; i >= 0; i--) {
            if (location.get(i) == len) {
                lis[len--] = arr.get(i);
            }
        }

        System.out.println(N - lisLength);

        for (int i = lisLength; i >= 1; i--) {
            int now = lis[i] - 1;
            while (now > lis[i - 1]) {
                System.out.println("A " + now + " " + (now + 1));
                now--;
            }
        }

        for (int now = lis[lisLength] + 1; now <= N; now++) {
            System.out.println("B " + now + " " + (now - 1));
        }
    }

    static int lowerBound(int[] arr, int val, int length) {
        int left = 0, right = length;
        while (left < right) {
            int mid = (left + right) >>> 1;
            if (arr[mid] < val) left = mid + 1;
            else right = mid;
        }
        return left;
    }
}