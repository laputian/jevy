/**
 * Copyright 2016 the original author or authors.
 * 
 * Licensed under the Apache License, Version 2.0 the "License";
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
**/
package com.tito.options.merton;

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
		
		return Math.max(0, step - option.getStrike());
	}
	
	public double discount(double endValue, SimpleOption option, MertonProcess mp){
		double val = endValue - option.getStrike();
		if (val > 0){
			return val * Math.exp(-mp.getDrift() * option.getTime());
		}
		return 0.0;
	}
	
	public double calcOptionPrice(SimpleOption option, Random rn, MertonProcess mp, int numStep){
			
			int i = 0;
			double tot = 0;
			while (i < numTry){
				tot = tot + calcPath(option, mp, rn, numStep);
				i++;
			}
			
			return tot*Math.exp(-mp.getDrift()*option.getTime())/numTry ;
			
		}
	
	private double next_step(double step, MertonProcess mp, Random rn){
		
		double dt = mp.getTimeFraction();
		double vol = mp.getVolatiliy();
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
