package com.learn.algorithms;
import java.io.*;

class Node{
	int info;
	Node next;
}



 class LinkedList {

	static Node head1=null;
	static Node head2=null;
	static int listSize=0;
	static Node cycleStartNode=null;
	static Node tail=null;
	
	public static void main(String[] args) throws Exception {

		int[] list1=new int[]{27,90,2,300,1,60,70,200,34,67,78,99};
		for(int i=0;i<list1.length;i++){
			insertIntoList1(list1[i]);
		}
		tail.next=cycleStartNode;
		System.out.println(cycleStartNode.info);
		System.out.println("cycle detected at="+findCycle(head1).info);	
	}
	
	static Node findCycle(Node head){
		if(head==null){
			return head;
		}
		Node f=head;
		Node s=head;
		while(f!=null && s!=null){
			f=f.next.next;
			s=s.next;
			if(f==s){
				break;
			}
		}
		f=head;
		while(f!=s){
			f=f.next;
			s=s.next;
		}
		return f;
	}
	
	static Node MergeSortOnLinkedList(Node head){
		if(head==null || head.next==null){
			return head;
		}
		Node middleNode=getMiddle(head);
		Node l=head;
	
		while(head.next!=middleNode){
			head=head.next;
		}
		head.next=null;
		Node r=middleNode;
		Node h1=MergeSortOnLinkedList(l);
		Node h2=MergeSortOnLinkedList(r);
		Node res=mergeTwoSortedLinkedLists(h1, h2);
		return res;
	}
	
	static Node findHead2InSortedLists(Node head){
		if(head==null){
			return head;
		}
		while(head.next.info>=head.info){
			head=head.next;
		}
		Node tmp=head.next;
		head.next=null;
		return tmp;
	}
	
	
	static Node appendLastNToFirst(Node head,int n){
		if(head==null || head.next==null){
			System.out.println("empty list or only one element");
			return head;
		}
		Node f=head; 
		int c=1;
		while(f!=null && c<=n){
			f=f.next;
			c++;
		}
		if(f==null){
			System.out.println("n>size");
			return head;
		}
		Node p=head;
		while(f.next!=null){
			f=f.next;
			p=p.next;
		}
		Node tmp=p.next;
		p.next=null;
		f.next=head;
		head=tmp;
		return head;
	}
	
	
	static Node swapAlternateElements(Node head){
		if(head==null || head.next==null){
			return head;
		}
		Node temp=head;
		head=head.next;
		Node succ=head.next;
		head.next=temp;
		temp.next=swapAlternateElements(succ);
		return head;
	}
	
	static void changeHead(Node temp){
		temp=head1;
		
	}
	
	static void reverseListWithVoidType(Node head){
		
	}
	
	static Node reverseListAfterK(Node head,int k){
		if(head==null){
			return null;
		}
		if(k==0){
			return reverseList(null, head);
		}
		Node f=head;
		int c=1;
		while(f!=null && c<k){
			f=f.next;
			c++;
		}
		if(f==null){
			return null;
		}
		Node r=reverseList(null, f.next);
		f.next=r;
		return head;
	}
	
	static Node reverseList(Node prev,Node head){
		if(head==null){
			return null;
		}
		if(head.next==null){
			head.next=prev;
			return head;
		}
		Node r=reverseList(head, head.next);
		head.next=prev;
		return r;
	}
	

	
	static void deleteKthFromEnd(Node head,int k){
		if(head==null){
			return;
		}
		if(k==1){
			Node p=head;
			Node f=head.next;
			while(f.next!=null){
				f=f.next;
				p=p.next;
			}
			p.next=null;
			return;
		}
		int c=1;
		Node f=head;
		Node p=head;
		while(c<k){
			f=f.next;
			c++;
		}
		if(f==null){
			return;
		}
		while(f.next!=null){
			f=f.next;
			p=p.next;
		}
		p.info=p.next.info;
		p.next=p.next.next;
	}
	
	public static Node mergeTwoLinkedListsRecursion(Node n1, Node n2) {
	    if (n1 == null) return n2;
	    if (n2 == null) return n1;

	    if (n1.info <= n2.info) {
	        n1.next = mergeTwoLinkedListsRecursion(n1.next, n2);
	        return n1;
	    } else {
	        n2.next = mergeTwoLinkedListsRecursion(n2.next, n1);
	        return n2;
	    }
	}
	
	
	
	
	public static Node mergeTwoSortedLinkedLists(Node head1,Node head2){
		Node head=null;
		if(head1==null){
			head=head2;
			return head;
		}
		if(head2==null){
			head=head2;
			return head;
		}
		if(head1.info<=head2.info){
			head=head1;
			head1=head1.next;
		}else{
			head=head2;
			head2=head2.next;
		}
		Node current=head;
		while(head1!=null && head2!=null){
			if(head1.info<=head2.info){
				current.next=head1;
				current=current.next;
				head1=head1.next;
			}else{
				current.next=head2;
				current=current.next;
				head2=head2.next;
			}
		}
		if(head1==null){
			current.next=head2;
		}else if(head2==null){
			current.next=head1;
		}
		
		return head;
	}
	
	
	
	private static Node iterativeListReverse(Node head){
		Node prev=null,curr=head;
		while(curr!=null){
			Node temp=curr.next;
			curr.next=prev;
			prev=curr;
			curr=temp;
		}
		return prev;
	}
	
	
	private static Node getMiddle(Node head){
		Node fast=head,slow=head;
		while(fast!=null){
			fast=fast.next;
			if(fast!=null){
				fast=fast.next;
				slow=slow.next;
			}
		}
		return slow;
	}
	
	
	public static Node getNode(){
		Node temp=new Node();
		temp.next=null;
		return temp;
	}
	
	
	public static void insertIntoList1(int data){
		Node temp=getNode();
		if(head1==null){
			temp.info=data;
			head1=temp;
			tail=temp;
		}else{
			temp.info=data;
			if(temp.info==70){
				cycleStartNode=temp;
			}
			temp.next=head1;
			head1=temp;
		}
	}
	
	public static void insertIntoList2(int data){
		Node temp=getNode();
		if(head2==null){
			temp.info=data;
			head2=temp;
		}else{
			temp.info=data;
			temp.next=head2;
			head2=temp;
		}
	}
	
	public static void display(Node first){
		while(first!=null){
			System.out.print(first.info+"->");
			first=first.next;
		}
		System.out.println();
	}
	
	public static Node delete(int data){
		if(head1==null){
			return null;
		}
		if(data==head1.info){
			Node temp=head1;
			head1=head1.next;
			return temp;
		}
		Node next=head1.next;
		Node prev=head1;
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


