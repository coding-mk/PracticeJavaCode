//Concatenate Three Numbers
/*Problem Description

Given three 2-digit integers, A, B, and C, find out the minimum number obtained by concatenating them in any order.

Return the minimum result obtained.



Problem Constraints

10 <= A, B, C <= 99



Input Format

The first argument of input contains an integer, A.

The second argument of input contains an integer, B.

The third argument of input contains an integer, C.



Output Format

Return an integer representing the answer.



Example Input

Input 1:

 A = 10
 B = 20
 C = 30
Input 2:

 A = 55
 B = 43
 C = 47 


Example Output

Output 1:

 102030 
Output 2:

 434755 


Example Explanation

Explanation 1:

 10 + 20 + 30 = 102030 
Explanation 2:

 43 + 47 + 55 = 434755 
 */
package Math;

import java.util.ArrayList;

public class ConcatenateThreeNumbers {
  public static void main(String[] args) {
    System.out.println(solve(20,10,30));
  }

  public static int solve(int A, int B, int C) {
        int min=Integer.MAX_VALUE,mid=0,max=Integer.MIN_VALUE;
        ArrayList<Integer> arr = new ArrayList<Integer>();
        int maxnum = A+B+C;
        arr.add(A);
        arr.add(B);
        arr.add(C);
        for(int i=0;i<3;i++){
            if(min>arr.get(i)){
                min=arr.get(i);
            }
            if(max<arr.get(i)){
                max=arr.get(i);
            }
        }
        mid = maxnum - (max + min);
        int num = (min*10000);
        num = (mid*100) + num;
        num = num + max;
        return(num);
    }
}
