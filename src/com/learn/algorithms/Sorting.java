package com.learn.algorithms;

import java.util.Arrays;

public class Sorting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a={100,90,80,70,60,50,40,30,20,10};

//		heapSort(inp,inp.length-1);
//		System.out.println("after heap sort:");
//		for(int i=0;i<inp.length;i++){
//			System.out.println(inp[i]);
//		}
		quickSort(a, 0, a.length-1);
		for(int i=0;i<a.length;i++){
			System.out.print(a[i]+",");
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
	
	private static void buildHeap(int[] inp,int i){
		while(i>=0){
			maxHeapify(inp, i);
			i--;
		}
	}
	
	
	private static void heapSort(int a[],int i){
		
		do{
			buildHeap(a,i);
			int temp=a[0];
			a[0]=a[i];
			a[i]=temp;
			i--;
		}while(i>0);
	}
	
	private static void maxHeapify(int[] a,int lastIndexOfHeap){
		int i=lastIndexOfHeap/2-1;
		while(i>=0 && i<=lastIndexOfHeap/2-1){
			int leftChild=2*i + 1;
			int rightChild=2*i + 2;
			int largestIndex=-1;
			if(a[i]>a[leftChild]){
				largestIndex=i;
			}else{
				largestIndex=leftChild;
			}
			
			if(a[rightChild]>=a[largestIndex]){
				largestIndex=rightChild;
			}
			if(largestIndex!=i){
				int temp=a[i];
				a[i]=a[largestIndex];
				a[largestIndex]=temp;
				i=largestIndex;
			}else{
				break;
			}
		}
	}
	
	private static void quickSort(int[] a,int l,int r){
		if(l<r){
			int pivotIndex=partition(a, l, r);
			quickSort(a, 0, pivotIndex);
			quickSort(a, pivotIndex+1, r);
		}
	}
	
	
	private static int partition(int[] a,int left,int right){
		int mid=(left+right)/2;
		int pivot=a[mid];
		while(true){
			while(left<=right && a[left]<pivot){
				left++;
			}
			while(left<=right && a[right]>=pivot){
				right--;
			}
			if(left<right){
				int temp=a[left];
				a[left]=a[right];
				a[right]=temp;
			}else{
				return left;
			}
		}
	}
	
	
}
