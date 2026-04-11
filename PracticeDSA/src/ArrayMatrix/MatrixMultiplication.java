//Matrix Multiplication
/*Problem Description
You are given two integer matrices A(having M X N size) and B(having N X P). You have to multiply matrix A with B and return the resultant matrix. (i.e. return the matrix AB).
Matrix Multiplication

Problem Constraints:
1 <= M, N, P <= 100
-100 <= A[i][j], B[i][j] <= 100

Input Format:
The first argument given is the 2-D integer matrix A.
The second argument given is the 2-D integer matrix B.

Output Format:
Return a 2D integer matrix denoting AB.

Example Input:
Input 1:
A = [[1, 2],
     [3, 4]]
B = [[5, 6],
     [7, 8]]
Input 2:
A = [[1, 1]]
B = [[2],
     [3]]

Example Output:
Output 1:
 [[19, 22],
  [43, 50]]
Output 2:
 [[5]]
 */
package ArrayMatrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MatrixMultiplication {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> A = new ArrayList<>();
        A.add(new ArrayList<>(Arrays.asList(1, 2)));
        A.add(new ArrayList<>(Arrays.asList(3, 4)));

        ArrayList<ArrayList<Integer>> B = new ArrayList<>();
        B.add(new ArrayList<>(Arrays.asList(5, 6)));
        B.add(new ArrayList<>(Arrays.asList(7, 8)));

        ArrayList<ArrayList<Integer>> ans = solve(A,B);

        for (List<Integer> i : ans) {
            for(Integer j : i){
                System.out.print(j + "  ");
            }
            System.out.println();
        }
    }

    public static ArrayList<ArrayList<Integer>> solve(ArrayList<ArrayList<Integer>> A, ArrayList<ArrayList<Integer>> B) {
        ArrayList<ArrayList<Integer>> mulMatrix = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> row = new ArrayList<Integer>();
        int sum=0;
        for(int i=0;i<A.size();i++){
            row = new ArrayList<Integer>();
            for(int j=0;j<B.get(0).size();j++){
                sum=0;
                for(int k=0;k<A.get(0).size();k++){
                    sum+=A.get(i).get(k)*B.get(k).get(j);
                }
                row.add(sum);
            }
            mulMatrix.add(row);
        }
        return(mulMatrix);
    }
}
