package project.euler.plus;

import java.io.*;
import java.util.*;
import java.math.*;

public class PowerDigitSum {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int numberOfTestCases = in.nextInt();
         for(int i=0;i<numberOfTestCases;i++)
            {
             BigInteger bi = null;
             int n = in.nextInt();
             if(n%2==0)
                 {
                  bi = compute2ToTheN(n);
             }
             else 
                 {
                 bi = compute2ToTheN(n-1);
                 bi = bi.multiply(BigInteger.valueOf(2));
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
    public static BigInteger compute2ToTheN(int n)
        {
        if(n==1) return BigInteger.valueOf(2);
        BigInteger pow = compute2ToTheN(n/2);
        if(n%2==0) return pow.multiply(pow);
        else return BigInteger.valueOf(2).multiply(pow.multiply(pow));
    }
}
