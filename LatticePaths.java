package project.euler.plus;

import java.io.*;
import java.util.*;
import java.math.*;

public class LatticePaths {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int numberOfTestCases = in.nextInt();
        
        for(int i=0;i<numberOfTestCases;i++)
            {
            int n = in.nextInt();
            int m = in.nextInt();  
            BigInteger nPlusMfact = getFactorial(n+m);
            BigInteger nFact = getFactorial(n);
            BigInteger mFact = getFactorial(m);
            BigInteger nFactIntoMFact = nFact.multiply(mFact);
            BigInteger res = nPlusMfact.divide(nFactIntoMFact);
            BigInteger modVal = BigInteger.valueOf(1000000007);
            System.out.println(res.mod(modVal));
        }
    }
    public static BigInteger getFactorial(int n)
        {
        if(n==1) return BigInteger.valueOf(1);
        BigInteger fact = BigInteger.valueOf(1);
        for(int i=2;i<=n;i++)
            {
            fact = fact.multiply(BigInteger.valueOf(i));
        }
        return fact;
    }
}