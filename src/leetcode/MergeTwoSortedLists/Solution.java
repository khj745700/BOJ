package leetcode.MergeTwoSortedLists;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) {
        this.val = val;
    }
    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}


public class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode header = new ListNode();
        ListNode answer = header;
        while(list1 != null && list2 != null) {
            if(list1.val >= list2.val) {
                answer.next = new ListNode(list2.val);
                answer = answer.next;
                list2 = list2.next;
            }else {
                answer.next = new ListNode(list1.val);
                answer = answer.next;
                list1 = list1.next;
            }
        }

        while(list1 != null) {
            answer.next = new ListNode(list1.val);
            answer = answer.next;
            list1 = list1.next;
        }

        while(list2 != null) {
            answer.next = new ListNode(list2.val);
            answer = answer.next;
            list2 = list2.next;
        }

        return header.next;
    }

}
