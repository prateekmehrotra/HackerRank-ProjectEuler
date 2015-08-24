package project.euler.plus;

import java.io.*;
import java.util.*;
import java.math.*;

public class CodedTriangleNumbers {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int numberOfTestCases = in.nextInt();
        for(int i=0;i<numberOfTestCases;i++)
            {
            long n = in.nextLong();
            long perfectSquareNum = 8*n+1;
            if(isPerfectSquare(perfectSquareNum))
                {
                double term = 0.5*(Math.sqrt(perfectSquareNum))-0.5;
                System.out.println((long)term);
            }
            else System.out.println("-1");
        }
    }
    private static boolean isPerfectSquare(long n)
        {
        long root = (long)Math.sqrt(n);
        return n == root*root;
    }
}
