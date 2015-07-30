package project.euler.plus;

import java.io.*;
import java.util.*;

public class AmicableNumbers {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int numberOfTestCases = in.nextInt();
        HashMap<Integer, Long> sumUnderN = new HashMap<Integer, Long>();
        
        long sum = 0;
        for(int j=1;j<100000;j++)
            {
            int a = j;  
            long da = getSumOfProperDivisors(a); 
            long b = da; 
            long db = getSumOfProperDivisors(b); 
            if(a!=b && a==db)
                {
                sum+=a;
                sumUnderN.put(j, sum);
            }
            else sumUnderN.put(j, sum);
        }
        
        for(int i=0;i<numberOfTestCases;i++)
            {
            int n = in.nextInt();
            System.out.println(sumUnderN.get(n));
        }
    }
    public static long getSumOfProperDivisors(long n)
        {
        if(n==0) return 0;
        if(n==1) return 1;
        
        int maxD = (int)Math.sqrt(n);
        long sum=1;
        for(int i=2;i<=maxD;i++)
            {
            if(n%i==0)
                {
                sum += i;
                long d = n/i;
                if(d!=i)
                    sum+=d;
            }
        }
        return sum;
    }
}
