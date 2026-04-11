//Matrix Subtraction
/*Problem Description
You are given two integer matrices A and B having same size (Both having same number of rows (N) and columns (M)). You have to subtract matrix B from A and return the resultant matrix. (i.e. return the matrix A - B).
If A and B are two matrices of the same order (same dimensions). Then A - B is a matrix of the same order as A and B and its elements are obtained by doing an element wise subtraction of A from B.

Problem Constraints:
1 <= N, M <= 103
-109 <= A[i][j], B[i][j] <= 109

Input Format:
The first argument is the 2D integer array A
Second argument is the 2D integer array B

Output Format:
Return a 2D matrix denoting A - B.

Example Input:
Input 1:
A =  [[1, 2, 3],
      [4, 5, 6],
      [7, 8, 9]]

B =  [[9, 8, 7],
      [6, 5, 4],
      [3, 2, 1]]
Input 2:
A = [[1, 1]]
B = [[2, 3]]

Example Output:
Output 1:
 [[-8, -6, -4],
  [-2, 0, 2],
  [4, 6, 8]]
Output 2:
 [[-1, -2]]

Example Explanation
Explanation 1:
Explanation 2:
 [[1, 1]] - [[2, 3]] = [[1 - 2, 1 - 3]] = [[-1, -2]]
*/
package ArrayMatrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MatrixSubtraction {
    public static void main(String[] args) {
        List<List<Integer>> A = new ArrayList<>();
        A.add(Arrays.asList(1, 2, 3));
        A.add(Arrays.asList(4, 5, 6));
        A.add(Arrays.asList(7, 8, 9));

        List<List<Integer>> B = new ArrayList<>();
        B.add(Arrays.asList(1, 2, 3));
        B.add(Arrays.asList(4, 5, 6));
        B.add(Arrays.asList(7, 8, 9));

        List<List<Integer>> ans = solve(A,B);
        for (List<Integer> i : ans) {
            for(Integer j : i){
                System.out.print(j + "  ");
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> solve(List<List<Integer>> A, List<List<Integer>> B) {
        List<List<Integer>> addArray = new ArrayList<>();
        int num;
        for(int i=0;i<A.size();i++){
            List<Integer> arr = new ArrayList<>();
            for(int j=0;j<A.get(i).size();j++){
                num=A.get(i).get(j)-B.get(i).get(j);
                arr.add(num);
            }
            addArray.add(arr);
        }
        return(addArray);
    }
}
