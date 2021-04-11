package Matrix;

import java.util.Random;

public class MaTran {
	 private int[][] matran;
	    
	    //Tao ngau nhien ma tran
	    public MaTran(int n, int m){
	        matran = new int[n][m];
	        Random r = new Random();
	        for(int i = 0; i < matran.length; i++){
	            for(int j = 0; j < matran[i].length; j++){
	                this.matran[i][j] = r.nextInt(10);
	            }
	        }
	    }
	    
	    //In ra ma tran
	    @Override
	    public String toString(){
	        StringBuilder sb = new StringBuilder();
	        for(int i = 0; i < matran.length; i++){
	            for(int j = 0; j < matran[i].length; j++){
	                sb.append(String.format("%4d", this.matran[i][j]));
	            }
	            sb.append("\n");
	        }
	        return sb.toString();
	    }
	    
	    //Cong 2 ma tran return ra 1 ma tran
	    public MaTran cong(MaTran other){
	        MaTran sum = new MaTran(this.matran.length, this.matran[0].length);
	        for(int i = 0; i < matran.length; i++){
	            for(int j = 0; j < matran[i].length; j++){
	                sum.matran[i][j] = this.matran[i][j] + other.matran[i][j];
	            }
	        }
	        return sum;
	    }
	    // Tru 2 ma tran return ra 1 ma tran
	    public MaTran tru(MaTran other) {
	    	MaTran diff= new MaTran(this.matran.length, this.matran[0].length);
	    	for(int i=0;i<matran.length;i++) {
	    		for(int j=0;j<matran.length;j++) {
	    			diff.matran[i][j]=this.matran[i][j]-other.matran[i][j];
	    		}
	    			
	    	}
	    	return diff;
	    }
	    
}
