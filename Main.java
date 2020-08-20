import java.util.Scanner;  // Import the Scanner class

class Main {     
    public static void main(String[] args) {         
        int row, col, i, j;
        int arr[][] = new int[100][100];
        Scanner scan = new Scanner(System.in);
    
        row = scan.nextInt();
        col = scan.nextInt();
     
        for(i=0; i<row; i++)
        {
            for(j=0; j<col; j++)
            {
                arr[i][j] = scan.nextInt();
            }
        }
        Integer sum = new Solution().numBoats(arr, row , col);
        System.out.println(sum);  // Output user input      
    }
}

class Solution {
    public int numBoats(int[][] arr, int row , int col) {
       // insert your solution here
       int ans=0;
       int sol[][]=new int[row][col];
       for(int i=0;i<row;i++)
       {
           for(int j=0;j<col;j++)
           {
               ans+=d(arr,sol,i,j,row,col);
           }
       }
       return ans;
    }
    
    public static int d(int a[][],int sol[][],int s,int l,int row,int col)
    {
        if(a[s][l]==0 || sol[s][l]==1)
        {
            return 0;
        }
        sol[s][l]=1;
        for(int k=s+1;k<row;k++)
        {
            if(a[k][l]==0)
            {
                break;
            }
            else
            {
                sol[k][l]=1;
            }
        }
        for(int k=l+1;k<col;k++)
        {
            if(a[s][k]==0)
            {
                break;
            }
            else
            {
                sol[s][k]=1;
            }
        }
        int k1=s+1;
        int k2=l+1;
        while(k1<row && k2<col)
        {
            if(a[k1][k2]==0)
            {
                break;
            }
            else
            {
                sol[k1][k2]=1;
            }
            k1++;
            k2++;
        }
        return 1;
    }
}