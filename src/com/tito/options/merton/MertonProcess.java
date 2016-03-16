package com.tito.options.merton;

public class MertonProcess {
		
	private double timeFraction;
	private double drift;
	private double volatiliy;
	private double intensity;
	private double mean;
	private double stDev;
	private MertonJumpFactory mertonJumpFactory;
	private double kappa;
	
		
	
	public MertonProcess(double timeFraction, double drift, double volatiliy, double intensity,
			double mean, double stDev) {
		super();
		this.timeFraction = timeFraction;
		this.drift = drift;
		this.volatiliy = volatiliy;
		this.intensity = intensity;
		this.mean = mean;
		this.stDev = stDev;
		this.kappa = Math.exp(mean + 0.5 * stDev * stDev) - 1;
		double reg = intensity * timeFraction;
		this.mertonJumpFactory = new MertonJumpFactory(reg, mean, stDev);

	}
	
	public double getTimeFraction() {
		return this.timeFraction;
	}
	
	public double getDrift() {
		return drift;
	}
	public void setDrift(double drift) {
		this.drift = drift;
	}
	public double getVolatiliy() {
		return volatiliy;
	}
	public void setVolatiliy(double volatiliy) {
		this.volatiliy = volatiliy;
	}
	public double getIntensity() {
		return intensity;
	}
	public void setIntensity(double intensity) {
		this.intensity = intensity;
	}
	public double getMean() {
		return mean;
	}
	public void setMean(double mean) {
		this.mean = mean;
	}
	double getStDev() {
		return stDev;
	}
	public void setStDev(double stDev) {
		this.stDev = stDev;
	}
	
	public double getKappa() {
		return kappa;
	}
	
	public MertonJumpFactory getMertonJumpFactory(){
		return this.mertonJumpFactory;
	}





}
