package project.euler.plus;

import java.io.*;
import java.util.*;
import java.math.*;

public class DigitNthPower {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long end = (long)(n*Math.pow(9, n));
        long finalSum = 0;
        
        for(long i=2;i<=end;i++)
            {
            long digitSum = getDigitSum(i, n);
            if(i==digitSum)
                finalSum+=digitSum;
        }
        System.out.println(finalSum);
    }
    public static long getDigitSum(long num, int pow)
        {
        long digitSum = 0;
        while(num!=0)
            {
            int digit = (int)num%10;
            digitSum+=(long)Math.pow(digit, pow);
            num/=10;
        }
        return digitSum;
    }
}
