package json_sandbox;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.HashMap;

import org.quickconnectfamily.json.JSONException;
import org.quickconnectfamily.json.JSONInputStream;
import org.quickconnectfamily.json.JSONOutputStream;
import org.quickconnectfamily.json.JSONUtilities;

public class testClient {
	
	public static void main(String[] args) throws UnknownHostException, IOException, JSONException {
		
		Socket toServer = new Socket("localhost", 8080);
		
		JSONInputStream jsonIn = new JSONInputStream(toServer.getInputStream());
		JSONOutputStream jsonOut = new JSONOutputStream(toServer.getOutputStream());
		
		gearBean redSquier = new gearBean();
		redSquier.setBrand("Squier");
		redSquier.setModel("Classic Vibe Precision");
		redSquier.setSerialNumber(55_55_55_55L);
		
		jsonOut.writeObject(redSquier);
				
		toServer.close();
		
	}

}