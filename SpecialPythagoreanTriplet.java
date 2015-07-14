package project.euler.plus;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class SpecialPythagoreanTriplet {

    public static void main(String[] args) {
        //long startTime = System.nanoTime();    
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        Integer numberOfTestCases = in.nextInt();
        HashMap<Long, Long> seenValues = new LinkedHashMap<Long, Long>();
        for(int i=0;i<numberOfTestCases;i++)
            {
            Long n = in.nextLong();
            if(seenValues.containsKey(n))
                {
                System.out.println(seenValues.get(n));
            }
            else
                {
                long maxProduct = -1;
                boolean atLeastOneTripletExists = false;
                for(int j=3;j<=Math.ceil(n/3);j++)
                    {
                    if((Math.pow(n,2) - 2*n*j)%(2*n-2*j)==0)
                        {
                        int k= (int)((Math.pow(n,2) - 2*n*j)/(2*n-2*j));
                        atLeastOneTripletExists = true;
                        long product = j*k*(n-(j+k));
                        if(product>maxProduct) maxProduct = product;
                    }
                }
                if(!atLeastOneTripletExists)
                    {
                    seenValues.put(n, -1L);
                    System.out.println(-1);
                }
                else if(maxProduct!=-1)
                    {
                    seenValues.put(n, maxProduct);
                    System.out.println(maxProduct);
                }
            }
        }
        //long estimatedTime = System.nanoTime() - startTime;        
        //System.out.println("Total execution time: " + (double)estimatedTime/1000000000);
    }
}
