//Range Sum Query
/*Problem Description
You are given an integer array A of length N.
You are also given a 2D integer array B with dimensions M x 2, where each row denotes a [L, R] query.
For each query, you have to find the sum of all elements from L to R indices in A (0 - indexed).
More formally, find A[L] + A[L + 1] + A[L + 2] +... + A[R - 1] + A[R] for each query.

Problem Constraints
1 <= N, M <= 105
1 <= A[i] <= 109
0 <= L <= R < N

Input Format:
The first argument is the integer array A.
The second argument is the 2D integer array B.

Output Format:
Return an integer array of length M where ith element is the answer for ith query in B.

Example Input:
Input 1:
A = [1, 2, 3, 4, 5]
B = [[0, 3], [1, 2]]
Input 2:
A = [2, 2, 2]
B = [[0, 0], [1, 2]]

Example Output:
Output 1:
[10, 5]
Output 2:
[2, 4]

Example Explanation:
Explanation 1:
The sum of all elements of A[0 ... 3] = 1 + 2 + 3 + 4 = 10.
The sum of all elements of A[1 ... 2] = 2 + 3 = 5.
Explanation 2:
The sum of all elements of A[0 ... 0] = 2 = 2.
The sum of all elements of A[1 ... 2] = 2 + 2 = 4.
*/
package Arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.*;

public class RangeSumQuery {
    public static void main(String[] args) {
        List<Integer> A = Arrays.asList(1, 2, 3, 4, 5);

        // Equivalent of List<List<int>>
        List<List<Integer>> B = Arrays.asList(
                Arrays.asList(0, 3),
                Arrays.asList(1, 2)
        );

        List<Long> ans = RangeSum(A, B);

        for (long val : ans) {
            System.out.print(val + " ");
        }
    }

    public static List<Long> RangeSum(List<Integer> A, List<List<Integer>> B) {
        int n = A.size(), m = B.size();

        long[] pref = new long[n];
        pref[0] = A.get(0);
        for (int i = 1; i < n; i++) {
            pref[i] = pref[i - 1] + A.get(i);
        }

        List<Long> ans = new ArrayList<>(Collections.nCopies(m, 0L));
        for (int i = 0; i < m; i++) {
            int left = B.get(i).get(0);
            int right = B.get(i).get(1);
            long sum = pref[right] - (left > 0 ? pref[left - 1] : 0);
            ans.set(i, sum);
        }

        return ans;
    }
}
