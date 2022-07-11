import math


def smallest_subarray_sum(s, arr):
  min_length = math.inf
  window_sum = 0
  window_start = 0
  for window_end in range(0, len(arr)):
    window_sum += arr[window_end]  # add the next element
    # shrink the window as small as possible until the 'window_sum' is smaller than 's'
    while window_sum >= s:
      min_length = min(min_length, window_end - window_start + 1)
      window_sum -= arr[window_start]
      window_start += 1
    
  if min_length == math.inf:
    return 0

  return min_length


def main():
  print("Smallest subarray length: " + str(smallest_subarray_sum(7, [2, 1, 5, 2, 3, 2])))
  print("Smallest subarray length: " + str(smallest_subarray_sum(8, [3, 4, 1, 1, 6])))
  print("Smallest subarray length: " + str(smallest_subarray_sum(8, [2, 1, 5, 2, 3, 2])))

main()


'''
Time Complexity#
The time complexity of the above algorithm will be O(N). 
The outer for loop runs for all elements, and the inner while loop processes each element only once; therefore, the time complexity of the algorithm will be O(N+N)
, which is asymptotically equivalent to O(N)

Space Complexity#
The algorithm runs in constant space O(1)
'''
