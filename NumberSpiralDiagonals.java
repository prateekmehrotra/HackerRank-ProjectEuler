package project.euler.plus;

import java.io.*;
import java.util.*;
import java.math.*;

public class NumberSpiralDiagonals {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int numberOfTestCases = in.nextInt();
        for(int i=0;i<numberOfTestCases;i++)
            {
            BigInteger n = in.nextBigInteger();
            n=n.subtract(BigInteger.valueOf(1));
            n=n.divide(BigInteger.valueOf(2));
            
            BigInteger p1 = n.pow(3);
            p1 = p1.multiply(BigInteger.valueOf(16));
            BigInteger p2 = n.pow(2);
            p2 = p2.multiply(BigInteger.valueOf(30));
            BigInteger p3 = n.multiply(BigInteger.valueOf(26));
            BigInteger res = p1.add(p2).add(p3).add(BigInteger.valueOf(3));
            res = res.divide(BigInteger.valueOf(3));
            System.out.println(res.mod(BigInteger.valueOf(1000000007)));
        }
    }
}
