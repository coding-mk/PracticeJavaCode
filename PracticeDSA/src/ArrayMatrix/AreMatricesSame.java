//Are Matrices Same ?
/*Problem Description
You are given two matrices A and B of equal dimensions, you have to check whether two matrices are equal or not.
NOTE: Both matrices are equal if A[i][j] == B[i][j] for all i and j.

Problem Constraints:
1 <= A.size(), B.size() <= 1000
1 <= A[i].size(), B[i].size() <= 1000
1 <= A[i][j], B[i][j] <= 1000
A.size() == B.size()
A[i].size() == B[i].size()

Input Format:
First argument is 2-D array of integers representing matrix A.
Second argument is 2-D array of integers representing matrix B.

Output Format:
Return 1 if both matrices are equal or return 0.

Example Input:
Input 1:
A = [[1, 2, 3],
     [4, 5, 6],
     [7, 8, 9]]
B = [[1, 2, 3],
     [4, 5, 6],
     [7, 8, 9]]
Input 2:
A = [[1, 2, 3],
     [4, 5, 6],
     [7, 8, 9]]
B = [[1, 2, 3],
     [7, 8, 9],
     [4, 5, 6]]

Example Output:
Output 1:
1
Output 2:
0

Example Explanation:
Explanation 1:
==> Clearly all the elements of both matrices are equal at respective positions.
Explanation 2:
==> Clearly, there are mismatches at (1, 0), (1, 1), (1, 2), (2, 0), (2, 1) and (2, 2).
A = [[1, 2, 3],
     [4, 5, 6],
     [7, 8, 9]]
B = [[1, 2, 3],
     [7, 8, 9],
     [4, 5, 6]]
*/
package ArrayMatrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AreMatricesSame {
    public static void main(String[] args) {
        List<List<Integer>> A = new ArrayList<>();
        A.add(Arrays.asList(1, 2, 3));
        A.add(Arrays.asList(4, 5, 6));
        A.add(Arrays.asList(7, 8, 9));

        List<List<Integer>> B = new ArrayList<>();
        B.add(Arrays.asList(1, 2, 3));
        B.add(Arrays.asList(4, 5, 6));
        B.add(Arrays.asList(7, 8, 9));

        System.out.println(solve(A, B));
    }

    public static int solve(List<List<Integer>> A, List<List<Integer>> B)
    {
        for (int i = 0; i < A.size(); i++)
        {
            for (int j = 0; j < A.get(0).size(); j++)
            {
                if (A.get(i).get(j) != B.get(i).get(j))
                {
                    return 0;
                }
            }
        }
        return 1;
    }
}
