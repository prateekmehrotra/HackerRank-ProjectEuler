package project.euler.plus;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class LargestProductInAGrid {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        Integer[][] arr = new Integer[20][20];
        int rowIndex=0;
        for(int i=0;i<20;i++)
            {
            String s = in.nextLine();
            String[] splitArray = s.split(" "); 
            for(int colIndex=0;colIndex<splitArray.length;colIndex++)
                {
                arr[rowIndex][colIndex] = Integer.parseInt(splitArray[colIndex]);
            }
            rowIndex+=1;
        }
        //print2DArray(arr, 20, 20);
        
        long maxProduct = 1L;
        for(int i=0;i<20;i++)
            {
            for(int j=0;j<20;j++)
                {
                if(j+3<=19)
                    {
                    long rightProduct = arr[i][j] * arr[i][j+1] * arr[i][j+2] * arr[i][j+3];
                    if(rightProduct>maxProduct) maxProduct = rightProduct;
                }
                if(i+3<=19)
                    {
                    long bottomProduct = arr[i][j] * arr[i+1][j] * arr[i+2][j] * arr[i+3][j];
                    if(bottomProduct>maxProduct) maxProduct = bottomProduct;
                }
                if(i+3<=19 && j+3<=19)
                    {
                    long bottomRightDiaonal = arr[i][j] * arr[i+1][j+1] * arr[i+2][j+2] * arr[i+3][j+3];
                    if(bottomRightDiaonal>maxProduct) maxProduct = bottomRightDiaonal;
                }
                if(j-3>=0)
                    {
                    long leftProduct = arr[i][j] * arr[i][j-1] * arr[i][j-2] * arr[i][j-3];
                    if(leftProduct>maxProduct) maxProduct = leftProduct;
                }
                if(i-3>=0)
                    {
                    long topProduct = arr[i][j] * arr[i-1][j] * arr[i-2][j] * arr[i-3][j];
                    if(topProduct>maxProduct) maxProduct = topProduct;
                }
                if(i-3>=0 && j-3>=0)
                    {
                    long topLeftDiagonal = arr[i][j] * arr[i-1][j-1] * arr[i-2][j-2] * arr[i-3][j-3];
                    if(topLeftDiagonal>maxProduct) maxProduct = topLeftDiagonal;
                }
                if(i-3>=0 && j+3<=19)
                    {
                    long topRightDiagonal = arr[i][j] * arr[i-1][j+1] * arr[i-2][j+2] * arr[i-3][j+3];
                    if(topRightDiagonal>maxProduct) maxProduct = topRightDiagonal;
                }
                if(i+3<=19 && j-3>=0)
                    {
                    long bottomLeftDiagonal = arr[i][j] * arr[i+1][j-1] * arr[i+2][j-2] * arr[i+3][j-3];
                    if(bottomLeftDiagonal>maxProduct) maxProduct = bottomLeftDiagonal;
                }
            }
        }
        System.out.println(maxProduct);
    }
    public static void print2DArray(Integer[][] arr, int r, int c)
        {
        for(int i=0;i<r;i++)
            {
            for(int j=0;j<c;j++)
                {
                if(j!=c-1) System.out.print(arr[i][j] + " ");
                else System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }
}
