//Time to equality
/*
Problem Description
Given an integer array A of size N. In one second, you can increase the value of one element by 1.
Find the minimum time in seconds to make all elements of the array equal.

Problem Constraints
1 <= N <= 1000000
1 <= A[i] <= 1000

Input Format:
First argument is an integer array A.

Output Format:
Return an integer denoting the minimum time to make all elements equal.

Example Input:
A = [2, 4, 1, 3, 2]

Example Output:
8

Example Explanation:
We can change the array A = [4, 4, 4, 4, 4]. The time required will be 8 seconds.
*/
package Arrays;

import java.util.ArrayList;
import java.util.List;

public class TimeToEquality {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(List.of(2, 4, 1, 3, 2 ));
        System.out.println(Solve(list));

    }

    public static int Solve(List<Integer> A)
    {
        int sum = A.get(0), max = Integer.MIN_VALUE, len = A.size();
        for (int i = 1; i < len; i++)
        {
            sum += A.get(i);
            if (max < A.get(i))
            {
                max = A.get(i);
            }
        }
        return (len * max) - sum;
    }
}
