package project.euler.plus;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class SummationOfPrimes {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int numberOfTestCases = in.nextInt();
        HashMap<Integer, Long> allSums = new LinkedHashMap<Integer, Long>();
        
        int limit = 1000000;
        boolean[] prime = new boolean[limit+1];
        prime[2] = true;
        prime[3] = true;
        int root = (int) Math.ceil(Math.sqrt(limit));
        
        //Sieve of Atkin for prime number generation
        for (int x = 1; x < root; x++)
            {
            for (int y = 1; y < root; y++)
                {
                int n = 4 * x * x + y * y;
                if (n <= limit && (n % 12 == 1 || n % 12 == 5))
                    prime[n] = !prime[n];

                n = 3 * x * x + y * y;
                if (n <= limit && n % 12 == 7)
                    prime[n] = !prime[n];

                n = 3 * x * x - y * y;
                if ((x > y) && (n <= limit) && (n % 12 == 11))
                    prime[n] = !prime[n];
            }
        }
        
        for (int i = 5; i <= root; i++)
            {
            if (prime[i])
                {
                for (int j = i * i; j < limit; j += i * i)
                    {
                    prime[j] = false;
                }
            }
        }
        
        Long sum = 0L;
        for(int i=0;i<=limit-1;i++)
            {
            if(i==0 || i==1) allSums.put(0, 0L);
            else
                {
                if(prime[i])
                    {
                    sum+=i;
                    allSums.put(i, sum);
                }
                else
                    allSums.put(i, sum);
            }
        }
        allSums.put(limit, sum);
        
        for(int i=0;i<numberOfTestCases;i++)
            {
            int n = in.nextInt();
            System.out.println(allSums.get(n));
        }
    }
}