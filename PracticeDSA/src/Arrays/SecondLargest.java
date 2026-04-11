//Second Largest
/*Problem Description
You are given an integer array A. You have to find the second largest element/value in the array or report that no such element exists.
Problem Constraints
1 <= |A| <= 105
0 <= A[i] <= 109

Input Format:
The first argument is an integer array A.

Output Format:
Return the second largest element. If no such element exist then return -1.

Example Input:
Input 1:
 A = [2, 1, 2]
Input 2:
 A = [2]

Example Output:
Output 1:
 1
Output 2:
 -1

Example Explanation:
Explanation 1:
 First largest element = 2
 Second largest element = 1
Explanation 2:
 There is no second largest element in the array.
*/
package Arrays;

import java.util.ArrayList;
import java.util.List;

public class SecondLargest {
    public static void main(String[] args) {
        List<Integer> A = new ArrayList<>(List.of(11, 12, 13, 17,19,6,4,8,9));
        System.out.println(findSecondLargest(A));
    }

    public static int findSecondLargest(List<Integer> A)
    {
         int index = 0, n = A.size();
         for (int i = 1; i < n; i++)
         {
           if (A.get(i) > A.get(index))
           {
             index = i;
           }
         }

         int ans = -1;
         for (int i = 0; i < n; i++)
         {
           if (A.get(i) != A.get(index))
           {
             ans = Math.max(ans, A.get(i));
           }
         }
         return ans;
//        int max = Integer.MIN_VALUE, max2 = -1;
//        for (int i : A)
//        {
//            if (i > max)
//            {
//                max = i;
//            }
//        }
//        for (int i : A)
//        {
//            if (i != max && i > max2)
//            {
//                max2 = i;
//            }
//        }
//        return max2;
    }
}
