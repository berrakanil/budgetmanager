package com.berrakanil.simplebudget;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

import org.hamcrest.core.IsInstanceOf;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CommandFactoryTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testCreateViewCommand() throws Exception {
        Account mockAccount = mock(Account.class);
        String[] commandParameters = {"income"};
        Command command = CommandFactory.createCommand("view", commandParameters, mockAccount);
        
        assertThat(command, IsInstanceOf.instanceOf(ViewCommand.class));
    }
    
    @Test
    public void testCreateShowStatusCommand() throws Exception {
        Account mockAccount = mock(Account.class);
        String[] commandParameters = {};
        Command command = CommandFactory.createCommand("showstatus", commandParameters, mockAccount);
        
        assertThat(command, IsInstanceOf.instanceOf(ShowStatusCommand.class));
    }
        
    @Test
    public void testCreateInvalidCommand() throws Exception {
        Account mockAccount = mock(Account.class);
        String[] commandParameters = {"income"};
        Command command = CommandFactory.createCommand("invalid", commandParameters, mockAccount);
        
        assertThat(command, IsInstanceOf.instanceOf(UsageCommand.class));
    }
    
    @Test
    public void testCreateAddCommand_CorrectParameters() throws Exception {
        Account mockAccount = mock(Account.class);
        String[] commandParameters = {"food", "5"};
        Command command = CommandFactory.createCommand("add", commandParameters, mockAccount);

        assertThat(command, IsInstanceOf.instanceOf(AddCommand.class));
    }
    
    @Test(expected=Exception.class)
    public void testCreateAddCommand_IncorrectParametersCount() throws Exception {
        Account mockAccount = mock(Account.class);
        String[] commandParameters = {"bill"};
        Command command = CommandFactory.createCommand("add", commandParameters, mockAccount);

        assertThat(command, IsInstanceOf.instanceOf(AddCommand.class));
    }
}
