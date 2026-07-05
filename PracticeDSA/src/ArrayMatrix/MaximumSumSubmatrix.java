//Maximum Sum Submatrix
/*Problem Description

Given a N * M 2D matrix A. Find the maximum sum sub-matrix from the matrix A. Return the Sum.


Problem Constraints

1 <= N, M <= 300
-104 <= A[i][j] <= 104


Input Format

The first argument is a 2D Integer array A.


Output Format

Return the sum of the maximum sum sub-matrix from matrix A.


Example Input

Input 1:-
    -6 -6
   -29 -8
A =  3 -8
   -15  2
    25 25
    20 -5
Input 2:-
A = -17 -2
     20 10


Example Output

Output 1:-
65
Output 2:-
30


Example Explanation

Explanation 1:-
The submatrix 
25 25
20 -5
has the highest submatrix sum 65.
Explanation 2:-
The submatrix 
20 10
has the highest sub matrix sum 30.
 */
package ArrayMatrix;
import java.util.ArrayList;


public class MaximumSumSubmatrix {
  public static void main(String[] args) {
    int[][] A = new int[][]{{-6,-6},{-29,-8},{3,-8},{-15 ,2},{25,25},{20,-5}};
     System.out.println(solve(A));
  }

  public static int kadane(ArrayList<Integer> v)
    {
        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < (int)v.size(); i++) {
            currSum += v.get(i);
            if (currSum > maxSum) {
                maxSum = currSum;
            }
     
            if (currSum < 0) {
                currSum = 0;
            }
        }
        return maxSum;
    }
    public static int solve(int[][] A) {
        int r = A.length;
        int c = A[0].length;
        int prefix[][] = new int[r][c];
        for(int i=0 ; i<r ; i++){
            for(int j=0 ; j<c ; j++){
                if(j==0)
                    prefix[i][j] = A[i][j];
                else
                    prefix[i][j] = A[i][j] + prefix[i][j - 1];
            }
        }
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < c; i++) {
            for (int j = i; j < c; j++) {
                ArrayList<Integer>v = new ArrayList(); 
                for (int k = 0; k < r; k++) {
                    int el = 0;
                    if (i == 0)
                        el = prefix[k][j];
                    else
                        el = prefix[k][j] - prefix[k][i - 1];
                    v.add(el);
                }
                maxSum = Math.max(maxSum, kadane(v));
            }
        }
        return maxSum;
    }
}
