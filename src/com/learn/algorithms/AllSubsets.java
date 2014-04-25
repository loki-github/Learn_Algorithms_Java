package com.learn.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class AllSubsets {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList a=new ArrayList();
		a.add(new Integer(2));
		a.add(new Integer(3));
		a.add(new Integer(6));
		ArrayList allSubsets=findAllSubSets(a);
		Iterator it=allSubsets.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}

	}
	
	private static ArrayList findAllSubSets(ArrayList set){
		ArrayList allSubsets=new ArrayList();
		int max=1<<set.size();
		for(int i=0;i<max;i++){
			ArrayList subSet=new ArrayList();
			int k=i;
			int index=0;
			while(k>0){
				if((k&1)>0){
					subSet.add(set.get(index));
				}
				k=k>>1;
				index++;
			}
			allSubsets.add(subSet);
		}
		return allSubsets;
	}

}
