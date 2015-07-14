package project.euler.plus;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class LargestProductInASeries {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        Integer numberOfTestCases = in.nextInt();
        for(int i=0;i<numberOfTestCases;i++)
            {
            int n = in.nextInt();
            int k = in.nextInt();
            String s = in.next();
            StringBuilder sb = new StringBuilder(s);
            ArrayList<Integer> list = new ArrayList<Integer>();
            Long maxProduct = 0L;
            
            while(sb.length()!=0)
                {
                Integer digit = Character.getNumericValue(sb.charAt(sb.length()-1));
                sb = sb.deleteCharAt(sb.length()-1);
                
                if(list.size()<k)
                    {
                    list.add(digit);
                    //printList(list);
                }
                if(list.size()%k==0)
                    {
                    Long product = getProduct(list);
                    if(product > maxProduct)
                        {
                        maxProduct = product;
                    }
                    list.remove(0);
                }
            }
            System.out.println(maxProduct);
        }
    }
    public static Long getProduct(ArrayList<Integer> list)
        {
        Long product = 1L;
        for(int i=0;i<list.size();i++)
            {
            product*=list.get(i);
        }
        return product;
    }
    public static void printList(ArrayList<Integer> list)
        {
        for(int i=0;i<list.size();i++)
            {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
    }
}
