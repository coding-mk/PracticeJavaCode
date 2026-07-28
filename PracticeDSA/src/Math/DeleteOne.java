//Delete one
/*Problem Description

You are given an integer array A of size N. You must remove exactly one element. Return the maximum possible gcd of the remaining N - 1 elements.


Problem Constraints

2 <= N <= 105
1 <= A[i] <= 109


Input Format

The only argument is the integer array A.


Output Format

Return a single integer, the maximum gcd after removing one element.


Example Input

Input 1:
A = [12, 15, 18]
Input 2:
A = [5, 15, 30]


Example Output

Output 1:
6
Output 2:
15


Example Explanation

Explanation 1:
Remove 12 -> gcd(15, 18) = 3.
Remove 15 -> gcd(12, 18) = 6.
Remove 18 -> gcd(12, 15) = 3.
Best is 6.
Explanation 2:
Remove 5  -> gcd(15, 30) = 15.
Remove 15 -> gcd(5, 30)  = 5.
Remove 30 -> gcd(5, 15)  = 5.
Best is 15.
 */

 package Math;

import java.util.ArrayList;

public class DeleteOne {
  public static void main(String[] args) {
    ArrayList<Integer> A = new ArrayList<Integer>();
    A.add(12);
    A.add(15);
    A.add(18);
    System.out.println(solve(A));
    ArrayList<Integer> B = new ArrayList<Integer>();
    B.add(5);
    B.add(15);
    B.add(30);
    System.out.println(solve(B));
  }

  public static int solve(ArrayList<Integer> A) {
        ArrayList<Integer> sf = new ArrayList<Integer>();
		ArrayList<Integer> pf = new ArrayList<Integer>();
		pf.add(A.get(0));
		sf.add(A.get(A.size()-1));
		for(int i=1;i<A.size();i++) {
			pf.add(gcd(pf.get(i-1),A.get(i)));
		}
		int k=0;
		for(int i=A.size()-2;i>=0;i--) {
			sf.add(gcd(sf.get(k),A.get(i)));
			k+=1;
		}
		int i=0,j=pf.size()-1,temp=0;
		while(i<j) {
			temp = pf.get(i);
			pf.set(i, pf.get(j));
			pf.set(j, temp);
			i++;
			j--;
		}
		int max=pf.get(0);
		for(int m=1;m<A.size()-1;m++) {
			max = Math.max(max, gcd(sf.get(m-1),pf.get(m+1)));
		}
		max=Math.max(max,sf.get(sf.size()-2));
		
		return(max);
    }

    public static int gcd(int A, int B) {
        if(B==0){
            return(A);
        }
        return(gcd(B,A%B));
    }
}
