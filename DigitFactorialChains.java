package project.euler.plus;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class DigitFactorialChains {
    public static int[] factorialArray = new int[10];
    public static int[] chainLengths = new int[1000000];
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int numberOfTestCases = in.nextInt();
        populateFactorialArray();
        Arrays.fill(chainLengths, -1);
        
        for(int i=0;i<numberOfTestCases;i++)
            {
            int n = in.nextInt();
            int l = in.nextInt(); 
            boolean atLeastOneNumberFound = false;
            
            for(int j=0;j<=n;j++){
                if(chainLengths[j] == -1){
                    int chainLength = getChainLength(j);
                    chainLengths[j] = chainLength;
                    if(chainLength == l){
                        atLeastOneNumberFound = true;
                        System.out.print(j + " ");
                    }
                }
                else{
                    int chainLength = chainLengths[j];
                    if(chainLength == l){
                        atLeastOneNumberFound = true;
                        System.out.print(j + " ");
                    }
                }
            }
            if(!atLeastOneNumberFound)
                System.out.println("-1");
            else System.out.println();
        }
    }
    public static int getChainLength(int n){
        if(n==0) return 2;
        long num = n;
        HashSet<Long> set = new HashSet<Long>();
        set.add((long)n);
        //System.out.print(n + "-->");
        int size = 1;
        
        while(true){
            long res = 0;
            while(num!=0){
                int digit = (int)num%10;
                num/=10;
                res+=factorialArray[digit];
                //System.out.println("digit : " + digit);
            }
            //System.out.print(res + "-->");
            if(!set.contains(res)){
                set.add(res);
                num = res;
                size+=1;
            }
            else break;
        }
        //System.out.println();
        return size;
    }
    public static void populateFactorialArray(){
        factorialArray[0] = 1;
        factorialArray[1] = 1;
        for(int i=2;i<=9;i++) factorialArray[i] = getFactorial(i);
    }
    public static int getFactorial(int n){
        if(n==1) return 1;
        int res = 1;
        for(int j=2;j<=n;j++){
            res*=j;
        }
        return res;
    }
}