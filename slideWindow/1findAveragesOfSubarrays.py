def find_averages_of_subarrays(K, arr):
  result = []
  for i in range(len(arr)-K+1):
    # find sum of next 'K' elements
    _sum = 0.0
    for j in range(i, i+K):
      _sum += arr[j]
    result.append(_sum/K)  # calculate average

  return result


def main():
  result = find_averages_of_subarrays(5, [1, 3, 2, 6, -1, 4, 1, 8, 2])
  print("Averages of subarrays of size K: " + str(result))


main()


'''
Time complexity: Since for every element of the input array, we are calculating the sum of its next ‘K’ elements, the time complexity of the above algorithm will be O(N*K)
O(N∗K) where ‘N’ is the number of elements in the input array.
'''