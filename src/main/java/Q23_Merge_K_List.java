import java.util.PriorityQueue;

/**
 *  Problem - 23
 *
 * You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
 * Merge all the linked-lists into one sorted linked-list and return it.
 *
 *Input: lists = [[1,4,5],[1,3,4],[2,6]]
 * Output: [1,1,2,3,4,4,5,6]
 * Explanation: The linked-lists are:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * merging them into one sorted list:
 * 1->1->2->3->4->4->5->6
 */
public class Q23_Merge_K_List {

  /** Using Priority Queue **/
  public ListNode mergeKLists_PriorityQueue(ListNode[] lists) {

    PriorityQueue<ListNode> queue = new PriorityQueue<>((a, b) -> a.val - b.val);
    ListNode out = new ListNode();
    ListNode temp = out;

    for(ListNode n: lists){

      while(n != null){
        queue.offer(n);
        n = n.next;
      }
    }

    while(!queue.isEmpty()){
      temp.next = queue.remove();
      temp = temp.next;
    }

    temp.next = null;

    return out.next;
  }


  /** Using Divide and Conquer with Recursive **/

  public ListNode mergeKLists(ListNode[] lists) {

    if(lists.length == 0) return null;
    return partition(lists, 0, lists.length-1);
  }

  public ListNode partition(ListNode[] lists, int start, int end){
    if(start == end) return lists[start];
    int mid = (start + end)/2;
    ListNode l1 = partition(lists, start, mid);
    ListNode l2 = partition(lists, mid+1, end);
    return merge(l1, l2);
  }

  public ListNode merge(ListNode l1, ListNode l2){
    if(l1 == null) return l2;
    if(l2 == null) return l1;
    if(l1.val <= l2.val){
      l1.next = merge(l1.next, l2);
      return l1;
    } else {
      l2.next = merge(l1, l2.next);
      return l2;
    }
  }



}
