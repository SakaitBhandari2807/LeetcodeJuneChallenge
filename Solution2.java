class Solution {
    public void deleteNode(ListNode node) {
        ListNode current = node;
        ListNode temp = node.next;
        
        current.val = temp.val;
        current.next = temp.next;
        temp.next = null;
        
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
