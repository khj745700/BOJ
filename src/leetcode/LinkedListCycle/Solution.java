package leetcode.LinkedListCycle;

import java.util.HashSet;
import java.util.Set;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class Solution {
    public boolean hasCycle(ListNode head) {
        Set<ListNode> referenceSet = new HashSet<>();

        while(head != null) {
            if(referenceSet.contains(head)){
                return true;
            }else {
                referenceSet.add(head);
            }
            head = head.next;
        }
        return false;
    }
}
