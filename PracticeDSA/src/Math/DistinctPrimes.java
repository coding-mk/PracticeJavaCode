//Distinct Primes
/*You have given an array A having N integers. Let say G is the product of all elements of A.

You have to find the number of distinct prime divisors of G.



Input Format

The first argument given is an Array A, having N integers.
Output Format

Return an Integer, i.e number of distinct prime divisors of G.
Constraints

1 <= N <= 1e5
1 <= A[i] <= 1e5
For Example

Input:
    A = [1, 2, 3, 4]
Output:
     2

Explanation:
    here G = 1 * 2 * 3 * 4 = 24
    and distinct prime divisors of G are [2, 3]
 */
package Math;

import java.util.HashSet;

public class DistinctPrimes {
  public static void main(String[] args) {
    int[] A = {1, 2, 3, 4};
    System.out.println(solve(A));
  }

  public static int solve(int[] A) {
        int max=Integer.MIN_VALUE;
        for(int j:A){
            if(max<j){
                max=j;
            }
        }
        int[] spf = new int[max+1];
		for(int i=0;i<=max;i++) {
			spf[i]=i;
		}
		for(int i=2;i*i<=max;i++) {
			if(spf[i]==i) {
				for(int j=i*i;j<=max;j=j+i) {
					if(spf[j]==j) {
						spf[j]=i;
					}
				}
			}
		}

        HashSet<Integer> primefact = new HashSet<>();
		int p=0;
        for(int num:A){
            p=0;
            while(num>1) {
			    p=spf[num];
			    primefact.add(p);
			    num=num/p;
		    }
        }
		return(primefact.size());
    }
}
