def find_string_anagrams(str1, pattern):
  window_start, matched = 0, 0
  char_frequency = {}

  for chr in pattern:
    if chr not in char_frequency:
      char_frequency[chr] = 0
    char_frequency[chr] += 1

  result_indices = []
  # Our goal is to match all the characters from the 'char_frequency' with the current window
  # try to extend the range [window_start, window_end]
  for window_end in range(len(str1)):
    right_char = str1[window_end]
    if right_char in char_frequency:
      # Decrement the frequency of matched character
      char_frequency[right_char] -= 1
      if char_frequency[right_char] == 0:
        matched += 1

    if matched == len(char_frequency):  # Have we found an anagram?
      result_indices.append(window_start)

    # Shrink the sliding window
    if window_end >= len(pattern) - 1:
      left_char = str1[window_start]
      window_start += 1
      if left_char in char_frequency:
        if char_frequency[left_char] == 0:
          matched -= 1    # Before putting the character back, decrement the matched count
        char_frequency[left_char] += 1  # Put the character back

  return result_indices


def main():
  print(find_string_anagrams("ppqp", "pq"))
  print(find_string_anagrams("abbcabc", "abc"))


main()


'''
Time  O(N + M), where ‘N’ and ‘M’ are the number of characters in the input string and the pattern, respectively.
Space O(M) since in the worst case, the whole pattern can have distinct characters which will go into the HashMap. In the worst case, we also need O(N) space for the result list, this will happen when the pattern has only one character and the string contains only that character.
'''



# My First Answer below (Worse Space)
def find_permutation(str1, pattern):
  result_indexes = []
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
        result_indexes.append(window_start)

    if (window_end - window_start + 1) >= len(pattern):  # keep size_window == len(pattern)
      left_char = str1[window_start]
      frequency_map[left_char] -= 1
      if frequency_map[left_char] == 0:
        del frequency_map[left_char]
      window_start += 1
  
  return result_indexes