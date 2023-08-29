package leetcode.AddTwoNumbers;

import java.math.BigInteger;
import java.util.Arrays;

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

class CustomLinkedList{
    ListNode head;

    int capacity;

    public void addFirst(int val) {
        ListNode newNode = new ListNode(val, null);
        if(isEmpty()) {
            head = newNode;
            return;
        }
        ListNode toNext = head;
        head = newNode;
        newNode.next = toNext;
    }

    boolean isEmpty() {
        return capacity == 0;
    }

}


public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();

        sb1.append(l1.val);
        while(l1.next != null) {
            l1 = l1.next;
            sb1.append(l1.val);
        }

        sb2.append(l2.val);
        while(l2.next != null) {
            l2 = l2.next;
            sb2.append(l2.val);
        }
        BigInteger left = new BigInteger(sb1.toString());

        BigInteger right = new BigInteger(sb2.toString());

        CustomLinkedList linkedList = new CustomLinkedList();
        for(char c : left.add(right).toString().toCharArray()){
            linkedList.addFirst(c - '0');
        }
        return linkedList.head;
    }
}
