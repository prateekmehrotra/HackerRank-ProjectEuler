package project.euler.plus;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class LongestCollatzSequence {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        //long startTime = System.nanoTime();  
        Scanner in = new Scanner(System.in);
        int numberOfTestCases = in.nextInt();
        Integer[] arr = new Integer[5000001];
        Integer[] highestBelowArr = new Integer[5000001];
        Integer maxChainLengthStartIndex = 0;
        Integer maxChainLengthStartSize = 0;
        
        for(int j=1;j<=5000000;j+=1)
            {
            if(arr[j]==null)
                {
                long lastElementAdded = j;
                int chainLength = 1;
                while(lastElementAdded!=1)
                    {
                    if(lastElementAdded<arr.length && arr[(int)lastElementAdded]!=null)
                        {
                        chainLength+=arr[(int)lastElementAdded];
                        chainLength-=1;
                        break;
                    }
                    else
                        {
                        lastElementAdded=(lastElementAdded&1)==1?(lastElementAdded * 3)+1:lastElementAdded/2 ;
                        chainLength+=1;
                    }
                }
                arr[j] = chainLength;
            }

            if(arr[j]>=maxChainLengthStartSize)
                {
                maxChainLengthStartSize = arr[j];
                maxChainLengthStartIndex = j;
            }

            highestBelowArr[j] = maxChainLengthStartIndex;
            if(j+1<highestBelowArr.length)
                highestBelowArr[j+1] = maxChainLengthStartIndex;
        }
    
        for(int i=0;i<numberOfTestCases;i++)
            {
            int n = in.nextInt();
            System.out.println(highestBelowArr[n]);
        }
        //long estimatedTime = System.nanoTime() - startTime;        
        //System.out.println("Total execution time: " + (double)estimatedTime/1000000000);
    }
}