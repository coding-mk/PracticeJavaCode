//Add Binary Strings
/*Problem Description
Given two binary strings A and B. Return their sum (also a binary string).

Problem Constraints:
1 <= length of A <= 105
1 <= length of B <= 105
A and B are binary strings

Input Format:
The two argument A and B are binary strings.

Output Format:
Return a binary string denoting the sum of A and B

Example Input:
Input 1:
A = "100"
B = "11"
Input 2:
A = "110"
B = "10"

Example Output:
Output 1:
"111"
Output 2:
"1000"

Example Explanation:
For Input 1:
The sum of 100 and 11 is 111.
For Input 2:
 The sum of 110 and 10 is 1000.
 */
package BitManipulation;

public class AddBinaryStrings {
  public static void main(String[] args) {
    System.out.println(AddBinary("100", "11"));
  }

  public static String AddBinary(String A, String B) {
        String result="";
		int A_size = A.length()-1,B_size = B.length()-1,temp=0;
		while(A_size>=0 || B_size>=0 || temp == 1) {
			 temp += ((A_size >= 0)? A.charAt(A_size) - '0': 0);
		        temp += ((B_size >= 0)? B.charAt(B_size) - '0': 0);
		        result = (char)(temp % 2 + '0') + result;
		        temp /= 2;
		        A_size--; 
		        B_size--;
		}
		return result;
    }
}
