package space_mining_sim;

public class ship_stats {
	
int i =1;
int ship_hull_integrity = 100;
int fuel_amount = 100;
int availableCrewSpots = 1;
boolean wentOnMiningExpedition = false; 
boolean shipHasMiningArm = false; 
boolean shipHasFusionEngine = false; 
//Example of part IDs, can be expanded as needed
final int BASIC_RADAR = 1;
final int ADVANCED_MINING_LASER = 2;
//Add more parts as needed

int shipHardpoint1 =0;
int shipHardpoint2 =0;
int shipHardpoint3 =0;
int shipHardpoint4 =0;
int shipHardpoint5 =0;
int shipHardpoint6 =0;




private Shop_space_mining_sim shop_instance;

//Shop_space_mining_sim spaceship_parts_store_instance = new Shop_space_mining_sim();



// Assuming a fixed number of hardpoints for simplicity
private int[] hardpoints = new int[6]; // Array to store equipped parts by ID

// Method to equip a part to a hardpoint
public void equipPartToHardpoint(int hardpointIndex, int partId) {
    if (hardpointIndex >= 0 && hardpointIndex < hardpoints.length) {
        hardpoints[hardpointIndex] = partId;
        System.out.println("Equipped part " + partId + " to hardpoint " + (hardpointIndex + 1));
    } else {
        System.out.println("Invalid hardpoint index.");
    }
}

// Method to display current equipment
public void displayEquippedParts() {
    for (int i = 0; i < hardpoints.length; i++) {
        System.out.println("Hardpoint " + (i + 1) + ": Part ID " + hardpoints[i]);
    }
}

// Add getters/setters as needed



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
 System.out.println("press e to equip ship hardpoints");
}


public void upgradeToBasicCrewQuarters() {
    this.availableCrewSpots = 4; // Assuming 4 is the upgraded number of crew spots
    // Additional logic if needed
    System.out.println("Crew quarters upgraded. Available crew spots: " + availableCrewSpots);
}



public void test_for_parameter(Shop_space_mining_sim spaceship_parts_store_instance)
{
	
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

	return availableCrewSpots;
}

public int getShipHardpoint1() {
	
	return shipHardpoint1;
}

public int getShipHardpoint2() {
	
	return shipHardpoint2;
}

public int getShipHardpoint3() {
	
	return shipHardpoint3;
}

public int getShipHardpoint4() {
	
	return shipHardpoint4;
}

public int getShipHardpoint5() {
	
	return shipHardpoint5;
}

public int getShipHardpoint6() {
	
	return shipHardpoint6;
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


