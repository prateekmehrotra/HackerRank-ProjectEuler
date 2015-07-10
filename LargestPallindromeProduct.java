package project.euler.plus;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class LargestPallindromeProduct {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int numberOfTestCases = in.nextInt();
        for(int i=0;i<numberOfTestCases;i++)
            {
            long n = in.nextLong();
            long maxProduct = 1L;
            for(long j=999L;j>100L;j--)
                {
                for(long k=990L;k%11==0 && k>100;k-=11)
                    {
                    long product = k*j;
                    String productString = Long.toString(product);
                    String reversedProductString = new StringBuilder(productString).reverse().toString();
                    if(productString.length()==6 && productString.equals(reversedProductString) && product<n)
                        {
                        //System.out.println(product + " " + j + ":" + k);
                        if(product>maxProduct)
                            {
                            maxProduct = product;
                        }
                    }
                }
            }
            System.out.println(maxProduct);
        }
    }
}