package com.learn.algorithms;

import java.util.Arrays;
import java.util.Stack;

public class SimpleProblems {

	public static void main(String[] args) {
		int[] a={4,7,9,2,4,5,7,8};
		merge(0,3,7,a);
		System.out.println(Arrays.toString(a));
		String inpStr = "2*3";
		char[] inp = inpStr.toCharArray();
		Stack st = new Stack();
		for(char c:inp){
			if(Character.isDigit(c)){
				st.push(c);
			}
		}
		for(char c:inp){
			if(c=='*'){
				
			}
		}
	}
	
	static void merge(int low,int mid,int high,int A[]){
		int[] temp = new int[A.length];
		
		for(int i=low;i<=high;i++){
			temp[i] = A[i];
		}
		int i=low;
		int j=mid+1;
		int k=low;
		
		while(i<=mid && j<=high){
			if(temp[i]<=temp[j]){
				A[k]=temp[i];
				i++;
			}else{
				A[k]=temp[j];
				j++;
			}
			k++;
		}
		
		while(i<=mid){
			A[k]=temp[i];
			i++;
			k++;
		}
		
//		while(j<=high){
//			A[k]=temp[j];
//			j++;
//			k++;
//		}
	
	}
	
	public static int add(int a, int b) {
		 if (b == 0) return a;
		 int sum=a^b;//addwithoutcarrying
		 int carry=(a&b)<<1;//carry,butdon'tadd
		 return add(sum,carry); // recurse
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
	
	private static char[] dectoBinBitWise(int decimalNum){
		int mask=(int) Math.pow(2, 31);
		System.out.println();
		char[] bin=new char[32];
		int i=0;
		while(mask>0){
			if((decimalNum & mask) > 0){
				bin[i++]='1';
			}else{
				bin[i++]='0';
			}
			mask=mask>>1;
		}
		return bin;
	}

}
