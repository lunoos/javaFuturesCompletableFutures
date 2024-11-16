package main;

public class CompletableFutureMain {
	
	//focus
	//focus
	//focus
	//focus
	//focus
	//focus
	public static void main(String[] args) throws InterruptedException {
		System.out.println("CompletableFutures ");
		System.out.println("Hello wordl");
		ResultHolder resultHolder = new ResultHolder();
		Thread thread = new Thread(new RunnableImp(10, resultHolder));
		thread.start();
		System.out.println("Some other work is going on");
		Thread.sleep(5000);
		System.out.println("Thread is been blocked to wait for the resutls");
		resultHolder.getResult();
		
		//method used in completableFutures
		//.supplyAsync -> returns future
		//.runAsync -> does not return anything
		//.thenApply -> Transforms the result (like map)
		//.thenAsycApply -> 
		//.thenAccept -> Consumes the result (like forEach)
		//.thenRun -> Runs code after completion (ignores result)
		//.exceptionally -> Handles exceptions and provides fallback
		//.timeOut
		//.thenCombine -> Combines two futures when both complete
		//.thenCompose() ->  Chains futures sequentially (flatMap)
		//.allOf(): -> Waits for multiple futures to complete
		//.combineAll
		//handle(): Processes both success and failure cases
		//completeOnTimeout(): Provides default value if operation times out
		//orTimeout(): Throws exception if operation times out
		
		//Will implement
		//.supplyAsync -> returns future
		//.thenApply -> Transforms the result (like map)
		//.thenAsycApply -> 
		//.exceptionally -> Handles exceptions and provides fallback
		//.thenCombine -> Combines two futures when both complete
		
		
//		impl supplyAsync 
//			accepts a function
//			return a comfutur with type
//			
//		
		
		
	}
}
