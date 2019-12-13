import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;

public class Main {
	
	public static void main(String[] args) throws InterruptedException {
		// initialise queue
		LinkedBlockingQueue<String> inputQueue = new LinkedBlockingQueue<String>();
		LinkedBlockingQueue<String> outputQueue = new LinkedBlockingQueue<String>();
		
		// Initialise threads for reading and writing the file
		TxtFileReader txtFileReader = new TxtFileReader("example.txt",inputQueue);
		Thread txtFileReaderThread = new Thread(new FutureTask<Void>(txtFileReader));
		
		TxtFileWriter txtFileWriter = new TxtFileWriter("result.txt",outputQueue);
		Thread txtFileWriterThread = new Thread(new FutureTask<Void>(txtFileWriter));
		
		// Initialize the number of threads and callable reversing strings 
		final int numberThreadWorker = 4;
		Thread[] palindromeWorkerThreads = new Thread[numberThreadWorker];
		
		Worker[] tabWorkers = new Worker[numberThreadWorker];
		for (int i = 0; i < numberThreadWorker; i++){
			tabWorkers[i] = new Worker(inputQueue, outputQueue);
			palindromeWorkerThreads[i] = new Thread(new FutureTask<Void>(tabWorkers[i]));
		}
		
		// Start all the threads
		txtFileReaderThread.start();
		for (int i = 0; i < numberThreadWorker; i++){
			palindromeWorkerThreads[i].start();
		}
		txtFileWriterThread.start();
		
		// Wait the end of the file reading
		while (txtFileReaderThread.isAlive()){
			Thread.sleep(500);
		}
		
		// Stop all worker thread
		// They will finish only if the inputQueue is empty
		for (int i = 0; i < numberThreadWorker; i++){
			tabWorkers[i].stopRunning();
		}
		
		// Wait that all worker thread are terminated
		for (int i = 0; i < numberThreadWorker; i++){
			while(palindromeWorkerThreads[i].isAlive()){
				Thread.sleep(500);
			}
		}
		
		// Stop the writer Thread
		// It will finish only after writting all the strings it can find in the outputQueue
		txtFileWriter.stopRunning();
		
		// Wait the end of the file writing
		while(txtFileWriterThread.isAlive()){
			Thread.sleep(500);
		}
		System.out.println("prog terminé");
	}

}
