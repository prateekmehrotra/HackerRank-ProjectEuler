package project.euler.plus;

import java.io.*;
import java.util.*;

public class PanDigitalPrime {
    private static ArrayList<Integer> panDigitalSet = null;
    private static boolean[] prime = null;
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int numberOfTestCases = in.nextInt();
        int generatedPrimeLimit = 10000000;
        generatePrimes(generatedPrimeLimit);
        generatePanDigitalSet();
        
        for(int i=0;i<numberOfTestCases;i++)
            {
            long n = in.nextLong();
            
            if(n>=panDigitalSet.get(panDigitalSet.size()-1))
                System.out.println(panDigitalSet.get(panDigitalSet.size()-1));
            else
                {
                long maxFoundPrime = -1;
                Iterator it = panDigitalSet.iterator();
                while (it.hasNext()) {
                    Object element = it.next();
                    long val = Long.valueOf(element.toString());
                    if(val<=n)
                        maxFoundPrime = val;
                    else break;
                }
                if(maxFoundPrime!=-1)
                    System.out.println(maxFoundPrime);
                else System.out.println("-1");
            }
        }
    }
    public static void generatePrimes(int limit)
    {
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
    public static void generatePanDigitalSet()
    {
        panDigitalSet = new ArrayList<Integer>(); 
        int start = (int)Math.pow(10,3);
        int end = (int)Math.pow(10,4)-1;

        for(int i=start;i<=end;i++)
            {
            String js = String.valueOf(i);
            if(prime[i] && isKPanDigital(new StringBuffer(js), js.length()))
                panDigitalSet.add(i);
        }
        
        start = (int)Math.pow(10,6)+1;
        end = (int)Math.pow(10,7)-1;

        for(int i=start;i<=end;i+=2)
            {
            String js = String.valueOf(i);
            if(prime[i] && isKPanDigital(new StringBuffer(js), js.length()))
                panDigitalSet.add(i);
        }
    }
    public static boolean isKPanDigital(StringBuffer sb, int k)
    {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        String s = sb.toString();
        for(int i=0;i<s.length();i++)
            {
            if(!map.containsKey(Character.getNumericValue(s.charAt(i))))
                map.put(Character.getNumericValue(s.charAt(i)), 1);
            else return false;
        }
        for(int i=1;i<=k;i++)
            {
            if(!map.containsKey(i)) return false;
        }
        return true;
    }
    public static int getPrimeCount()
    {
        int primeCount=0;
        for(int i=0;i<prime.length;i++)
            {
            if(prime[i])
                primeCount+=1;
        }
        return primeCount;
    }
}
