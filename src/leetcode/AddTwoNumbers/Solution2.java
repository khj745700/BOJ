package leetcode.AddTwoNumbers;

public class Solution2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode answer = new ListNode();
        ListNode flag = answer;
        while(l1 != null && l2 != null ) {
            flag = addDigit(flag, l1.val, l2.val, l1.next != null || l2.next != null);
            l1 = l1.next;
            l2 = l2.next;
        }

        while(l1 != null) {
            flag = addDigit(flag, l1.val, 0, l1.next != null);
            l1 = l1.next;
        }

        while(l2 != null) {
            flag = addDigit(flag, l2.val, 0, l2.next != null);
            l2 = l2.next;
        }
        return answer;
    }

    public ListNode addDigit(ListNode node, int l1, int l2, boolean hasNext) {
        int digit = l1 + l2 + node.val;
        node.val = digit % 10;
        node.next =  hasNext || digit/10 != 0 ? new ListNode(digit/10, null) : null;
        return node.next;
    }
}
