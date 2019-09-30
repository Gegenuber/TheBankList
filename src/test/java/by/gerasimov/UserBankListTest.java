package by.gerasimov;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertTrue;

import by.gerasimov.domain.Account;
import org.junit.Test;

public class UserBankListTest
{
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void testApp()
    {
        int amount = 10;
        Account acc = new Account();
        acc.setAccount(amount);
        assertEquals(amount, acc.getAccount());
    }
}
