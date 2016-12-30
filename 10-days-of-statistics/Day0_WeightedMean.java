/**
 * Created by ScottWeitzner on 12/29/16.
 */

import java.io.*;
import java.util.*;
import java.text.DecimalFormat;

public class Day0_WeightedMean {

    public static DecimalFormat formatter = new DecimalFormat("#.0");

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt( in.nextLine() );
        int[] nums = toArray( in.nextLine() );
        int[] weights = toArray( in.nextLine() );
        System.out.println( formatter.format( weightedMean(nums, weights, n) ) );
    }

    public static double weightedMean( int[] nums, int[] weights, int n ){
        double sum = 0;
        double weight_sum = 0;
        for( int i = 0; i < n; i++ ){
            sum += nums[i] * weights[i];
            weight_sum += weights[i];
        }
        return sum / weight_sum;
    }

    public static int[] toArray( String line ){
        String[] str_arr = line.split(" ");
        int[] int_arr = new int[ str_arr.length ];
        for( int i = 0; i < str_arr.length; i++ )
            int_arr[i] = Integer.parseInt( str_arr[i].trim() );
        return int_arr;
    }

}
