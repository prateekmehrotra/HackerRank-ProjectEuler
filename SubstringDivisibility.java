package project.euler.plus;

import java.io.*;
import java.util.*;

public class SubstringDivisibility {
    private static ArrayList<String> panDigitalList = null;
    public static void main(String[] args) {
        long startTime = System.nanoTime();
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<=n;i++)
            sb.append(i);
        
        getPermutations(new String(sb));
        System.out.println(getSatisfiedPropertySum(panDigitalList, n));
        //long estimatedTime = System.nanoTime() - startTime;        
        //System.out.println("Total execution time: " + (double)estimatedTime/1000000000);
    }
    public static long getSatisfiedPropertySum(ArrayList<String> list, int n)
    {
        long sum=0;
        int[] arr = {2, 3, 5, 7, 11, 13, 17};
        if(n!=9)
            {
            for(int i=0;i<list.size();i++)
                {
                int ws = 1;
                int we = ws+3;
                int arrIndex=0;
                boolean broken = false;
                while(we<=list.get(i).length())
                    {
                    int val = Integer.valueOf(list.get(i).substring(ws, we));
                    if(val%arr[arrIndex]!=0)
                        {
                        broken=true;
                        break;
                    }
                    arrIndex+=1;
                    ws+=1;we+=1;
                }
                if(!broken) sum+=Integer.valueOf(list.get(i));
            }
        }
        else
            {
            for(int i=0;i<list.size();i++)
                {
                if(list.get(i).charAt(5) == '5')
                    {
                    int ws = 1;
                    int we = ws+3;
                    int arrIndex=0;
                    boolean broken = false;
                    while(we<=list.get(i).length())
                        {
                        int val = Integer.valueOf(list.get(i).substring(ws, we));
                        if(val%arr[arrIndex]!=0)
                            {
                            broken=true;
                            break;
                        }
                        arrIndex+=1;
                        ws+=1;we+=1;
                    }
                    if(!broken) sum+=Long.valueOf(list.get(i));
                }
            }
        }
        
        return sum;
    }
    public static void getPermutations(String s)
    {
        panDigitalList = new ArrayList<String>();
        getPermutationsUtil(new StringBuilder(s), 0, s.length() - 1);
    }
    private static void getPermutationsUtil(StringBuilder s, int start, int end)
    {
        if (start == end)
            panDigitalList.add(s.toString());
        else {
            for (int i = start; i <= end; i++) {
                swap(s, start, i);
                getPermutationsUtil(s, start + 1, end);
                swap(s, start, i);
            }
        }
    }
    private static void swap(StringBuilder s, int i, int j)
    {
        char tmp = s.charAt(i);
        s.setCharAt(i, s.charAt(j));
        s.setCharAt(j, tmp);
    }
}
