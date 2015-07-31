package project.euler.plus;

import java.io.*;
import java.util.*;

public class NonAbundantSums {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int numberOfTestCases = in.nextInt();
        LinkedHashMap<Integer, Long> amicableNumbersMap = new LinkedHashMap<Integer, Long>();
        for(int j=0;j<=100000;j++)
            {
            long sumOfDivisors = getSumOfProperDivisors(j);
            if(sumOfDivisors>j) amicableNumbersMap.put(j, sumOfDivisors);
        }
        
        for(int i=0;i<numberOfTestCases;i++)
            {
            long n = in.nextLong();
            boolean pairFound = false;
            ArrayList<Integer> list = new ArrayList<Integer>();
            for(int j=0;j<=n;j++)
                {
                if(amicableNumbersMap.containsKey(j))
                    list.add(j);
            }
            
            for(int k=0;k<list.size();k++)
            {
                for(int l=k;l<list.size();l++)
                {
                    if(list.get(k) + list.get(l) == n)
                    {
                        pairFound = true;
                        break;
                    }
                }
                if(pairFound) break;
            }
            if(pairFound) System.out.println("YES");
            else System.out.println("NO");
        }
    }
    public static void printList(ArrayList<Integer> list)
        {
        for (Integer i : list)
            System.out.println(i);
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
