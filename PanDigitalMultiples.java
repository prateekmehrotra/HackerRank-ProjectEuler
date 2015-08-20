package project.euler.plus;

import java.io.*;
import java.util.*;

public class PanDigitalMultiples {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        
        for(int i=2;i<n;i++)
            {
            StringBuffer sb = new StringBuffer();
            for(int j=1;j<=k;j++)
                {
                long product = i*j;
                sb.append(product);
                if(sb.length() == k && isKPanDigital(sb, k))
                    System.out.println(i);
            }
        }
    }
    public static boolean isKPanDigital(StringBuffer sb, int k)
        {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        String s = sb.toString();
        for(int i=0;i<s.length();i++)
            {
            if(!map.containsKey(Character.getNumericValue(s.charAt(i))))
                map.put(Character.getNumericValue(s.charAt(i)), 1);
            else return false;
        }
        for(int i=1;i<=k;i++)
            {
            if(!map.containsKey(i)) return false;
        }
        return true;
    }
}
