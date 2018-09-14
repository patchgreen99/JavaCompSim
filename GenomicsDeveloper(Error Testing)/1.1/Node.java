/*
   Stores a node linked to adjacent nodes on the line below in the triangle. 
Author:	Joel Hutton.
Date:  	12/04/2014
*/
public class Node {
	private int val;
	private int total;
	private Node leftNode;
	private Node rightNode;

	//Allows the best path to be found by following the links all the way down.
	//'shortest' in this context is taken to mean lowest sum path. 
	private boolean shortestIsLeft;

	Node(int val){
		//Checks all nodes are positive.
		if(val >= 0){
			this.val = val;
			this.total = val;
		}
		else{
			System.out.println("Invalid node: " + Integer.toString(val));
			//Non-zero exit code shows error.
			System.exit(1);
		}
	}



	public int getVal(){
		return val;
	}		

	public int getTotal(){
		return total;
	}		

	public void setTotal(int t){
		total = t;
	}

	public Node getLeftNode(){
		return leftNode;
	}
	public void setLeftNode(Node n){
		leftNode = n;
	}


	public Node getRightNode(){
		return rightNode;
	}
	public void setRightNode(Node n){
		rightNode = n;
	}

	public boolean getShortestIsLeft(){
		return shortestIsLeft;
	}


	public void setShortestIsLeft(boolean b){
		shortestIsLeft = b;
	}
	
	//Printing node simply gives it's value. 
	//Used for debug purposes.
	public String toString(){
		String str = Integer.toString(this.val);
		return str;
	}

}
