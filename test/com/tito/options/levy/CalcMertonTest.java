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
package com.tito.options.levy;

import static org.junit.Assert.assertTrue;

import java.util.Random;

import org.junit.Test;

public class CalcMertonTest {
	
	int numStep=10000;
	double optionTime = 0.5;
	private AlgoMerton algoMerton = new AlgoMerton(100);
	private SimpleOption so = new SimpleOption(40, 42, optionTime);
	private MertonProcess mp = new MertonProcess(optionTime/numStep, 0.003, 0.2, 1, 0.5, 0.1);
	private Random rn = new Random();
	
	@Test
	public void calcTest(){
		
		assertTrue(algoMerton.calcPath(so, mp, rn, numStep) > 0);

	}

}
