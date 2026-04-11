//Column Sum
/*Problem Description
You are given a 2D integer matrix A, return a 1D integer array containing column-wise sums of original matrix.

Problem Constraints
1 <= A.size() <= 103
1 <= A[i].size() <= 103
1 <= A[i][j] <= 103

Input Format:
First argument is a 2D array of integers.(2D matrix).

Output Format:
Return an array containing column-wise sums of original matrix.

Example Input:
Input 1:
[1,2,3,4]
[5,6,7,8]
[9,2,3,4]

Example Output:
Output 1:
{15,10,13,16}

Example Explanation:
Explanation 1
Column 1 = 1+5+9 = 15
Column 2 = 2+6+2 = 10
Column 3 = 3+7+3 = 13
Column 4 = 4+8+4 = 16
*/
package ArrayMatrix;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class AddTheMatrices {
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
            for(int j=0;j<A.get(0).size();j++){
                num=A.get(i).get(j)+B.get(i).get(j);
                arr.add(num);
            }
            addArray.add(arr);
        }
        return(addArray);
    }
}
