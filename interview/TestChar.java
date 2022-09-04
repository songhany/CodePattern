package interview;

class TestChar {
  public static void main(String[] args) {
    int i = 35;
    char c = (char)i;
    System.out.println(c);  // #

    i = 6;   // ascii from 0 to 31 cannot be printed
    c = (char)i;
    System.out.println(c);

    i = 256 + 65;
    c = (char)i;
    System.out.println(c);  // Ł

    i = 256*256 + 65;   // 2^16 = 256*256, 前面的 256*256 会被直接 truncate 掉
    c = (char)i;
    System.out.println(c);  // A

    i = -1000;
    c = (char)i;
    System.out.println(c);  // ﰘ
    long l = (long)(Math.pow(2, 32) - 1000);
    char d = (char)l;
    System.out.println(d);  // ﰘ
    /*
      1000    ->  0000 0000 0000 0000 0011 1110 1000
              ->  1111 1111 1111 1111 1100 0001 0111 (1's complement)
                  +1
     -1000    ->  1111 1111 1111 1111 1100 0001 1000 (2's complement)

      2^32   -> 1 0000 0000 0000 0000 0000 0000 0000
   2^32-1000 -> 1 1111 1111 1111 1111 1100 0001 1000  相当于直接 2^32 + (-1000)
      
      because char in Java is 16bits,  32bits will be truncated to 16bits, that is 1111 1100 0001 1000(binary) = -1000(decimal) 
     */ 

    char c1 = '1';
    char c2 = '2';
    System.out.println(type(c1 + c2));    // class java.lang.Integer
    System.out.println((char)(c1 + c2));  // 'c'

    c1 = '9';
    c2 = '3';
    System.out.println(c1 - c2);  // 6

    char lowercase = 'd';
    System.out.println(toUpperCase(lowercase));  // 'D'
    char uppercase = 'D';
    System.out.println(toLowerCase(uppercase));  // 'd'
  }

  // Convert a lowercase letter to uppercase, 'd' -> 'D' for example
  public static char toUpperCase(char lower) {
    return (char)(lower - 'a' + 'A');
  }

  public static char toLowerCase(char upper) {
    return (char)(upper - 'A' + 'a');
  }

  private static String type(Object a) {
    return a.getClass().toString();
  }
}


