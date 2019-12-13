import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ServerMain {
	private int id = 0;
	private ArrayList<Thread> listClient = new ArrayList<Thread>();
	private ServerSocket serverSocket;

	public void start() throws IOException {
		serverSocket = null;
		Socket socket = null;
		CounterSynchronized nbHeader = new CounterSynchronized();
		nbHeader.start();
		
		try {
			serverSocket = new ServerSocket(2134);
			
			while (serverSocket != null) {
				System.out.println("Server: le server attend une nouvelle connexion ...");
				socket = serverSocket.accept();
				
				ClientHandler clientHandler = new ClientHandler(socket, id, nbHeader);
				id++;
				
				Thread thread = new Thread(clientHandler, "ClientHandler_" + id);
				listClient.add(thread);
				System.out.println("Demmarrage du thread -> " + id);
				thread.start();
				
			}
			System.out.println("Valeur du Header"+ nbHeader);
			socket.close();	
			serverSocket.close();
			nbHeader.stop();
			
		}catch (Exception e) {
			System.out.println(e);
			if (serverSocket != null && socket != null) {
				System.out.println("close");
				serverSocket.close();
				socket.close();
			}
			
		}
	}
	
	public void interrupted() throws IOException {
		for (Thread iterable_element : listClient) {
			iterable_element.interrupt();
		}
	}

	public static void main(String[] args) throws IOException {
		new ServerMain().start();
	}

}
