package main;

public class RunnableImp implements Runnable{

	private Integer val;
	private ResultHolder resultHolder;
	
	public RunnableImp(Integer val, ResultHolder resultHolder) {
		this.val = val;
		this.resultHolder = resultHolder;
	}
	@Override
	public void run() {
		Integer result = calculateProduct(val);
		resultHolder.setResult(result);
	}
	
	private Integer calculateProduct(Integer val) {
		Integer result = 0;
		
		try {
			System.out.println("Result is been calculated please waint ");
			result = val*val;
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Result has be calculated Result: "+result);
		return result;
	}

}
