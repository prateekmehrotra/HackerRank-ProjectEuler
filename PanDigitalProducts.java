package project.euler.plus;

import java.io.*;
import java.util.*;

public class PanDigitalProducts {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long endVal = (long)Math.pow(10, n)-1;
        int end = (int)Math.sqrt(endVal);
        HashMap<Integer, Integer> nMap = new HashMap<Integer, Integer>();
        for(int i=1;i<=n;i++) nMap.put(i, 0);
        long productSum = 0;
        
        HashSet<Integer> set = new HashSet<Integer>();
        for(int i=1;i<=end;i++)
            {
            for(int j=i;j<=end;j++)
                {
                int product = i*j;
                int iLength = Integer.toString(i).length();
                int jLength = Integer.toString(j).length();
                int productLength = Integer.toString(product).length();
                if(iLength + jLength + productLength == n)
                    {
                    if(isPanDigital(i, j, product, nMap))
                        set.add(product);
                }
                else if(iLength + jLength + productLength>n) break;
            }
        }
        for(Integer i : set)
            productSum+=i;
            
        System.out.println(productSum);
    }
    public static boolean isPanDigital(int multiplicand, int multiplier, int product, HashMap<Integer, Integer> nMap)
        {
        HashMap<Integer, Integer> countMap = new HashMap<Integer, Integer>();
        while(multiplicand!=0)
            {
            int digit = multiplicand%10;
            if(!countMap.containsKey(digit) && nMap.containsKey(digit))
                {
                countMap.put(digit,1);
                multiplicand/=10;
            }
            else return false;
        }
        while(multiplier!=0)
            {
            int digit = multiplier%10;
            if(!countMap.containsKey(digit) && nMap.containsKey(digit))
                {
                countMap.put(digit,1);
                multiplier/=10;
            }
            else return false;
        }
        while(product!=0)
            {
            int digit = product%10;
            if(!countMap.containsKey(digit) && nMap.containsKey(digit))
                {
                countMap.put(digit,1);
                product/=10;
            }
            else return false;
        }
        return true;
    }
}
