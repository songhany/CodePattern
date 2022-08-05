package slowfastPointer;

class ListNode {
  int value = 0;
  ListNode next;

  ListNode(int value) {
    this.value = value;
  }
}

class ReorderList {
  public static ListNode reorder(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }

    ListNode mid = findMiddle(head);
    ListNode one = head;
    ListNode two = mid.next;

    mid.next = null;
    
    return merge(one, reverse(two));
  }

  private static ListNode findMiddle(ListNode head) {
    ListNode slow = head;
    ListNode fast = head;
    while (fast.next != null && fast.next.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    return slow;
  }

  private static ListNode reverse(ListNode head) {
    ListNode pre = null;
    while (head != null) {
      ListNode next = head.next;
      head.next = pre;

      pre = head;
      head = next; 
    }
    return pre;
  }

  private static ListNode merge(ListNode one, ListNode two) {
    ListNode dummy = new ListNode(0);
    ListNode cur = dummy;
    while (one != null && two != null) {
      cur.next = one;
      one = one.next;
      cur.next.next = two;
      two = two.next;

      cur = cur.next.next;
    }
    return dummy.next;
  }
  // 2 4 6 8 10 12
  public static void main(String[] args) { 
    ListNode head = new ListNode(2);
    head.next = new ListNode(4);
    head.next.next = new ListNode(6);
    head.next.next.next = new ListNode(8);
    head.next.next.next.next = new ListNode(10);
    head.next.next.next.next.next = new ListNode(12);
    ReorderList.reorder(head);
    while (head != null) {
      System.out.print(head.value + " ");
      head = head.next;
    }
  }
}
