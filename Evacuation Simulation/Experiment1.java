import java.util.ArrayList;



public class Experiment1 {
	
	//Room time simulation
	
	public static void main(String[] args){
		

		//ArrayList<Double> exitTime = new ArrayList<Double>();
		//ArrayList<Integer> doorSize = new ArrayList<Integer>();
		//ArrayList<Integer> numberOfEvacuees = new ArrayList<Integer>();
		//ArrayList<Integer> speeds = new ArrayList<Integer>();
		
		int doorvalue = 30;
		int noEvacuees = 100;
		int speed = 2;
		
		//for(speed = 5; speed<50 ; speed++){
			//for( noEvacuees =1; noEvacuees<101 ; noEvacuees++){
                       ArrayList<Integer> exitTimes = new ArrayList<Integer>();
				//for(int i=0;i<4;i++){

				//doorSize.add(doorvalue);
				//numberOfEvacuees.add(noEvacuees);
				//speeds.add(speed);
				
				Room r = new Room(doorvalue,noEvacuees,speed);
				EvacuationFrame myFrame = new EvacuationFrame(r,speed);
				myFrame.setVisible(true);

				for(int time=0;time<10001;time++){
					
				
					r.move();
					myFrame.Update();
					if(r.getAllFree()==true){
						exitTimes.add(time);
						System.out.print(doorvalue+","+noEvacuees+"\n");
						break;}
					if(time==10000){
						exitTimes.add(10000);}
				//}
//}
//Average a = new Average(exitTimes);
//exitTime.add(a.getAverage());
		
		//}
}
			
		
				
			
		//Output.outputdataX(speeds);
		//Output.outputdataY(numberOfEvacuees);
		//Output.outputdataZ(exitTime);
		
		System.exit(0);
	

}
}
	
