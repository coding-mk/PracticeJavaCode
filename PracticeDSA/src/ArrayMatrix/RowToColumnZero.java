//Row To Column Zero
/*Problem Description
You are given a 2D integer matrix A, make all the elements in a row or column zero if the A[i][j] = 0. Specifically, make entire ith row and jth column zero.

Problem Constraints
1 <= A.size() <= 103
1 <= A[i].size() <= 103
0 <= A[i][j] <= 103

Input Format
First argument is a 2D integer matrix A.

Output Format
Return a 2D matrix after doing required operations.

Example Input:
Input 1
[1,2,3,4]
[5,6,7,0]
[9,2,0,4]

Example Output:
Output 1:
[1,2,0,0]
[0,0,0,0]
[0,0,0,0]

Example Explanation:
Explanation 1:
A[2][4] = A[3][3] = 0, so make 2nd row, 3rd row, 3rd column and 4th column zero.
 */
package ArrayMatrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RowToColumnZero {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> A = new ArrayList<>();
        A.add(new ArrayList<>(Arrays.asList(1,2,3,4)));
        A.add(new ArrayList<>(Arrays.asList(5,6,7,0)));
        A.add(new ArrayList<>(Arrays.asList(9,2,0,4)));

        ArrayList<ArrayList<Integer>> ans = solve(A);
        for (List<Integer> i : ans) {
            for(Integer j : i){
                System.out.print(j + "  ");
            }
            System.out.println();
        }
    }

    public static ArrayList<ArrayList<Integer>> solve(ArrayList<ArrayList<Integer>> A) {
        ArrayList<Integer> row = new ArrayList<>();
        ArrayList<Integer> col = new ArrayList<>();
        int R=A.size();
        int C=A.get(0).size();
        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                if(A.get(i).get(j)==0){
                    row.add(i);
                    col.add(j);
                }
            }
        }

        for(int r:row){
            for(int i=0;i<C;i++){
                A.get(r).set(i,0);
            }
        }

        for(int c:col){
            for(int i=0;i<R;i++){
                A.get(i).set(c,0);
            }
        }

        return(A);
    }
}
