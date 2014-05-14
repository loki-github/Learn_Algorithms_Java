package com.learn.algorithms;

public class QuickSelectSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr=new int[]{5,6,4,2,7,8,9,10};
		
		System.out.println(getKthSmallest(arr, 0, arr.length-1, 3));
	}
	
	private static int getKthSmallest(int[] arr,int l,int r,int k){
		int i=partition(arr,l,r);
		if(i==k-1){
			return arr[i];
		}else if(i<k-1){
			return getKthSmallest(arr, l, i-1, k);
		}else{
			return getKthSmallest(arr, i, r, k);
		}
	}
	
	
	private static int partition(int[] arr,int l,int r){
		int i=l;
		int j=r;
		int pivot=arr[i];
		i++;
		while(true){
			while(i<j && arr[i]<pivot){
				i++;
			}
			while(i<j&& arr[j]>pivot){
				j--;
			}
			if(i<j){
				swap(arr,i,j);
			}else{
				for(int k=0;k<arr.length;k++){
					System.out.print(arr[k]+",");
				}
				System.out.println();
				System.out.println("pivot index="+i);
				return i;
			}
		}
		
		
	}
	
	private static void swap(int[] arr,int i,int j){
		int temp=arr[i];
		arr[i]=arr[j];;
		arr[j]=temp;
	}

}
