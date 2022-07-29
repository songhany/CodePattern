package slideWindow;

class MinSizeSubArraySum {
  // Time   O(N)
  // Space  O(1)
  private static int findMinSubArray(int S, int[] a) {
    int n = a.length;

    int lengthOfSmallestSubarray = Integer.MAX_VALUE;
    int windowSum = 0;

    int windowStart = 0;
    for(int windowEnd = 0; windowEnd < n; windowEnd++) {
      windowSum += a[windowEnd]; // Add the next element to the window

      while(windowSum >= S) {    // Shrink the window as small as possible until the 'windowSum' is smaller than 'K'
        lengthOfSmallestSubarray = Math.min(lengthOfSmallestSubarray, windowEnd - windowStart + 1);
        windowSum -= a[windowStart];  // Discard the element at 'windowStart' since it is going out of the window
        windowStart++;                // Shrink the window
      }
    }

    return lengthOfSmallestSubarray == Integer.MAX_VALUE ? 0 : lengthOfSmallestSubarray;
  }

  public static void main(String[] args) {
    int result = MinSizeSubArraySum.findMinSubArray(7, new int[] { 2, 1, 5, 2, 3, 2 });
    System.out.println("Smallest subarray length: " + result);
    result = MinSizeSubArraySum.findMinSubArray(8, new int[] { 3, 4, 1, 1, 6 });
    System.out.println("Smallest subarray length: " + result);
    result = MinSizeSubArraySum.findMinSubArray(8, new int[] { 2, 1, 5, 2, 3, 2});
    System.out.println("Smallest subarray length: " + result);
  }
}
