package com.berrakanil.simplebudget;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ShowStatusCommandTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    
    @Test
    public void testShowStatusCommand_CorrectParameters() throws Exception {
        String[] parameters = {};
        Account mockAccount = mock(Account.class);
        
        ShowStatusCommand showStatusCommand = new ShowStatusCommand(parameters, mockAccount);
        showStatusCommand.execute();
        
        assertTrue(true);
    }
    
    @Test(expected=Exception.class)
    public void testShowStatusCommand_IncorrectParametersCount() throws Exception {
        String[] parameters = { "incorrect"};
        Account mockAccount = mock(Account.class);
        
        ShowStatusCommand showStatusCommand = new ShowStatusCommand(parameters, mockAccount);
        showStatusCommand.execute();
    }
}
