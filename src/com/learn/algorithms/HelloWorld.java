package com.learn.algorithms;

import java.util.Stack;

public class HelloWorld {

	public static void main(String[] args) {
		int[][] mat=new int[3][3];
		int row=1,col=2;
		//makeZeros(mat, row, col, 3, 3);
		int inp[]=new int[]{1,2,3,4};
//		swap(inp);
//		System.out.println(inp[0]+" "+inp[1]);
		find3LargestAnd2Smallest(inp);
//		find3Largest(inp);
//		Integer a=new Integer(3);
//		Integer b=new Integer(5);
//		swap(a,b);
//		System.out.println("a="+a+" b="+b);
	}
	
	private static void swap(Integer a,Integer b){
		int temp=a;
		a=b;
		b=temp;
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
	
	
	private static void find3LargestAnd2Smallest(int[] inp){
		int max1=Integer.MIN_VALUE;
		int max2=Integer.MIN_VALUE;
		int max3=Integer.MIN_VALUE;
		int min1=Integer.MAX_VALUE;
		int min2=Integer.MAX_VALUE;
	
		for(int i=0;i<inp.length;i++){
			if(inp[i]>max1){
				max3=max2;
				max2=max1;
				max1=inp[i];
			}
			else if(inp[i]>max2){
				max3=max2;
				max2=inp[i];
			}else if(inp[i]>max3){
				max3=inp[i];
			}
			if(inp[i]<min1){
				min2=min1;
				min1=inp[i];
			}
			else if(inp[i]<min2){
				min2=inp[i];
			}
				
		}
				
		System.out.println("max1="+max1+" max2="+max2+" max3="+max3+" min1="+min1+" min2="+min2);
	}
	
	private static void swap(int inp[]){
		int temp=inp[0];
		inp[0]=inp[1];
		inp[1]=temp;
	}
}
