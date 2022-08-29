package interview;

import java.util.*;

class Cell {
  int aIdx;
  int bIdx;
  public Cell(int idx1, int idx2) {
      aIdx = idx1;
      bIdx = idx2;
  }
}

class KSmallestPairs {
  public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
    PriorityQueue<Cell> minheap = new PriorityQueue<>(k, new Comparator<Cell>() {
        public int compare(Cell c1, Cell c2) {
            int sum1 = nums1[c1.aIdx] + nums2[c1.bIdx];
            int sum2 = nums1[c2.aIdx] + nums2[c2.bIdx];
            if (sum1 == sum2) {
                return 0;
            }
            return sum1 < sum2 ? -1 : 1;
        }
    });
    
    List<List<Integer>> result = new ArrayList<>();
    boolean[][] visited = new boolean[nums1.length][nums2.length];
    visited[0][0] = true;
    minheap.offer(new Cell(0, 0));
    
    for(int i = 0; i < k; i++) {
      if (minheap.peek() == null) {
        break;
      }
      Cell temp = minheap.poll();
      System.out.printf("poll %d\n", nums1[temp.aIdx] + nums2[temp.bIdx]);
      List<Integer> oneResult = new ArrayList<>(Arrays.asList(nums1[temp.aIdx], nums2[temp.bIdx]));
      result.add(oneResult);
      
      if (temp.aIdx + 1 < nums1.length && !visited[temp.aIdx + 1][temp.bIdx]) {
          visited[temp.aIdx + 1][temp.bIdx] = true;
          minheap.offer(new Cell(temp.aIdx + 1, temp.bIdx));
          System.out.printf("offer %d\n", nums1[temp.aIdx + 1] + nums2[temp.bIdx]);
      }
      if (temp.bIdx + 1 < nums2.length && !visited[temp.aIdx][temp.bIdx + 1]) {
          visited[temp.aIdx][temp.bIdx + 1] = true;
          minheap.offer(new Cell(temp.aIdx, temp.bIdx + 1));
          System.out.printf("offer %d\n", nums1[temp.aIdx] + nums2[temp.bIdx + 1]);
      }
    }
    
    return result;
  }


  public List<List<Integer>> kSmallestPairs1(int[] nums1, int[] nums2, int k) {
    PriorityQueue<Cell> minheap = new PriorityQueue<>(k, new Comparator<Cell>() {
        public int compare(Cell c1, Cell c2) {
            int sum1 = nums1[c1.aIdx] + nums2[c1.bIdx];
            int sum2 = nums1[c2.aIdx] + nums2[c2.bIdx];
            if (sum1 == sum2) {
                return 0;
            }
            return sum1 < sum2 ? -1 : 1;
        }
    });
    
    List<List<Integer>> result = new ArrayList<>();
    // boolean[][] visited = new boolean[nums1.length][nums2.length];  // use HashSet to optimize space complexity
    // visited[0][0] = true;
    Set<Cell> set = new HashSet<>();
    Cell c1 = new Cell(0, 0);
    set.add(c1);
    minheap.offer(c1);
    
    for(int i = 0; i < k; i++) {
        if (minheap.peek() == null) {
            break;
        }
        Cell temp = minheap.poll();
        System.out.printf("poll %d\n", nums1[temp.aIdx] + nums2[temp.bIdx]);
        result.add(new ArrayList<>(Arrays.asList(nums1[temp.aIdx], nums2[temp.bIdx])));
        if (temp != null && temp.aIdx + 1 < nums1.length && !set.contains(new Cell(temp.aIdx + 1, temp.bIdx))) {
            // visited[temp.aIdx + 1][temp.bIdx] = true;
            c1 = new Cell(temp.aIdx + 1, temp.bIdx);
            set.add(c1);
            minheap.offer(c1);
            System.out.printf("offer %d\n", nums1[temp.aIdx + 1] + nums2[temp.bIdx]);
        }
        if (temp != null && temp.bIdx + 1 < nums2.length && !set.contains(new Cell(temp.aIdx, temp.bIdx + 1))) {
            // visited[temp.aIdx][temp.bIdx + 1] = true;
            c1 = new Cell(temp.aIdx, temp.bIdx + 1);
            set.add(c1);
            minheap.offer(c1);
            System.out.printf("offer %d\n", nums1[temp.aIdx] + nums2[temp.bIdx + 1]);
        }
    }
    
    return result;
}

  public static void main(String[] args) {
    KSmallestPairs sol = new KSmallestPairs();
    List<List<Integer>> res = sol.kSmallestPairs(new int[]{1, 7, 11}, new int[]{2, 4, 6}, 3);
    // System.out.println(res);

    // res = sol.kSmallestPairs(new int[]{1, 2}, new int[]{3}, 3);
    // System.out.println(res);

    // res = sol.kSmallestPairs1(new int[]{1, 7, 11}, new int[]{2, 4, 6}, 3);
    // System.out.println(res);

    res = sol.kSmallestPairs1(new int[]{1, 1, 2}, new int[]{1, 2, 3}, 10);  // [[1,1],[1,1],[2,1],[1,2],[1,2],[2,2],[1,3],[1,3],[2,3]]
    System.out.println(res);
  }
}
