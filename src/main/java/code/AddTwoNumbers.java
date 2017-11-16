package code;


   class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        long i = 1;
        long var1 = 0;
        long var2 = 0;
        while (l1 != null) {
            var1 += l1.val * i;
            i *= 10;
            l1 = l1.next;
        }
        i = 1;
        while (l2 != null) {
            var2 += l2.val * i;
            i *= 10;
            l2 = l2.next;
        }
        var1 += var2;
        System.out.println(var1);
        l1 = new ListNode(0);
        l2 = l1;
        i = 10;
        while (var1 != 0) {
            l1.val = (int) (var1 % i);
            var1 /= i;
            if (var1 != 0) {
                l1.next = new ListNode(0);
                l1 = l1.next;
            }
        }
        return l2;
    }

    public static void main(String[] args) {
        AddTwoNumbers r = new AddTwoNumbers();
        ListNode l1 = r.constructList(new int[]{9});

        ListNode l2 = r.constructList(new int[]{1,9,9,9,9,9,9,9,9,9});


        ListNode listNode = r.addTwoNumbers(l1, l2);
        while(listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }


    public ListNode constructList(int [] array) {
        ListNode result = new ListNode(0);
        ListNode temp = result;
        for (int i = 0;i<array.length; i++) {
            result.val = array[i];
            if ((i+1) != array.length ) {
                result.next = new ListNode(0);
                result = result.next;
            }
        }
        return temp;
    }
}


