import java.io.BufferedReader;
import java.io.FileReader;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;

public class TxtFileReader implements Callable<Void>{
	private String file;
	private BlockingQueue<String> inputQueue;
	
	public TxtFileReader(String file, BlockingQueue<String> inputQueue) {
		// TODO Auto-generated constructor stub
		this.file = file;
		this.inputQueue = inputQueue;
	}
	
	@Override
	public Void call() throws Exception {
		// TODO Auto-generated method stub
		try (BufferedReader reader =  new BufferedReader(new FileReader(file))){
			String line = reader.readLine();
			
			while(line != null) {
				inputQueue.add(line);
				line = reader.readLine();
			}
			reader.close();
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return null;
	}

}
