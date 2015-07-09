package project.euler.plus;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class MultiplesOfThreeAndFive {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        long numberOfTestCases = in.nextLong();
        for(long i=0;i<numberOfTestCases;i++)
            {
            long num = in.nextLong();
            long firstThreeTerm = 3;
            long divThree = (num-1)/3;
            long lastThreeTerm = 3*divThree;
            long numberOfThreeTerms = (lastThreeTerm-firstThreeTerm)/3+1;
            BigDecimal threeSumTemp = BigDecimal.valueOf(numberOfThreeTerms).multiply(BigDecimal.valueOf(3).add(BigDecimal.valueOf(lastThreeTerm)));
            BigDecimal threeSum = threeSumTemp.divide(BigDecimal.valueOf(2));
            
            long firstFiveTerm = 5;
            long divFive = (num-1)/5;
            long lastFiveTerm = 5*divFive;
            long numberOfFiveTerms = (lastFiveTerm-firstFiveTerm)/5+1;
            BigDecimal fiveSumTemp = BigDecimal.valueOf(numberOfFiveTerms).multiply(BigDecimal.valueOf(5).add(BigDecimal.valueOf(lastFiveTerm)));
            BigDecimal fiveSum = fiveSumTemp.divide(BigDecimal.valueOf(2));
            
            long firstFifteenTerm = 15;
            long divFifteen = (num-1)/15;
            long lastFifteenTerm = 15*divFifteen;
            long numberOfFifteenTerms = (lastFifteenTerm-firstFifteenTerm)/15+1;
             BigDecimal fifteenSumTemp = BigDecimal.valueOf(numberOfFifteenTerms).multiply(BigDecimal.valueOf(15).add(BigDecimal.valueOf(lastFifteenTerm)));
            BigDecimal fifteenSum = fifteenSumTemp.divide(BigDecimal.valueOf(2));
            
            BigDecimal tempRes = threeSum.add(fiveSum);
            BigDecimal res = tempRes.subtract(fifteenSum);
            System.out.println(res.toBigInteger());
        }
    }
}