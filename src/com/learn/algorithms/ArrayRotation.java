package com.learn.algorithms;

public class ArrayRotation {
	public static void main(String... args){
		int[] arr=new int[]{1,2,3,4,5};
		rotate(arr,7);
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+",");
		}
		System.out.println();
	}
	
	private static void reverse(int[] arr,int s,int e){
		while(s<=e){
			int temp=arr[s];
			arr[s]=arr[e];
			arr[e]=temp;
			s++;
			e--;
		}
	}
	
	private static void rotate(int[] arr,int i){
		i=i%arr.length;
		reverse(arr,0,arr.length-1);
		reverse(arr,0,i-1);
		reverse(arr,i,arr.length-1);
	}
}
