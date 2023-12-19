package space_mining_sim;

public class finances_player {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	int finances_player = 0;
	
	public void print_finances() {
	
	 System.out.println(finances_player);
	}
	
	
	public void increase_finances (int finance_amount)
	{
		finances_player+=finance_amount;
	}
	
	   public void decrease_finances(int amount) {
	        finances_player -= amount;
	    }
	

}

