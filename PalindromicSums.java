package project.euler.plus;

import java.io.*;
import java.util.*;
import java.math.*;

public class PalindromicSums {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int numberOfTestCases = in.nextInt();
        for(int i=0;i<numberOfTestCases;i++)
            {
            int n = in.nextInt();
            int d = in.nextInt();
            double sqrtLimit = Math.sqrt(n);

            BigInteger sum = BigInteger.valueOf(0);
            HashSet<Long> set = new HashSet<Long>();
            
            for(int j=1;j<=sqrtLimit;j++){
                long number = j*j;
                int k = j+d;
                //System.out.println("j " + j);
                while(number < n && k<=sqrtLimit){
                    number+=k*k;
                    if(number == reverse(number) && number<n){
                        //System.out.println(k + ":" + number);
                        if(!set.contains(number)){
                            //System.out.println("addedToSet: " + number);
                            sum=sum.add(BigInteger.valueOf(number));
                            set.add(number);
                        }
                    } 
                    k+=d;
                    //System.out.println(k);
                }
                //System.out.println("kEnd " + number);
            }
            System.out.println(sum);
            //System.out.println("test case end.");
        }
    }
    public static long reverse(long number){
        long reverse = 0;
        while(number!=0){
            reverse = reverse*10 + number%10;
            number/=10;
        }
        return reverse;
    }
}