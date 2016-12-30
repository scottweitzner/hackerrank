/**
 * Created by ScottWeitzner on 12/29/16.
 */

import java.io.*;
import java.util.*;
import java.text.DecimalFormat;

public class Day1_InterquartileRange {

    public static double q1;
    public static double q2;
    public static double q3;

    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>();
        Scanner in = new Scanner( System.in );
        int n = in.nextInt();

        for( int i = 0; i < n; i++ )
            nums.add( in.nextInt() );

        for( int i = 0; i < n; i++ ){
            int freq = in.nextInt();
            int curr_num = nums.get(i);
            while( freq-- > 1 )
                nums.add( curr_num );
        }
        n = nums.size();
        Collections.sort(nums);
        getQuartiles(nums, n);
        double IQR = q3 - q1;
        System.out.println( format(IQR) );
    }

    public static void getQuartiles( ArrayList<Integer> nums, int n ){
        ArrayList<Integer> lower = new ArrayList<>();
        ArrayList<Integer> upper = new ArrayList<>();

        if( n % 2 != 0 ){ //if odd amount of numbers
            q2 = nums.get( n/2 );
            nums.remove(n/2);
            n = n-1;
        } else {
            q2 = median(nums, n);
        }

        for( int i = 0; i < n/2; i++)
            lower.add( nums.get(i) );
        for( int i = n/2; i < n; i++)
            upper.add( nums.get(i) );

        q1 = median(lower, n/2);
        q3 = median(upper, n/2);
    }

    public static double median( ArrayList<Integer> nums, int n ){
        if( n % 2 == 0 ){
            return averageMid(nums, n);
        } else {
            return nums.get(n/2);
        }
    }

    public static double averageMid( ArrayList<Integer> nums, int n ){
        int num1 = nums.get(n/2 - 1);
        int num2 = nums.get(n/2);
        double sum = num1 + num2;
        return sum/2;
    }

    public static String format(Number n){
        DecimalFormat df = new DecimalFormat("#0.0");
        //df.setMinimumFractionDigits(0);
        return df.format(n);
    }

}
