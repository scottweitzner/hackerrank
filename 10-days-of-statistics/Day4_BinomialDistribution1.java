/**
 * Created by ScottWeitzner on 12/30/16.
 */

import java.io.*;
import java.text.DecimalFormat;
import java.util.*;

public class Day4_BinomialDistribution1 {

    private static DecimalFormat df = new DecimalFormat("#0.000");

    public static void main(String[] args) {
        Scanner in = new Scanner( System.in );
        double ratio_left = in.nextDouble();
        double ratio_right = in.nextDouble();
        double p = ratio_left/ ( ratio_left + ratio_right );

        double prob_at_least_3 = 0;
        for (int i = 3; i <= 6; i++)
            prob_at_least_3 += b(i,6,p);

        System.out.println( df.format(prob_at_least_3) );
    }

    private static double b( int x, int n, double p ){
        return combinations(x,n) * Math.pow(p, x) * Math.pow( 1-p, n-x );
    }

    private static double combinations( int x, int n ){
        double numerator = factorial(n);
        double denominator = factorial(x) * factorial(n - x) ;
        return numerator / denominator;
    }

    private static int factorial( int n ){
        if( n <= 1 ) return 1;
        else return  n * factorial ( n - 1 );
    }

}
