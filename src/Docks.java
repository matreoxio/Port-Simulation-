import java.util.LinkedList;
import java.util.List;

public class Docks {
	//Linked lists which will store ship data 
	private List<Ship> dock1Row1 = new LinkedList<Ship>();
	private List<Ship> dock1Row2 = new LinkedList<Ship>();
	private List<Ship> dock2Row1 = new LinkedList<Ship>();
	private List<Ship> dock2Row2 = new LinkedList<Ship>();;
	private List<Ship> waitingList = new LinkedList<Ship>();;
	
	/*
	 * TODO - Delete 6th object, should be 5
	 * Hard Coded data for content of docks
	 */	
		public void dockInitialize(){ //Hard coded data for ships
		//Dock 1 Row 1 test Data
		Ship ship0 = new Ship("Rambler","Cargo");
		Ship ship1 = new Ship("Abbot","Cargo");
		Ship ship2 = new Ship("Free","Container");
		Ship ship3 = new Ship("Free","Container");
		Ship ship4 = new Ship("Icarus","Container");
		Ship ship01 = new Ship("", "");//Never used, created for counter 
		dock1Row1.add(ship0);
		dock1Row1.add(ship1);
		dock1Row1.add(ship2);
		dock1Row1.add(ship3);
		dock1Row1.add(ship4);
		
		//Dock 1 Row 2 test Data
		Ship ship5 = new Ship("Pembroke","Cargo");
		Ship ship6 = new Ship("Lech","Cargo");
		Ship ship7 = new Ship("Courser","Container");
		Ship ship8 = new Ship("Free","Container");
		Ship ship9 = new Ship("Mewa","Super-Container");
		Ship ship02 = new Ship("", "");
		dock1Row2.add(ship5);
		dock1Row2.add(ship6);
		dock1Row2.add(ship7);
		dock1Row2.add(ship8);
		dock1Row2.add(ship9);
		
		//Dock 2 Row 1 test Data
		Ship ship10 = new Ship("Medea","Cargo");
		Ship ship11 = new Ship("Free","Cargo");
		Ship ship12 = new Ship("Bedouin","Container");
		Ship ship13 = new Ship("Juniper","Cargo");
		Ship ship14 = new Ship("Aura","Super-Container");
		Ship ship03 = new Ship("", "");
		dock2Row1.add(ship10);
		dock2Row1.add(ship11);
		dock2Row1.add(ship12);
		dock2Row1.add(ship13);
		dock2Row1.add(ship14);
		
		//Dock 2 Row 2 test Data
		Ship ship15 = new Ship("Clara","Cargo");
		Ship ship16 = new Ship("Brage","Cargo");
		Ship ship17 = new Ship("Pantaloon","Container");
		Ship ship18 = new Ship("Free","Container");
		Ship ship19 = new Ship("Free","Super-Container");
		Ship ship04 = new Ship("", "");
		dock2Row2.add(ship15);
		dock2Row2.add(ship16);
		dock2Row2.add(ship17);
		dock2Row2.add(ship18);
		dock2Row2.add(ship19);
		
		//Waiting List test Data
		Ship waiting1 = new Ship("Free","");
		Ship waiting2 = new Ship("Free","");
		Ship waiting3 = new Ship("Free","");
		Ship waiting4 = new Ship("Free","");
		Ship waiting5 = new Ship("Free","");
		waitingList.add(waiting1);
		waitingList.add(waiting2);
		waitingList.add(waiting3);
		waitingList.add(waiting4);
		waitingList.add(waiting5);
		new Port().mainMenu(dock1Row1, dock1Row2, dock2Row1, dock2Row2, waitingList);
		}

}

//Created by Mateusz Szymanski
//email - Matreoxioo@gmail.com