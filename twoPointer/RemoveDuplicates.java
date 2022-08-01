package twoPointer;

import java.util.Arrays;

class RemoveDuplicates {
  public static String remove(int[] arr) {
    int nextNonDuplicate = 1;  // index of next non-duplicate element
    for (int i = 0; i < arr.length; i++) {
      if (arr[nextNonDuplicate - 1] != arr[i]) {
        arr[nextNonDuplicate] = arr[i];
        nextNonDuplicate++;
      }
    }

    return Arrays.toString(Arrays.copyOfRange(arr, 0, nextNonDuplicate));
  }

  public static void main(String[] args) {
    int[] arr = new int[] { 2, 3, 3, 3, 6, 9, 9 };
    System.out.println(RemoveDuplicates.remove(arr));

    arr = new int[] { 2, 2, 2, 11 };
    System.out.println(RemoveDuplicates.remove(arr));
  }
}
