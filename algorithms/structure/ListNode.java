package algorithms.structure;

/**
 * @author wuxiaobiao
 * @date 2020-09-27 : 15:16
 */
public class ListNode {

    public int val;
    public ListNode next;
    public ListNode() {}

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val; this.next = next;
    }

    public ListNode(ListNode node) {
        this.val = node.val;
        this.next = node.next;
    }
}
