package json_sandbox;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;

import org.quickconnectfamily.json.JSONException;
import org.quickconnectfamily.json.JSONInputStream;
import org.quickconnectfamily.json.JSONOutputStream;
import org.quickconnectfamily.json.JSONUtilities;

public class ClientHandler extends Thread {
	private Socket Serverus;
	private ArrayList beanList;
	private int i;

	public ClientHandler(Socket Serverus, ArrayList beanList, int i) {
		this.Serverus = Serverus;
		this.beanList = beanList;
		this.i = i;
	}

	@Override
	public void run() {

		try {

			JSONOutputStream jsonOut = new JSONOutputStream(Serverus.getOutputStream());
			JSONInputStream jsonIn = new JSONInputStream(Serverus.getInputStream());
			HashMap<String, ?> gearCollectionMap = (HashMap<String, ?>) jsonIn.readObject();

			String gearBeanString = JSONUtilities.stringify(gearCollectionMap);
			beanList.add(gearBeanString);
			System.out.println("Thread Number: " + i);
			System.out.println(beanList);

			Thread.currentThread();
			Thread.sleep(3000);

			Serverus.close();
			System.out.println("Client Connection Number " + i + " Closed");

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
