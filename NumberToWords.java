package project.euler.plus;

import java.io.*;
import java.util.*;

public class NumberToWords {
    private static String[] numNames = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private static String[] tensNames = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int numberOfTestCases = in.nextInt();
        for(int i=0;i<numberOfTestCases;i++)
            {
            long n = in.nextLong();
            String sr = String.valueOf(n);
            int numberOfGroups = 0;
            if(sr.length()%3==0)
                numberOfGroups = sr.length()/3;
            else numberOfGroups = sr.length()/3 + 1;
            int groupsForPrinting = numberOfGroups;
            int len = sr.length();
            StringBuilder sb = null;
            Stack<String> finalStack = new Stack<String>();
            while(numberOfGroups!=0)
                {
                sb = new StringBuilder();
                if(len-3>=0)
                    sb.append(sr.charAt(len-3));
                if(len-2>=0)
                    sb.append(sr.charAt(len-2));
                if(len-1>=0)
                    sb.append(sr.charAt(len-1));
                finalStack.push(new String(sb));
                
                len-=3;
                numberOfGroups-=1;
            }
            while(!finalStack.isEmpty())
                {
                int val = Integer.valueOf(finalStack.pop());
                if(val!=0)
                    {
                    Stack<String> s = getWordsLessThanThousand(val);
                    if(s!=null) printStack(s);
                    if(groupsForPrinting==5)
                        System.out.print("Trillion ");
                    if(groupsForPrinting==4)
                        System.out.print("Billion ");
                    if(groupsForPrinting==3)
                        System.out.print("Million ");
                    if(groupsForPrinting==2)
                        System.out.print("Thousand ");
                }
                groupsForPrinting-=1;
            }
            System.out.println();
        }
    }
    public static Stack<String> getWordsLessThanThousand(long n)
        {
        Stack<String> s = null;
        if(n<numNames.length)
            System.out.print(numNames[(int)n] + " ");
        else if(n/10<10 && n%10==0)
            System.out.print(tensNames[(int)n/10] + " ");
        else
            { 
            long num = n;
            int index = 1;
            s = new Stack<String>();
            boolean firstMod = false;
            while(num!=0)
                {
                if(num%100<numNames.length && !firstMod)
                    {
                    int digit = (int)num%100;
                    if(index==100) 
                        {
                        s.push("Hundred");
                        s.push(numNames[digit]);
                    }
                    else s.push(numNames[digit]);
                    index*=100;
                    num/=100;
                }
                else
                    {   
                    firstMod = true;
                    int digit = (int)num%10;
                    if(index<10)
                        {
                        s.push(numNames[digit]);
                    }
                    if(index==10) 
                        s.push(tensNames[digit]); 
                    if(index==100) 
                        {
                        s.push("Hundred");
                        s.push(numNames[digit]);
                    }
                    num/=10;
                    index*=10;
                }
            }
        }
        return s;
    }
    public static void printStack(Stack<String> s)
        {
        while(!s.isEmpty())
            {
            String str = s.pop();
            if(!str.equals(""))
                System.out.print(str + " ");
        }
    }
}
