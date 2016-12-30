/**
 * Created by ScottWeitzner on 12/29/16.
 */

import java.io.*;
import java.util.*;

public class Day0_MeanMedianMode {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt( in.nextLine() );
        ArrayList<Integer> nums = new ArrayList<>();
        while( in.hasNext() )
            nums.add(in.nextInt());
        Collections.sort(nums);
        System.out.println( mean(nums, n) );
        System.out.println( median(nums, n) );
        System.out.println( mode(nums, n) );
    }

    public static int mode( ArrayList<Integer> nums, int n ){
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = 0;
        int mode = 0;
        for( int i : nums ){
            if( map.get(i) == null )
                map.put(i,1);
            else {
                map.put( i, map.get(i) + 1 );
            }

            int curr_count = map.get(i);
            if( curr_count > max ){
                max = curr_count;
                mode = i;
            }
        }
        return mode;
    }

    public static double mean( ArrayList<Integer> nums, int n ){
        int sum = 0;
        for( int i = 0; i < nums.size(); i++ )
            sum += nums.get(i);
        return sum / ( n * 1.0) ;
    }

    public static double median( ArrayList<Integer> nums, int n ){
        if( n % 2 == 0 ){
            ArrayList<Integer> sub = new ArrayList<>(nums.subList( n/2 - 1, n/2 + 1 ));
            return mean( sub, 2);
        } else {
            return nums.get( n/2 );
        }
    }
}
