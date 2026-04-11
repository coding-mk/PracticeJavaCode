//Single Number III
/*Problem Description
Given an array of positive integers A, two integers appear only once, and all the other integers appear twice.
Find the two integers that appear only once.
Note: Return the two numbers in ascending order.

Problem Constraints:
2 <= |A| <= 100000
1 <= A[i] <= 109

Input Format:
The first argument is an array of integers of size N.

Output Format:
Return an array of two integers that appear only once.

Example Input:
Input 1:
A = [1, 2, 3, 1, 2, 4]
Input 2:
A = [1, 2]

Example Output:
Output 1:
[3, 4]
Output 2:
[1, 2]

Example Explanation:
Explanation 1:
3 and 4 appear only once.
Explanation 2:
1 and 2 appear only once. */
package BitManipulation;

import java.util.ArrayList;
import java.util.List;

public class SingleNumberIII {
  public static void main(String[] args) {
    ArrayList<Integer> A = new ArrayList<>(List.of(1, 2, 3, 1, 2, 4));
    System.out.println(solve(A));
  }

  public static ArrayList<Integer> solve(ArrayList<Integer> A) {
        int xor=0,bit=0;
        ArrayList<Integer> B = new ArrayList<Integer>();
        for(int i=0;i<A.size();i++){
            xor=xor^A.get(i);
        }
        bit = checkSetBit(xor);
        int arr1=0,arr2=0;
        for(int i=0;i<A.size();i++){
            if(((A.get(i)>>bit)&1)==1) {
            	arr1=arr1^A.get(i);
            }else {
            	arr2=arr2^A.get(i);
            }
        }
        if(arr1<arr2){
            B.add(arr1);
            B.add(arr2);
        }else{
            B.add(arr2);
            B.add(arr1);
        }
		return(B);
    }

    public static int checkSetBit(int num){
        int bit=0;
		for(int i=0;i<num;i++) {
			if(((num>>i)&1)==1) {
				bit=i;
				break;
			}
		}
		return(bit);
    }
}
