package com.learn.algorithms;

import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;
import java.util.*;

class BTNode {
	int info;
	BTNode left;
	BTNode right;

	BTNode(int data) {
		this.info = data;
		this.left = null;
		this.right = null;
	}
}

public class BinaryTree {

	static BTNode root1 = null;
	static BTNode root2 = null;
	static BTNode root = null;

	public static void main(String[] args) {
		BTNode temp = new BTNode(9);
		setNode(temp);
		System.out.println(temp.info);
		
		
	}
	
	static void setNode(BTNode t){
		BTNode s=new BTNode(49);
		System.out.println(t.info);
		t=s;
		System.out.println(t.info);
	}
	
	static void modifyArrayList(ArrayList list){
		list.add(30);
	}
	
	static boolean doesRootAExistsInB(BTNode rootA,BTNode rootB){
		if(rootA==null || rootB==null){
			return false;
		}
		if(rootA.info==rootB.info){
			return isASubsetOfB(rootA, rootB);
		}
		return doesRootAExistsInB(rootA, rootB.left ) || doesRootAExistsInB(rootA, rootB.right);
	}
	
	static boolean isASubsetOfB(BTNode rootA, BTNode rootB){
		
		if(rootA==null){
			return true;
		}
		if(rootB==null){
			return false;
		}
		
		if(rootA.info!=rootB.info){
			return false;
		}else{
			return isASubsetOfB(rootA.left,rootB.left) && isASubsetOfB(rootA.right,rootB.right);
		}
	}
	
	static BTNode makeLevelOrderBT(int info,BTNode root){
		if(root==null){
			root=new BTNode(info);
			return root;
		}
		Queue<BTNode> queue = new java.util.LinkedList();
		queue.add(root);
		while(!queue.isEmpty()){
			BTNode node = queue.remove();
			if(node.left==null){
				node.left = new BTNode(info);
				return root;
			}
			if(node.right==null){
				node.right=new BTNode(info);
				return root;
			}
			queue.add(node.left);
			queue.add(node.right);
		}
		return root;
	}
	
	static int maxSumInBT(BTNode root){
		if(root==null){
			return 0;
		}
		
		return root.info + Math.max(maxSumInBT(root.left), maxSumInBT(root.right));
	}
	
	static void printMaxSumPath(BTNode root,int sum,ArrayList<Integer> path,int maxSum){
		if(root==null){
			return;
		}
		sum=sum+root.info;
		path.add(root.info);
		if(root.left==null && root.right==null && sum==maxSum){
			for(Integer info: path){
				System.out.print(info+" ");
			}
		}
		printMaxSumPath(root.left, sum, new ArrayList(path), maxSum);
		printMaxSumPath(root.right, sum,new ArrayList(path), maxSum);
	}

	static int replaceNodesWithSumOfSubtrees(BTNode root){
		if(root==null){
			return 0;
		}
		if(root.left==null && root.right==null){
			int tmp=root.info;
			root.info=0;
			return tmp;
		}
		root.info=replaceNodesWithSumOfSubtrees(root.left)+replaceNodesWithSumOfSubtrees(root.right);
		return root.info;
	}
	static int count=0;
	static int kthLarge=0;
	static void findKthLargest(BTNode root,int k){
		if(root!=null){
			findKthLargest(root.right, k);
			count++;
			if(count==k){
				kthLarge=root.info;
			}
			findKthLargest(root.left, k);
		}
	}

	static int findMaxInBt(BTNode root, int max) {
		if (root == null) {
			return max;
		}
		if (root.info > max) {
			max = root.info;
		}
		int lmax = findMaxInBt(root.left, max);
		int rmax = findMaxInBt(root.right, max);
		return Math.max(lmax, rmax);
	}

	public static void printAlternateCorner(BTNode node, boolean leftMost,
			boolean rightMost, boolean left) {

		if (node == null) {
			return;
		}

		if (left) {
			if (leftMost) {
				System.out.println(node.info);
			}

		} else {
			if (rightMost) {
				System.out.println(node.info);
			}
		}
		left = !left;

		printAlternateCorner(node.left, leftMost,
				(rightMost && node.right == null), left);
		printAlternateCorner(node.right, (leftMost && node.left == null),
				rightMost, left);

	}

	static int sum = 0;

	static void replaceNodesWithSumOfGreaterNodes(BTNode root) {
		if (root == null) {
			return;
		}
		replaceNodesWithSumOfGreaterNodes(root.right);
		sum = sum + root.info;
		root.info = sum;
		replaceNodesWithSumOfGreaterNodes(root.left);
	}

