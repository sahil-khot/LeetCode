class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k == 0) {
            return head;
        }

        ListNode temp = head;
        int size = 1;

        while(temp.next != null) {
            temp = temp.next;
            size++;
        }
        temp.next = head;

        k = k % size;
        ListNode temp1 = head;
        for(int i = 1; i < size - k; i++) {
            temp1 = temp1.next;
        }
        ListNode newHead = temp1.next;
        temp1.next = null;

        return newHead;
    }
}