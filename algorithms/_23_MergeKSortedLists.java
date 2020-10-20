package algorithms;

import algorithms.structure.ListNode;

import java.util.Arrays;
import java.util.List;

/**
 * You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
 *
 * Merge all the linked-lists into one sorted linked-list and return it.
 *
 *
 *
 * Example 1:
 *
 * Input: lists = [[1,4,5],[1,3,4],[2,6]]
 * Output: [1,1,2,3,4,4,5,6]
 * Explanation: The linked-lists are:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * merging them into one sorted list:
 * 1->1->2->3->4->4->5->6
 * Example 2:
 *
 * Input: lists = []
 * Output: []
 * Example 3:
 *
 * Input: lists = [[]]
 * Output: []
 *
 *
 * Constraints:
 *
 * k == lists.length
 * 0 <= k <= 10^4
 * 0 <= lists[i].length <= 500
 * -10^4 <= lists[i][j] <= 10^4
 * lists[i] is sorted in ascending order.
 * The sum of lists[i].length won't exceed 10^4.
 *
 *
 * @author wuxiaobiao
 * @date 2020-09-28 : 14:00
 */




public class _23_MergeKSortedLists {


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



        ListNode l7 = new ListNode(1);
        ListNode l8 = new ListNode(4);
        ListNode l9 = new ListNode(6);
        ListNode l10 = new ListNode(8);
        ListNode l11 = new ListNode(10);
        ListNode l12 = new ListNode(11);
        l11.next = l12;
        l10.next = l11;
        l9.next = l10;
        l8.next = l9;
        l7.next = l8;


        _23_MergeKSortedLists lists = new _23_MergeKSortedLists();

        ListNode[] listNodes = new ListNode[2];
        listNodes[0] = l1;
        listNodes[1] = l7;

        ListNode a = lists.mergeKLists(listNodes);
        ListNode b = lists.mergeKLists(listNodes);

    }

    public ListNode mergeTwo(ListNode node1, ListNode node2){
        if(node1 == null) return node2;
        if(node2 == null) return node1;

        ListNode head = new ListNode();
        ListNode ptr = head;

        while(node1 != null && node2 != null){
            if(node1.val > node2.val){
                ptr.next = new ListNode(node2.val);
                node2 = node2.next;
            }else{
                ptr.next = new ListNode(node1.val);
                node1 = node1.next;
            }
            ptr = ptr.next;
        }

        while(node2 != null){
            ptr.next = new ListNode(node2.val);
            node2 = node2.next;
            ptr = ptr.next;
        }

        while(node1 != null){
            ptr.next = new ListNode(node1.val);
            node1 = node1.next;
            ptr = ptr.next;
        }

        return head.next;
    }


    public ListNode divide(ListNode[] lists, int start, int end){
        if(start == end){
            return lists[start];
        }else{
            return mergeTwo(divide(lists, start, (start+end)/2), divide(lists, (start+end)/2 + 1, end));
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) return null;
        return divide(lists, 0, lists.length-1);
    }

}
