def find_permutation(str1, pattern):
  window_start, matched = 0, 0
  char_frequency = {}

  for chr in pattern:
    if chr not in char_frequency:
      char_frequency[chr] = 0
    char_frequency[chr] += 1

  # our goal is to match all the characters from the 'char_frequency' with the current window
  # try to extend the range [window_start, window_end]
  for window_end in range(len(str1)):
    right_char = str1[window_end]
    if right_char in char_frequency:
      # decrement the frequency of matched character
      char_frequency[right_char] -= 1
      if char_frequency[right_char] == 0:
        matched += 1

    if matched == len(char_frequency):
      return True

    # shrink the window by one character
    if window_end >= len(pattern) - 1:
      left_char = str1[window_start]
      window_start += 1
      if left_char in char_frequency:
        if char_frequency[left_char] == 0:
          matched -= 1
        char_frequency[left_char] += 1

  return False


def main():
  print('Permutation exist: ' + str(find_permutation("oidbcaf", "abc")))
  print('Permutation exist: ' + str(find_permutation("odicf", "dc")))
  print('Permutation exist: ' + str(find_permutation("bcdxabcdy", "bcdyabcdx")))
  print('Permutation exist: ' + str(find_permutation("aaacb", "abc")))


main()


'''
Time  O(N + M), where ‘N’ and ‘M’ are the number of characters in the input string and the pattern, respectively.
Space O(M)
'''


# My First Answer below
def find_permutation(str1, pattern):
  window_start = 0
  frequency_map = {}
  pattern_map = {}
  
  for char in pattern:
    if char not in pattern_map:
      pattern_map[char] = 0
    pattern_map[char] += 1

  for window_end in range(len(str1)):
    right_char = str1[window_end]
    if right_char not in frequency_map:
      frequency_map[right_char] = 0
    frequency_map[right_char] += 1

    if (window_end - window_start + 1) == len(pattern):
      if pattern_map == frequency_map:
        return True

    if (window_end - window_start + 1) >= len(pattern):  # keep size_window == len(pattern)  滑动窗口的大小要等于pattern的大小
      left_char = str1[window_start]
      frequency_map[left_char] -= 1
      if frequency_map[left_char] == 0:
        del frequency_map[left_char]
      window_start += 1
  
  return False


# find_permutation('oidbcaf', 'abc')