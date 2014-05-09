package com.learn.algorithms;

public class Anagramchecker {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isAnagram("two plus one is three", "one plus two is thre"));
	}
	
	private static boolean isAnagram(String str1,String str2){
		int[] count=new int[256];
		if(str1.length()!=str2.length()){
			return false;
		}
		for(int i=0;i<str1.length();i++){
			count[str1.charAt(i)]++;
		}
		
		for(int i=0;i<str2.length();i++){
			count[str2.charAt(i)]--;
		}
		for(int i=0;i<str1.length();i++){
			if(count[str1.charAt(i)]!=0){
				return false;
			}
		}
		return true;
	}

}
