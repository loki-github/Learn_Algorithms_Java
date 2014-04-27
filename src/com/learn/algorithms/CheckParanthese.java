package com.learn.algorithms;

import java.util.Stack;

public class CheckParanthese {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] st=new String[]{")(){}","[]({})","([])","{()[]}","([)]"};
		check_braces(st);
	}
	
	public static void check_braces(String[] expressions) {
	     for(int j=0;j<expressions.length;j++) {
	       if (expressions[j]== null || expressions[j].isEmpty()){
	            System.out.println(0);
	            continue;
	       }
	        int len=expressions[j].length();
	        int count=0;
	        Stack<Character> pStack=new Stack<Character>();
	        if(expressions[j].charAt(0)==')'||expressions[j].charAt(0)=='}'||expressions[j].charAt(0)==']'){
	        	System.out.println(0);
	        	continue;
	        }
	        char ch;
	        for (int i=0;i<len;i++){
	            ch=expressions[j].charAt(i);            
	            if (ch=='(' || ch=='{' || ch=='[') {
	                pStack.push(ch);
	                count=count+1;
	            }
	            else{
	                if ((!pStack.isEmpty())) {
	                	char stackTop=pStack.pop();        
	                	if((ch==')' && stackTop=='(') || (ch=='}' && stackTop=='{') || (ch==']' && stackTop=='[')) 
	                		count=count-1;
	                }
	            }
	        }
	        if (pStack.isEmpty() && count==0)
	            System.out.println(1);
	        else
	            System.out.println(0);  
	     }
	 }

}
