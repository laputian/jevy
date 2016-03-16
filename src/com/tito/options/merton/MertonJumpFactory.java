package com.tito.options.merton;

import org.apache.commons.math3.distribution.NormalDistribution;
import org.apache.commons.math3.distribution.PoissonDistribution;

public class MertonJumpFactory {
	
	private PoissonDistribution ps;
	private NormalDistribution nr;
	
	public MertonJumpFactory(double lambda, double nrMean, double nrVariance){
		if (lambda > 0){
			ps = new PoissonDistribution(lambda);
		} 
		nr = new NormalDistribution(nrMean, nrVariance);
	}
	
	public int getSample(){
		return ps.sample();
	}
	
	public double getJump(){
			
		if (ps != null && ps.sample() > 0){
			return nr.sample();
		}
		
		return 0;
	}

}
