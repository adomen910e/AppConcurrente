import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

class ServerMain {
	private int id = 0;

	public void start() throws IOException {
		try (ServerSocket s = new ServerSocket(1234)) {
			while (true) {
				System.out.println("Server: le server attend une nouvelle connexion ...");
				Socket socket = s.accept();
				id++;
				ClientManager clientManager = new ClientManager(socket, id);
				Thread thread = new Thread(clientManager, "ClientManager_" + id);
				System.out.println("Demmarrage du thread -> " + id);
				thread.start();
			}

		} 
	}

	public static void main(String[] args) throws IOException {
		new ServerMain().start();
	}

}
