package algorithms;


import algorithms.structure.ListNode;


/**
 *
 * Given a linked list, remove the n-th node from the end of list and return its head.
 *
 * Example:
 *
 * Given linked list: 1->2->3->4->5, and n = 2.
 *
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 * Note:
 *
 * Given n will always be valid.
 *
 * Follow up:
 *
 * Could you do this in one pass?
 *
 *
 *
 *
 * @author wuxiaobiao
 * @date 2020-09-27 : 15:14
 */
public class _19_RemoveNthNodeFromEndOfList {


    /**
     *
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Remove Nth Node From End of List.
     * Memory Usage: 36.7 MB, less than 100.00% of Java online submissions for Remove Nth Node From End of List.
     *
     *
     *
     */

    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode first = dummy;
        ListNode second = dummy;

        for (int i=0;i<n;i++) {
            first = first.next;
        }

        while (first != null) {
            first = first.next;
            second = second.next;
        }

        second.next = second.next.next;
        return dummy.next;
    }





}
