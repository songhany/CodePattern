package slideWindow;

import java.util.*;

class StringAnagrams {
  public static List<Integer> findStringAnagrams(String str, String pattern) {
    int matched = 0;
    int windowStart = 0;
    Map<Character, Integer> charFrequencyMap = new HashMap<>();
    for (char chr : pattern.toCharArray()) {
      charFrequencyMap.put(chr, charFrequencyMap.getOrDefault(chr, 0) + 1);
    }

    List<Integer> resultIndices = new ArrayList<Integer>();
    // our goal is to match all the characters from the map with the current window
    for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
      char rightChar = str.charAt(windowEnd);
      // decrement the frequency of the matched character
      if (charFrequencyMap.containsKey(rightChar)) {
        charFrequencyMap.put(rightChar, charFrequencyMap.get(rightChar) - 1);
        if (charFrequencyMap.get(rightChar) == 0)
          matched++;
      }

      if (matched == charFrequencyMap.size()) // Have we found an anagram?
        resultIndices.add(windowStart);

      
      if (windowEnd >= pattern.length() - 1) { // shrink the slide window
        char leftChar = str.charAt(windowStart++);
        if (charFrequencyMap.containsKey(leftChar)) {
          if (charFrequencyMap.get(leftChar) == 0) {
            matched--; // before putting the character back, decrement the matched count
          }
          charFrequencyMap.put(leftChar, charFrequencyMap.get(leftChar) + 1); // put the character back
        }
      }
    }
    
    return resultIndices;
  }

  public static void main(String[] args) {
    System.out.println(StringAnagrams.findStringAnagrams("ppqp", "pq"));
    System.out.println(StringAnagrams.findStringAnagrams("abbcabc", "abc"));
  }
}
