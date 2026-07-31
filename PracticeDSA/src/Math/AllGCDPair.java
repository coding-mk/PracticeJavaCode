//All GCD Pair
/*Problem Description

Given an array of integers A of size N containing GCD of every possible pair of elements of another array.





Find and return the original numbers used to calculate the GCD array in any order. For example, if original numbers are {2, 8, 10} then the given array will be {2, 2, 2, 2, 8, 2, 2, 2, 10}.









Problem Constraints

1 <= N <= 10000

1 <= A[i] <= 109



Input Format

The first and only argument given is the integer array A.



Output Format

Find and return the original numbers which are used to calculate the GCD array in any order.



Example Input

Input 1:

 A = [2, 2, 2, 2, 8, 2, 2, 2, 10]
Input 2:

 A = [5, 5, 5, 15]


Example Output

Output 1:

 [2, 8, 10]
Output 2:

 [5, 15]


Example Explanation

Explanation 1:

 Initially, array A = [2, 2, 2, 2, 8, 2, 2, 2, 10].
 2 is the gcd between 2 and 8, 2 and 10.
 8 and 10 are the gcds pair with itself.
 Therefore, [2, 8, 10] is the original array.
Explanation 2:

 Initially, array A = [5, 5, 5, 15].
 5 is the gcd between 5 and 15.
 15 is the gcds pair with itself.
 Therefore, [5, 15] is the original array.
 */
package Math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class AllGCDPair {
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(2, 2, 2, 2, 8, 2, 2, 2, 10));
        System.out.println(solve(A));
        ArrayList<Integer> B = new ArrayList<>(Arrays.asList(5, 5, 5, 15));
        System.out.println(solve(B));
    }

   public static int gcd(int A, int B) {
        if (A == 0)
            return B;
        return gcd(B % A, A);
    }
    public static ArrayList < Integer > solve(ArrayList < Integer > A) {
        ArrayList < Integer > ans = new ArrayList < Integer > ();
        Collections.sort(A, Collections.reverseOrder());
        HashMap < Integer, Integer > mp = new HashMap < Integer, Integer > ();
        // mp stores the count of A[i]'s that are to be deleted from the array
        for (int i = 0; i < A.size(); i++) {
            int x = A.get(i);
            if (mp.containsKey(x) && mp.get(x) > 0)
                mp.put(x, mp.get(x) - 1);
            else {
                for (int j = 0; j < ans.size(); j++) {
                    int g = gcd(ans.get(j), x);

                    if (mp.containsKey(g))
                        mp.put(g, mp.get(g) + 2);
                    else
                        mp.put(g, 2);
                        
                    // we are adding 2 to the mp as there will 2 pairs gcd(ans[j],A[i]) and gcd(A[i],ans[j])
                }
                ans.add(x);
            }
        }
        return ans;
    }
}
