package project.euler.plus;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class LargestPrimeFactor {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int numberOfTestCases = in.nextInt();
        for(int i=0;i<numberOfTestCases;i++)
            {
            Long n = in.nextLong();
            Long maxPrimeFactor = primeFactorize(n);
            System.out.println(maxPrimeFactor);
        }
    }
    public static Long primeFactorize(Long n)
        {
        try
            {
            Long maxPrimeFactor = 1L;
            for(Long i=2L;i<=n/i;i++)
                {
                while(n%i==0)
                    {
                    if(i>maxPrimeFactor) maxPrimeFactor=i;
                    n/=i;
                }
            }
            if(n>1)
                {
                if(n>maxPrimeFactor) maxPrimeFactor = n;
            }
            return maxPrimeFactor;
        }
        catch(Exception e)
            {
            throw e;
        }
    }
}