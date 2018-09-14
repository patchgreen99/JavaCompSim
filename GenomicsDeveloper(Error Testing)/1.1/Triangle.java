/*
Stores entire structure as an ArrayList of Lines. Links nodes together with adjacent nodes on the 
line below.
Reads from STDin and prints to STDout.
Author:	Joel Hutton.
Date:  	12/04/2014
*/
import java.util.ArrayList;
public class Triangle {
	private int curLine = 1;
	private ArrayList<Line> lines = new ArrayList<Line>(); 
	
	//Parses a string into individual elements, adds them
	//to an ArrayList of Integers, uses the Line constructor
	//to create a line from ArrayList<Integer>. Finally, adds the 
	//'Line' to an ArrayList 'lines'.
	public void addLine(String line){
		//Ignores empty lines.
		if(line.length() != 0){			
			
			
			ArrayList<Integer> intLine = new ArrayList<Integer>();
			//Splits the line into individual elements.
			String[] lineSplit = line.split("\\s+");

			//Remove empty characters caused by extra spaces and check for invalid strings.
			for(int i=0; i<lineSplit.length; i++){
				if (lineSplit[i] != ""){
					//'try catch' statement catches characters which can not be 
					//converted to int and handles the error.
					try{
						int temp = Integer.parseInt(lineSplit[i]);
						//Error handling for negative numbers.
						if (temp >= 0){
							intLine.add(temp);
						}
						else{
							//Prints error message detailing location
							//of invalid element and exits.
							System.out.println("Line " + Integer.toString(curLine) + " Element " + Integer.toString(i+1) +  ": invalid value \"" + lineSplit[i] +  "\", not positive" );
							System.out.println(line);
							//non-zero exit code shows error.
							System.exit(1);
						}
					}
					catch(NumberFormatException n){
						//Prints error message detailing location of 
						//non-integer element and exits.
						System.out.println("Line " + Integer.toString(curLine) + " Element " + Integer.toString(i+1) +  ": invalid value \"" + lineSplit[i] +  "\", not an integer" );
						System.out.println(line);
						//non-zero exit code shows error.
						System.exit(1);
					}
				}
				
			}
			//Checks to see if line length is what is expected. 
			if(intLine.size() != curLine){
				//Prints error message detailing line of invalid length
				//and exits.
				System.out.println("Line " + Integer.toString(curLine) + ": number of elements is " + Integer.toString(lineSplit.length) + ", expected " + Integer.toString(curLine));
				System.out.println(line);
				//non-zero exit code shows error.
				System.exit(1);
			}
			//Uses line constructor to convert ArrayList of Integers to a 
			//'Line' object and adds it to the ArrayList<Line> 'lines'.
			lines.add(new Line(intLine));
			if( lines.size() > 1){
				//link the nodes on the second last layer to those on the last.
				linkNodes(lines.size()-2);
			}
			curLine += 1;
		}
	}

	/*Starts at the second line from the bottom.
	//Chooses the lowest value path to the bottom (by choosing the
	//smaller of the left or right nodes on the bottom line)
	//Assign this path to 'total' and move onto solving the
	//next line up. For each line, for each node, choose the node
	//below, either left or right, which has the lowest total.
	//Then store the new total (total of node in line below chosen 
	//plus value of current node) and which direction the shortest path takes
	//in 'total' and 'shortestIsLeft' respectively. 'shortestIsLeft' is
	//a boolean value where true means the path forks left and false 
	//means the path forks right.
	//'total' for any given node is the sum of the values of
	//the nodes in the lowest value path from that node to the bottom
	//line. 
	//From the bottom up, each node gets given a left or
	//right value, stored by shortestIsLeft, which determines
	//if the shortest path from that node to the bottom is left
	//or right. When the top node is reached, these directions 
	//can be followed to give the path.
	//When the top node is reached the path is determined by following
	//each left or right link until the bottom line is reached, 
	//at which point the linked left and right nodes will be null. 
	//This path is retured as a String.
	*/
	public String solve(){
		//This loop iterates through lines.
		//index of size -2 corresponds to line second to bottom.
		for(int i=(this.size()-2); i >= 0; i --){
			Line line = this.getLine(i);
			//This loop iterates through nodes on a line.
			for(int ind=0; ind<line.size();ind++){
				Node node = line.getNode(ind);		
				//Selects lower path of 2 linked nodes
				if (node.getLeftNode().getTotal() < node.getRightNode().getTotal()){
					node.setShortestIsLeft(true);
					node.setTotal(node.getVal() + node.getLeftNode().getTotal());
				}
				else{
					node.setShortestIsLeft(false);
					node.setTotal(node.getVal() + node.getRightNode().getTotal());
				}
			}
		}
		//At this point all nodes have a shortest path to the bottom line
		//found by following links. Lowest path for any given node is known
		//and stored in 'total'
		
		
		//Trace path back down by following the link given by one node to the next. 
		//Builds up string detailing this path.
		Node curNode = this.getLine(0).getNode(0);
		//Top node.
		Node firstNode = curNode;
		String path = "Minimal path is: " + curNode.getVal();
		while(curNode != null){
			if(curNode != firstNode){
				path += " + " +  curNode.getVal();
			}
			//Checks if the bottom line has been reached.
			if(curNode.getLeftNode()== null){
				break;
			}
			if(curNode.getShortestIsLeft()){
				curNode = curNode.getLeftNode();
			}
			else{
				curNode = curNode.getRightNode();
			}
		}
		path += " = " + Integer.toString(firstNode.getTotal());
		return path;

	}


	
	//Links one line of nodes the 2 adjacent nodes beneath.	
	public void linkNodes(int lineInd){
		Line line = lines.get(lineInd);
		Line nextLine = lines.get(lineInd+1);
		//As the line below is one bigger, the node one to the left has the
		//same index, while the one to the right has an index 1 greater.
		for(int i=0;i < line.size(); i++){
			line.getNode(i).setLeftNode(nextLine.getNode(i));
			line.getNode(i).setRightNode(nextLine.getNode(i + 1));
		}
	}
	
	//Allow the triangle to be printed for debug
	public String toString(){
		String str = "";
		for(int i=0;i < lines.size(); i++){
			str += lines.get(i).toString() +  "\n";
		}
		return str;
	}

	public Line getLine(int ind){
		return lines.get(ind);
	}
	public int size(){
		return lines.size();
	}

}
