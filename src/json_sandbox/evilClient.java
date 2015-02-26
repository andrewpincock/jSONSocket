package json_sandbox;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import org.quickconnectfamily.json.JSONException;
import org.quickconnectfamily.json.JSONInputStream;
import org.quickconnectfamily.json.JSONOutputStream;

public class evilClient {
	
	public static void main(String[] args) throws UnknownHostException, IOException, JSONException {
		
		Socket toServer = new Socket("localhost", 8080);
		
		JSONInputStream jsonIn = new JSONInputStream(toServer.getInputStream());
		JSONOutputStream jsonOut = new JSONOutputStream(toServer.getOutputStream());
		
		gearBean whiteSquier = new gearBean();
		whiteSquier.setBrand(null);
		whiteSquier.setModel("8");
		whiteSquier.setSerialNumber(0);
		
		jsonOut.writeObject(whiteSquier);
				
		toServer.close();
		
	}

}