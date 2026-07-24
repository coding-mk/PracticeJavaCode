//Rearrange Array
/*Given an array A of size N. Rearrange the given array so that A[i] becomes A[A[i]] with O(1) extra space.

Constraints:

1 <= N <= 5×104

0 <= A[i] <= N - 1

The elements of A are distinct

Input Format

The argument A is an array of integers

Example 1:

Input : [1, 0]
Return : [0, 1]
Example 2:

Input : [0, 2, 1, 3]
Return : [0, 1, 2, 3]
 */
package Math;

import java.util.ArrayList;

public class RearrangeArray {
  public static void main(String[] args) {
    ArrayList<Integer> A = new ArrayList<>(){
      {
        add(1);
        add(0);
      }
    };
    arrange(A);
    for (int i = 0; i < A.size(); i++) {
      System.out.print(A.get(i) + " ");
    }
    ArrayList<Integer> B = new ArrayList<>(){
      {
        add(0);
        add(2);
        add(1);
        add(3);
      }
    };
    arrange(B);
    for (int i = 0; i < B.size(); i++) {
      System.out.print(B.get(i) + " ");
    }
  }

  public static void arrange(ArrayList<Integer> A) {
   	    int n = A.size();
	    for (int i = 0; i < n; i++) A.set(i, A.get(i) + (A.get(A.get(i)) % n) * n );
	    for (int i = 0; i < n; i++) A.set(i, A.get(i) / n);
	}
}
