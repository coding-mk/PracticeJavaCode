package Arrays;

//Count Odd and Even
//You are given an array. your task is to count the number of even and odd elements.
//Return first even and then odd count
public class CountEvenAndOdd {
    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6,7,8,9};
        countEvenAndOdd(a);
    }

    public static void countEvenAndOdd(int[] a) {
        int odd = 0, even = 0;
        for (int j : a) {
            if (j % 2 == 0) {
                even++;
            } else {
                odd++;
            }
        }

        System.out.println("Even : " + even + " Odd : " + odd);
    }
}
