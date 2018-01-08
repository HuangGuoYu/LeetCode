package code;

import java.util.Arrays;

public class Solution {

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int num1 = convertListNodeToInt(l1);
        int num2 = convertListNodeToInt(l2);
        int result = num1 + num2;
        int rank = 10;
        int temp;
        System.out.println(result);
        ListNode rNode = new ListNode(0);
        ListNode finallNode = rNode;
        System.out.println(result);
        while(result != 0) {
            temp = result % rank;
            ListNode item = new ListNode(temp);
            rNode.next = item;
            rNode = rNode.next;
            result /= rank;
        }
        if (finallNode.next == null) {
            return new ListNode(0);
        }
        return finallNode.next;
    }

    public static Integer convertListNodeToInt(ListNode l) {
        Integer result = 0;
        int rank = 1;
        while(l != null) {
            result += l.val * rank;
            l = l.next;
            rank *= 10;
        }
        return result;
    }

    public void compute() {
       ListNode l1 = new ListNode(2);
       l1.next = new ListNode(4);
       l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        addTwoNumbers(l1, l2);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
//        s.compute();
        System.out.println(Arrays.asList(new Integer[] {1,2}, new Integer[] {1,2}).size());
        for (Integer[] item : Arrays.asList(new Integer[] {1,2}, new Integer[] {1,2})) {

        }
    }
}



