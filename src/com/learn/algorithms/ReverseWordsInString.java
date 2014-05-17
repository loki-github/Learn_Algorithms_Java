package com.learn.algorithms;

public class ReverseWordsInString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(reverWords("I evol. ahens"));

	}
	
	private static String reverWords(String s){
		char[] chArr=s.toCharArray();
		int startIOfWord=0;
		int i=0;
		while(i<chArr.length){
			if(chArr[i]!=' '){
				i++;
			}else{
				int endIOfWord=i-1;
				while(startIOfWord<=endIOfWord){
					char tmp=chArr[endIOfWord];
					chArr[endIOfWord]=chArr[startIOfWord];
					chArr[startIOfWord]=tmp;
					startIOfWord++;
					endIOfWord--;
				}
				startIOfWord=i+1;
				i++;
			}
		}
		//reverse last word;
		int end=i-1;
		while(startIOfWord<=end){
			char tmp=chArr[end];
			chArr[end]=chArr[startIOfWord];
			chArr[startIOfWord]=tmp;
			end--;
			startIOfWord++;			
		}
		return String.valueOf(chArr);
	}

}
