package space_mining_sim;

public class LoadingBar {
	
	private final int loadingBarWidth;
	private final int sleepTime;
	
	public LoadingBar(int loadingBarWidth, int sleepTime) {
		this.loadingBarWidth = loadingBarWidth;
		this.sleepTime = sleepTime;
	}
	
	public void displayLoadingBar() throws InterruptedException {
	    for (int i = 0; i <= loadingBarWidth; i++) {
	        System.out.print("\r[");
	        int j = 0;
	        for (; j < i; j++) {
	            System.out.print("#");
	        }
	        for (; j < loadingBarWidth; j++) {
	            System.out.print(" ");
	        }
	        System.out.print("]");
	        Thread.sleep(sleepTime); // pause to simulate loading time
	    }

	}
}	
