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

public class BlackScholesFormula {
	
	//Hull 4th ed. 11.6
	  
	
	public double callBL(Option option){
		return option.getActualPrice() * Cumulative.dist(d1(option)) 
				- option.getStrikePrice() * Math.exp(-option.getRfInterest() * option.getTime())
				* Cumulative.dist(d2(option));
	}
	
	public double putBL(Option option){
		return option.getStrikePrice() * Math.exp(-option.getRfInterest() * option.getTime())
				* Cumulative.dist(-d2(option)) - option.getActualPrice() * Cumulative.dist(-d1(option)) ;
	}
	
	public double d1(Option option){
		double vol = option.getVolatility();
		double time = option.getTime();
		double num1 = Math.log(option.getActualPrice()/option.getStrikePrice());
		double num2 = (option.getRfInterest() + (vol * vol /2)) * time;
		double den = vol*Math.sqrt(time);
		return (num1 + num2)/den;
	}
	
	public double d2(Option option){
		double vol = option.getVolatility();
		double time = option.getTime();
		return d1(option) - vol * Math.sqrt(time);
	}

}
