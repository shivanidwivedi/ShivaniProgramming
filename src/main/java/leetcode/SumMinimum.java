package leetcode;

/**
 * Given an array arr of positive integers, let sum be the sum of the digits of the minimal element of arr.
 *
 * Return 0 if sum is odd, otherwise return 1.
 */
public class SumMinimum {
    public static int sumOfDigits(int[] arr){
        if (arr==null||arr.length==0){
            return -1;
        }
        int min = arr[0];
        for(int i=0; i < arr.length-1 ;i++){
            min = Math.min(min, arr[i+1]);
        }
        int sum=0;
        while (min!=0){
            sum += min % 10;
            min = min / 10;
        }
        return (sum % 2 != 0) ? 0 : 1 ;
    }
}
