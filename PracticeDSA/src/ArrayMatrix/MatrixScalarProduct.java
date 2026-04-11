//Matrix Scalar Product
/*Problem Description
You are given a matrix A and and an integer B, you have to perform scalar multiplication of matrix A with an integer B.

Problem Constraints:
1 <= A.size() <= 1000
1 <= A[i].size() <= 1000
1 <= A[i][j] <= 1000
1 <= B <= 1000

Input Format:
First argument is 2D array of integers A representing matrix.
Second argument is an integer B.

Output Format
You have to return a 2D array of integers after doing required operations.

Example Input:
Input 1:
A = [[1, 2, 3],
     [4, 5, 6],
     [7, 8, 9]]
B = 2
Input 2:
A = [[1]]
B = 5

Example Output:
Output 1:
[[2, 4, 6],
[8, 10, 12],
[14, 16, 18]]
Output 2:
[[5]]

Example Explanation:
Explanation 1:
==> ( [[1, 2, 3],[4, 5, 6],[7, 8, 9]] ) * 2
==> [[2*1, 2*2, 2*3],
     [2*4, 2*5, 2*6],
     [2*7, 2*8, 2*9]]
==> [[2,   4,  6],
     [8,  10, 12],
     [14, 16, 18]]
Explanation 2:
==> ( [[1]] ) * 5
==> [[5*1]]
==> [[5]]
*/
package ArrayMatrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MatrixScalarProduct {
    public static void main(String[] args) {
        List<List<Integer>> A = new ArrayList<>();
        A.add(Arrays.asList(1, 2, 3));
        A.add(Arrays.asList(4, 5, 6));
        A.add(Arrays.asList(7, 8, 9));
        int B = 2;
        List<List<Integer>> ans = solve(A,B);
        for (List<Integer> i : ans) {
            for(Integer j : i){
                System.out.print(j + "  ");
            }
            System.out.println();
        }

    }

    public static List<List<Integer>> solve(List<List<Integer>> A, int B)
    {
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < A.size(); i++)
        {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < A.get(0).size(); j++)
            {
                row.add(A.get(i).get(j) * B);
            }
            ans.add(row);
        }
        return ans;
    }
}
