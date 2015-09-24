package project.euler.plus;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class PrimeSummations {
    private static boolean[] prime = null;
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int numberOfTestCases = in.nextInt();
        generatePrimes();
        
        int[] primes = new int[1000];
        int i=0;
        for(int j=0;j<prime.length;j++)
            {
            if(i>999) break;
            if(prime[j])
                {
                primes[i] = j;
                i+=1;
            }
        }
        for(int k=0;k<numberOfTestCases;k++)
            {
            i=0;
            int target = in.nextInt();
            BigInteger[] ways = new BigInteger[target+1];
            for(int temp =0;temp<ways.length;temp++)
                ways[temp] = BigInteger.valueOf(0);
            ways[0] = BigInteger.valueOf(1);
            
            for (; i < primes.length; i++) {                    
                for (int j = primes[i]; j <= target; j++) {
                    ways[j] = ways[j].add(ways[j - primes[i]]);
                }
            }
            System.out.println(ways[ways.length-1]);
        }

    }
    public static void generatePrimes()
    {
        int limit = 1000000;
        prime = new boolean[limit+1];
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
    }
}
