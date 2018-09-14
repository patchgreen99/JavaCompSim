public class Polygon {
	private Vector2D[] edge ;
	private Vector2D[] vertices;
	
	
	public Polygon(Vector2D[] vertex){
		vertices = vertex;
		edge = new Vector2D[vertex.length];
		for(int i=0;i<edge.length-1;i++){
			edge[i] = Vector2D.differenceVector(vertex[i+1], vertex[i]);}
			edge[edge.length-1] = Vector2D.differenceVector(vertex[0], vertex[edge.length-1]);	
		}
	
	public Vector2D[] getEdges(){
		return edge;
	}
	public Vector2D[] getVertices(){
		return vertices;
	}
	
	public boolean convex(){
		boolean convex = true;
		double n = 0;
		for(int i=0;i<edge.length-1;i++){
			double m = Vector2D.perpendicularDotProduct(edge[i],edge[i+1]);
				if((m<0 && n>0) || (m>0 && n<0)){
					convex = false;}
				n=m;}
		double m = Vector2D.perpendicularDotProduct(edge[edge.length-1],edge[0]);
		if((m<0 && n>0) || (m>0 && n<0)){
			convex = false;}
		return convex;
		}
		
		
	}
	
	
		
	