	static void printList(BTNode root) {
		BTNode tmp = root;
		while (tmp != null) {
			System.out.println(tmp.info);
			tmp = tmp.right;
		}
	}

	static BTNode prev = null;
	static BTNode listHead = null;

	static void convert(BTNode root) {
		if (root == null)
			return;
		convert(root.left);
		if (prev != null)
			prev.right = root;
		else
			listHead = root;
		root.left = prev;
		prev = root;
		convert(root.right);
	}

	// amplitude: The maximum difference between any two nodes in a path.
	// Path: path between two nodes is only from ancestor to it's descendents.
	static int amplitude = Integer.MIN_VALUE;

	private static void findBTAmplitude(BTNode root, int max, int min) {
		if (root == null) {
			return;
		}
		if (root.info > max) {
			max = root.info;
		}
		if (root.info < min) {
			min = root.info;
		}
		findBTAmplitude(root.left, max, min);
		if (max - min >= amplitude) {
			amplitude = max - min;
		}
		findBTAmplitude(root.right, max, min);
		if (max - min >= amplitude) {
			amplitude = max - min;
		}
	}

	private static boolean areSameTrees(BTNode root1, BTNode root2) {

		if (root1 == null && root2 == null) {
			return true;
		}
		if (root1 == null || root2 == null) {
			return false;
		}

		if (root1.info != root2.info) {
			return false;
		}

		return areSameTrees(root1.left, root2.left)
				&& areSameTrees(root1.right, root2.right);
	}

	private static void doubleTree(BTNode root) {
		if (root != null) {
			BTNode leftNode = root.left;
			BTNode newNode = new BTNode(root.info);
			root.left = newNode;
			newNode.left = leftNode;
			doubleTree(leftNode);
			doubleTree(root.right);
		}
	}

	private static void mirror(BTNode root) {
		if (root != null) {
			BTNode leftChild = root.left;
			BTNode rightChild = root.right;
			root.left = rightChild;
			root.right = leftChild;
			mirror(root.left);
			mirror(root.right);
		}
	}

	private static void insertIntoBT(BTNode tempRoot, int[] arr, int i, int size) {
		int leftChildIndex = 2 * i + 1;
		int rightChildIndex = 2 * i + 2;

		if (leftChildIndex > size && rightChildIndex > size) {
			return;
		}

		if (tempRoot == null) {
			tempRoot = createNode(arr[i]);
			root1 = tempRoot;
		}

		if (leftChildIndex < size) {
			tempRoot.left = createNode(arr[leftChildIndex]);
		}

		if (rightChildIndex < size) {
			tempRoot.right = createNode(arr[rightChildIndex]);
		}

		insertIntoBT(tempRoot.left, arr, leftChildIndex, size);
		insertIntoBT(tempRoot.right, arr, rightChildIndex, size);
	}

	private static BTNode createNode(int data) {
		BTNode node = new BTNode(data);
		node.info = data;
		node.right = null;
		node.left = null;
		return node;
	}

	private static void printBTInorder(BTNode root) {
		if (root != null) {
			printBTInorder(root.left);
			System.out.println(root.info);
			printBTInorder(root.right);
		}
	}

	private static int findHieght(BTNode tempRoot) {
		if (tempRoot == null) {
			return -1;
		}

		int LHieght = findHieght(tempRoot.left) + 1;
		int RHieght = findHieght(tempRoot.right) + 1;

		if (LHieght > RHieght)
			return LHieght;
		else
			return RHieght;
	}

	private static void printNodesAtGivenLevel(BTNode tempRoot, int l) {
		if (tempRoot == null) {
			return;
		}
		if (l == 0) {
			System.out.println(tempRoot.info);
		} else {
			printNodesAtGivenLevel(tempRoot.left, l - 1);
			printNodesAtGivenLevel(tempRoot.right, l - 1);
		}
	}

	private static int countNegAtGivenLevel(BTNode tempRoot, int l) {

		int count;
		if (tempRoot == null) {
			return -1;
		}

		if (l == 0) {
			if (tempRoot.info < 0) {
				return 1;
			} else {
				return -1;
			}
		} else {
			count = countNegAtGivenLevel(tempRoot.left, l - 1)
					+ countNegAtGivenLevel(tempRoot.right, l - 1);
		}

		if (count > 0)
			return count;
		else
			return 0;

	}

	private static void createListAtGivenLevel(BTNode tempRoot, int l,
			java.util.LinkedList list) {
		if (tempRoot == null) {
			return;
		}
		if (l == 0) {
			list.add(tempRoot.info);
		} else {
			createListAtGivenLevel(tempRoot.left, l - 1, list);
			createListAtGivenLevel(tempRoot.right, l - 1, list);
		}
	}

