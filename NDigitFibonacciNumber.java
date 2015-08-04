package project.euler.plus;

import java.io.*;
import java.util.*;
import java.math.*;

public class NDigitFibonacciNumber {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        long numberOfTestCases = in.nextLong();
        for(long i=0;i<numberOfTestCases;i++)
            {
            int numberOfDigits = in.nextInt();
            if(numberOfDigits==1) System.out.println(1);
            else
                {
                int numberOfDigitsEncountered = 0;
                int nthFibonacci = 1;
                while(numberOfDigitsEncountered<numberOfDigits)
                    {
                    double rootFive = Math.sqrt(5);
                    double logFiveOverTwo = Math.log10(rootFive);
                    double digits = nthFibonacci*Math.log10((1+rootFive)/2) - logFiveOverTwo;
                    int ds = (int)digits+1;
                    if(ds == numberOfDigits) break;
                    numberOfDigitsEncountered=ds;
                    nthFibonacci+=1;
                }
                System.out.println(nthFibonacci);
            }
        }
    }
}
