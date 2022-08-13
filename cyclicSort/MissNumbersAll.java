package cyclicSort;

import java.util.*;

class MissNumbersAll {
  public static List<Integer> findNumbers(int[] nums) {
    int i = 0;
    while (i < nums.length) {
      if (nums[i] != nums[nums[i] - 1])
        swap(nums, i, nums[i] - 1);
      else
        i++;
    }

    List<Integer> missingNumbers = new ArrayList<>();
    for (i = 0; i < nums.length; i++) {
      if (nums[i] != i + 1)
        missingNumbers.add(i + 1);
    }

    return missingNumbers;
  }

  private static void swap(int[] arr, int i, int j) {
    int tmp = arr[i];
    arr[i] = arr[j];
    arr[j] = tmp;
  }

  public static void main(String[] args) {
    List<Integer> missing = MissNumbersAll.findNumbers(new int[] { 2, 3, 1, 8, 2, 3, 5, 1 });
    System.out.println("Missing numbers: " + missing);

    missing = MissNumbersAll.findNumbers(new int[] { 2, 4, 1, 2 });
    System.out.println("Missing numbers: " + missing);

    missing = MissNumbersAll.findNumbers(new int[] { 2, 3, 2, 1 });
    System.out.println("Missing numbers: " + missing);
  }
}
