package space_mining_sim;

import java.util.Scanner;

public class finances_player {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	int finances_player = 0;
	int debtPlayer = 600000;

	
	public void print_finances() {
	
	 System.out.println(finances_player);
	}
	
	
	public void increase_finances (int finance_amount)
	{
		finances_player+=finance_amount;
	}
	
	   public void decrease_finances(int amount) {
		   int finances_before_purchase =finances_player;
		  
		   if(finances_before_purchase <= 0)
		   {
			   System.out.println("you have no money"); 
		   }
		   else
		   {
			   finances_player -= amount;
		   }
	    }

	    
	    public void payOffPlayerDebt ()
	    {
	    	  Scanner scanner = new Scanner(System.in);
		        int payOffAmount  = scanner.nextInt();
	    	
	    	
		        // Check if the entered amount is valid
		        if (payOffAmount <= 0) {
		            System.out.println("Invalid amount.");
		            return;
		        }
		        

		        // Check if the player has enough money
		        if (payOffAmount > finances_player) {
		            System.out.println("Insufficient funds to pay off the debt.");
		            return;
		        }

		        // Deduct the payment from the player's finances and debt
		        finances_player -= payOffAmount;
		        debtPlayer -= payOffAmount;
		        System.out.println("Paid off " + payOffAmount + " of the debt. Remaining debt: " + debtPlayer);
	    }
	    
	    public void printDebtPlayer ()
	    {
	    	
	    	System.out.println(debtPlayer); 
	    }
	    
	    

	    // Method to get the current amount of finances
	    public int getFinances() {
	        return finances_player;
	    }
	    


		public int getDebt() {
			// TODO Auto-generated method stub
			return debtPlayer;
		}


		public void setFinances(int newFinances) {
			this.finances_player = newFinances;

			
		}


		public void setDebt(int newDebtPlayer) {
			// TODO Auto-generated method stub
			this.debtPlayer = newDebtPlayer;
		}
}

