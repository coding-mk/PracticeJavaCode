//Sorted Permutation Rank with Repeats
/*Problem Description

Given a string A, find the rank of the string amongst its permutations sorted lexicographically.

Note that the characters might be repeated. If the characters are repeated, we need to look at the rank in unique permutations.

Look at the example for more details.

NOTE:

The answer might not fit in an integer, so return your answer % 1000003 where 1000003 is a prime number.
String A can consist of both lowercase and uppercase letters. Characters with lesser ASCII values are considered smaller, i.e., 'a' > 'Z'.



Problem Constraints

1 <= len(A) <= 1000000



Input Format

First argument is a string A.



Output Format

Return an integer denoting the rank.



Example Input

Input 1:

 A = "aba"
Input 2:

 A = "bca"






Example Output

Output 1:

 2
Output 2:

 4






Example Explanation

Explanation 1:


 The order permutations with letters 'a', 'a', and 'b' :
    aab
    aba 
    baa
 So, the rank is 2.
Explanation 2:

 The order permutations with letters 'a', 'b', and 'c' :
    abc
    acb 
    bac
    bca
    cab
    cba
 So, the rank is 4.
 */
package Math;

import java.util.ArrayList;

public class SortedPermutationRankRepeats {

  private static int MOD = 1000003;
  public static void main(String[] args) {
    System.out.println(findRank("aba"));
    System.out.println(findRank("bca"));
  }

  
    public static int findRank(String A) {
    
        // Initializations
        ArrayList<Integer> charCount = new ArrayList<Integer>(256);
        
        for(int i = 0; i < 256; i++) 
            charCount.add(0);
        for (int i = 0; i < A.length(); i++) {
            int ch = (int)A.charAt(i);
            charCount.set(ch, charCount.get(ch)+1);
        }
        
        ArrayList<Integer> fact = new ArrayList<Integer>(); // fact[i] will contain i! % MOD
        initializeFactorials(A.length() + 1, fact);
        
        long rank =  1;
        
        for (int i = 0; i < A.length(); i++) {
            // find number of permutations placing character smaller than A[i] at ith position 
            // among characters from i to A.length 
            long less = 0;
            int remaining = A.length() - i - 1;
            for (int ch = 0; ch < A.charAt(i); ch++) {
                if (charCount.get(ch) == 0) continue;
                // Lets try placing ch as the first character in remaining characters
                // and check the number of permutation possible.
                charCount.set(ch, charCount.get(ch)-1);
                long numPermutation = fact.get(remaining);
                
                for (int c = 0; c < 128; c++) {
                    if (charCount.get(c) <= 1) continue; 
                    numPermutation = (numPermutation * inverseNumber(fact.get(charCount.get(c)))) % MOD;
                }
    
                charCount.set(ch, charCount.get(ch)+1);
                less = (less + numPermutation) % MOD;
            }
            
            rank = (rank + less) % MOD;
            // remove the current character from the set. 
            charCount.set((int)A.charAt(i), charCount.get(A.charAt(i))-1);
        }
        return (int)rank;

    }
    
    public static void initializeFactorials(int totalLen, ArrayList<Integer> fact) {
        // calculates factorial
        long factorial = 1;
        fact.add(1); // 0!= 1
        for (int curIndex = 1; curIndex < totalLen; curIndex++) {
            factorial = (factorial * curIndex) % MOD;
            fact.add((int)factorial);
        }
        return;
    }
    
    public static long pow(long x, int y, int k){
        long result = 1;
        while(y > 0){
            if(y % 2 == 1) {
                result = (result * x) % k;
                y--;
            }
            y >>= 1;
            x = (x * x) % k;
        }
        return result;
    }
    public static long inverseNumber(int num) {
        // Find the modular multiplicative inverse
        // Calculates (num ^ (MOD - 2)) % MOD
        return pow(num, MOD-2 , MOD);
    }
}
