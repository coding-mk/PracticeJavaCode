//Even Subarrays
/*Problem Description
You are given an integer array A.
Decide whether it is possible to divide the array into one or more subarrays of even length such that the first and last element of all subarrays will be even.
Return "YES" if it is possible; otherwise, return "NO" (without quotes).

Problem Constraints:
1 <= |A|, A[i] <= 106

Input Format:
The first and the only input argument is an integer array, A.

Output Format:
Return a string "YES" or "NO" denoting the answer.

Example Input:
Input 1:
 A = [2, 4, 8, 6]
Input 2:
 A = [2, 4, 8, 7, 6]

Example Output:
Output 1:
 "YES"
Output 2:
 "NO"

Example Explanation:
Explanation 1:
 We can divide A into [2, 4] and [8, 6].
Explanation 2:
 There is no way to divide the array into even length subarrays.
*/
package Arrays;

import java.util.ArrayList;
import java.util.List;

public class EvenSubarrays {
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(List.of(2, 4, 8, 6));
        //List<Integer> A = new ArrayList<>(List.of(2, 4, 8, 7, 6));
        System.out.println(solve(A));
    }

    public static String solve(ArrayList<Integer> A)
    {
        int N = A.size();
        if (A.get(0) % 2 == 0 && A.get(N - 1) % 2 == 0 && N % 2 == 0)
        {
            return ("YES");
        }
        else
        {
            return ("NO");
        }
    }
}
