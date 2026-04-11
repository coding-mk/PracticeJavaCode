//Pick from both side
/*Problem Description
You are given an integer array A of size N.
You have to perform B operations. In one operation, you can remove either the leftmost or the rightmost element of the array A.
Find and return the maximum possible sum of the B elements that were removed after the B operations.

NOTE: Suppose B = 3, and array A contains 10 elements, then you can:
Remove 3 elements from front and 0 elements from the back, OR
Remove 2 elements from front and 1 element from the back, OR
Remove 1 element from front and 2 elements from the back, OR
Remove 0 elements from front and 3 elements from the back.

Problem Constraints:
1 <= N <= 105
1 <= B <= N
-103 <= A[i] <= 103

Input Format:
First argument is an integer array A.
Second argument is an integer B.

Output Format:
Return an integer denoting the maximum possible sum of elements you removed.

Example Input:
Input 1:
 A = [5, -2, 3 , 1, 2]
 B = 3
Input 2:
 A = [ 2, 3, -1, 4, 2, 1 ]
 B = 4

Example Output:
Output 1:
 8
Output 2:
 9

Example Explanation:
Explanation 1:
 Remove element 5 from front and element (1, 2) from back so we get 5 + 1 + 2 = 8
Explanation 2:
 Remove the first element and the last 3 elements. So we get 2 + 4 + 2 + 1 = 9
*/
package Arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class PickFromBothSide {
    public static void main(String[] args) {
        //ArrayList<Integer> A = new ArrayList<>(Arrays.asList(5, -2, 3 , 1, 2));
        //int B = 3;
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(2, 3, -1, 4, 2, 1));
        int B = 4;
        System.out.println(Solve(A, B));
    }

    public static int Solve(ArrayList<Integer> A, int B) {
        int N=A.size();
        ArrayList<Integer> forwordPreFix = new ArrayList<Integer>();
        ArrayList<Integer> reversePreFix = new ArrayList<Integer>();
        forwordPreFix.add(A.get(0));
        reversePreFix.add(A.get(N-1));
        for(int i=1;i<N;i++){
            forwordPreFix.add(forwordPreFix.get(i-1)+A.get(i));
        }
        int k=0;
        for(int i=N-2;i>=0;i--){
            reversePreFix.add(reversePreFix.get(k)+A.get(i));
            k+=1;
        }
        int max=Integer.MIN_VALUE,sum=0,n=B-1,a=B,j=0;
        for(int i=-1;i<B;i++) {
            if(i==-1) {
                sum = reversePreFix.get(B-1);
            }else if(j == -1) {
                sum = forwordPreFix.get(i);
            }else {
                sum = forwordPreFix.get(i)+reversePreFix.get(j);
            }
            if(max<sum) {
                max=sum;
            }
            a-=1;
            j=n-(B-a);
        }
        return(max);
    }
}
