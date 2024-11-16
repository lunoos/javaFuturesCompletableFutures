package main;

public class FutureImp {
	
	public static void main(String[] args) throws InterruptedException {
		System.out.println("Hello wordl");
		ResultHolder resultHolder = new ResultHolder();
		Thread thread = new Thread(new RunnableImp(10, resultHolder));
		thread.start();
		System.out.println("Some other work is going on");
		Thread.sleep(5000);
		System.out.println("Thread is been blocked to wait for the resutls");
		resultHolder.getResult();
		
	}
}
