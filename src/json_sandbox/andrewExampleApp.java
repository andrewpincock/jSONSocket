package json_sandbox;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.net.ServerSocket;
import java.net.Socket;

import org.quickconnectfamily.json.JSONException;
import org.quickconnectfamily.json.JSONInputStream;
import org.quickconnectfamily.json.JSONOutputStream;
import org.quickconnectfamily.json.JSONUtilities;

public class andrewExampleApp extends Thread{
	
	public static void main(String[] args) throws IOException, JSONException {
		
		ArrayList beanList = new ArrayList();

		while (true) {
			//SOCKET IO
			ServerSocket listeningSocket = new ServerSocket(8080);
			System.out.println("Socket Open");
			Socket Serverus = listeningSocket.accept();

			JSONOutputStream jsonOut = new JSONOutputStream(Serverus.getOutputStream());
			JSONInputStream jsonIn = new JSONInputStream(Serverus.getInputStream());

			try {
				
				HashMap<String, ?> gearCollectionMap = (HashMap<String, ?>) jsonIn.readObject();
				
				String gearBeanString = JSONUtilities.stringify(gearCollectionMap);
				beanList.add(gearBeanString);
				System.out.println(beanList);
				
				listeningSocket.close();
				System.out.println("Socket Closed");

			} catch (JSONException e) { 
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e){
				e.printStackTrace();
			}

		}

	}
}