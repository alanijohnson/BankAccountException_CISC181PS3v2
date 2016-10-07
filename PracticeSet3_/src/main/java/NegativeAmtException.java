/**
 * Custom class for throwing negative amount entered
 * Added because in class you mentioned that it was a given that amounts entered shouldn't be negative
 * @author Alani
 *
 */
public class NegativeAmtException extends Exception
{
   private double amount;
  
   public NegativeAmtException(double amount)
   {
	  super("You entered " + amount+ ". Please enter a positive value.");
      this.amount = amount;
   } 
   public double getAmount()
   {
      return amount;
   }
}