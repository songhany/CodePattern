package slideWindow;

import java.util.*;

public class StringPermutation {
  public static boolean findPermutation(String str, String pattern) {
    int matched = 0;
    int windowStart = 0;
    Map<Character, Integer> charMap = new HashMap<>();
    for (char chr : pattern.toCharArray()) {
      charMap.put(chr, charMap.getOrDefault(chr, 0) + 1);
    }

    // our goal is to match all the characters from the 'charMap' with the current window
    // try to extend the range [windowStart, windowEnd]
    for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
      char rightChar = str.charAt(windowEnd);
      if (charMap.containsKey(rightChar)) {
        charMap.put(rightChar, charMap.get(rightChar) - 1);
        if (charMap.get(rightChar) == 0) // character is completely matched
          matched++;
      }

      if (matched == charMap.size())
        return true;

      if (windowEnd >= pattern.length() - 1) { // shrink the window by one character
        char leftChar = str.charAt(windowStart++);
        if (charMap.containsKey(leftChar)) {
          if (charMap.get(leftChar) == 0)
            matched--;  // before putting the character back, decrement the matched count
          // put the character back for matching
          charMap.put(leftChar, charMap.get(leftChar) + 1);
        }
      }
    }

    return false;
  }
}
