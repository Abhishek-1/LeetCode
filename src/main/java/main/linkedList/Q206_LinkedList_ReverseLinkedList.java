package main.linkedList;

import java.util.Stack;
import main.ListNode;

/**
 *
 * Problem - 206
 *
 * Given the head of a singly linked list, reverse the list, and return the reversed list.
 *
 * Input: head = [1,2,3,4,5]
 * Output: [5,4,3,2,1]
 */

public class Q206_LinkedList_ReverseLinkedList {

    /** Using stack **/
    public ListNode reverseList(ListNode head) {

      Stack<ListNode> stack = new Stack<ListNode>();
      ListNode output = new ListNode(0);
      ListNode temp = output;
      while(head != null){
        stack.push(head);
        head = head.next;
      }

      while(!stack.isEmpty()){
        temp.next = stack.pop();
        temp = temp.next;
      }

      temp.next = null;
      return output.next;

    }


    /** Using previous Node approach **/
    public ListNode reverseList_PreviousNode(ListNode head) {

      ListNode prev = null;

      while(head != null){
        ListNode temp = head.next;
        head.next = prev;
        prev = head;
        head = temp;
      }

      return prev;

    }



}
