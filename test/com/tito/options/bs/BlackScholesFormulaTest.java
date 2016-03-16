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

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.tito.options.bs.BlackScholesFormula;
import com.tito.options.bs.Option;

public class BlackScholesFormulaTest {
	
	private Option option = new Option(40, 42, 0.5 , 0.1, 0.2);
	private BlackScholesFormula blf = new BlackScholesFormula();

	@Test
	public void testCall() {

		assertEquals(4.76,  blf.callBL(option) , 0.01);
	}
	
	@Test
	public void testPut() {

		assertEquals(0.81,  blf.putBL(option) , 0.01);
	}
	
	@Test
	public void testD1(){
		assertEquals(0.7692626281060315,  blf.d1(option), 0.00001);
	}

}
