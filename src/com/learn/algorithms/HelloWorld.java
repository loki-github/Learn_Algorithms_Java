package com.learn.algorithms;

public class HelloWorld {

	public static void main(String[] args) {
		int[][] mat=new int[3][3];
		int row=1,col=2;
		//makeZeros(mat, row, col, 3, 3);
		int inp[]=new int[]{100,2,-30,-20,-40,-99,6,1,8,9,20,80,99,-90,120};
		find3Largest(inp);
		find3Largest(inp);
	}
	
	private static void makeZeros(int[][] mat,int row,int col,int m,int n){
		for(int i=0;i<n;i++)
			mat[row][i]=1;
		for(int i=0;i<m;i++){
			mat[i][col]=1;
		}
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				System.out.print(mat[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	private static void printPairSum(int a[],int S){
		
	}
	
	private static void find3Largest(int[] inp){
		int max1=0;
		int max2=0;
		int max3=0;
		int min1=0;
		int min2=0;
	
		for(int i=0;i<inp.length;i++){
			if(inp[i]>max1){
				max3=max2;
				max2=max1;
				max1=inp[i];
			}else if(inp[i]>max2){
				max3=max2;
				max2=inp[i];
			}else if(inp[i]>max3){
				max3=inp[i];
			}
			if(inp[i]<min1){
				min2=min1;
				min1=inp[i];
			}else if(inp[i]<min2){
				min2=inp[i];
			}
				
		}
				
		System.out.println("max1="+max1+" max2="+max2+" max3="+max3+"min1="+min1+" min2="+min2);
	}
	
	
}
