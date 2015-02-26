package json_sandbox;

import java.io.Serializable;

@SuppressWarnings("serial")
public class gearBean implements Serializable{
	String brand;
	String model;
	long serialNumber;
	
	public gearBean() {
		
	}
	public String getBrand(){
		return brand;
	}
	public void setBrand(String brand){
		this.brand = brand;
	}
	public String getModel(){
		return brand;
	}
	public void setModel(String model){
		this.model = model;
	}
	public long getSerialNumber(){
		return serialNumber;
	}
	public void setSerialNumber(long serialNumber){
		this.serialNumber = serialNumber;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((brand == null) ? 0 : brand.hashCode());
		result = prime * result + ((model == null) ? 0 : model.hashCode());
		result = prime * result + (int) (serialNumber ^ (serialNumber >>> 32));
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		gearBean other = (gearBean) obj;
		if (brand == null) {
			if (other.brand != null)
				return false;
		} else if (!brand.equals(other.brand))
			return false;
		if (model == null) {
			if (other.model != null)
				return false;
		} else if (!model.equals(other.model))
			return false;
		if (serialNumber != other.serialNumber)
			return false;
		return true;
	}

}
