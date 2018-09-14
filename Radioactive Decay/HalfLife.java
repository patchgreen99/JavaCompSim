
public class HalfLife {
	
	
    //mean
    public static double mean(double[] m) {
        double sum = 0;
        for (int i = 0; i < m.length && m[i]!=0 ; i++) {
            sum += m[i];
        }
        return sum / m.length;
    }
    
    //Standard deviation
    public static double uncertainty(double[] n) {
        if(n.length == 0)
            return 0.0;
        double sum = 0;
        double sq_sum = 0;
        for(int i = 0; i < n.length && n[i]!=0 ; ++i) {
           sum += n[i];
           sq_sum += n[i] * n[i];
        }
        double mean = sum / n.length;
        double variance = sq_sum / n.length - mean * mean;
        //n.length -1 because array length is 1 greater than to saved values in that array 
        return Math.sqrt(variance)/Math.sqrt(n.length - 1);
    }
    
    }


