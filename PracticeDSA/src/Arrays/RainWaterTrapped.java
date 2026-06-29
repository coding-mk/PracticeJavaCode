//Rain Water Trapped
/*Problem Description

Imagine a histogram where the bars' heights are given by the array A. Each bar is of uniform width, which is 1 unit. When it rains, water will accumulate in the valleys between the bars.

Your task is to calculate the total amount of water that can be trapped in these valleys.

Example:

The Array A = [5, 4, 1, 4, 3, 2, 7] is visualized as below. The total amount of rain water trapped in A is 11.


Rain Water Trapped




Problem Constraints

1 <= |A| <= 105
0 <= A[i] <= 105



Input Format

First and only argument is the Integer Array, A.



Output Format

Return an Integer, denoting the total amount of water that can be trapped in these valleys



Example Input

Input 1:

 A = [0, 1, 0, 2]
Input 2:

A = [1, 2]


Example Output

Output 1:

1
Output 2:

0

*/
package Arrays;

import java.util.ArrayList;
import java.util.List;

public class RainWaterTrapped {
  public static void main(String[] args) {
    //List<Integer> A = new ArrayList<>(List.of(0, 1, 0, 2));
    List<Integer> A = new ArrayList<>(List.of(1, 2));
    System.out.println(trap(A));
  }

  public static int trap(final List<Integer> A) {
        ArrayList<Integer> leftmax= new ArrayList<Integer>();
        ArrayList<Integer> rightmax= new ArrayList<Integer>();
        int left=Integer.MIN_VALUE,right=Integer.MIN_VALUE,min=0,sum=0,diff;
        for(int i:A){
            if(i>left){
                left=i;
            }
            leftmax.add(left);
        }
        for(int i=A.size()-1;i>=0;i--){
            if(A.get(i)>right){
                right=A.get(i);
            }
             rightmax.add(right);
        }
        int r=0,k=rightmax.size()-1,temp=0;
        while(r<k) {
        	temp = rightmax.get(r);
        	rightmax.set(r, rightmax.get(k));
        	rightmax.set(k, temp);
        	r++;
        	k--;
        }
        for(int i=0;i<A.size();i++){
            min=Math.min(leftmax.get(i),rightmax.get(i));
            diff = min-A.get(i);
            if(diff>0){
                sum=sum+diff;
            }
        }
        return(sum);
    }

}
