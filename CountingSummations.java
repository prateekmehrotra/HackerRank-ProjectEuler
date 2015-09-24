package project.euler.plus;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class CountingSummations {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int numberOfTestCases = in.nextInt();
        for(int i=0;i<numberOfTestCases;i++)
            {
            int target = in.nextInt();
            BigInteger[] ways = new BigInteger[target + 1];
            for(int temp =0;temp<ways.length;temp++)
                ways[temp] = BigInteger.valueOf(0);
            ways[0] = BigInteger.valueOf(1);

            for (int j = 1; j <= target-1; j++) {
                for (int k = j; k <= target; k++) {
                    ways[k] = ways[k].add(ways[k - j]);
                }
                //print(ways);
            }
            System.out.println((ways[ways.length-1]).mod(BigInteger.valueOf(1000000007)));
        }
    }
    public static void print(long[] ways)
        {
        for(int i=0;i<ways.length;i++)
            {
            System.out.print(ways[i] + " ");
        }
        System.out.println();
    }
}
