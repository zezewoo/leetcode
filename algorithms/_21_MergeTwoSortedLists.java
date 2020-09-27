package algorithms;

import algorithms.structure.ListNode;

/**
 *
 * Merge two sorted linked lists and return it as a new sorted list. The new list should be made by splicing together the nodes of the first two lists.
 *
 * Example:
 *
 * Input: 1->2->4, 1->3->4
 * Output: 1->1->2->3->4->4
 *
 *
 * @author wuxiaobiao
 * @date 2020-09-27 : 16:24
 */
public class _21_MergeTwoSortedLists {


    /**
     *
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Merge Two Sorted Lists.
     * Memory Usage: 38.2 MB, less than 99.99% of Java online submissions for Merge Two Sorted Lists.
     *
     */


    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode l3 = new ListNode(0);
        ListNode dumpy = new ListNode(0);
        dumpy.next = l3;

        while (l1 != null || l2 != null) {

            if (l1 == null && l2 != null) {
                l3.next = l2;
                l3 = l3.next;
                l2 = l2.next;
                continue;
            }

            if (l2 == null && l1 != null) {
                l3.next = l1;
                l3 = l3.next;
                l1 = l1.next;
                continue;
            }

            if (l1.val < l2.val) {

                l3.next = l1;
                l3 = l3.next;
                l1 = l1.next;
            } else {

                l3.next = l2;
                l3 = l3.next;
                l2 = l2.next;
            }
        }

        return dumpy.next.next;
    }

}
