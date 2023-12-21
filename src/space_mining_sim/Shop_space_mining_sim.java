package space_mining_sim;
import java.util.Scanner;

public class Shop_space_mining_sim {
	
	
	
	//ship_stats shipStats_instance = new ship_stats();
	
	public void spaceship_parts_store()
	{
		 System.out.println("xenon engine");
		 System.out.println("fusion engine");
		 System.out.println("pres r to repair hull");
		 
		 
		 
		 
		 
		 
		 
				 
		 
		 
	}
	
	
	public void spaceship_parts_prices(int engine_price)
	{
	 engine_price = 100;
				 
	 System.out.println(engine_price);	 
		 
	}
	
	
	
								//   remember you can input instance of classes as variables
											//V
	
	public void refuel_spaceship(ship_stats shipStats_instance, finances_player playerFinances)
	{
		 System.out.println(" press f to refuel your ship");
		 

		 shipStats_instance.reset_fuel(100);
		 playerFinances.decrease_finances(10); // Decrease finances by 10
		 playerFinances.print_finances();
		
	}
	
	
	
	public void repair_hull()
	{
		 System.out.println(" press r to refuel your ship");
		
	}



			

}
