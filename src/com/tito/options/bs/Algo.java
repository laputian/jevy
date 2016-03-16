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
package com.tito.options.bs;

import java.util.Random;


public class Algo {
	
	//Bergström - Pricing American Options using Lévy Processes ... - 
	
	private int numStep;
	private int numTry;
	
	public Algo(int numStep, int numTry){
		
		this.numStep = numStep;
		this.numTry = numTry;
		
	}
	
	public double calcPath(Option option, Random rn){
		int i = 0;
		double dt = option.getTime()/numStep;
		double intr = option.getRfInterest();
		double step = option.getActualPrice();
		double vol = option.getVolatility();
		while (i < numStep){
			step = next_step(step, dt, intr, vol, rn );
			i++;
		}
		
		return step;
	}
	
	public double discount(double endValue, Option option){
		double val = endValue - option.getStrikePrice();
		if (val > 0){
			return val*Math.exp(-option.getRfInterest()*option.getTime());
		}
		return 0.0;
	}
	
	public double calcOptionPrice(Option option, Random rn){
		
		int i = 0;
		double tot = 0;
		while (i < numTry){
			tot = tot + discount(calcPath(option, rn),option);
			i++;
		}
		
		return tot/numTry ;
		
	}
	
		
	private double next_step(double step, double dt, double intr, double vol, Random rn){
		
		return step*Math.exp((intr-0.5*vol*vol)*dt + vol*rn.nextGaussian()*Math.sqrt(dt));
	}

}
