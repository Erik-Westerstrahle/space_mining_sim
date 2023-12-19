package space_mining_sim;

public class ship_stats {
	
int i =1;
int ship_hull_integrity = 100;
int fuel_amount = 100;
boolean wentOnMiningExpedition = false; 



public static void main(String[] args) throws InterruptedException {

}

public void wear_and_tear()
{
	if(wentOnMiningExpedition)
	{
		ship_hull_integrity--;
		// wentOnMiningExpedition = false; 
	}
}

public void fuel_comsumption()
{
	if(wentOnMiningExpedition)
	{
		fuel_amount= fuel_amount-10;
		 wentOnMiningExpedition = false; 
	}
	
}


public void reset_fuel(int fuel_amount)
{
	this.fuel_amount = fuel_amount; 
}


public void setWentOnMiningExpedition(boolean wentOnExpedition)
{
	this.wentOnMiningExpedition = wentOnExpedition;
}

public void displayStats() {
	
	
	
	
 System.out.println("hull:"+ ship_hull_integrity);
 System.out.println("fuel: "+ fuel_amount);
}


public void test_for_parameter(Shop_space_mining_sim spaceship_parts_store_instance)
{
	 System.out.println("remember lesson "  );
	 spaceship_parts_store_instance.spaceship_parts_prices(100);
}


}


