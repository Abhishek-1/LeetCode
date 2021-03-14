package main.linkedList;

import main.ListNode;

/**
 * Problem - 19
 *
 * Given the head of a linked list, remove the nth node from the end of the list and return its head.
 */
public class Q19_LinkedList_RemoveNthNode {

  public ListNode removeNthFromEnd(ListNode head, int n) {

    ListNode pre = head;
    ListNode cur = head;
    while(n > 0 ){
      cur = cur.next;
      n--;
    }

    if(cur == null) return head.next;

    while(cur.next != null){
      cur = cur.next;
      pre = pre.next;
    }

    if(pre.next.next != null){
      pre.next = pre.next.next;
    } else {
      pre.next =null;
    }

    return head;

  }

}
