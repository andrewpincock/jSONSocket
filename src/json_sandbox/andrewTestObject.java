package json_sandbox;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;

@SuppressWarnings("serial")
public class andrewTestObject implements Serializable {
	
	private String name;
	private int number;
	private Date todaysDate;
	
	public andrewTestObject(String theName, int theNumber, Date theDate){
		name = theName;
		number = theNumber;
		todaysDate = theDate;
	}
	
	
	

}
