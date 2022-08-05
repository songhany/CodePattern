package twoPointer;


class BackspaceCompare {
  public static boolean compare(String str1, String str2) {
    int idx1 = str1.length() - 1;
    int idx2 = str2.length() - 1;
    while (idx1 >= 0 || idx2 >= 0) {
      int i1 = getNextValidCharIndex(str1, idx1);
      int i2 = getNextValidCharIndex(str2, idx2);

      if (i1 < 0 && i2 < 0)  // reached the end of both strings
        return true;

      if (i1 < 0 || i2 < 0)   // reached the end of one of strings
        return false;

      if (str1.charAt(i1) != str2.charAt(i2))  // check if the characters are equal
        return false;

      idx1 = i1 - 1;
      idx2 = i2 - 1;
    }

    return true;
  }
  
  private static int getNextValidCharIndex(String str, int index) {
    int backspaceCount = 0;
    while (index >= 0) {
      if (str.charAt(index) == '#')  // found a backspace character
        backspaceCount++;
      else if (backspaceCount > 0)  // a non-backspace character
        backspaceCount--;
      else
        break;

      index--;  // skip a backspace or a valid character
    }
    return index;
  }

  public static void main(String[] args) {
    System.out.println(BackspaceCompare.compare("xy#z", "xzz#"));
    System.out.println(BackspaceCompare.compare("xy#z", "xyz#"));
    System.out.println(BackspaceCompare.compare("xp#", "xyz##"));    
    System.out.println(BackspaceCompare.compare("xywrrmp", "xywrrmu#p"));
  }
}
