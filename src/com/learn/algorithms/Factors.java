package com.learn.algorithms;

public class Factors {

	public static void main(String[] args){		
		int n=Integer.parseInt("8");
		String str=1+"*"+n;
		System.out.println(str);
		factors(n,"",n);
	}
	
	private static void factors(int n, String str,int prev_i){			
		for(int i=2;i<=n-1;i++){
			if (n % i != 0 || i > prev_i)
                continue;
            int q = n / i;					
		    if (q <= i && q<= prev_i) {
		            System.out.println(str + q + "*" + i);
		    }		    			
			factors(q, str + i + "*", i);			
		}	
	}		
}
