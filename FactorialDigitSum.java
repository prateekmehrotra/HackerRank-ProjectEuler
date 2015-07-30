package project.euler.plus;

import java.io.*;
import java.util.*;
import java.math.*;

public class FactorialDigitSum {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
         Scanner in = new Scanner(System.in);
        int numberOfTestCases = in.nextInt();
        for(int i=0;i<numberOfTestCases;i++)
            {
            BigInteger bi = BigInteger.valueOf(1);
            int n = in.nextInt();
            for(int j=2;j<=n;j++)
                {
                bi = bi.multiply(BigInteger.valueOf(j));
            }
            System.out.println(getDigitSum(bi));
        }
    }
    public static long getDigitSum(BigInteger bi)
        {
        int digit = 0;
        long sum = 0;
        while(bi.compareTo(BigInteger.valueOf(0))==1)
            {
            digit = bi.mod(BigInteger.valueOf(10)).intValue();
            sum+=digit;
            bi = bi.divide(BigInteger.valueOf(10));
        }
        return sum;
    }
}
