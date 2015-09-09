package project.euler.plus;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class DistinctPrimeFactors {
    private static boolean[] prime = null;
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int limit = 2500000;
        int root = (int) Math.ceil(Math.sqrt(limit));
        prime = generatePrimes(root, limit);
        
        for(int i=2;i<=n;i++)
            {
            ArrayList<TreeSet> list = new ArrayList<TreeSet>();
            if(!prime[i])
                {
                for(int j=0;j<k;j++)
                    {
                    if(!prime[i+j])
                        {
                        TreeSet s = primeFactorize(i+j);
                        if(s.size()==k)
                            list.add(s);
                        else break;
                    }
                    else break;
                }
            }
            if(list.size()==k)
                System.out.println(i);
        }
    }
    public static TreeSet<Integer> primeFactorize(Integer n)
    {
        try
        {
            TreeSet<Integer> set = new TreeSet<Integer>();
            for(int i=2;i<=n/i;i++)
                {
                while(n%i==0)
                    {
                    set.add(i);
                    n/=i;
                }
            }
            if(n>1) set.add(n);
            return set;
        }
        catch(Exception e)
            {
            throw e;
        }
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
