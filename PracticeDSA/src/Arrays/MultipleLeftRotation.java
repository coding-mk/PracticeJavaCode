//Multiple left rotations of the array
/*Problem Descriptio

Given an array of integers A and multiple values in B, which represents the number of times array A needs to be left rotated.
Find the rotated array for each value and return the result in the from of a matrix where ith row represents the rotated array for the ith value in B.

Problem Constraints:
1 <= length of both arrays <= 2000 -10^9 <= A[i] <= 10^9 0 <= B[i] <= 2000

Input Format:
The first argument given is the integer array A.
The second argument given is the integer array B.

Output Format:
Return the resultant matrix.

Example Input:
Input 1:
    A = [1, 2, 3, 4, 5]
    B = [2, 3]

Input 2:
    A = [5, 17, 100, 11]
    B = [1]

Example Output:
Output 1:
    [ [3, 4, 5, 1, 2]
     [4, 5, 1, 2, 3] ]

Output 2:
    [ [17, 100, 11, 5] ]

Example Explanation:
for input 1 -> B[0] = 2 which requires 2 times left rotations
1: [2, 3, 4, 5, 1]
2: [3, 4, 5, 1, 2]

B[1] = 3 which requires 3 times left rotation
1: [2, 3, 4, 5, 1]
2: [3, 4, 5, 1, 2]
2: [4, 5, 1, 2, 4]
*/
package Arrays;

public class MultipleLeftRotation {
    public static void main(String[] args) {
        int[][] arr = {
                { 9, 8, 7, 6, 11, 5, 4 },
                { 6, 5, 4, 8, 11, 10, 9, 7 }
        };
        int[] arr2 = { 3, 16 };

        for (int i = 0; i < arr2.length; i++) {
            arr[i] = rotateLeft(arr[i], arr2[i]);
        }

        // print the rotated arrays
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[] rotateLeft(int[] A, int B)
    {
        int len = A.length;
        B = B % len;
        int i = 0, j = B - 1;
        while (i < j)
        {
            var c = A[i];
            A[i] = A[j];
            A[j] = c;
            i++;
            j--;
        }
        j = len - 1;
        i = B;
        while (i < j)
        {
            var c = A[i];
            A[i] = A[j];
            A[j] = c;
            i++;
            j--;
        }
        i = 0;
        j = len - 1;
        while (i < j)
        {
            var c = A[i];
            A[i] = A[j];
            A[j] = c;
            i++;
            j--;
        }
        return A;
    }
}
