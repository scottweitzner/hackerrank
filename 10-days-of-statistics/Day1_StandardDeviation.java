/**
 * Created by ScottWeitzner on 12/29/16.
 */

import java.io.*;
import java.util.*;
import java.text.DecimalFormat;

public class Day1_StandardDeviation {

    private static ArrayList<Double> nums;
    private static int n;
    private static double mean;
    private static double stdDev;

    public static void main(String[] args) {
        populateList();
        mean = findMean();
        stdDev = findStandardDev();
        System.out.println( format(stdDev) );
    }

    private static double findStandardDev(){
        double sum = 0;
        for (int i = 0; i < n ; i++)
            sum += Math.pow( (nums.get(i) - mean), 2);
        return Math.sqrt(sum/n);
    }

    private static double findMean(){
        double sum = 0;
        for ( double num : nums) {
            sum += num;
        }
        return sum/n;
    }

    private static void populateList(){
        nums = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        while (in.hasNext())
            nums.add(in.nextDouble());
    }

    private static String format(Number n){
        DecimalFormat df = new DecimalFormat("#0.0");
        df.setMinimumFractionDigits(0);
        return df.format(n);
    }

}
