package space_mining_sim;

public class timeManager {
	
	 // mining_expedition_simulation miningExpedition = new mining_expedition_simulation();
	
	int timeDay = 1;
	int timeMonth = 1;
	int timeYear = 2221;
	int timeToDebtDeadline =  60;
	

	  public timeManager() {
	        // Initialize without creating a mining_expedition_simulation instance
	    }


	
	
	
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
	
	public int increaseTimeDay(int increaseTimeDayAmount)
	{
		return timeDay += increaseTimeDayAmount;
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
	
    public void resetTimeManager() {
        this.timeDay = 1;
        this.timeMonth = 1;
        this.timeYear = 2221;
        this.timeToDebtDeadline = 60;
    }
	
	public int getTimeUnitlDeadline()
	{
		return timeToDebtDeadline-timeDay;
		
	}
	
	public int resetDebtDeadline()
	{
		return timeToDebtDeadline = timeDay + 60;
	}
	
	public int getCurrentTimeDay()
	{
		return timeDay;
	
	}
	
	public int getCurrentTimeMonth()
	{
		return timeMonth;
	
	}
	
	public int getCurrentTimeYear()
	{
		return timeYear;
	
	}



}
