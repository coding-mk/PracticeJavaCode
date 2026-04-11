//Closest MinMax
/*Problem Description
Given an array A, find the size of the smallest subarray such that it contains at least one occurrence of the maximum value of the array
and at least one occurrence of the minimum value of the array.

Problem Constraints:
1 <= |A| <= 2000

Input Format:
First and only argument is vector A

Output Format:
Return the length of the smallest subarray which has at least one occurrence of minimum and maximum element of the array

Example Input:
Input 1:
A = [1, 3, 2]
Input 2:
A = [2, 6, 1, 6, 9]

Example Output:
Output 1:
 2
Output 2:
 3

Example Explanation:
Explanation 1:
 Take the 1st and 2nd elements as they are the minimum and maximum elements respectively.
Explanation 2:
 Take the last 3 elements of the array.
*/
package Arrays;

import java.util.ArrayList;
import java.util.List;

public class ClosestMinMax {
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(List.of(2, 6, 1, 6, 9));
        System.out.println(solve(A));
    }

    public static int solve(ArrayList<Integer> A) {
        int max=Integer.MIN_VALUE,min=Integer.MAX_VALUE;
        for (Integer integer : A) {
            if (max < integer) {
                max = integer;
            }
            if (min > integer) {
                min = integer;
            }
        }
        int N=A.size(),ans=A.size(),maxI=-1,minI=-1,l;
        for(int i=N-1;i>=0;i--){
            if(A.get(i)==min){
                minI=i;
                if(maxI!=-1){
                    l=Math.abs(minI-maxI)+1;
                    ans=Math.min(ans,l);
                }
            }
            if(A.get(i)==max){
                maxI=i;
                if(minI!=-1){
                    l=Math.abs(minI-maxI)+1;
                    ans=Math.min(ans,l);
                }
            }
        }
        return(ans);
    }
}
