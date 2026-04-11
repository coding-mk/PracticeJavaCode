//Subarrays with Bitwise OR 1
/*Problem Description
Given an array B of length A with elements 1 or 0. Find the number of subarrays such that the bitwise OR of all the elements present in the subarray is 1.
Note : The answer can be large. So, return type must be long.

Problem Constraints:
1 <= A <= 105

Input Format:
The first argument is a single integer A.
The second argument is an integer array B.

Output Format:
Return the number of subarrays with bitwise array 1.

Example Input:
Input 1:
 A = 3
B = [1, 0, 1]
Input 2:
 A = 2
B = [1, 0]

Example Output:
Output 1:
5
Output2:
2

Example Explanation:
Explanation 1:
The subarrays are :- [1], [0], [1], [1, 0], [0, 1], [1, 0, 1]
Except the subarray [0] all the other subarrays has a Bitwise OR = 1
Explanation 2:
The subarrays are :- [1], [0], [1, 0]
Except the subarray [0] all the other subarrays has a Bitwise OR = 1 */
package BitManipulation;

import java.util.ArrayList;
import java.util.List;

public class SubarraysBitwiseOR1 {
  public static void main(String[] args) {
    ArrayList<Integer> A = new ArrayList<>(List.of(1, 0, 1));
    System.out.println(solve(A.size(), A));
  }

  public static Long solve(int A, ArrayList<Integer> B) {
        //// O(N^2)////
        /**long ans=0,count=0;
        for(int i=0;i<A;i++){
            ans=0;
            for(int j=i;j<A;j++){
                ans=(long)ans|B.get(j);
                if(ans==1){
                    count+=1;
                }
            }
            if(i==0 && count==0){
                return(count);
            }
        }
        return(count);**/
        //// O(N)//////
        long l=0,sum=0,ans=0;
        long N=(long)A;
        for(int i=0;i<A;i++){
            if(B.get(i)==1){
                sum = (l*(l+1))/2;
                ans+=sum;
                l=0;
            }else{
                l+=1;
            }
        }
        sum = (l*(l+1))/2;
        ans+=sum;
        long count = (N*(N+1))/2;
        long diff = count-ans;
        return(diff);
    }
}
