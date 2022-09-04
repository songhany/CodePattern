// package interview;


// class Node {
//   private final String key;
//   private Integer value;
//   Node next;
  
//   Node(String key, Integer value) {
//     this.key = key;
//     this.value = value;
//   }

//   public String getKey() {
//     return key;
//   }

//   public Integer getValue() {
//     return value;
//   }

//   public void setValue(Integer value) {
//     this.value = value;
//   }
// }


// class HashMap {
//   // field
//   private static final int DEFAULT_CAPACITY = 16;
//   private static final double DEFAULT_LOADFACTOR = 0.75;
//   private int size;
//   private Node[] array;
//   private int capacity;
//   private double loadFactor;

//   // constructors
//   public HashMap() {
//     this.array = new Node[DEFAULT_CAPACITY];
//     this.size = 0;
//     this.loadFactor = DEFAULT_CAPACITY;
//   }

//   public HashMap(int cap, double loadFactor) throws Exception {
//     if (cap <= 0) {
//       throw new Exception("illegal capacity");
//     }
//     this.array = new Node[cap];
//     this.size = 0;
//     this.loadFactor = loadFactor;
//   }

//   public Integer get(Object key) {
//     int index = getIndex(key);
//     Node cur = array[index];
//     while (cur != null) {
//       if (cur.getKey().equals(key)) {
//         return cur.getValue();
//       } else {
//         cur = cur.next;
//       }
//     }
//     return null;
//   }

//   public Integer put(String key, Integer value) {
//     int index = getIndex(key);
//     Node head = array[index];
//     Node current = head;
//     while (current != null) {
//       if (current.getKey().equals(key)) {
//         Integer result = current.getValue();
//         current.setValue(value);
//         return result;
//       }
//       current = current.next;
//     }
//     // reach here: given key not exist
// 		// need insert to the head
//     Node newHead = new Node(key, value);
//     newHead.next = head;
//     array[index] = newHead;  // 更新 head, array[index] is newHead
//     size++;                  // eager computation
//     return null;  // insert operation, return null after insert
//   }

//   public Integer remove(String key) {
//     int index = getIndex(key);
//     Node head = array[index];
//     Node prev = null;
//     while (head != null) {
//       // use head.key
//       if (head.getKey().equals(key)) {
//         // in the midlle or tail
//         if (prev != null) {
//           prev.next = head.next;  // at head
//         } else {
//           array[index] = head.next;  // 更新head就可以完成删除head这个操作
//         }
//         size--;
//         return head.getValue();
//       } else {
//         prev = head;
//         head = head.next;
//       }
//     }
//     return null;
//   }
// }
