package com.tito.options.merton;

public class SimpleOption {
	
	private double strike;
	private double current;
	private double time;
	
	public SimpleOption(double strike, double current, double time) {
		super();
		this.strike = strike;
		this.current = current;
		this.time = time;
	}
	
	public double getStrike() {
		return strike;
	}
	public void setStrike(double strike) {
		this.strike = strike;
	}
	public double getCurrent() {
		return current;
	}
	public void setCurrent(double current) {
		this.current = current;
	}
	
	public double getTime() {
		return time;
	}
	public void setTime(double time) {
		this.time = time;
	}


}
