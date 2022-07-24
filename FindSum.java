package com.gl.service;

import java.util.HashSet;


public class FindSum {

	static class Node {

		int nodeData;
		Node leftNode, rightNode;
		
		
	}
	static Node NewNode(int nodedata) {
		Node temp = new Node();
		temp.nodeData = nodedata;
		temp.leftNode = null;
		temp.rightNode = null;
		return temp;
		}
	public  Node insert(Node root, int key) {
	
		if( root==null)
return NewNode(key);
		
		if(key<root.nodeData) {
		root.leftNode=insert(root.leftNode,key);
		}
		else {
			root.rightNode= insert(root.rightNode,key);
			return root ;
		}
		return root;
		}
		public boolean findSum(Node root, int sum ,
			HashSet<Integer>set)

{
	if(root == null)
		return false ;
	
	if(findSum(root.leftNode,sum , set))
		return true ;
	
	if(set.contains(sum - root.nodeData)) {
		System.out.println("binary tree : "
				+ "pair is found  ("
				+  (sum - root.nodeData)  + "," 
				+ root.nodeData + ")");
		return true ;
	
	}
	else
		set.add(root.nodeData);
	return findSum(root.rightNode , sum , set);

}
		public void findSumOFpairGiven(Node root , int sum )
		{
			HashSet<Integer> set = new HashSet<Integer>();
			if(!findSum(root , sum , set)) ;
		}

// Driver class

public static void main(String[] args)
{
	Node root = null;
	
	FindSum findSP = new FindSum();
	root = findSP.insert(root, 40);
	root = findSP.insert(root, 20);
	root = findSP.insert(root, 60);
	root = findSP.insert(root, 10);
	root = findSP.insert(root, 30);
	root = findSP.insert(root, 50);
	root = findSP.insert(root, 70);

	int sum = 60;
	findSP.findSumOFpairGiven(root, sum);

	}
	}

