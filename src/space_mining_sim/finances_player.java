package space_mining_sim;

import java.util.Scanner;

public class finances_player {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	int finances_player = 0;
	int debtPlayer = 600000;
	

	
	public void print_finances() {
	
	 System.out.println("your money: "+finances_player);
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

	    // the debt is the win condition for the game
	   // when the player reduces the debt to zero then the player has won the game
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
	    
	    
	    // function that lets the player pay off the debt
	    public void payDebtIstallment(timeManager timeManager_instance)
	    {
	    	int debtPayment = 300;
	    	if(finances_player >= debtPayment)
	    	{
	    		finances_player -=debtPayment;
	    		
	    		debtPlayer -= debtPayment;
	    		System.out.println("Paid " + debtPayment + " towards debt. Remaining debt: " + debtPlayer);
	    		timeManager_instance.resetDebtDeadline();
	    	}
	    	else
	    	{
	    		System.out.println("Insufficient funds to pay the debt");
	    	}
	    }
	    
	    public void printDebtPlayer ()
	    {
	    	
	    	System.out.println("your debt is: "+debtPlayer); 
	    }
	    
	    public void checkIFDebtHasBeenPaid ()
	    {
	    	if(debtPlayer<=0)
	    	{
	    		System.out.println("Congratulations. You have paid of your debt and now own your ship fully. You have won the game."); 
	    		System.out.println("there is no post game content yet. But you can continue if you want to."); 
	    	}
	    	
	   
	    }
	    
	    public void resetFinances() {
	        this.finances_player = 1000; // Default starting finances
	        this.debtPlayer = 5000; // Default starting debt
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

