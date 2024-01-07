package space_mining_sim;

public class ship_stats {
	
int i =1;
int ship_hull_integrity = 100;
int fuel_amount = 100;
int availableCrewSpots = 1;
boolean wentOnMiningExpedition = false; 
boolean shipHasMiningArm = false; 
boolean shipHasFusionEngine = false; 
private Shop_space_mining_sim shop_instance;

Shop_space_mining_sim spaceship_parts_store_instance = new Shop_space_mining_sim();






public ship_stats(Shop_space_mining_sim shop_instance) {
    this.shop_instance = shop_instance;
}


public ship_stats() {
	// TODO Auto-generated constructor stub
}


// Call this method to update the status
public void updateShipFeatures() {
    this.shipHasMiningArm = shop_instance.hasBoughtMiningArm();
    this.shipHasFusionEngine = shop_instance.getHaveBoughtFusionEngine();
}


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
 System.out.println("available crew spots "+ availableCrewSpots);
 System.out.println("Ship has a mining arm: "+ shipHasMiningArm);
 System.out.println("Ship has a fusion engine: "+ shipHasFusionEngine);
}


public void upgradeToBasicCrewQuarters() {
    this.availableCrewSpots = 4; // Assuming 4 is the upgraded number of crew spots
    // Additional logic if needed
    System.out.println("Crew quarters upgraded. Available crew spots: " + availableCrewSpots);
}


public void test_for_parameter(Shop_space_mining_sim spaceship_parts_store_instance)
{
	 System.out.println("remember lesson "  );
	 spaceship_parts_store_instance.spaceship_parts_prices(100);
}

public int getHullIntegrity() {
	// TODO Auto-generated method stub
	return ship_hull_integrity;
}

public int getFuelAmount() {
	// TODO Auto-generated method stub
	return fuel_amount;
}

public int getAvailableCrewSpots() {
	// TODO Auto-generated method stub
	return availableCrewSpots;
}

public void setHullIntegrity(int newShipHullIntegrity) {
	// TODO Auto-generated method stub
	this.ship_hull_integrity = newShipHullIntegrity;
}

public void setFuelAmount(int newFuelAmount) {
	// TODO Auto-generated method stub
	this.fuel_amount = newFuelAmount;
}

public void setAvailableCrewSpots(int newAvailableCrewSpots) {
	 this.availableCrewSpots = newAvailableCrewSpots;
}



}


