package space_mining_sim;

import java.util.Scanner;

public class ship_stats {
	
int i =1;
int ship_hull_integrity = 100;
int fuel_amount = 100;
int availableCrewSpots = 1;
boolean wentOnMiningExpedition = false; 
boolean shipHasMiningArm = false; 
boolean shipHasFusionEngine = false; 
double bonusFusionEngine = 1.0;
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

private String shipName; 

int crewMorale =100;

int crewMoraleBonus =0;
// add so that crewMorale is saved later



private Shop_space_mining_sim shop_instance;

private int minerSkillValue;

Scanner scanner = new Scanner(System.in);
String input = "";

//Shop_space_mining_sim spaceship_parts_store_instance = new Shop_space_mining_sim();

public void checkIfShipHasFusionEngine(){
	if(shipHasFusionEngine==true) {
		System.out.println("fusion engine lowered time");
	}
	
}

public void checkIfShipHasMiningArm(){
	if(shipHasMiningArm==true) {
		setBonusFusionEngine(0.6);
	}
}

//6 hardpoints here
private int[] hardpoints = new int[6]; // Array to store equipped parts by ID

// Method to equip a part to a hardpoint
public void equipPartToHardpoint(int hardpointIndex, int partId) {
    if (hardpointIndex >= 1 && hardpointIndex <= hardpoints.length) {
        hardpoints[hardpointIndex - 1] = partId; // Adjust for 0-based indexing
        System.out.println("Part " + partId + " equipped to hardpoint " + hardpointIndex);
    } else {
        System.out.println("Invalid hardpoint selected.");
    }
}

// Method to display hardpoints and equipped parts
public void displayHardpoints() {
    for (int i = 0; i < hardpoints.length; i++) {
        System.out.println("Hardpoint " + (i + 1) + ": Part ID " + hardpoints[i]);
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

public void crewMoraleEvents ()
{
	if (crewMorale>120 && crewMorale<140)
	{
		 System.out.println("crew morale is good");
		 setCrewMorale(2);
				 }
	if (crewMorale>100 && crewMorale<120)
	{
		 System.out.println("crew morale is normal");
		 setCrewMorale(1);
				 }
	if (crewMorale<80)
	{
		 System.out.println("Events have coused your crew to get a bit uneasy. You should perhaps pay attention to the crews morale");
	}
	if (crewMorale<60)
	{
		 System.out.println("The morale of the crew is middling. You should perhaps do something to improve morale.");
	}
	if (crewMorale<40)
	{
		System.out.println("The morale of the crew is poor. If you do not improve morale the crew will abandon you.");
	}
	if (crewMorale<20)
	{
		System.out.println("You need to urgently improve morale.");
		
	}
}

public void decreaseCrewMorale(int decreaseCrewMoraleAmount) {
	//crewMorale = crewMorale-reduceCrewMoraleAmount;
	setCrewMorale(crewMorale = crewMorale-decreaseCrewMoraleAmount);
	System.out.println("Crew morale reduced to "+ crewMorale );
	crewMoraleEvents();
}

public void increaseCrewMorale(int increaseCrewMoraleAmount) {
	//crewMorale = crewMorale-reduceCrewMoraleAmount;
	setCrewMorale(crewMorale = crewMorale+increaseCrewMoraleAmount);
	System.out.println("Crew morale increased to "+ crewMorale );
	crewMoraleEvents();
}



public ship_stats() {
	// TODO Auto-generated constructor stub

}

//public void selectHardpoint() {
//	  input = scanner.nextLine();  
//	switch (input) {
//     case "1":
//       
//     //    SoundGeneratorInstance.playTone(loadingBarWidth, sleepTime, infinityTimerStop);
//         break;
//  
//     case "2":
//         
//         //    SoundGeneratorInstance.playTone(loadingBarWidth, sleepTime, infinityTimerStop);
//             break;
//             
//     case "3":
//         
//         //    SoundGeneratorInstance.playTone(loadingBarWidth, sleepTime, infinityTimerStop);
//             break;
//             
//     case "4":
//         
//         //    SoundGeneratorInstance.playTone(loadingBarWidth, sleepTime, infinityTimerStop);
//             break;
//     case "5":
//         
//         //    SoundGeneratorInstance.playTone(loadingBarWidth, sleepTime, infinityTimerStop);
//             break;
//     case "6":
//         
//         //    SoundGeneratorInstance.playTone(loadingBarWidth, sleepTime, infinityTimerStop);
//             break;
//         default:
//         System.out.println("Invalid command.");
//         break;
//	}
//}


//public void equiptHardpoint() {
//	  input = scanner.nextLine();  
//	switch (input) {
//   case "1":
//     
//   //    SoundGeneratorInstance.playTone(loadingBarWidth, sleepTime, infinityTimerStop);
//       break;
//   default:
//       System.out.println("Invalid command.");
//       break;
//	}
//}


// Call this method to update the status
public void updateShipFeatures() {
    this.shipHasMiningArm = shop_instance.hasBoughtMiningArm();
    this.shipHasFusionEngine = shop_instance.getHaveBoughtFusionEngine();
    System.out.println("succesfully updated ship parts");
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

public void repairShip()
{

	
	
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
	
	
	
 updateShipFeatures();
 System.out.println("Ship Name: "+ shipName);
 System.out.println("hull:"+ ship_hull_integrity);
 System.out.println("fuel: "+ fuel_amount);
 System.out.println("available crew spots "+ availableCrewSpots);
 System.out.println("Ship has a mining arm: "+ shipHasMiningArm);
 System.out.println("Ship has a fusion engine: "+ shipHasFusionEngine);
 System.out.println("press e to equip ship hardpoints");
 System.out.println("press r to change ship name");
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


public void renameShip()
{
	Scanner scanner = new Scanner(System.in);
	System.out.println("Enter new ship name:");
	String newShipName = scanner.nextLine();
	setShipName(newShipName);
	 System.out.println("Your ship has been renamed to: " + newShipName);
}

public void resetShipStats()
{
	this.ship_hull_integrity = 100;
	this.fuel_amount = 100;
	this.availableCrewSpots =1;
	this.wentOnMiningExpedition = false;
	this.shipHasMiningArm = false;
	this.bonusFusionEngine = 1.0;
	this.hardpoints = new int[6];
	this.shipName = "";
	
	
}

public String getShipName() {
	return shipName;
}


public double getBonusFusionEngine() {
	// TODO Auto-generated method stub
	return bonusFusionEngine;
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


public int getMinerValueForJob() {
	
	return shipHardpoint6;
}


public int getMinerSkillValue() {
    return minerSkillValue; 
}

public int getCrewMorale() {
    return crewMorale; 
}

public int getCrewMoraleBonus() {
    return crewMoraleBonus; 
}


public void setMinerSkillValue(int minerSkillValue) {
    this.minerSkillValue = minerSkillValue;
}


public void setBonusFusionEngine(double newBonusFusionEngine) {
	// TODO Auto-generated method stub
	
	this.bonusFusionEngine = newBonusFusionEngine;
}

public void setShipHardpoint1(int newShipHardpoint1) {
	// TODO Auto-generated method stub
	this.shipHardpoint1 = newShipHardpoint1;
}

public void setShipHardpoint2(int newShipHardpoint2) {
	// TODO Auto-generated method stub
	this.shipHardpoint2 = newShipHardpoint2;
}

public void setShipHardpoint3(int newShipHardpoint3) {
	// TODO Auto-generated method stub
	this.shipHardpoint3 = newShipHardpoint3;
}

public void setShipHardpoint4(int newShipHardpoint4) {
	// TODO Auto-generated method stub
	this.shipHardpoint4 = newShipHardpoint4;
}

public void setShipHardpoint5(int newShipHardpoint5) {
	// TODO Auto-generated method stub
	this.shipHardpoint5 = newShipHardpoint5;
}

public void setShipHardpoint6(int newShipHardpoint6) {
	// TODO Auto-generated method stub
	this.shipHardpoint6 = newShipHardpoint6;
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

public void setShipName(String shipName) {
	this.shipName=shipName;
}


public void setCrewMorale(int crewMorale) {
	this.crewMorale=crewMorale;
}

public void setCrewMoraleBonus(int crewMoraleBonus) {
	this.crewMoraleBonus=crewMoraleBonus;
}
}


