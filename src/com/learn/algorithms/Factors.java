package com.learn.algorithms;

import java.io.*;


public class Factors {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int number=Integer.parseInt(args[0]);
		String factorString=number+"*"+1;
		System.out.println(factorString);
		factors(number,"",number);
		//printFactorsList(number, number + "*" + 1 + "\n", number);

	}
	
	private static void factors(int n, String factorString,int prev){
			
		for(int i=n-1;i>=2;i--){
			if (n % i != 0)
                continue;
            if (i > prev)
                continue;
            int q = n / i;					
		    if (q <= i && q<= prev) {
		            System.out.println(factorString + q + "*" + i);
		    }		    			
			factors(q, factorString + i + "*", i);			
		}	
	}		
}
