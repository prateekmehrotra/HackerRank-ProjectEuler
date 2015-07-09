package project.euler.plus;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class SumSquareDifference {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int numberOfTestCases = in.nextInt();
        for(int i=0;i<numberOfTestCases;i++)
            {
            long n = in.nextLong();
            long sumOfSquares = (n*(n+1)*((2*n)+1))/6;
            long squareOfSum = (long)Math.pow((n*(n+1))/2,2);
            System.out.println(squareOfSum-sumOfSquares);
        }
    }
}