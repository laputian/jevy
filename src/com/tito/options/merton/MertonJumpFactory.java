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

import org.apache.commons.math3.distribution.NormalDistribution;
import org.apache.commons.math3.distribution.PoissonDistribution;

public class MertonJumpFactory {
	
	private PoissonDistribution ps;
	private NormalDistribution nr;
	
	public MertonJumpFactory(double lambda, double nrMean, double nrVariance){
		if (lambda > 0){
			ps = new PoissonDistribution(lambda);
		} 
		nr = new NormalDistribution(nrMean, nrVariance);
	}
	
	public int getSample(){
		return ps.sample();
	}
	
	public double getJump(){
			
		if (ps != null && ps.sample() > 0){
			return nr.sample();
		}
		
		return 0;
	}

}
