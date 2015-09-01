package com.berrakanil.simplebudget;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AddCommandTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAddCommand_CorrectParameters() throws Exception {
		String[] parameters = { "food", "5" };
		Account mockAccount = mock(Account.class);
		
		AddCommand addCommand = new AddCommand(parameters, mockAccount);
		addCommand.execute();
		
		assertTrue(true);
	}
	
	@Test(expected=Exception.class)
	public void testAddCommand_IncorrectParameters() throws Exception {
		String[] parameters = { "incorrect", "5" };
		Account mockAccount = mock(Account.class);
		
		AddCommand addCommand = new AddCommand(parameters, mockAccount);
		addCommand.execute();
	}
	
	@Test(expected=Exception.class)
	public void testAddCommand_IncorrectParameterCount() throws Exception {
		String[] parameters = { "food" };
		Account mockAccount = mock(Account.class);
		
		AddCommand addCommand = new AddCommand(parameters, mockAccount);
		addCommand.execute();
	}
	
	@Test(expected=Exception.class)
	public void testAddCommand_NegativeAmount() throws Exception {
		String[] parameters = { "food", "-10" };
		Account mockAccount = mock(Account.class);
		
		AddCommand addCommand = new AddCommand(parameters, mockAccount);
		addCommand.execute();
	}
}
