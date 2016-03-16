package com.tito.options.first;

import java.util.Random;

public class First {
	
	int numStep = 180;
	int numTry = 100;

	public static void main(String[] args) {
		Random rn = new Random();

	}
	
	private double next_step(double step, double dt, double intr, double vol, Random rn){
				
		return step*Math.exp((intr-0.5*vol*vol)*dt + vol*rn.nextGaussian()*dt);
	}

}
