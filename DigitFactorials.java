package project.euler.plus;

import java.io.*;
import java.util.*;
import java.math.*;

public class DigitFactorials {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long result = 0;
        if(n<10) System.out.println(0);
        else
            {
            for(int i=10;i<=n;i++)
                {
                int temp=i;
                BigInteger factorialSum = BigInteger.valueOf(0);
                while(temp!=0)
                    {
                    int digit = temp%10;
                    factorialSum = factorialSum.add(getFactorial(digit));
                    temp/=10;
                }
                if(factorialSum.mod(BigInteger.valueOf(i)).compareTo(BigInteger.valueOf(0))==0)
                    result+=i;
            }
            System.out.println(result);
        }
    }
    public static BigInteger getFactorial(int n)
        {
        BigInteger bi = BigInteger.valueOf(1);
        for(int j=2;j<=n;j++)
            {
            bi = bi.multiply(BigInteger.valueOf(j));
        }
        return bi;
    }
}
