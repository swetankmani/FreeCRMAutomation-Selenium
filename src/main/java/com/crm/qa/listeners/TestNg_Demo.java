package com.crm.qa.listeners;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.internal.annotations.ListenersAnnotation;


public class TestNg_Demo {

	
	@Test
	public void test1() {
			
			System.out.println("I am in test 1");
			
		}
	@Test
public void test2() {
			
			System.out.println("I am in test 2");
			Assert.assertTrue(false);
			
		} 
	@Test
public void test3() {
	
	System.out.println("I am in test 3");
	throw new SkipException("This test is skipped") ;
} 
	@Test
	
public void test4() {
	
	System.out.println("I am in test 4");
	
} 


}
