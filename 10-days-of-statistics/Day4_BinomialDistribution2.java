/**
 * Created by ScottWeitzner on 12/31/16.
 */

import java.io.*;
import java.text.DecimalFormat;
import java.util.*;

public class Day4_BinomialDistribution2 {

    private static DecimalFormat df = new DecimalFormat("#0.000");

    private static final int x = 2;
    private static int n;
    private static double p;

    public static void main(String[] args) {
        readInput();

        double prob = 0;
        for (int i = 0; i <= n; i++){
            prob += binomialDist(i,n,p);
            if ( i == x ){
                System.out.println( df.format(prob) );
                prob = binomialDist(i,n,p);
            }
        }
        System.out.println( df.format(prob) );
    }

    private static double binomialDist( int x, int n, double p ){
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

    private static void readInput(){
        Scanner in = new Scanner( System.in );
        p = in.nextInt()/100.0;
        n = in.nextInt();
    }

}
