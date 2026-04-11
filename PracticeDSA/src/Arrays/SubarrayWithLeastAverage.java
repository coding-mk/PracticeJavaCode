//Subarray With The Least Average
/*Problem Description
Given an array A of size N, find the subarray of size B with the least average.

Problem Constraints:
1 <= B <= N <= 105
-105 <= A[i] <= 105

Input Format:
First argument contains an array A of integers of size N.
Second argument contains integer B.

Output Format:
Return the index of the first element of the subarray of size B that has the least average.
Array indexing starts from 0.

Example Input:
Input 1:
A = [3, 7, 90, 20, 10, 50, 40]
B = 3
Input 2:
A = [3, 7, 5, 20, -10, 0, 12]
B = 2

Example Output:
Output 1:
3
Output 2:
4

Example Explanation:
Explanation 1:
Subarray between indexes 3 and 5
The subarray {20, 10, 50} has the least average
among all subarrays of size 3.
Explanation 2:

 Subarray between [4, 5] has minimum average
*/
package Arrays;

import java.util.ArrayList;
import java.util.List;

public class SubarrayWithLeastAverage {
    public static void main(String[] args) {
//        ArrayList<Integer> A = new ArrayList<>(List.of(3, 7, 90, 20, 10, 50, 40));
//        int B = 3;
        ArrayList<Integer> A = new ArrayList<>(List.of(3, 7, 5, 20, -10, 0, 12));
        int B=2;
        System.out.println(solve(A, B));
    }

    public static int solve(ArrayList<Integer> A, int B) {
        long sum,min=Long.MAX_VALUE;
        int index=0,N=A.size();
        ArrayList<Long> prefix = new ArrayList<>();
        prefix.add((long)A.get(0));
        for(int i=1;i<N;i++){
            prefix.add((long)prefix.get(i-1)+A.get(i));
        }
        for(int i=0;i<=N-B;i++){
            if(i==0){
                sum=prefix.get(i+B-1);
            }else{
                sum=(long)prefix.get(i+B-1)-prefix.get(i-1);
            }
            if(sum<min){
                min=sum;
                index=i;
            }
        }
        return(index);
    }
}
