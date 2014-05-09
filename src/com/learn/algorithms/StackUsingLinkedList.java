package com.learn.algorithms;

class LLNode{
	int info;
	LLNode next;
	
	LLNode(int data){
		this.info=data;
		this.next=null;
	}
}


public class StackUsingLinkedList {

	static LLNode top=null;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		push(10);
		push(11);
		push(12);
		displayStack();
		
		LLNode deleted=pop();
		pop();
		pop();
		if(pop()==null){
			System.out.println("stack is empty");
		}
		
		displayStack();

	}
	
	private static void push(int data){
		if(top==null){
			top=new LLNode(data);
		}else{
			LLNode newNode=new LLNode(data);
			newNode.next=top;
			top=newNode;
		}
	}
	
	private static void displayStack(){
		LLNode temp=top;
		System.out.println("stack elements are");
		while(temp!=null){
			System.out.println(temp.info);
			temp=temp.next;
		}
	}
	
	private static LLNode pop(){
		if(top==null){
			return null;
		}else{
			LLNode temp=top;
			top=top.next;
			return temp;
		}
	}

}
