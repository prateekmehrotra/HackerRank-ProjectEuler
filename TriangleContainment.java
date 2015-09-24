package project.euler.plus;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class TriangleContainment {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int numberOfTestCases = in.nextInt();
        in.nextLine();
        int res=0;
        for(int i=0;i<numberOfTestCases;i++)
            {
            String s = in.nextLine();
            String[] arr = s.split(" ");
            long[] a = {Integer.valueOf(arr[0]), Long.valueOf(arr[1])};
            long[] b = {Integer.valueOf(arr[2]), Long.valueOf(arr[3])};
            long[] c = {Integer.valueOf(arr[4]), Long.valueOf(arr[5])};
            long[] P = {0,0};
            if (area(a, b, c) ==
                area(a, b, P) +
                area(a, P, c) +
                area(P, b, c))
                res+=1;
        }
        System.out.println(res);
    }
    private static long area(long[] a, long[] b, long[] c) 
        {
        return Math.abs((a[0] - c[0])*(b[1] -a[1]) -
                        (a[0]-b[0])*(c[1]-a[1]));
    }
}
