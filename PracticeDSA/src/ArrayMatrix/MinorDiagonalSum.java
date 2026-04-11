//Minor Diagonal Sum
/*Problem Description
You are given  N X N integer matrix. You have to find the sum of all the minor diagonal elements of A.
Minor diagonal of  M X M matrix A is a collection of elements A[i, j] such that i + j = M + 1 (where i, j are 1-based).

Problem Constraints:
1 <= N <= 103
-1000 <= A[i][j] <= 1000

Input Format:
First and only argument is a 2D integer matrix A.

Output Format:
Return an integer denoting the sum of minor diagonal elements.

Example Input:
Input 1:
 A = [[1, -2, -3],
      [-4, 5, -6],
      [-7, -8, 9]]
Input 2:
 A = [[3, 2],
      [2, 3]]

Example Output:
Output 1:
 -5
Output 2:
 4

Example Explanation:
Explanation 1:
 A[1][3] + A[2][2] + A[3][1] = (-3) + 5 + (-7) = -5
Explanation 2:
 A[1][2] + A[2][1] = 2 + 2 = 4
*/
package ArrayMatrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinorDiagonalSum {
    public static void main(String[] args) {
        List<List<Integer>> A = new ArrayList<>();
        A.add(Arrays.asList(1, 2, 3));
        A.add(Arrays.asList(4, 5, 6));
        A.add(Arrays.asList(7, 8, 9));

        System.out.println(solve(A));
    }

    public static int solve(List<List<Integer>> A)
    {
        int i = 0, j = A.get(0).size() - 1, sum = 0;
        while (i < A.size())
        {
            sum += A.get(i).get(j);
            i++;
            j--;
        }
        return sum;
    }
}
