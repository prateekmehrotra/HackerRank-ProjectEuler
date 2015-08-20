package project.euler.plus;

import java.io.*;
import java.util.*;

public class DoubleBasePallindromes {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        long res = 0;
        
        for(int i=1;i<n;i++)
            {
            if(isPallindrome(String.valueOf(i)) && isPallindrome(getNumberInGivenBase(i, k)))
                res+=i;
        }
        System.out.println(res);
    }
    public static boolean isPallindrome(String s)
        {
        String reverse = new StringBuffer(s).reverse().toString();
        return s.equals(reverse);
    }
    public static String getNumberInGivenBase(int n, int k)
        {
        Stack<Integer> s = new Stack<Integer>();
        while(n!=0)
            {
            s.push(n%k);
            n/=k;
        }
        StringBuffer sb = new StringBuffer();
        while(!s.isEmpty())
            {
            sb.append(s.pop());
        }
        return new String(sb);
    }
}
