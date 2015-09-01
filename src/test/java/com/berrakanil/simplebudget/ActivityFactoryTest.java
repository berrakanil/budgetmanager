package com.berrakanil.simplebudget;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ActivityFactoryTest {

	private final float DELTA = 0.0001f;

	@Before
	public void setUp() throws Exception {}
	
	@After
	public void tearDown() throws Exception {}
	
	@Test(expected=Exception.class)
	public void testCreateInvalidActivity() throws Exception {
		Activity testActivity = ActivityFactory.createActivity("invalid",10);	
		testActivity.getAmount();
	}
		
	@Test
	public void testCreateFoodActivity() throws Exception {
		Activity testActivity = ActivityFactory.createActivity("food",5);
		
		assertEquals("food", testActivity.getName());
		assertEquals(5.0f,testActivity.getAmount(),DELTA);
	}
	
	@Test
	public void testCreateBillActivity() throws Exception {
		Activity testActivity = ActivityFactory.createActivity("bill",10);
		
		assertEquals("bill", testActivity.getName());
		assertEquals(10.0f,testActivity.getAmount(),DELTA);
	}
	
	@Test(expected=Exception.class)
	public void testCreateBillActivity_NegativeAmount() throws Exception {
		Activity testActivity = ActivityFactory.createActivity("bill",-10);
	}
}
