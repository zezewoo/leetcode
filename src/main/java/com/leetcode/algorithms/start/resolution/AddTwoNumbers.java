package com.leetcode.algorithms.start.resolution;


import com.leetcode.algorithms.start.resolution.collections.ListNode;

import java.util.List;


public class AddTwoNumbers {


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return resolution(l1, l2, 0);
    }


    private ListNode resolution(ListNode n1, ListNode n2, int in) {
        ListNode listNode = null;
        int val;
        int nextIn;
        if (n1 == null && n2 == null) {
            if (in != 0) {
                listNode = new ListNode(in);
                return listNode;
            } else {
                return null;
            }
        }

        if (n1 == null && n2 != null) {
            val = (n2.val + in)%10;
            nextIn = (n2.val + in)/10;
            listNode = new ListNode(val);
            listNode.next = resolution(null, n2.next, nextIn);
        }

        if (n1 != null && n2 == null) {
            val = (n1.val + in)%10;
            nextIn = (n1.val + in)/10;
            listNode = new ListNode(val);
            listNode.next = resolution(n1.next, null, nextIn);
        }


        if (n1 != null && n2 != null) {
            val = (n1.val + n2.val + in)%10;
            nextIn = (n1.val + n2.val + in)/10;
            listNode = new ListNode(val);
            listNode.next = resolution(n1.next, n2.next, nextIn);
        }

        return listNode;
    }


    @Deprecated
    private Integer resolveInteger(ListNode listNode, Integer i) {

        if (listNode == null) {
            return i;
        }

        i = i*10 + listNode.val;
        return resolveInteger(listNode.next, i);
    }

    @Deprecated
    private ListNode generateList(Integer i, ListNode next) {

        int val = i%10;
        ListNode listNode = new ListNode(val);
        listNode.next = next;

        if (i > 10) {
            return generateList(i/10, listNode);
        }
        return listNode;
    }


    public static void main(String[] args) {

        ListNode a1 = new ListNode(2);
        ListNode a2 = new ListNode(4);
        ListNode a3 = new ListNode(3);

        a1.next = a2;
        a2.next = a3;

        ListNode b1 = new ListNode(5);
        ListNode b2 = new ListNode(6);
        ListNode b3 = new ListNode(4);

        b1.next = b2;
        b2.next = b3;

        ListNode listNode = new AddTwoNumbers().addTwoNumbers(a1, b1);

    }

}
