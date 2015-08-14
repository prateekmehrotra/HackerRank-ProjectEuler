package project.euler.plus;

import java.io.*;
import java.util.*;
import java.math.*;

public class CoinSums {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int numberOfTestCases = in.nextInt();
        
        int target = 100000;
        BigInteger[] ways = new BigInteger[target+1];
        for(int i=0;i<ways.length;i++) ways[i] = BigInteger.valueOf(0);
        ways[0] = BigInteger.valueOf(1);

        int[] coinSizes = { 1, 2, 5, 10, 20, 50, 100, 200 };
        for (int i = 0; i < coinSizes.length; i++) {
            for (int j = coinSizes[i]; j <= target; j++) {
                ways[j] = ways[j].add(ways[j - coinSizes[i]]);
            }
        }
        
        for(int k=0;k<numberOfTestCases;k++)
            {
            int n = in.nextInt();
            System.out.println(ways[n].mod(BigInteger.valueOf(1000000007)));
        }
    }
}
