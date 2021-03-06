import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.ArrayList;

public class ClientManager implements Runnable {
	private final int id;
	private final Socket socket;

	public ClientManager(Socket s, int id) {
		// TODO Auto-generated constructor stub
		this.socket = s;
		this.id = id;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			System.out.println("Client[" + id + "] Début du traitement");
			readHeader();
			writeResponse();
			socket.close();
			System.out.println("Client[" + id + "] Fin de traitement");
		} catch (IOException e) {
			throw new IllegalStateException("Le client -> " + id + " est en erreur");
		}
	}

	private void writeResponse() throws IOException {
		// TODO Auto-generated method stub
		try {
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			writer.write("HTTP/1.1 200 OK\n\n");
			Thread.sleep(10 * 1000);
			writer.write("<h1>HELLO</h1>");
			writer.write("Je suis le client -> " + id);
			writer.flush();
		} catch (InterruptedException e) {
			throw new IllegalStateException("Attention Thread interrompu");
		}
	}

	private void readHeader() throws IOException {
		// TODO Auto-generated method stub
		BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		ArrayList<String> header = new ArrayList<>();
		String headerline = reader.readLine();
		while (headerline != null && !headerline.isEmpty()) {
			header.add(headerline);
			headerline = reader.readLine();
		}

		if (headerline == null) {
			String message = "Client " + socket.getInetAddress() + " envoie du header non terminé";
			throw new IOException(message);
		}

	}

}
