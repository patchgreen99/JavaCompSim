import java.io.*;

public class Atom {
	
    private double p, life ;
    
	//Decimal to Fraction
	public double choose(){
		double x=p;
		for(x=p ; Math.floor(x)!=x; x=x*10){}
			return x;}
	public double have(){
		double x=p;
		int i=0;
		for(x=p ; Math.floor(x)!=x; x=x*10){
			i++;}
		return Math.pow(10,i);}
	
	//Create atom
    public Atom(double p1,double life1){
    p=p1;
    life=life1;}
    
	//get probability
    public double getp() {
	return p;}
    
    //get life
    public double getlife() {
	return life;}
    
    //Check Decay
    public static Atom checkdecay(Atom A1){
    	if(A1.getlife()==1){
    		double a=Math.floor(Math.random()*A1.have());
    		if(a<A1.choose()){
    			 return new Atom(A1.getp(),0);}
    		else{return new Atom(A1.getp(),1);}}
    	else{return new Atom(A1.getp(),0);}}
     }
    