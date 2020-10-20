package algorithms;

import algorithms.structure.ListNode;

/**
 *
 *  Given a linked list, swap every two adjacent nodes and return its head.
 *
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 *
 *
 *
 * Example:
 *
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 *
 *
 * @author wuxiaobiao
 * @date 2020-09-28 : 14:51
 */
public class _24_SwapNodesInPairs {


    public static void main(String[] args) {

        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(5);
        ListNode l4 = new ListNode(7);
        ListNode l5 = new ListNode(9);
        ListNode l6 = new ListNode(11);
        l5.next = l6;
        l4.next = l5;
        l3.next = l4;
        l2.next = l3;
        l1.next = l2;


        _24_SwapNodesInPairs inPairs = new _24_SwapNodesInPairs();
        ListNode a = inPairs.swapPairs(l1);
        ListNode b = inPairs.swapPairs(a);
    }




    public ListNode swapPairs(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode dumpy = new ListNode(0);
        ListNode here = head;
        head = head.next;
        ListNode tmp = null;

        while (here != null && here.next!=null) {
            tmp = here.next;
            here.next = here.next.next;
            tmp.next = here;
            dumpy.next = tmp;
            dumpy = here;
            here = here.next;
        }

        return head;
    }

}
