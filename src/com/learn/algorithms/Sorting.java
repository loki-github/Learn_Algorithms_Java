package com.learn.algorithms;

import java.util.Arrays;

public class Sorting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] inp={100,90,80,70,60,50,40,30,20,10};
		mergeSort(inp);
		for(int i=0;i<inp.length;i++){
			System.out.println(inp[i]);
		}

	}
	
	private static void mergeSort(int[] inp){
		if(inp.length>1){
			int m=inp.length/2;
			int[] leftArray = Arrays.copyOfRange(inp, 0, m);
            int[] rightArray = Arrays.copyOfRange(inp,m,inp.length);
			
			mergeSort(leftArray);
			mergeSort(rightArray);
			merge(inp,leftArray,rightArray);
		}
		
	}
	
	private static void merge(int inp[],int[] leftArr,int[] rightArr){
		int i=0,j=0,k=0;
		
		int n1=leftArr.length;
		
		
		int n2=rightArr.length;
		
		
		
		
		while(i<n1 && j<n2){
			if(leftArr[i]<=rightArr[j]){
				inp[k]=leftArr[i];
				k++;
				i++;
			}else{
				inp[k]=rightArr[j];
				k++;
				j++;
			}
		}
		
		while(i<n1){
			inp[k]=leftArr[i];
			k++;
			i++;
		}
		
		while(j<n2){
			inp[k]=rightArr[j];
			k++;
			j++;
		}
		
	}

}
