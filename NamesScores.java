package project.euler.plus;

import java.io.*;
import java.util.*;

public class NamesScores {
    private static HashMap<Character, Integer> alphabetMap = null;
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int numberOfNames = in.nextInt();
        
        alphabetMap = initializeAlphabetMap(alphabetMap);
        ArrayList<String> namesList = new ArrayList<String>();
        for(int i=0;i<numberOfNames;i++)
            namesList.add(in.next().toLowerCase());
        Collections.sort(namesList);
        //printList(namesList);
        HashMap<String, Integer> indexInSortedListMap = new HashMap<String, Integer>();
        for(int i=0;i<namesList.size();i++)
            indexInSortedListMap.put(namesList.get(i), i+1);
        
        HashMap<String, Integer> scoreMap = new HashMap<String, Integer>();
        for(int i=0;i<namesList.size();i++)
            {
            int sum = 0;
            String s = namesList.get(i);
            for(int j=0;j<s.length();j++)
                {
                sum+=alphabetMap.get(s.charAt(j));
            }
            scoreMap.put(s, sum*indexInSortedListMap.get(s));
        }
        
        int q = in.nextInt();
        for(int i=0;i<q;i++)
            System.out.println(scoreMap.get(in.next().toLowerCase()));
    }
    public static HashMap<Character, Integer> initializeAlphabetMap(HashMap<Character, Integer> alphabetMap)
        {
        alphabetMap = new HashMap<Character, Integer>();
        for(int i=97;i<=122;i++)
            alphabetMap.put((char)i, i-96);   
        return alphabetMap;
    }
    public static void printList(List<String> list)
        {
        for (String i : list)
            System.out.println(i);
    }
}
