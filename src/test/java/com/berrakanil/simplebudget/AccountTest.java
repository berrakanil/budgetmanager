package com.berrakanil.simplebudget;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AccountTest {
    
    private final float DELTA = 0.0001f;
    private Account m_account;
    
    @Before
    public void setUp() throws Exception {
        m_account = new Account();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testAddActivity() {
        Activity mockActivity = mock(Activity.class);
        m_account.addActivity(mockActivity);
        assertEquals(1, m_account.getActivityCount());
    }
    
    public void testGetBalance() {
        Activity mockOutcomeActivity = mock(Activity.class);
        when(mockOutcomeActivity.getAmount()).thenReturn(5.0f);
        when(mockOutcomeActivity.getDirection()).thenReturn(Direction.OUTCOME);
        
        Activity mockIncomeActivity = mock(Activity.class);
        when(mockIncomeActivity.getAmount()).thenReturn(15.0f);
        when(mockIncomeActivity.getDirection()).thenReturn(Direction.INCOME);
        
        m_account.addActivity(mockOutcomeActivity);
        m_account.addActivity(mockIncomeActivity);
        
        assertEquals(10, m_account.getBalance(),DELTA);
    }
    
    public void testGetOutcome() {
        Activity mockOutcomeActivity = mock(Activity.class);
        when(mockOutcomeActivity.getAmount()).thenReturn(5.0f);
        when(mockOutcomeActivity.getDirection()).thenReturn(Direction.OUTCOME);
        m_account.addActivity(mockOutcomeActivity);
        
        assertEquals(5.0f, m_account.getTotalOutcome(),DELTA);
    }
    
    public void testGetIncome() {
        Activity mockIncomeActivity = mock(Activity.class);
        when(mockIncomeActivity.getAmount()).thenReturn(3500.0f);
        when(mockIncomeActivity.getDirection()).thenReturn(Direction.INCOME);
        m_account.addActivity(mockIncomeActivity);
        
        assertEquals(3500.0f, m_account.getTotalIncome(),DELTA);
    }

    public void testGetAllAcitivtiyHistory() {
        Activity mockOutcomeActivity = mock(Activity.class);
        when(mockOutcomeActivity.getAmount()).thenReturn(5.0f);
        when(mockOutcomeActivity.getDirection()).thenReturn(Direction.OUTCOME);
        
        Activity mockIncomeActivity = mock(Activity.class);
        when(mockIncomeActivity.getAmount()).thenReturn(15.0f);
        when(mockIncomeActivity.getDirection()).thenReturn(Direction.INCOME);
        
        m_account.addActivity(mockOutcomeActivity);
        m_account.addActivity(mockIncomeActivity);
        
        Activity[] activityArray = { mockOutcomeActivity, mockIncomeActivity };
        assertArrayEquals(activityArray, m_account.getAllAcitivtiyHistory().toArray());     
    }
    
    public void testGetOutcomeActivityHistory() {
        Activity mockOutcomeActivity = mock(Activity.class);
        when(mockOutcomeActivity.getAmount()).thenReturn(5.0f);
        when(mockOutcomeActivity.getDirection()).thenReturn(Direction.OUTCOME);
        
        Activity mockOutcomeActivity2 = mock(Activity.class);
        when(mockOutcomeActivity2.getAmount()).thenReturn(15.0f);
        when(mockOutcomeActivity2.getDirection()).thenReturn(Direction.OUTCOME);
        
        Activity mockIncomeActivity = mock(Activity.class);
        when(mockIncomeActivity.getAmount()).thenReturn(15.0f);
        when(mockIncomeActivity.getDirection()).thenReturn(Direction.INCOME);
        
        m_account.addActivity(mockOutcomeActivity);
        m_account.addActivity(mockOutcomeActivity2);
        m_account.addActivity(mockIncomeActivity);
        
        Activity[] activityArray = {mockOutcomeActivity, mockOutcomeActivity2};
        assertArrayEquals(activityArray, m_account.getOutcomeActivityHistory().toArray());      
    }
    
    public void testGetIncomeActivityHistory() {
        Activity mockOutcomeActivity = mock(Activity.class);
        when(mockOutcomeActivity.getAmount()).thenReturn(5.0f);
        when(mockOutcomeActivity.getDirection()).thenReturn(Direction.OUTCOME);
        
        Activity mockIncomeActivity = mock(Activity.class);
        when(mockIncomeActivity.getAmount()).thenReturn(15.0f);
        when(mockIncomeActivity.getDirection()).thenReturn(Direction.INCOME);
        
        Activity mockIncomeActivity2 = mock(Activity.class);
        when(mockIncomeActivity2.getAmount()).thenReturn(20.0f);
        when(mockIncomeActivity2.getDirection()).thenReturn(Direction.INCOME);
        
        m_account.addActivity(mockOutcomeActivity);
        m_account.addActivity(mockIncomeActivity);
        m_account.addActivity(mockIncomeActivity2);
        
        Activity[] activityArray = {mockIncomeActivity, mockIncomeActivity2};
        assertArrayEquals(activityArray, m_account.getIncomeActivityHistory().toArray());       
    }
}
