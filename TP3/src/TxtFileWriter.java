import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;

public class TxtFileWriter implements Callable<Void>{
	private BlockingQueue<String> outputQueue;
	private String file;
	private Boolean isRunning;
	
	public TxtFileWriter(String file, BlockingQueue<String> outputQueue) {
		// TODO Auto-generated constructor stub
		this.file = file;
		this.outputQueue = outputQueue;
		this.isRunning = false;
	}

	@Override
	public Void call() throws Exception {
		// TODO Auto-generated method stub
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))){
			isRunning = true;
			while(isRunning || !outputQueue.isEmpty()) {
				String line = outputQueue.poll();
				
				if (line != null) {
					writer.write(line + "\n");
				}
			}
			writer.close();
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return null;
	}
	
	public void stopRunning() {
		isRunning = false;
	}

}
