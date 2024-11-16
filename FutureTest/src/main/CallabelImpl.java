package main;

import java.util.concurrent.Callable;

public class CallabelImpl implements Callable<Integer>{
	
	private int val = 0;
	
	public CallabelImpl(int val) {
		this.val = val;
	}

	@Override
	public Integer call() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Calculation in progress....");
		return calcValue(val);
	}
	
	private Integer calcValue(int val) {
		Integer result = null;
		try {
			result = val*val;
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Calculation Done. Result: "+result);
		return result;
		
	}

}
