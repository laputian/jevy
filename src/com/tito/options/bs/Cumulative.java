package com.tito.options.bs;

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
public class Cumulative {
	
	//Hull 4th ed. 11.6
	
	private static final double gamma = 0.2316419;
	private static final double a1 = 0.319381530;
	private static final double a2 = -0.356563782;
	private static final double a3 = 1.781477937;
	private static final double a4 = -1.821255978;
	private static final double a5 = 1.330274429;
	
	public static double dist(double x){
		if (x >= 0){
			return distPlus(x);
		}
		return distMinus(x);
		
	}
	
	private static double kappa(double x){
		return 1/(1+gamma*x);
	}
	
	private static double nPrime(double x){
		return (1/Math.sqrt(2*Math.PI))*Math.exp(-x*x/2);
	}
	
	private static double distPlus(double x){
		double k = kappa(x);
		double k2 = k*k;
		double k3 = k2*k;
		double k4 = k3*k;
		double k5 = k4*k;
		return 1 - nPrime(x)*(a1 * k + a2 * k2 +a3 * k3 + a4 * k4 + a5 * k5);
	}
	
	private static double distMinus(double x){
		return 1 - distPlus(-x);
	}
}
