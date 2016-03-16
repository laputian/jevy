package com.tito.options.levy;

import java.util.Random;

//Matsuda - Introduction to Merton Jump Diffusion Model 

public class AlgoMerton {
	
	private int numTry;
	
	public AlgoMerton(int numTry){
		
		this.numTry = numTry;
		
		
	}
	
	public double calcPath(SimpleOption option, MertonProcess mp, Random rn, int numStep){
		int i = 0;
		double step = option.getCurrent();
		while (i < numStep){
			step = next_step(step, mp, rn );
			i++;
		}
		
		return step;
	}
	
	private double next_step(double step, MertonProcess mp, Random rn){
		
		double dt = mp.getTimeFraction();
		double vol = mp.getStDev();
		double intr = mp.getDrift();
		double kappa = mp.getKappa();
		double lambda = mp.getIntensity();
		MertonJumpFactory mjf = mp.getMertonJumpFactory();
		
		
	
		double expo = (intr-0.5 * vol * vol - kappa * lambda) * dt 
				+ vol * rn.nextGaussian() * Math.sqrt(dt)
				+ mjf.getJump();
		
		return step*Math.exp(expo);
	}

}
