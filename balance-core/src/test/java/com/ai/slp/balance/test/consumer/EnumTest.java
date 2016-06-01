package com.ai.slp.balance.test.consumer;

import junit.framework.TestCase;

import org.junit.Test;

import com.ai.slp.balance.constants.BalancesCostants;

public class EnumTest extends TestCase{
    @Test
    public void testEnum(){
        System.out.println(BalancesCostants.FunResBook.ResourceType.CALL);
        
    }
    
}
