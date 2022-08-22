package interview;

/*
  Corner Cases:
  1. null || empty string
  2. leading spaces
  3. sign + or -
  4. trailing spaces || other nondigit character
  5. overflow an integer
  6. overflow a long

  1. null, "" -> 0
  2. "  123" -> 123,
  3. "+123" -> 123,  "-123" -> -123,  "+-123" -> 0
  4. "123 1" -> 123,  "123a1" -> 123,  "a123" -> 0,  "+ 123" -> 0
  5. Integer.MAX_VALUE
  6. Integer.MAX_VALUE 

 */

class StringToInt {
  public int myAtoi(String str) {
    if (str == null || str.length() == 0) {  // case 1
      return 0;
    }

    int i = 0;
    while (i < str.length() && str.charAt(i) == ' ') {  // case 2
      i++;
    }

    boolean positive  = true;
    int signNumber = 0;
    while (i < str.length() && (str.charAt(i) == '+' || str.charAt(i) == '-')) {  // case 3
      positive = (str.charAt(i) == '+');
      signNumber += 1;
      i++;
    }
    if (signNumber > 1) {
      return 0;
    }

    long sum = 0;  // because overflow, we have to use 'long' at first
    while (i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9') {  // case 4
      sum = sum * 10 + (str.charAt(i) - '0');
      if (positive && sum > (long)Integer.MAX_VALUE) {
        return Integer.MAX_VALUE;
      }
      if (!positive && -sum < (long)Integer.MIN_VALUE) {
        return Integer.MIN_VALUE;
      }
      i++;   //! very important
    }

    sum = positive ? sum : -sum;
    return (int)sum;
  }

  public static void main(String[] args) {
    StringToInt sol = new StringToInt();
    System.out.println(sol.myAtoi(""));
    System.out.println(sol.myAtoi("+-12"));   // -12 we should return 0
    System.out.println(sol.myAtoi("  123"));
    System.out.println(sol.myAtoi("123  "));
    System.out.println(sol.myAtoi("+123 "));
    System.out.println(sol.myAtoi("-123"));
    System.out.println(sol.myAtoi("+-123"));  // -123 we should return 0
    System.out.println(sol.myAtoi("123 1"));
    System.out.println(sol.myAtoi("123a1"));
    System.out.println(sol.myAtoi("12312387918237498718230087078098908023780127497182374812377410823749182349871238748917234812730418723094718902739412307490"));
  }
}
