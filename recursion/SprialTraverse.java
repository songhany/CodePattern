package recursion;

import java.util.*;

public class SprialTraverse {
    public List<Integer> sprial(int[][] matrix) {
        List<Integer> list = new ArrayList<Integer>();
        int m = matrix.length;
        if (m == 0) {
            return list;
        }
        int n = matrix[0].length;
        int up = 0;
        int down = m - 1;
        int left = 0;
        int right = n - 1;
        while (left < right && up < down) {
            for (int i = left; i <= right; i++) {
                list.add(matrix[up][i]);
            }
            for (int i = up + 1; i <= down - 1; i++) {
                list.add(matrix[i][right]);
            }
            for (int i = right; i >= left; i--) {
                list.add(matrix[down][i]);
            }
            for (int i = down - 1; i >= up + 1; i--) {
                list.add(matrix[i][left]);
            }
            up++;
            down--;
            left++;
            right--;
        }
    
        // base case:
        // 1. if there is nothing left.
        if (left > right || up > down) {
            return list;
        }
    
        // 2. if there is one column left.
        if (left == right) {
            for (int i = up; i <= down; i++) {
                list.add(matrix[i][left]);
            }
        } else {
            // 3. if there is one row left.
            for (int i = left; i <= right; i++) {
                list.add(matrix[up][i]);
            }
        }
        return list;
    }

    // 1 2
    // 3 4 
    // 5 6
    public static void main(String[] args) {
        SprialTraverse sol = new SprialTraverse();
        System.out.println(sol.sprial(new int[][]{{1, 2}, {3, 4}, {5, 6}}));
    }
}
