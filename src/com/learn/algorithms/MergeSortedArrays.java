package com.learn.algorithms;

public class MergeSortedArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A=new int[8];
		int[] B=new int[3];
		A[0]=4;
		A[1]=6;
		A[2]=7;
		A[3]=8;
		A[4]=10;
		B[0]=1;
		B[1]=2;
		B[2]=3;
		merge(A,B,4);
		for(int a: A){
			System.out.println(a);
		}

	}
	
	private static void merge(int A[], int B[],int lastAi){
		int ai=lastAi;
		int bi=B.length-1;
		int mi=A.length-1;
		
		while(ai>=0 && bi>=0){
			if(A[ai]>=B[bi]){
				A[mi]=A[ai];
				ai--;
				mi--;
			}else{
				A[mi]=B[bi];
				bi--;
				mi--;
			}
		}
		while(ai>=0){
			A[mi]=A[ai];
			ai--;
			mi--;
		}
		while(bi>=0){
			A[mi]=B[bi];
			bi--;
			mi--;
		}
	}

}
