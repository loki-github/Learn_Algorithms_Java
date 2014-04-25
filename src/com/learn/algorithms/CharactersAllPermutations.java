package com.learn.algorithms;

import java.util.ArrayList;
import java.util.Iterator;



public class CharactersAllPermutations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a="ab";
		ArrayList<String> res=getPerms(a);
		Iterator it=res.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
		
		//perm(a.toCharArray(),0,a.length());

	}
	
	private static void perm(char a[],int i,int l){
		int j;
		if(i==l){
			System.out.println(a);
		}else{
			for(j=i;j<l;j++){
				char temp=a[i];
				a[i]=a[j];
				a[j]=temp;
				perm(a,i+1,l);
				temp=a[i];
				a[i]=a[j];
				a[j]=temp;
			}
		}
	}
	
	public static ArrayList<String> getPerms(String s) { 
		ArrayList<String> permutations = new ArrayList<String>(); 
		if (s == null) { // error case
			return null;
		} else if (s.length() == 0) { // base case
			permutations.add(new String("")); 
			return permutations;
		}
		char first = s.charAt(0); // get the first character
		String remainder = s.substring(1); // remove the first character 
		ArrayList<String> words = getPerms(remainder);
		for (String word : words) {
			for (int j = 0; j <= word.length(); j++) {
				permutations.add(insertCharAt(word, first, j)); 
			}
		}
		return permutations; 
	}
		
	public static String insertCharAt(String word, char c, int i) { 
		String start = word.substring(0, i);
		String end = word.substring(i);
		return start + c + end;
	}

}
