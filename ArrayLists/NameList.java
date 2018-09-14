import java.util.*;

public class NameList {

    // Create vector
    // Using <String> means that the vector can only hold elements of type String
    static  ArrayList<String> nameList = new ArrayList<String>();
    
    public static void main(String args[]) {
	
	// create String objects
        String name1 = "Judy";
        String name2 = "Simon";

        // add objects to vector
        nameList.add(name1);
        nameList.add(name2);

	printDetails();

        // remove object from vector
        nameList.remove(name2);

	printDetails();

    }

    static void printDetails() {

	int size = nameList.size();
	System.out.println("Size of nameList = "+nameList.size());
	for (int i=0;i<nameList.size(); i++) {
           // note that objects have to be explicitly cast to type String
               String s = (String) nameList.get(i);
               System.out.println(s);
	}

    }

}