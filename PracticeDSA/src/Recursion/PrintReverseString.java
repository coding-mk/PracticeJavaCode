//Print reverse string
/*Problem Description

Write a recursive function that takes a string, S, as input and prints the characters of S in reverse order.



Problem Constraints

1 <= |s| <= 1000



Input Format

First line of input contains a string S.



Output Format

Print the character of the string S in reverse order.



Example Input

Input 1:

 scaleracademy
Input 2:

 cool


Example Output

Output 1:

 ymedacarelacs
Output 2:

 looc
*/
public class PrintReverseString {

  public static void main(String[] args) {
    //String str = "scaleracademy";
    String str = "cool";
    solve(str);
  }

  public static void solve(String str){
    if(str.length() == 0){
      return;
    }
    solve(str.substring(1));
    System.out.print(str.charAt(0));
  }

}
