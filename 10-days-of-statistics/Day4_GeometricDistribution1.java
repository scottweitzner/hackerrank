/**
 * Created by ScottWeitzner on 12/31/16.
 */

import java.io.*;
import java.text.DecimalFormat;
import java.util.*;

public class Day4_GeometricDistribution1 {

    private static DecimalFormat df = new DecimalFormat("#0.000");

    private static int n;
    private static double p;

    public static void main(String[] args) {
        readInput();
        System.out.println( df.format( geometricDist(n,p) ) );
    }

    private static double geometricDist( int n, double p ){
        return p * Math.pow( 1-p, n-1 );
    }

    private static void readInput(){
        Scanner in = new Scanner( System.in );
        p = (double) in.nextInt() / in.nextInt();
        n = in.nextInt();
        in.close();
    }

}

