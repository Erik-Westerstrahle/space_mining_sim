package space_mining_sim;

public class timeManager {
	
	  mining_expedition_simulation miningExpedition = new mining_expedition_simulation();
	
	int timeDay = 1;
	int timeMonth = 1;
	int timeYear = 2221;
	int timeToDebtDeadline =  60;
	

	

	
	
	
	public void advanceTime(double d)
	{
		 int intDays = (int) Math.round(d); // Round to nearest integer
		   timeDay += intDays;
    //    timeDay += d;
        while (timeDay > 30) {  // Assuming each month has 30 days for simplicity
            timeDay -= 30;
            timeMonth++;
            if (timeMonth > 12) {
                timeMonth = 1;
                timeYear++;
            }
        }
	}
	
	
	public void printCurrentDate()
	{
		 System.out.println("Current date is " + timeDay + '.' + timeMonth + '.' +  timeYear);
	}
	
	public void calculateTimeToDebtDeadline()
	{
		
	}
	
	public boolean isDebtDeadlinePassed()
	{
		return timeDay >= timeToDebtDeadline;
	}
	
	public int getTimeUnitlDeadline()
	{
		return timeToDebtDeadline-timeDay;
		
	}
	
	public int resetDebtDeadline()
	{
		return timeToDebtDeadline = timeDay + 60;
	}


}
