package com.learn.algorithms;

import java.io.ObjectInputStream.GetField;

class BTNode{
	int info;
	BTNode left;
	BTNode right;
}



public class BinaryTree {

	static BTNode root=null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] anArray={4,3,7,8,9,1,2,3,4,5};
		insertIntoBT(root, anArray, 0, anArray.length);
		int hieght=findHieght(root);
		System.out.println("Hieght of the Tree="+hieght);
		printNodesAtGivenLevel(root, 3);
		//printBTInorder(root);
		

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

}
