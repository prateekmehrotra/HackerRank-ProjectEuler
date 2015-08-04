package project.euler.plus;

import java.io.*;
import java.util.*;
import java.math.*;

public class ReciprocalCycles {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int numberOfTestCases = in.nextInt();
        int[] cycleLengths = new int[10000];
        
        int maxSize = 0;
        int maxD = 0;
        for(int j=3;j<10000;j++)
            {
            if(isPrime(j) && j%2!=0)
                {
                HashMap<Integer, Integer> seenRemainders = new HashMap<Integer, Integer>();
                int num = 1;
                int remainder = num%j;
                while(!seenRemainders.containsKey(remainder))
                    {
                    seenRemainders.put(remainder, num);
                    num = remainder*10;
                    remainder = num%j;
                }
                if(seenRemainders.size()>maxSize)
                    {
                    maxSize = seenRemainders.size();
                    maxD = j;
                }
                cycleLengths[j] = maxD;
            }
            else
                cycleLengths[j] = maxD;
        }
        
        for(int i=0;i<numberOfTestCases;i++)
            System.out.println(cycleLengths[in.nextInt()-1]);
    }
    public static boolean isPrime(long num)
        {
        try
            {
            if (num > 2 && num%2 == 0 ) return false;
            int top = (int)Math.sqrt(num) + 1;
            for(int i = 3; i < top; i+=2)
                {
                if(num % i == 0)
                    return false;
            }
            return true;  
        }
        catch(Exception e)
            {
            throw e;
        }
    }
}
