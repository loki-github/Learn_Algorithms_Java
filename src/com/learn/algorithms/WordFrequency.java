package com.learn.algorithms;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class WordFrequency {

	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new FileReader("/Users/lokesh/Desktop/test.rtf"));
		
		//String input="This this this this this this this this";
		String sCurrentLine;
		StringBuffer input=new StringBuffer();
		while ((sCurrentLine = br.readLine()) != null) {
			input.append(sCurrentLine);
		}
		ArrayList<String> result=getWordsWithFrequencyOrdered(input.toString(),6);
	}
	
	public static ArrayList<String> getWordsWithFrequencyOrdered(String text,int itemsToReturn ){
		//assumed words are separated with spaces in the text
		if(text==null){
			System.out.println("Please input valid text");
			return new ArrayList<String>();
		}
		String[] words=text.split(" ");
		
		if(itemsToReturn>words.length){
			System.out.println("Please enter number of items to return that is less than the number of words in the text");
			return new ArrayList<String>();
		}
		
		//wordsFrequencyMap contains word as the key and it's number of occurrences as value
		HashMap<String,Integer> wordsFrequencyMap=new HashMap<String,Integer>();
		for(int i=0;i<words.length;i++){
			if(wordsFrequencyMap.get(words[i])!=null){
				int increaseCount=wordsFrequencyMap.get(words[i])+1;
				wordsFrequencyMap.put(words[i], increaseCount);
			}else{
				wordsFrequencyMap.put(words[i], 1);
			}
		}
		//using counting sort to sort words according to frequencies
		ArrayList<String> result=countingSort(wordsFrequencyMap,itemsToReturn);
		return result;
	}
	
	private static ArrayList<String> countingSort(HashMap<String,Integer> inputMap,int itemsToReturn){
		//find maximum frequency to build the count array
		int max=-1;		
		 Iterator it = inputMap.entrySet().iterator();
		 while (it.hasNext()) {
			 Map.Entry pairs = (Map.Entry)it.next();
			 if((Integer)pairs.getValue()>max){
					max=(Integer) pairs.getValue();
				}
		}
				
		int[] countArray=new int[max+1];
		//construct count array.
		 it = inputMap.entrySet().iterator();
		 while (it.hasNext()) {
			 Map.Entry pairs = (Map.Entry)it.next();
			 int count=(Integer) pairs.getValue();
			 countArray[count]++;
		}				
		//prepare count array from the end so that the result will be sorted in descending order of frequencies
		for(int i=countArray.length-2;i>=0;i--){
			countArray[i]=countArray[i+1]+countArray[i];
		}
				
		String output[]=new String[inputMap.size()];
		
		it = inputMap.entrySet().iterator();
		 while (it.hasNext()) {
			 Map.Entry pairs = (Map.Entry)it.next();
			 int index=countArray[(Integer) pairs.getValue()]-1;
			 output[index]=(String) pairs.getKey();
			 int countArrayIndex=(Integer) pairs.getValue();
			 countArray[countArrayIndex]--;
		}
				
		
		ArrayList<String> finalItemsToReturn=new ArrayList<String>();
		if(itemsToReturn>output.length){
			System.out.println("The number of repeated word groups are: "+output.length+". Please enter the numbers of items to return that is less than or equal to this number.");
			return new ArrayList<String>();
		}
		System.out.println("sorted according to highest frequency:");
		for(int i=0;i<itemsToReturn;i++){
			finalItemsToReturn.add(output[i]);
			System.out.println(finalItemsToReturn.get(i));
		}
		
		return finalItemsToReturn;
	}

}
