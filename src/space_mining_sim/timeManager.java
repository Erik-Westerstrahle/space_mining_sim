package space_mining_sim;

public class timeManager {
	
	  mining_expedition_simulation miningExpedition = new mining_expedition_simulation();
	
	int timeDay = 1;
	int timeMonth = 1;
	int timeYear = 2221;

	

	
	
	
	public void advanceTime(int days)
	{
        timeDay += days;
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
}
