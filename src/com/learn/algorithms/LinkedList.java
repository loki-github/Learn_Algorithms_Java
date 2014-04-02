package com.learn.algorithms;
import java.io.*;

class Node{
	int info;
	Node next;
}



public class LinkedList {

	static Node head=null;
	static int listSize=0;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("enter list size");
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		listSize=Integer.parseInt(br.readLine());
		System.out.println("enter list elements");
		for(int i=0;i<listSize;i++){
			insert(Integer.parseInt(br.readLine()));
		}
		System.out.println("The list elements are");
		display(head);
		
		System.out.println("enter element to be deleted");
		int data=Integer.parseInt(br.readLine());
		Node temp=delete(data);
		if(temp==null){
			System.out.println("Element not found");
		}
		System.out.println("list after deletion");
		display(head);

	}
	
	public static Node getNode(){
		Node temp=new Node();
		temp.next=null;
		return temp;
	}
	
	
	public static void insert(int data){
		Node temp=getNode();
		if(head==null){
			temp.info=data;
			head=temp;
		}else{
			temp.info=data;
			temp.next=head;
			head=temp;
		}
	}
	
	public static void display(Node first){
		System.out.println("List elements:");
		while(first!=null){
			System.out.println(first.info);
			first=first.next;
		}
	}
	
	public static Node delete(int data){
		if(head==null){
			return null;
		}
		if(data==head.info){
			Node temp=head;
			head=head.next;
			return temp;
		}
		Node next=head.next;
		Node prev=head;
		while(next!=null){
			if(data==next.info){
				Node temp=next;
				prev.next=next.next;
				return temp;
			}
			next=next.next;
			prev=prev.next;
		}
		return null;
	}

}


