package project.euler.plus;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class HighlyDivisibleTriangularNumber {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int numberOfTestCases = in.nextInt();
        HashMap<Integer, Integer> seenFactors = new LinkedHashMap<Integer, Integer>();
    
        for(int i=0;i<numberOfTestCases;i++)
            {
            int numberOfDivisors = in.nextInt();
            int numberOfTriangleNumbersToBeGenerated=2;
            int index=1;
            while(index<=numberOfTriangleNumbersToBeGenerated)
                {
                int sumToIndex = (index*(index+1))/2;
                int numberOfFactors = 0;
                if(!seenFactors.containsKey(sumToIndex))
                    {
                    numberOfFactors = factorize(sumToIndex);
                    seenFactors.put(sumToIndex, numberOfFactors);
                }
                else
                    {
                    numberOfFactors = seenFactors.get(sumToIndex);
                }
                if(numberOfFactors>numberOfDivisors)
                    {
                    System.out.println(sumToIndex);
                    break;
                }
                else if(numberOfFactors<=numberOfDivisors) numberOfTriangleNumbersToBeGenerated+=2;
                index+=1;
            }
        }
    }
    public static Integer factorize(Integer n)
        {
        try
            {
            List<Integer> list = new ArrayList<Integer>();
            HashMap<Integer, Integer> exponentCount = new HashMap<Integer, Integer>();
            
            for(int i=2;i<=n/i;i++)
                {
                while(n%i==0)
                    {
                    list.add(i);
                    n/=i;
                }
            }
            if(n>1) list.add(n);
            
            //printList(list);
            for(int i=0;i<list.size();i++)
                {
                if(!exponentCount.containsKey(list.get(i)))
                    {
                    exponentCount.put(list.get(i),1);
                }
                else
                    {
                    int currentCount = exponentCount.get(list.get(i));
                    exponentCount.put(list.get(i), currentCount+1);
                }
            }
            
            int exponentProduct = 1;
            for (Map.Entry<Integer, Integer> entry : exponentCount.entrySet()) 
                {
                    exponentProduct*=entry.getValue()+1;
            }
            return exponentProduct; 
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