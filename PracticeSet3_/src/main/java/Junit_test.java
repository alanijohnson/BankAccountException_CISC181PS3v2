import static org.junit.Assert.*;

import org.junit.Test;

public class Junit_test {

	// Test
		@Test
		public void testAccountConstructor() {
			Account account1 = new Account(1122, 20000);
			assertEquals(1122, account1.getId());
			assertEquals(20000, account1.getBalance(), 0);
		}

		@Test
		public void testSettersnGetters() {
			Account account1 = new Account(1122, 0);
			account1.setAnnualInterestRate(10);
			assertEquals(10, account1.getAnnualInterestRate(),0);
			assertEquals((10.0 / 12), account1.getMothlyInterestRate(), 0);
			account1.setBalance(20000);
			assertEquals(20000, account1.getBalance(), 0);
			account1.setId(12);
			assertEquals(12, account1.getId());
		}

		
		@Test
		public void testProcedures_Valid() throws InsufficientFundsException, NegativeAmtException {
			Account account1 = new Account(1122, 20000);
			account1.deposit(10);
			assertEquals(20010, account1.getBalance(), 0);
			account1.withdraw(20000);
			assertEquals(10, account1.getBalance(), 0);
		}
		
		
		@Test(expected = InsufficientFundsException.class)
		public void testInsufficientFundsException() throws InsufficientFundsException, NegativeAmtException {
			Account account1 = new Account(1122, 200);
			account1.withdraw(2000);
		}

		@Test(expected = NegativeAmtException.class)
		public void testNegativeAmtException_Withdraw() throws InsufficientFundsException, NegativeAmtException {
			Account account1 = new Account(1122, 200);
			account1.withdraw(-500);
		}

		@Test(expected = NegativeAmtException.class)
		public void testNegativeAmtException_Deposit() throws InsufficientFundsException, NegativeAmtException {
			Account account1 = new Account(1122, 200);
			account1.deposit(-500);
		}

}