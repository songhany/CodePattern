package slideWindow;

import java.util.*;

public class LongestSubstringKDistinct {
  public static int findLength(String str, int k) {
    if (str == null || str.length() == 0) {
      throw new IllegalArgumentException();
    }
  
    int windowStart = 0;
    int maxLength = 0;
    Map<Character, Integer> charMap = new HashMap<>();

    // in the following loop we'll try to extend the range [windowStart, windowEnd]
    for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
      char rightChar = str.charAt(windowEnd);
      charMap.put(rightChar, charMap.getOrDefault(rightChar, 0) + 1);
      while (charMap.size() > k) {
        char leftChar = str.charAt(windowStart);
        charMap.put(leftChar, charMap.get(leftChar) - 1);
        if (charMap.get(leftChar) == 0) {
          charMap.remove(leftChar);
        }
        windowStart++;  // shrink the window
      }
      maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
    }

    return maxLength;
  }

  public static void main(String[] args) {
    System.out.println("Length of the longest substring: " + LongestSubstringKDistinct.findLength("araaci", 2));
    System.out.println("Length of the longest substring: " + LongestSubstringKDistinct.findLength("araaci", 1));
    System.out.println("Length of the longest substring: " + LongestSubstringKDistinct.findLength("cbbebi", 3));
  }
}
