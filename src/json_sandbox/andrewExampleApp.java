package json_sandbox;

import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;

import java.net.ServerSocket;


import org.quickconnectfamily.json.JSONException;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


public class andrewExampleApp extends Thread{

	public static void main(String[] args) throws IOException, JSONException, InterruptedException {

		ExecutorService anExecutor = Executors.newCachedThreadPool();
		ArrayList beanList = new ArrayList();
		ServerSocket listeningSocket = new ServerSocket(8080);
		System.out.println("Socket Open");
		int i = 1;

		while (i<6) {
			Socket Serverus = listeningSocket.accept();
			ClientHandler client = new ClientHandler(Serverus, beanList, i);
			anExecutor.execute(client);
			i++;
		}
		anExecutor.shutdown();
		anExecutor.awaitTermination(5, TimeUnit.SECONDS);
		listeningSocket.close();
		System.out.println("Socket Closed");

	}
}