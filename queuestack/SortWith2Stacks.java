package queuestack;

import java.util.*;

// stack1 (input) [
// stack2 (resule | buffer) [
public class SortWith2Stacks {
  public void sort(LinkedList<Integer> s1) {
    if (s1 == null || s1.size() <= 1) {
      return;
    }
    LinkedList<Integer> s2 = new LinkedList<>();
    sort(s1, s2);
  }

  private void sort(Deque<Integer> stack1, Deque<Integer> stack2) {
    while (!stack1.isEmpty()) {
      int curMin = Integer.MAX_VALUE;
      int count = 0;

      while (!stack1.isEmpty()) {
        int cur = stack1.pollFirst();
        if (cur < curMin) {
          curMin = cur;
          count = 1;
        } else if (cur == curMin) {  // duplicated curMin number
          count++;
        }
        stack2.offerFirst(cur);
      }

      while (!stack2.isEmpty() && stack2.peekFirst() >= curMin) { // 从 stack2 只往 stack1 里放大于 curMin 的元素, 小于curMin的元素留在stack2里作为result 不会被poll
        int tmp = stack2.pollFirst();
        if (tmp != curMin) {
          stack1.offerFirst(tmp);
        }
      }

      while (count > 0) { // 往 stack2 里放 duplicated curMin
        stack2.offerFirst(curMin);
        count--;
      }
    }

    // 把已经排好序的元素从 stack2 放到 stack1（input）里，使得 stack1 里是 ascending order
    while (!stack2.isEmpty()) {
      stack1.offerFirst(stack2.pollFirst());
    }
  }

  public static void main(String[] args) {
    SortWith2Stacks sol = new SortWith2Stacks();
    LinkedList<Integer> stack1 = new LinkedList<>(Arrays.asList(6, 3, 2, 3, 2, 1, 9));
    sol.sort(stack1);
    System.out.println(stack1);
  }
}
