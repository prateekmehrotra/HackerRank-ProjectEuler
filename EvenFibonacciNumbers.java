package project.euler.plus;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class EvenFibonacciNumbers {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        long numberOfTestCases = in.nextLong();
        for(long i=0;i<numberOfTestCases;i++)
            {
            BigInteger n = in.nextBigInteger();
            BigInteger a = BigInteger.valueOf(0);
            BigInteger b = BigInteger.valueOf(1);
            BigInteger c;
            BigInteger sum = BigInteger.valueOf(0);
            for(BigInteger bi=BigInteger.valueOf(1);bi.compareTo(n)<1;bi=bi.add(BigInteger.valueOf(1)))
                {
                c=a.add(b);
                a=b;
                b=c;
                
                if(c.compareTo(n)>=1)
                    break;
                else
                    {
                    if(c.mod(BigInteger.valueOf(2)).compareTo(BigInteger.valueOf(0)) == 0)
                        {
                        sum=sum.add(c);
                    }
                }
            }
            System.out.println(sum);
        }
    }
}