import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;

public class Worker implements Callable<Void>{
	private BlockingQueue<String> inputQueue;
	private BlockingQueue<String> outputQueue;
	private Boolean isRunning;
	static int number = 0;
	private int id;
	
	public Worker(BlockingQueue<String> inputQueue, BlockingQueue<String> outputQueue) {
		// TODO Auto-generated constructor stub
		this.inputQueue = inputQueue;
		this.outputQueue = outputQueue;
		this.id = number;
		number++;
	}
	
	@Override
	public Void call() throws Exception {
		// TODO Auto-generated method stub
		isRunning = true;
		
		while(isRunning || !inputQueue.isEmpty()) {
			String line = inputQueue.poll();
			
			if (line != null) {
				try {
					String reverseLine = palindrome(line);
					outputQueue.add(reverseLine);
					System.out.println("Worker["+ id+ "] entrée:  " + line);
					System.out.println("Worker["+ id+ "] sortie:  " + reverseLine);
					
				}catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
		}
		
		return null;
	}
	
	public String palindrome(String entry) throws IllegalStateException{
		try{
			Thread.sleep(10*1000);
		} catch (InterruptedException e){
			throw new IllegalStateException(e);
		}
		
		return new StringBuilder(entry).reverse().toString();
	}
	
	public void stopRunning() {
		isRunning = false;
	}

}
