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

public class Option {
	
	private double strikePrice;
	private double actualPrice;
	private double time;
	private double rfInterest;
	private double volatility;
	
	public Option(double strikePrice, double actualPrice, double time, double rfInterest, double volatility){
		this.strikePrice = strikePrice;
		this.actualPrice = actualPrice;
		this.time = time;
		this.rfInterest = rfInterest;
		this.volatility = volatility;
	}
	public double getStrikePrice() {
		return strikePrice;
	}
	public void setStrikePrice(double strikePrice) {
		this.strikePrice = strikePrice;
	}
	public double getActualPrice() {
		return actualPrice;
	}
	public void setActualPrice(double actualPrice) {
		this.actualPrice = actualPrice;
	}
	public double getTime() {
		return time;
	}
	public void setTime(double time) {
		this.time = time;
	}
	public double getRfInterest() {
		return rfInterest;
	}
	public void setRfInterest(double rfInterest) {
		this.rfInterest = rfInterest;
	}
	public double getVolatility() {
		return volatility;
	}
	public void setVolatility(double volatility) {
		this.volatility = volatility;
	}
	

}
