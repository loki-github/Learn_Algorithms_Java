package com.learn.algorithms;

public class SimpleProblems {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(fib(4));
		//System.out.println(isNumber("-8.4"));
//		int[] numArray=new int[]{4,6,7,8};
//		int[] indeces=new int[]{3,1,0,2};
//		arrayIndexSort(numArray, indeces);
		countBinary1s(-3);

	}
	
	private static int fib(int n){
		if(n==1 || n==0){
			return 0;
		}
		
		if(n==2){
			return 1;
		}
		
		return fib(n-1)+fib(n-2);
	}
	
	private static boolean isNumber(String str){
		int len=str.length();
		for(int i=0;i<len;i++){
			int ch=(int) str.charAt(i);
			if(ch!=45 && ch!=46){	
				if(ch<48 || ch>57){
					return false;
				}
			}
		}
		return true;
	}
	
	private static void arrayIndexSort(int[] nums,int[] indexes){
		int j=0;
		for(int i=0;i<nums.length;i++){
			int pos=indexes[j];
			if(i!=pos){
				swap(nums,i,pos);
				swap(indexes,j,pos);
			}
			j++;
		}
		
		System.out.println("numbers array:");
		for(int i=0;i<nums.length;i++){
			System.out.print(nums[i]+" ");
		}
		System.out.println();
		System.out.println("indeces array");
		for(int i=0;i<indexes.length;i++){
			System.out.print(indexes[i]+" ");
		}
	}
	
	private static void swap(int[] arr,int a,int b){
		int temp=arr[a];
		arr[a]=arr[b];
		arr[b]=temp;
	}
	
	private static void countBinary1s(int n){
		int count=0;
		String binString=Integer.toBinaryString(n);
		System.out.println("binary representation="+binString);
		n=~n;
		System.out.println(Integer.toBinaryString(n));
		
//		System.out.println(Integer.SIZE);
//		if(n<0){
//			while(n<0){
//				int res=n & 1;
//				if(res>0){
//					count++;
//				}
//				n=n<<1;
//			}
//		}else{
//		
//			while(Math.abs(n)>0){
//				int res=n & 1;
//				if(res>0){
//					count++;
//				}
//				n=n>>1;
//			}
//		}
//		System.out.println("count of 1's="+count);
	}

}
