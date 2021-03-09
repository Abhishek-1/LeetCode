import java.util.PriorityQueue;

/**
 * Problem - 21
 *
 *Merge two sorted linked lists and return it as a sorted list. The list should be made by splicing together the nodes of the first two lists.
 *
 * Input: l1 = [1,2,4], l2 = [1,3,4]
 * Output: [1,1,2,3,4,4]
 */
public class Q21_Merge2_Sorted_List {

  /** Using Priority Queue **/
  public ListNode mergeTwoLists_PriorityQueue(ListNode l1, ListNode l2) {

    if(l1 == null) return l2;
    if(l2 == null) return l1;

    PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> a.val - b.val);
    ListNode out = new ListNode();
    ListNode temp = out;

    while(l1 != null){
      pq.offer(l1);
      l1 = l1.next;
    }

    while(l2 != null){
      pq.offer(l2);
      l2 = l2.next;
    }

    while(!pq.isEmpty()){
      temp.next = pq.remove();
      temp = temp.next;
    }

    temp.next = null;

    return out.next;

  }

  /** Using Recursion **/
  public ListNode mergeTwoLists_Recursion(ListNode l1, ListNode l2) {

    if(l1 == null)
      return l2;

    if(l2 == null)
      return l1;

    if(l1.val <= l2.val){
      l1.next = mergeTwoLists_Recursion(l1.next, l2);
      return l1;
    } else {
      l2.next = mergeTwoLists_Recursion(l1, l2.next);
      return l2;
    }

  }

}
