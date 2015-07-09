package project.euler.plus;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class SmallestMultiple {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int numberOfTestCases = in.nextInt();
        for(int i=0;i<numberOfTestCases;i++)
            {
            Integer n = in.nextInt();
            HashMap<Integer, Integer> seenFactors = new HashMap<Integer, Integer>();
            for(int j=2;j<=n;j++)
                {
                List<Integer> list = primeFactorize(j);
                HashMap<Integer, Integer> currentListCounts = new HashMap<Integer, Integer>();
                for(int k=0;k<list.size();k++)
                    {
                    Integer key = list.get(k);
                    if(currentListCounts.containsKey(key))
                        {
                        currentListCounts.put(key, currentListCounts.get(key)+1);
                    }
                    else
                        {
                        currentListCounts.put(key, 1);
                    }
                }
                for(Integer key: currentListCounts.keySet())
                    {
                    if(seenFactors.containsKey(key))
                        {
                        Integer count = currentListCounts.get(key);
                        Integer curVal = seenFactors.get(key);
                        if(count>curVal) seenFactors.put(key, curVal+(count-curVal));
                    }
                    else
                        {
                        seenFactors.put(key, currentListCounts.get(key));
                    }
                }
            }
            long smallestMultiple = 1;
            for(Integer key: seenFactors.keySet())
                {
                for(int var = 1;var<=seenFactors.get(key);var++)
                    {
                    smallestMultiple*=key;
                }
            } 
            System.out.println(smallestMultiple);
        }
    }
    public static List<Integer> primeFactorize(Integer n)
        {
        try
            {
            List<Integer> list = new ArrayList<Integer>();
            for(int i=2;i<=n/i;i++)
                {
                while(n%i==0)
                    {
                    list.add(i);
                    n/=i;
                }
            }
            if(n>1) list.add(n);
            return list;
            
        }
        catch(Exception e)
            {
            throw e;
        }
    }
    public static void printList(List<Integer> list)
        {
        for (Integer i : list) 
            {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}