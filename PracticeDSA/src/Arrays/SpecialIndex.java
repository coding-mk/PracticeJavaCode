//Special Index
/*Problem Description
Given an array, arr[] of size N, the task is to find the count of array indices such that removing an element from these indices makes the sum of even-indexed and odd-indexed array elements equal.

Problem Constraints:
1 <= N <= 105
-105 <= A[i] <= 105
Sum of all elements of A <= 109

Input Format:
First argument contains an array A of integers of size N

Output Format:
Return the count of array indices such that removing an element from these indices makes the sum of even-indexed and odd-indexed array elements equal.

Example Input:
Input 1:
A = [2, 1, 6, 4]
Input 2:
A = [1, 1, 1]

Example Output:
Output 1:
1
Output 2:
3

Example Explanation:
Explanation 1:
Removing arr[1] from the array modifies arr[] to { 2, 6, 4 } such that, arr[0] + arr[2] = arr[1].
Therefore, the required output is 1.
Explanation 2:

Removing arr[0] from the given array modifies arr[] to { 1, 1 } such that arr[0] = arr[1]
Removing arr[1] from the given array modifies arr[] to { 1, 1 } such that arr[0] = arr[1]
Removing arr[2] from the given array modifies arr[] to { 1, 1 } such that arr[0] = arr[1]
Therefore, the required output is 3.
*/
package Arrays;

import java.util.ArrayList;
import java.util.List;

public class SpecialIndex {
    public static void main(String[] args) {
//        ArrayList<Integer> A = new ArrayList<>(List.of(2, 1, 6, 4));
        ArrayList<Integer> A = new ArrayList<>(List.of(1, 1, 1));
        System.out.println(Solve(A));
    }

    public static int Solve(ArrayList<Integer> A) {
        ArrayList<Integer> pfEven = new ArrayList<Integer>();
        ArrayList<Integer> pfOdd = new ArrayList<Integer>();
        pfOdd.add(0);
        pfEven.add(A.get(0));
        int N=A.size();
        for(int i=1;i<N;i++){
            if(i%2==1){
                pfEven.add(pfEven.get(i-1));
                pfOdd.add(pfOdd.get(i-1)+A.get(i));
            }else{
                pfEven.add(pfEven.get(i-1)+A.get(i));
                pfOdd.add(pfOdd.get(i-1));
            }
        }
        int ans=0,Todd=0,Teven=0;
        for(int i=0;i<N;i++){
            if(i==0){
                Todd= pfEven.get(N-1)-pfEven.get(i);
                Teven = pfOdd.get(N-1)-pfOdd.get(i);
            }else{
                Todd = pfOdd.get(i-1)+(pfEven.get(N-1)-pfEven.get(i));
                Teven = pfEven.get(i-1)+(pfOdd.get(N-1)-pfOdd.get(i));
            }
            if(Todd==Teven){
                ans+=1;
            }
        }
        return(ans);
    }
}
