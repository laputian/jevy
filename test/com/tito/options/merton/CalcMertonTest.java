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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Random;

import org.junit.Test;

import com.tito.options.merton.AlgoMerton;
import com.tito.options.merton.MertonJumpFactory;
import com.tito.options.merton.MertonProcess;
import com.tito.options.merton.SimpleOption;

public class CalcMertonTest{
	
	private int numStep=100;
	private double optionTime = 0.5;
	private AlgoMerton algoMerton = new AlgoMerton(1000000);
	private SimpleOption so = new SimpleOption(40, 42, optionTime);
	private MertonProcess mpBS = new MertonProcess(optionTime/numStep, 0.1, 0.2, 0, 0.5, 0.1);
	private MertonProcess mp = new MertonProcess(optionTime/numStep, 0.1, 0.2, 0.1, 0.5, 0.1);
	private Random rn = new Random();
	
	@Test
	public void calcTest(){
		
		assertTrue(algoMerton.calcPath(so, mp, rn, numStep) > 0);

	}
	
	@Test
	public void mertonJumpFactoryTest(){
		
		MertonJumpFactory mjf = mpBS.getMertonJumpFactory();
		assertEquals(mjf.getJump(), 0, 0.0001);

	}
	
	@Test
	public void mpBSTest(){
		
		assertEquals(mpBS.getDrift(), 0.1, 0.001);
		assertEquals(mpBS.getVolatiliy(), 0.2, 0.001);
		assertEquals(mpBS.getIntensity(), 0, 0.001);
		assertEquals(mpBS.getTimeFraction()*numStep, so.getTime(), 0.001);
		
		assertEquals(0.0, mpBS.getMertonJumpFactory().getJump(),  0.0001);

	}
	
	@Test
	public void calcOptionPriceBSTest(){
		
		assertEquals(4.76, algoMerton.calcOptionPrice(so, rn, mpBS, numStep), 0.01);
		
	}
	
	@Test
	public void calcOptionPriceTest(){
		
		double mertonOptionPrice = algoMerton.calcOptionPrice(so, rn, mp, numStep);
		System.out.println("Option price = " + mertonOptionPrice);
		assertTrue(4.76 < mertonOptionPrice);
		
	}
	



}
