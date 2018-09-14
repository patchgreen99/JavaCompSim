public class Cell {

	private int i,car ;

	public Cell(int index,int c){
		i=index;
		car=c;
	}

	public int getcar() {
		return car;
	}
	public int getindex() {
		return i;
	}

	public static Cell iteration(Cell behind,Cell change,Cell infront){
		Cell current_cell=change;
		if(change.getcar()==1){
			if(infront.getcar()==0){
				current_cell= new Cell(change.getindex(),0);
			}else{current_cell= new Cell(change.getindex(),1);}}
		if(change.getcar()==0){
			if(behind.getcar()==1){
				current_cell= new  Cell(change.getindex(),1);	
			}else{current_cell= new Cell(change.getindex(),0);}}
		return current_cell;
	} 

	public static Cell[] setRoad(double numcells,double numcars){ 
		Cell[] roadold = new Cell[(int) numcells];

		//fill assignOneCell array
		int[] aOC = new int[100];
		for(int f=0; f<aOC.length; f++){
			aOC[f]=100;}

		//Initialise all cells
		for(int i=0; i<numcells ; i++ ){
			roadold[i]=new Cell(i,0);}

		//Set a fixed number of cars to random cells
		int a = (int) numcars; 
		for(int i=0; i<a; i++ ){
			int m = (int) Math.floor(Math.random()*numcells);
			//answer variable is created so no single cell is assigned to 2 cars	
			int answer = 1;
			for(int s=0; s<a ;s++){
				if(m==aOC[s]){
					answer=0;}}
			if(answer==1){
				roadold[m]=new Cell(m,1);
				aOC[i]=m;}
			else{a++;}} 
		return roadold;
	}

	// iteration method

	public static Cell[] oneTimeStep(int numcells, Cell[] roadold){
		Cell[] roadnew = new Cell[numcells];

		for(int j=0; j<roadold.length; j++ ){
			if(j==0){roadnew[j]=Cell.iteration(roadold[roadold.length-1],roadold[j],roadold[j+1]);
			}else{if(j==roadold.length-1){roadnew[j]=Cell.iteration(roadold[j-1],roadold[j],roadold[0]);
			}else{roadnew[j]=Cell.iteration(roadold[j-1],roadold[j],roadold[j+1]);}}}
		return roadnew;
	}

	//cars moved counting method
	public static int carsMoved(Cell[] roadold,Cell[] roadnew){
		int numMoved=0;
		for(int j=0; j<roadnew.length; j++){
			if(roadnew[j].getcar()==0){
				if(roadold[j].getcar()==1){
					numMoved=numMoved+1;}}}
		return numMoved;
	}
	   //mean
    public static double mean(double[] m) {
        double sum = 0;
        for (int i = 0; i < m.length && m[i]!=0 ; i++) {
            sum += m[i];
        }
        return sum / m.length;
    }
    
}


