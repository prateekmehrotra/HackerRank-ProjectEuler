package project.euler.plus;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class FindNthPrime {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        //long startTime = System.nanoTime();    
        Scanner in = new Scanner(System.in);
        long numberOfTestCases = in.nextInt();
        HashMap<Long, Integer> seenPrimes = new LinkedHashMap<Long, Integer>();
        int primesFound = 2;
        int j=3;
        
        for(long i=0L;i<numberOfTestCases;i++)
            {
            Long n = in.nextLong();
            if((long)n == 1L)
                {
                System.out.println("2");
            }
            if(seenPrimes.containsKey(n))
                {
                System.out.println(seenPrimes.get(n));
            }
            else
                {
                for(;primesFound<=n;j+=2)
                    {
                    if(isPrime(j))
                        {
                        if((long)primesFound == n)
                            {
                            System.out.println(j);
                            break;
                        }
                        if(!seenPrimes.containsKey(primesFound))
                            {
                            seenPrimes.put((long)primesFound, j);
                        }
                        primesFound+=1;
                    }
                }   
            }    
        }
        //long estimatedTime = System.nanoTime() - startTime;        
        //System.out.println("Total execution time: " + (double)estimatedTime/1000000000);
    }
    
    public static boolean isPrime(long num)
        {
        try
            {
            if ( num > 2 && num%2 == 0 ) return false;
            int top = (int)Math.sqrt(num) + 1;
            for(int i = 3; i < top; i+=2)
                {
                if(num % i == 0)
                    {
                return false;
                }
            }
            return true;  
        }
        catch(Exception e)
            {
            throw e;
        }
    }
}