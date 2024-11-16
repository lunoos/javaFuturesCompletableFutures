package main;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class FutureTest {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		System.out.println("Hello world ");
		
		ExecutorService executer = Executors.newSingleThreadExecutor();
		
		Future<Integer> result = executer.submit(new CallabelImpl(10));
		
		System.out.println("Doing some other work in the background ");
		Thread.sleep(5000);
		System.out.println("blocking the main thread for the result");
		System.out.println("Is done "+result.isDone());
		System.out.println("Is cancelled "+result.isCancelled());
		//result.cancel(true);
		try {
			result.get(12,TimeUnit.SECONDS);
		} catch (InterruptedException | ExecutionException | TimeoutException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		executer.shutdown();
	}
}
