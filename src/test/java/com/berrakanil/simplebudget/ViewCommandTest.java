package com.berrakanil.simplebudget;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ViewCommandTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    
    @Test
    public void testViewCommand_CorrectParameters() throws Exception {
        String[] parameters = { "all" };
        Account mockAccount = mock(Account.class);
        
        ViewCommand viewCommand = new ViewCommand(parameters, mockAccount);
        viewCommand.execute();
        
        assertTrue(true);
    }
    
    @Test(expected=Exception.class)
    public void testViewCommand_IncorrectParameters() throws Exception {
        String[] parameters = { "incorrect" };
        Account mockAccount = mock(Account.class);
        
        ViewCommand viewCommand = new ViewCommand(parameters, mockAccount);
        viewCommand.execute();
    }

    @Test(expected=Exception.class)
    public void testViewCommand_IncorrectParameterCount() throws Exception {
        String[] parameters = { "income", "all" };
        Account mockAccount = mock(Account.class);
        
        ViewCommand viewCommand = new ViewCommand(parameters, mockAccount);
        viewCommand.execute();
    }
}
