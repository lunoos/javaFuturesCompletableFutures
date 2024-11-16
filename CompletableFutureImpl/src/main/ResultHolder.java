package main;


public class ResultHolder {

	private Integer result;
	private boolean isCompleted = false;
	
	public synchronized void setResult(Integer result) {
		this.result = result;
		this.isCompleted = true;
		notifyAll();
	}
	
	public synchronized Integer getResult() throws InterruptedException {
		while(!isCompleted) {
			wait();
		}
		return result;
	}
	
}
