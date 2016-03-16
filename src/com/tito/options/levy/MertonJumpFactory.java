package com.tito.options.levy;

import org.apache.commons.math3.distribution.PoissonDistribution;
import org.apache.commons.math3.distribution.NormalDistribution;

public class MertonJumpFactory {
	
	private PoissonDistribution ps;
	private NormalDistribution nr;
	
	public MertonJumpFactory(double lambda, double nrMean, double nrVariance){
		ps = new PoissonDistribution(lambda);
		nr = new NormalDistribution(nrMean, nrVariance);
	}
	
	public int getSample(){
		return ps.sample();
	}
	
	public double getJump(){
		
		if (ps.sample() > 0){
			return nr.sample();
		}
		
		return 0;
	}

}
