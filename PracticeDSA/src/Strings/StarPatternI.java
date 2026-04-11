//Star Pattern I
/*Problem Description
Write a program to input an integer N from user and print hollow diamond star pattern series of N lines.
See example for clarifications over the pattern.

Problem Constraints:
1 <= N <= 1000

Input Format:
First line is an integer N

Output Format:
N lines conatining only char '*' as per the question.

Example Input:
Input 1:
4
Input 2:
6

Example Output:
Output 1:
********
***  ***
**    **
*      *
*      *
**    **
***  ***
********
Output 2:
************
*****  *****
****    ****
***      ***
**        **
*          *
*          *
**        **
***      ***
****    ****
*****  *****
************
*/
package Strings;

import java.util.Scanner;

public class StarPatternI {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int A=sc.nextInt();
        for (int i = A; i > 0; i--)
        {
            for (int j = 0; j < A; j++)
            {
                if (j < i)
                {
                    System.out.print("*");
                }
                else
                {
                    System.out.print(" ");
                }
            }

            for (int j = A; j >= 1; j--)
            {
                if (j <= i)
                {
                    System.out.print("*");
                }
                else
                {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

        for (int i = A; i > 0; i--)
        {
            for (int j = A; j >= 1; j--)
            {
                if (j >= i)
                {
                    System.out.print("*");
                }
                else
                {
                    System.out.print(" ");
                }
            }

            for (int j = 1; j <= A; j++)
            {
                if (j < i)
                {
                    System.out.print(" ");
                }
                else
                {
                    System.out.print("*");
                }
            }
            System.out.println();
        }
    }
}
