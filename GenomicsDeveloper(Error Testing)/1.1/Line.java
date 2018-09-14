/*
   Stores an ArrayList of nodes.
Author:	Joel Hutton.
Date:  	12/04/2014
*/

import java.util.ArrayList;

public class Line{
	private ArrayList<Node> nodes = new ArrayList<Node>();

	Line(ArrayList<Integer> l){
		for(int i=0;i<l.size();i++){
			if(l.get(i) >= 0){
				nodes.add(new Node(l.get(i)));
			}
		}
	}
	public void addNode(Node n){
		nodes.add(n);
	}
	public Node getNode(int ind){
		if(ind < nodes.size()){
			return nodes.get(ind);
		}
		else {
			return null;
		}
	}
	public String toString(){
		String str = "";
		for(int i=0;i<nodes.size();i++){
			str += nodes.get(i).toString();
			if( i != (nodes.size()-1)){
				str += ",";
			}
		}
		return str;
	}
	
	//Returns the number of nodes in the
	//line.
	public int size(){
		return nodes.size();
	}
}
