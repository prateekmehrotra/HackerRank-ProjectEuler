package project.euler.plus;

import java.io.*;
import java.util.*;

public class CircularPrimes {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long res = 0;
        
        for(int i=2;i<n;i++)
            {
            if(isPrime(i))
                {
                if(isCircularPrime(i))
                    res+=i;
            }
        }
        System.out.println(res);
    }
    public static boolean isCircularPrime(int n)
        {
        String s = String.valueOf(n);
        char[] arr = s.toCharArray();
        int rotation = 0;
        while(rotation<s.length())
            {
            arr = getNextRotation(arr);
            if(!isPrime(Long.valueOf(new String(arr)))) return false;
            rotation+=1;
        }
        return true;
    }
    public static char[] getNextRotation(char[] arr)
        {
        if(arr.length>1)
            {
            char temp = arr[0];
            for(int i=0;i<arr.length-1;i++)
                {
                arr[i] = arr[i+1];
            }
            arr[arr.length-1] = temp;
        }
        return arr;
    }
    public static boolean isPrime(long num)
        {
        try
            {
            if ( num > 2 && num%2 == 0 ) return false;
            int top = (int)Math.sqrt(num) + 1;
            for(int i = 3; i < top; i+=2)
                {
                if(num % i == 0)
                    {
                    return false;
                }
            }
            return true;  
        }
        catch(Exception e)
            {
            throw e;
        }
    }
}
