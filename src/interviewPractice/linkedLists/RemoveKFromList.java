package interviewPractice.linkedLists;


// Singly-linked lists are already defined with this interface:
class ListNode<T> {
   ListNode(T x) {
       value = x;
   }
   T value;
   ListNode<T> next;
 }

public class RemoveKFromList {
    ListNode<Integer> removeKFromList(ListNode<Integer> l, int k) {
        ListNode<Integer> head = l;
        ListNode<Integer> prev = null;
        while (l != null) {
            if (l.value == k) {
                if (prev == null) {
                    head = l.next;
                } else {
                    prev.next = l.next;
                }
            } else {
                prev = l;
            }
            l = l.next;
        }
        return head;
    }

    ListNode<Integer> removeKFromList2(ListNode<Integer> l, int k) {
        ListNode<Integer> head = l;
        ListNode<Integer> curr = l;

        if(head == null){
            return null;
        }

        while (head != null && head.value.intValue() == k){
            head = head.next;
            curr = head;
        }

        while(curr != null && curr.next != null){
            if(curr.next.value.intValue() == k){
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }
        return head;
    }
}
