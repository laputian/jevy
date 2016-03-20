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
package com.tito.options.model;

import org.apache.commons.math3.analysis.UnivariateFunction;

public class LevyKhinchine {
	
	private double drift;
	private double stDev;
	private UnivariateFunction measure;
	
	public  LevyKhinchine(double drift, double stDev, UnivariateFunction measure){
		this.drift = drift;
		this.stDev = stDev;
		this.measure = measure;
	}
	
	public double getDrift() {
		return drift;
	}

	public void setDrift(double drift) {
		this.drift = drift;
	}

	public double getStDev() {
		return stDev;
	}

	public void setStDev(double stDev) {
		this.stDev = stDev;
	}

	public UnivariateFunction getMeasure() {
		return measure;
	}

	public void setMeasure(UnivariateFunction measure) {
		this.measure = measure;
	}


}
