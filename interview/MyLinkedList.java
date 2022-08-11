package interview;

class MyLinkedList {
  ListNode head;
  ListNode tail;

  /** Initialize your data structure here. */
  public MyLinkedList() {
    head = null;
    tail = null;
  }
  
  /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
  public int get(int index) {
    if (index < 0) {
      return -1;
    }
    if (index == 0) {
      return head.val;
    }

    ListNode cur = head;
    while (cur.next != null && index > 0) {
      cur = cur.next;
      index--;
    }
    return cur.val;
  }
  
  /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
  public void addAtHead(int val) {
    ListNode newNode = new ListNode(val);
    if (head == null) {
      head = newNode;
      tail = head;
      return;
    }

    newNode.next = head;
    head = newNode;      
  }
  
  /** Append a node of value val to the last element of the linked list. */
  public void addAtTail(int val) {
    ListNode newNode = new ListNode(val);
    if (head == null) {
      head = newNode;
      tail = head;
      return;
    }
    ListNode cur = head;
    while (cur.next != null) {
      cur = cur.next;
    }
    cur.next = newNode;
    tail = newNode;
  }
  
  /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
  public void addAtIndex(int index, int val) {
    if (index == 0) {
      addAtHead(val);
    }
    ListNode newNode = new ListNode(val);
    ListNode cur = head;
    int curIndex = 0;
    while (curIndex != index - 1) {
      cur = cur.next;
      curIndex++;
    }
    newNode.next = cur.next;
    cur.next = newNode;
  }
  
  /** Delete the index-th node in the linked list, if the index is valid. */
  public void deleteAtIndex(int index) {
    if (index < 0) {
      return;
    }
    if (index == 0) {
      head = tail = null;
      return;
    }
    if (index == 1) {
      head.next = head.next.next;
      return;
    }
    ListNode cur = head;
    while (cur != null && index - 1> 0) {
      cur = cur.next;
      index--;
    }
    if (cur == null) {
      return;
    }
    cur.next = cur.next.next;
  }

  public static void main(String[] args) {
    MyLinkedList linkedList = new MyLinkedList();
    linkedList.addAtHead(1);
    linkedList.addAtTail(3);
    linkedList.addAtIndex(1, 2);  // linked list becomes 1->2->3
    linkedList.get(1);            // returns 2
    linkedList.deleteAtIndex(1);  // now the linked list is 1->3
    linkedList.get(1);            // returns 3
  }
}

class ListNode {
  int val;
  ListNode next;

  public ListNode() {

  }

  public ListNode (int v) {
    val = v;
    next = null;
  }
}


