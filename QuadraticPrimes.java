package project.euler.plus;

import java.io.*;
import java.util.*;

public class QuadraticPrimes {
    private static boolean[] prime = null;
    public static void main(String[] args) {  
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        int maxPrimesEncountered = 0;
        int maxA=0;int maxB=0;
        
        int limit = 10000000;
        int root = (int) Math.ceil(Math.sqrt(limit));
        prime = generatePrimes(root, limit);
        
        for(int a=num*-1;a<=num;a++)
            {
            for(int b=2;b<=num;b++)
                {
                if(b>0 && a*b<0 && prime[b] && (1+a+b)%2!=0)
                    {
                    int primeCount = getPrimeCount(a, b, num);
                    
                    if(primeCount>maxPrimesEncountered)
                        {
                        maxPrimesEncountered = primeCount;
                        maxA = a;
                        maxB = b;
                    }
                }
            }
        }
        System.out.println(maxA + " " + maxB);
    }
    public static int getPrimeCount(int a, int b, int num)
        {
        int primeCount=0;
        for(int n=0;n<num;n++)
            {
            int nSquared = (int)Math.pow(n,2);
            int res = nSquared + n*a + b;
            if(res>0 && prime[res]) primeCount+=1;
            else break;
        }
        return primeCount;
    }
    public static boolean[] generatePrimes(int root, int limit)
        {
        boolean[] prime = new boolean[limit+1];
        prime[2] = true;
        prime[3] = true;
        
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
        
        return prime;
    }
}