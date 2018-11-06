//Created by Mateusz Szymanski
//email - Matreoxioo@gmail.com

public class Ship {
	private String shipName;
	private String shipSize;
	
	/*
	 * Constructor
	 */
	public Ship(String shipName, String shipSize){
		this.shipName = shipName;
		this.shipSize = shipSize;		
	}
	/*
	 * set and get shipName
	 */
	public void setShipName(String shipName){
		this.shipName = shipName;
	}
	public String getShipName(){
		return shipName;
	}
	
	/*
	 * set and get shipSize
	 */
	public void setShipSize(String shipSize){
		this.shipSize = shipSize;
	}
	public String getShipSize(){
		return shipSize;
	}
	
	/*
	 * Displays the values of objects not their memory address (non-Javadoc)
	 */
	  @Override
	   public String toString() {
	        return (this.getShipName() + " " +  this.getShipSize());
	   }
}

//Created by Mateusz Szymanski
//Student ID : 693822
