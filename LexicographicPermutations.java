package project.euler.plus;

import java.io.*;
import java.util.*;

public class LexicographicPermutations {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int numberOfTestCases = in.nextInt();
        String s = "abcdefghijklm";
        HashMap<Long, String> permutationMap = new HashMap<Long, String>();
        
        for(int i=0;i<numberOfTestCases;i++)
            {
            long n = in.nextLong();
            if(n==1) System.out.println(s);
            else
                {
                ArrayList<Integer> list = new ArrayList<Integer>();
                for(int j=0;j<s.length();j++)
                    list.add((int)s.charAt(j));
                
                StringBuilder sb = new StringBuilder();
                long remain = n-1;
                for (int k = 1; k < s.length(); k++) {
                    long j = remain / factorial(s.length() - k);
                    remain = remain % factorial(s.length() - k);
                    sb.append((char)(int)list.get((int)j));
                    list.remove((int)j);
                    
                    if (remain == 0)
                        break;
                }
                
                for (int k=0; k<list.size(); k++)
                    sb.append((char)(int)list.get((int)k));
                System.out.println(sb);
            }
        }
    }
    public static long factorial(long n)
        {
        long fact = 1L;
        for(long i=2L;i<=n;i++) fact*=i;
        return fact;
    }
    public static String getNextPermutation(int[] arr)
        {
        int i=arr.length-1;
        while (i > 0 && arr[i - 1] >= arr[i])
            i--;
        
        if(i>0)
            {
            int j = arr.length-1;
            while(arr[j] <= arr[i-1])
                j--;
            
            int temp = arr[i - 1];
            arr[i - 1] = arr[j];
            arr[j] = temp;
            
            j = arr.length - 1;
            while (i < j) 
                {
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }
        
        i=0;
        StringBuilder sb = new StringBuilder();
        for(;i<arr.length;i++)
            sb.append((char)arr[i]);
        
        return new String(sb);
    }
    public static void printArray(int[] arr)
        {
        for(int j=0;j<arr.length;j++)
            System.out.print(arr[j] + " ");

        System.out.println();
    }
}