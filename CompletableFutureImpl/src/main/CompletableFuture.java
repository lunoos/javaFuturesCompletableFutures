package main;

public class CompletableFuture<T> {
	private static Object t;
	public static CompletableFuture supplyAsync(Supplier supplier){
		t = supplier.get();
		return new CompletableFuture<>();
	}

}
