package linkedlist;
/*You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example:

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.*/

  class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }


public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return addRecursively(0, l1, l2);
    }

    public ListNode addRecursively(int carry, ListNode l1, ListNode l2) {
        int sum = 0;

        if (l1 != null) {
            sum += l1.val;
        }

        if (l2 != null) {
            sum += l2.val;
        }

        sum += carry;
        carry = sum / 10;

        if ((l1 == null || l1.next == null)&& (l2 ==  null || l2.next == null)) {
            return carry != 0 ? new ListNode(carry) : null;
        }


        return new ListNode(sum%10, addRecursively(carry, l1.next, l2.next));
    }
}