	private static void printLevelOrderBFS(BTNode tempRoot) {
		Queue<BTNode> q = new java.util.LinkedList<BTNode>();
		q.add(tempRoot);
		while (!q.isEmpty()) {
			BTNode temp = q.remove();
			System.out.println(temp.info);
			if (temp.left != null)
				q.add(temp.left);
			if (temp.right != null)
				q.add(temp.right);
		}
	}

	private static BTNode firstCommonAncestorOfBT(BTNode tempRoot, int p, int q) {
		if (covers(tempRoot.left, p) && covers(tempRoot.left, q)) {
			return firstCommonAncestorOfBT(tempRoot.left, p, q);
		}

		if (covers(tempRoot.right, p) && covers(tempRoot.right, q)) {
			return firstCommonAncestorOfBT(tempRoot.right, p, q);
		}

		return tempRoot;
	}

	private static boolean covers(BTNode tempRoot, int data) {
		if (tempRoot == null) {
			return false;
		}
		if (tempRoot.info == data) {
			return true;
		}

		return covers(tempRoot.left, data) || covers(tempRoot.right, data);
	}

	public static void insertIntoBST1(BTNode tempRoot, int data) {
		if (tempRoot == null) {
			root1 = new BTNode(data);
			return;
		}

		if (data <= tempRoot.info) {
			if (tempRoot.left == null) {
				tempRoot.left = new BTNode(data);
			} else {
				insertIntoBST1(tempRoot.left, data);
			}
		} else if (data > tempRoot.info) {
			if (tempRoot.right == null) {
				tempRoot.right = new BTNode(data);
			} else {
				insertIntoBST1(tempRoot.right, data);
			}
		}
	}

	public static void insertIntoBST2(BTNode tempRoot, int data) {
		if (tempRoot == null) {
			root2 = new BTNode(data);
			return;
		}

		if (data <= tempRoot.info) {
			if (tempRoot.left == null) {
				tempRoot.left = new BTNode(data);
			} else {
				insertIntoBST2(tempRoot.left, data);
			}
		} else if (data > tempRoot.info) {
			if (tempRoot.right == null) {
				tempRoot.right = new BTNode(data);
			} else {
				insertIntoBST2(tempRoot.right, data);
			}
		}
	}

	static ArrayList<Integer> preOrderList = new ArrayList<Integer>();

	public static ArrayList<Integer> preOrder(BTNode troot) {
		if (troot == null) {
			return preOrderList;
		}
		preOrderList.add(troot.info);
		preOrder(troot.left);
		preOrder(troot.right);
		return preOrderList;
	}

	private static void inOrderIteration(BTNode tempRoot) {
		Stack<BTNode> st = new Stack<BTNode>();
		while (!st.empty() || tempRoot != null) {
			if (tempRoot != null) {
				st.push(tempRoot);
				tempRoot = tempRoot.left;
			} else {
				BTNode temp = st.pop();
				System.out.println(temp.info);
				tempRoot = temp.right;
			}
		}
	}

	private static void preOrderIterative(BTNode current) {
		Stack<BTNode> st = new Stack<BTNode>();
		while (current != null || !st.empty()) {
			if (current != null) {
				System.out.println(current.info);
				st.push(current);
				current = current.left;
			} else {
				BTNode temp = st.pop();
				current = temp.right;
			}
		}
	}

	private static boolean hasPathSum(BTNode root, int sum) {
		if (root == null) {
			return (sum == 0);
		}

		return hasPathSum(root.left, sum - root.info)
				|| hasPathSum(root.right, sum - root.info);
	}

	private static void printPaths(BTNode root, ArrayList<Integer> path) {
		if (root == null) {
			return;
		}
		path.add(root.info);
		
		if (root.left == null && root.right == null) {
			for(Integer info: path){
				System.out.print(info+" ");
			}
			System.out.println();
		} else {
			printPaths(root.left, new ArrayList(path));
			printPaths(root.right, new ArrayList(path));
		}
	}

	public static void printEdgeNodes(BTNode node) {
		System.out.println(node.info);
		_printEdgeNodes(node.left, true, false);
		_printEdgeNodes(node.right, false, true);
	}

	public static void _printEdgeNodes(BTNode node, boolean isLeftEdge,
			boolean isRightEdge) {
		if (node != null) {
			_printEdgeNodes(node.left, isLeftEdge, false);
			if (isLeftEdge || isRightEdge
					|| (node.left == null && node.right == null)) {
				System.out.println(node.info);
			}
			_printEdgeNodes(node.right, false, isRightEdge);
		}
	}
}
