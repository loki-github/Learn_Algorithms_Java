package com.learn.algorithms;

public class StringNumberToInt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(atoi("23487798"));
	}
	
	private static int atoi(String numString){
		int res=0;
		int maxPower=numString.length()-1;
		for(int i=0;i<numString.length();i++){
			res=(int) (res+(numString.charAt(i)-'0') * Math.pow(10, maxPower-i));
		}
		return res;
	}

}
