//Count of divisors
/*Problem Description

Given an array of integers A, find and return the count of divisors of each element of the array.







NOTE: The order of the resultant array should be the same as the input array.










Problem Constraints

1 <= length of the array <= 100000
1 <= A[i] <= 106



Input Format

The only argument given is the integer array A.



Output Format

Return the count of divisors of each element of the array in the form of an array.



Example Input

Input 1:

 A = [2, 3, 4, 5]
Input 2:

 A = [8, 9, 10]


Example Output

Output 1:

 [2, 2, 3, 2]
Output 1:

 [4, 3, 4]


Example Explanation

Explanation 1:

 The number of divisors of 2 : [1, 2], 3 : [1, 3], 4 : [1, 2, 4], 5 : [1, 5]
 So the count will be [2, 2, 3, 2].
Explanation 2:

 The number of divisors of 8 : [1, 2, 4, 8], 9 : [1, 3, 9], 10 : [1, 2, 5, 10]
 So the count will be [4, 3, 4].
 */
package Math;

public class CountOfDivisors {
  public static void main(String[] args) {
    int[] A = {2, 3, 4, 5};
    int[] result = solve(A);
    for (int i = 0; i < result.length; i++) {
      System.out.print(result[i] + " ");
    }
    System.out.println("");
    int[] B = {8, 9, 10};
    int[] result2 = solve(B);
    for (int i = 0; i < result2.length; i++) {
      System.out.print(result2[i] + " ");
    }
  }

  public static int[] solve(int[] A) {
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
        int[] ans = new int[A.length];
        int p=0,c=0,total=1,num=0;
        for(int i=0;i<A.length;i++){
            num=A[i];
            p=0;
            c=0;
            total=1;
		    while(num>1) {
			    p=spf[num];
			    c=0;
			    while(num%p==0) {
				    c=c+1;
				    num=num/p;
			    }
			    total=total*(c+1);
		    }
            ans[i]=total;
        }
        return(ans);
    }
}
