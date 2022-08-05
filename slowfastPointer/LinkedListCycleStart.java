package slowfastPointer;

class ListNode {
  int value = 0;
  ListNode next;

  ListNode(int value) {
    this.value = value;
  }
}

public class LinkedListCycleStart {
  public static ListNode findCycleStart(ListNode head) {
    int cycleLength = 0;
    // find the LinkedList cycle
    ListNode slow = head;
    ListNode fast = head;
    while (fast != null && fast.next != null) {
      fast = fast.next.next;
      slow = slow.next;
      if (slow == fast) { // found the cycle
        cycleLength = calculateCycleLength(slow);
        break;
      }
    }

    return findStart(head, cycleLength);
  }

  private static int calculateCycleLength(ListNode slow) {
    ListNode current = slow;
    int cycleLength = 0;
    do {
      current = current.next;
      cycleLength++;
    } while (current != slow);
    
    return cycleLength;
  }

  private static ListNode findStart(ListNode head, int cycleLength) {
    ListNode pointer1 = head;
    ListNode pointer2 = head;
    while (cycleLength > 0) {
      pointer2 = pointer2.next;
      cycleLength--;
    }

    while (pointer1 != pointer2) {
      pointer1 = pointer1.next;
      pointer2 = pointer2.next;
    }
    
    return pointer1;
  }
}
