package com.learn.algorithms;

import java.util.ArrayList;
import java.util.Queue;

class BTNode{
	int info;
	BTNode left;
	BTNode right;
}



public class BinaryTree {

	static BTNode root=null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] anArray={-4,-3,-7,-8,-9,-1,-2,3,4,5};
		insertIntoBT(root, anArray, 0, anArray.length);
		int hieght=findHieght(root);
		System.out.println("Hieght of the Tree="+hieght);
//		System.out.println(covers(root.right, -2));
		BTNode FCA=firstCommonAncestorOfBT(root, -3, -7);
		System.out.println("fisrt common ancestor of 3 and 5="+FCA.info);
		//printNodesAtGivenLevel(root, 3);
//		System.out.println(countNegAtGivenLevel(root, 3));
		
//		ArrayList<LinkedList> arrayList=new ArrayList<LinkedList>();
//		for(int i=0;i<hieght;i++){
//			LinkedList list=new LinkedList();
//			createListAtGivenLevel(root, i, list);
//			System.out.println("At level "+i);
//			list.display(list.head);
//			list.head=null;
//		}
		//printBTInorder(root);
//		printLevelOrderBFS(root);

	}
	
	private static void insertIntoBT(BTNode tempRoot,int[] arr,int i,int size){
		int leftChildIndex=2*i+1;
		int rightChildIndex=2*i+2;
		
		if(leftChildIndex>size && rightChildIndex>size){
			return;
		}
		
		if(tempRoot==null){
			tempRoot=createNode(arr[i]);
			root=tempRoot;
		}
		
		if(leftChildIndex<size){
			tempRoot.left=createNode(arr[leftChildIndex]);
		}
		
		if(rightChildIndex<size){
			tempRoot.right=createNode(arr[rightChildIndex]);
		}
		
		insertIntoBT(tempRoot.left,arr,leftChildIndex,size);
		insertIntoBT(tempRoot.right, arr, rightChildIndex, size);
	}
	
	private static BTNode createNode(int data){
		BTNode node=new BTNode();
		node.info=data;
		node.right=null;
		node.left=null;
		return node;
	}
	
	private static void printBTInorder(BTNode root){
		if(root!=null){
			printBTInorder(root.left);
			System.out.println(root.info);
			printBTInorder(root.right);
		}
	}
	
	private static int findHieght(BTNode tempRoot){
		if(tempRoot==null){
			return 0;
		}
		
		int LHieght=findHieght(tempRoot.left)+1;
		int RHieght=findHieght(tempRoot.right)+1;
		
		if(LHieght>RHieght)
			return LHieght;
		else
			return RHieght;
	}
	
	private static void printNodesAtGivenLevel(BTNode tempRoot, int l){
		if(tempRoot==null){
			return;
		}
		
		if(l==0){
			System.out.println(tempRoot.info);
		}else{	
			printNodesAtGivenLevel(tempRoot.left, l-1);
			printNodesAtGivenLevel(tempRoot.right, l-1);
		}
	}
	
	private static int countNegAtGivenLevel(BTNode tempRoot, int l){
		
		
		int count;
		if(tempRoot==null){
			return -1;
		}
		
		if(l==0){
			if(tempRoot.info<0){
				return 1;
			}else{
				return -1;
			}
		}else{		
			count=countNegAtGivenLevel(tempRoot.left,l-1)+countNegAtGivenLevel(tempRoot.right,l-1);
		}
		
		if(count>0)	
			return count;
		else
			return 0;
		
	}
	
	private static void createListAtGivenLevel(BTNode tempRoot, int l,LinkedList list){
		if(tempRoot==null){
			return;
		}
		if(l==0){
			list.insert(tempRoot.info);
		}else{
			createListAtGivenLevel(tempRoot.left, l-1, list);
			createListAtGivenLevel(tempRoot.right, l-1, list);
		}
	}
	
	private static void printLevelOrderBFS(BTNode tempRoot){
		Queue<BTNode> q=new java.util.LinkedList<BTNode>();
		q.add(tempRoot);
		while(!q.isEmpty()){
			BTNode temp=q.remove();
			System.out.println(temp.info);
			if(temp.left!=null)
					q.add(temp.left);
			if(temp.right!=null)
				q.add(temp.right);
		}
	}

	private static BTNode firstCommonAncestorOfBT(BTNode tempRoot,int p,int q){
		if(covers(tempRoot.left,p) && covers(tempRoot.left,q)){
			return firstCommonAncestorOfBT(tempRoot.left, p, q);
		}
		
		if(covers(tempRoot.right,p) && covers(tempRoot.right,q)){
			return firstCommonAncestorOfBT(tempRoot.right, p, q);
		}
		
		return tempRoot;
	}
	
	
	private static boolean covers(BTNode tempRoot,int data){
		if(tempRoot==null){
			return false;
		}
		if(tempRoot.info==data){
			return true;
		}
		
		return covers(tempRoot.left,data) || covers(tempRoot.right,data);
	}
}
