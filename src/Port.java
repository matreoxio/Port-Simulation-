//Created by Mateusz Szymanski
//email - Matreoxioo@gmail.com

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Port {
	
	//Used as entry 
	public static void main(String[] args) {

		new Docks().dockInitialize();

	}

	/*
	 * User can choose to Dock, Undock, View Port Status and Exit the Program
	 */
	public static void mainMenu(List<Ship> dock1Row1, List<Ship> dock1Row2, List<Ship> dock2Row1, List<Ship> dock2Row2,
			List<Ship> waitingList) {
		System.out.println("\n--Main Menu--\n" + "1.Dock\n" + "2.Undock\n" + "3.Port Status\n" + "4.Exit");
		int menuOption = inputInt();
		  //Main Menu switch case
		switch (menuOption) {
		
		/*
		 *Case 1: Docking Ships
		 */
		case 1:
			//Getting User Input for ship name and ship size
			System.out.println("\nPlease enter the name of the ship");
			String shipName = inputString();
			System.out.println("\nPlease select one of the available sizes\n" + "1.Cargo\n" + "2.Container\n"
					+ "3.Super-Container\n");
			int shipSizeSelect = inputInt();
			String shipSize = "0";
			//Passing ship name and size to dockShip method where it will be used to dock ships 
			switch (shipSizeSelect) {
			case 1:
				shipSize = "Cargo";
				dockShips(dock1Row1, dock1Row2, dock2Row1, dock2Row2, waitingList, shipName, shipSize);
				break;
			case 2:
				shipSize = "Container";
				dockShips(dock1Row1, dock1Row2, dock2Row1, dock2Row2, waitingList, shipName, shipSize);
				break;

			case 3:
				shipSize = "Super-Container";
				dockShips(dock1Row1, dock1Row2, dock2Row1, dock2Row2, waitingList, shipName, shipSize);
				break;

			default:
				clearScreen();
				System.out.println("ERROR:Operation not recognised, please try again\n");
				mainMenu(dock1Row1, dock1Row2, dock2Row1, dock2Row2, waitingList);
				break;
			}
			/*
			 * Case 2:Undocking ships
			 * Firstly check if the entered name is == to free
			 * if it is you can't undock a free space so error pops up
			 * Next search for ship name and replace it with an object Ship(Free+
			 * shipSize) to empty the element
			 */
		case 2:
			String shipName1 = "";
			System.out.println("\nPlease enter the name of the ship");
			String shipNameUndock = inputString();
			// counter is used to assign empty to the right object
			// counter2 is used to get the index of object to be deleted
			int counter = 6;
			int counter2 = 1;
			// Declaring objects Ship that will replace object named by the user to empty them
			Ship freeCargo = new Ship("Free", "Cargor");
			Ship freeContainer = new Ship("Free", "Container");
			Ship freeSuper = new Ship("Free", "Super-Container");
			// Mechanism used to stop users from trying to undock empty space
			if (shipNameUndock.equals("Free")) {
				clearScreen();
				System.out.print("**ERROR: Unable to undock empty space**");
				pressAnyKeyToContinue();
				mainMenu(dock1Row1, dock1Row2, dock2Row1, dock2Row2, waitingList);
			} else {

			}
			// Searching dock1Row1 for entered ship name
			for (Ship shipSearch : dock1Row1) {
				if (shipSearch.getShipName().equals(shipNameUndock)) {
					counter = counter2;
					counter--;
				}
				counter2++;

			}

			// Replacing the existing object with Free + Size Ship object
			// Checking the index of object to be changed to determine the size
			// of the space, when ship is undocked check waiting list to see if 
			//appropriate place has been freed
			if (counter < 2) {
				dock1Row1.set(counter, freeCargo);
				System.out.println("\n" + shipNameUndock + " has been undocked");
				pressAnyKeyToContinue();
				dockFromWaitingList(dock1Row1, dock1Row2, dock2Row1, dock2Row2, waitingList, shipName1, shipName1);

			} else if (counter == 2 || counter == 3) {
				dock1Row1.set(counter, freeContainer);
				System.out.println("\n" + shipNameUndock + " has been undocked");
				pressAnyKeyToContinue();
				dockFromWaitingList(dock1Row1, dock1Row2, dock2Row1, dock2Row2, waitingList, shipName1, shipName1);
			} else if (counter == 4) {
				dock1Row1.set(counter, freeSuper);
				System.out.println("\n" + shipNameUndock + " has been undocked");
				pressAnyKeyToContinue();
				dockFromWaitingList(dock1Row1, dock1Row2, dock2Row1, dock2Row2, waitingList, shipName1, shipName1);
			} else {

				// Searching dock1Row2 for entered ship name
				counter2 = 1;
				for (Ship shipSearch : dock1Row2) {
					if (shipSearch.getShipName().equals(shipNameUndock)) {
						counter = counter2;
						counter--;
					}
					counter2++;

				}

				// Replacing the existing object with Free + Size Ship object
				// Checking the index of object to be changed to determine the
				// size of the space
				if (counter < 2) {
					dock1Row2.set(counter, freeCargo);
					System.out.println("\n" + shipNameUndock + " has been undocked");
					pressAnyKeyToContinue();
					dockFromWaitingList(dock1Row1, dock1Row2, dock2Row1, dock2Row2, waitingList, shipName1, shipName1);
				} else if (counter == 2 || counter == 3) {
					dock1Row2.set(counter, freeContainer);
					System.out.println("\n" + shipNameUndock + " has been undocked");
					pressAnyKeyToContinue();
					dockFromWaitingList(dock1Row1, dock1Row2, dock2Row1, dock2Row2, waitingList, shipName1, shipName1);
				} else if (counter == 4) {
					dock1Row2.set(counter, freeSuper);
					System.out.println("\n" + shipNameUndock + " has been undocked");
					pressAnyKeyToContinue();
					dockFromWaitingList(dock1Row1, dock1Row2, dock2Row1, dock2Row2, waitingList, shipName1, shipName1);
				} else {

					// Searching dock2Row1 for entered ship name
					counter2 = 1;
					for (Ship shipSearch : dock2Row1) {
						if (shipSearch.getShipName().equals(shipNameUndock)) {
							counter = counter2;
							counter--;
						}
						counter2++;

					}

					// Replacing the existing object with Free + Size Ship object
					// Checking the index of object to be changed to determine
					// the size of the space
					if (counter < 2) {
						dock2Row1.set(counter, freeCargo);
						System.out.println("\n" + shipNameUndock + " has been undocked");
						pressAnyKeyToContinue();
						dockFromWaitingList(dock1Row1, dock1Row2, dock2Row1, dock2Row2, waitingList, shipName1, shipName1);
					} else if (counter == 2 || counter == 3) {
						dock2Row1.set(counter, freeContainer);
						System.out.println("\n" + shipNameUndock + " has been undocked");
						pressAnyKeyToContinue();
						dockFromWaitingList(dock1Row1, dock1Row2, dock2Row1, dock2Row2, waitingList, shipName1, shipName1);
					} else if (counter == 4) {
						dock2Row1.set(counter, freeSuper);
						System.out.println("\n" + shipNameUndock + " has been undocked");
						pressAnyKeyToContinue();
						dockFromWaitingList(dock1Row1, dock1Row2, dock2Row1, dock2Row2, waitingList, shipName1, shipName1);
					} else {

						// Searching dock2Row2 for entered ship name
						counter2 = 1;
						for (Ship shipSearch : dock2Row2) {
							if (shipSearch.getShipName().equals(shipNameUndock)) {
								counter = counter2;
								counter--;
							}
							counter2++;

						}

						// Replacing the existing object with Free + Size Ship object 
						// Checking the index of object to be changed to
						// determine the size of the space
						if (counter < 2) {
							dock2Row2.set(counter, freeCargo);
							System.out.println("\n" + shipNameUndock + " has been undocked");
							pressAnyKeyToContinue();
							dockFromWaitingList(dock1Row1, dock1Row2, dock2Row1, dock2Row2, waitingList, shipName1, shipName1);
						} else if (counter == 2 || counter == 3) {
							dock2Row2.set(counter, freeContainer);
							System.out.println("\n" + shipNameUndock + " has been undocked");
							pressAnyKeyToContinue();
							dockFromWaitingList(dock1Row1, dock1Row2, dock2Row1, dock2Row2, waitingList, shipName1, shipName1);
						} else if (counter == 4) {
							dock2Row2.set(counter, freeSuper);
							System.out.println("\n" + shipNameUndock + " has been undocked");
							pressAnyKeyToContinue();
							dockFromWaitingList(dock1Row1, dock1Row2, dock2Row1, dock2Row2, waitingList, shipName1, shipName1);
						} else {
							clearScreen();
							System.out.print("\n**ERROR: Ship Not Found**\n");
							pressAnyKeyToContinue();
							dockFromWaitingList(dock1Row1, dock1Row2, dock2Row1, dock2Row2, waitingList, shipName1, shipName1);
						}

					}
				}
			}
			break;

		/*
		 * Case 3: Display all ships in all docks and Waiting List
		 */
		case 3:
			System.out.print("\n\nDock 1 Row 1:  " + dock1Row1 + "\n");
			System.out.print("Dock 1 Row 2:  " + dock1Row2 + "\n");
			System.out.print("Dock 2 Row 1:  " + dock2Row1 + "\n");
			System.out.print("Dock 2 Row 2:  " + dock2Row2 + "\n");
			System.out.print("Waiting List:  " + waitingList + "\n");
			pressAnyKeyToContinue();
			clearScreen();
			mainMenu(dock1Row1, dock1Row2, dock2Row1, dock2Row2, waitingList);
			break;

		/*
		 * Exit the system
		 */
		case 4:
			System.exit(0);
			break;
		default:
			System.out.println("**ERROR: Wrong value entered**");
			pressAnyKeyToContinue();
			clearScreen();
			mainMenu(dock1Row1, dock1Row2, dock2Row1, dock2Row2, waitingList);
			break;

		}

	}

	/*
	 * Dock ships
	 */
	public static void dockShips(List<Ship> dock1Row1, List<Ship> dock1Row2, List<Ship> dock2Row1, List<Ship> dock2Row2,
			List<Ship> waitingList, String shipName, String shipSize) {

		int counter = 6;
		int counter2 = 1;
		boolean found = false;

		Ship addCargo = new Ship(shipName, shipSize);
		Ship size = new Ship(shipSize, shipSize);// Create an object to check
													// size of the ship

		/*
		 * If the ship size == Cargo do this to dock it
		 */
		if (shipSize.equals("Cargo")) { // Check what ship size user wants to
										// dock
			for (Ship shipAdd : dock1Row1) {
				if (shipAdd.getShipName().equals("Free")) {// Look for free
															// space
					counter = counter2;
					counter--;
					dock1Row1.set(counter, addCargo);// Replace current object
														// with new one
					System.out.println("\nShip Docked:\n" + shipName + "\n" + shipSize);
					pressAnyKeyToContinue();
					clearScreen();
					mainMenu(dock1Row1, dock1Row2, dock2Row1, dock2Row2, waitingList);
				}
				counter2++;
			}

			// If no space found in port1Row1 look for space in port1Row2
			if (found != true) {
				counter2 = 1;
				for (Ship shipAdd : dock1Row2) {
					if (shipAdd.getShipName().equals("Free")) {
						counter = counter2;
						counter--;
						dock1Row2.set(counter, addCargo);
						System.out.println("\n" + shipName + " " + shipSize + " has been docked");
						pressAnyKeyToContinue();
						clearScreen();
						mainMenu(dock1Row1, dock1Row2, dock2Row1, dock2Row2, waitingList);
					}
					counter2++;
				}
			}

			// If no space found in port1Row2 look for space in port2Row1
			if (found != true) {
				counter2 = 1;
				for (Ship shipAdd : dock2Row1) {
					if (shipAdd.getShipName().equals("Free")) {
						counter = counter2;
						counter--;
						dock2Row1.set(counter, addCargo);
						System.out.println("\nShip Docked:\n" + shipName + "\n" + shipSize);
						pressAnyKeyToContinue();
						clearScreen();
						mainMenu(dock1Row1, dock1Row2, dock2Row1, dock2Row2, waitingList);
					}
					counter2++;
				}
			}

			// If no space found in port2Row1 look for space in port2Row2
			if (found != true) {
				counter2 = 1;
				for (Ship shipAdd : dock2Row2) {
					if (shipAdd.getShipName().equals("Free")) {
						counter = counter2;
						counter--;
						dock2Row2.set(counter, addCargo);
						System.out.println("\nShip Docked:\n" + shipName + "\n" + shipSize);
						pressAnyKeyToContinue();
						clearScreen();
						mainMenu(dock1Row1, dock1Row2, dock2Row1, dock2Row2, waitingList);
					}
					counter2++;
				}
			}
			//If no space is found in the docks check the waiting list for free space
			if (found != true) {
				counter2 = 1;
				for (Ship shipAdd : waitingList) {
					if (shipAdd.getShipName().equals("Free")) {
						counter = counter2;
						counter--;
						waitingList.set(counter, addCargo);
						System.out.println("\nShip Docked:\n" + shipName + "\n" + shipSize);
						pressAnyKeyToContinue();
						clearScreen();
						mainMenu(dock1Row1, dock1Row2, dock2Row1, dock2Row2, waitingList);
					}
					counter2++;
				}
			}
			// No Space found
			if (found != true) {
				System.out.println("**ERROR: No Space Available \nPlease turn back**");
				pressAnyKeyToContinue();
				clearScreen();
				mainMenu(dock1Row1, dock1Row2, dock2Row1, dock2Row2, waitingList);

			}
			/*
			 * If size == Container do this to dock it
			 */
		} else if (shipSize.equals("Container")) {
			// Look for space in dock1Row1
			for (Ship shipAdd : dock1Row1) {
				//Look for free space and Container or free space and Super Container
				if (shipAdd.getShipName().equals("Free") && shipAdd.getShipSize().equals("Container")
						|| shipAdd.getShipName().equals("Free") && shipAdd.getShipSize().equals("Super-Container")) {
					counter = counter2;
					counter--;
					dock1Row1.set(counter, addCargo);
					System.out.println("\nShip Docked:\n" + shipName + "\n" + shipSize);
					pressAnyKeyToContinue();
					clearScreen();
					mainMenu(dock1Row1, dock1Row2, dock2Row1, dock2Row2, waitingList);
				}
				counter2++;
			}

			// If no space is found in dock1Row1 look for space in dock1Row2
			if (found != true) {
				counter2 = 1;
				for (Ship shipAdd : dock1Row2) {
					if (shipAdd.getShipName().equals("Free") && shipAdd.getShipSize().equals("Container")
							|| shipAdd.getShipName().equals("Free")
									&& shipAdd.getShipSize().equals("Super-Container")) {
						counter = counter2;
						counter--;
						dock1Row2.set(counter, addCargo);
						System.out.println("\nShip Docked:\n" + shipName + "\n" + shipSize);
						pressAnyKeyToContinue();
						clearScreen();
						mainMenu(dock1Row1, dock1Row2, dock2Row1, dock2Row2, waitingList);
					}
					counter2++;
				}

			}

			// If no space is found in dock1Row2 look for space in dock2Row1
			if (found != true) {
				counter2 = 1;
				for (Ship shipAdd : dock2Row1) {
					if (shipAdd.getShipName().equals("Free") && shipAdd.getShipSize().equals("Container")
							|| shipAdd.getShipName().equals("Free")
									&& shipAdd.getShipSize().equals("Super-Container")) {
						counter = counter2;
						counter--;
						dock2Row1.set(counter, addCargo);
						System.out.println("\nShip Docked:\n" + shipName + "\n" + shipSize);
						pressAnyKeyToContinue();
						clearScreen();
						mainMenu(dock1Row1, dock1Row2, dock2Row1, dock2Row2, waitingList);
					}
					counter2++;
				}

			}

			// If no space is found in dock2Row1 look for space in dock2Row2
			if (found != true) {
				counter2 = 1;
				for (Ship shipAdd : dock2Row2) {
					if (shipAdd.getShipName().equals("Free") && shipAdd.getShipSize().equals("Container")
							|| shipAdd.getShipName().equals("Free")
									&& shipAdd.getShipSize().equals("Super-Container")) {
						counter = counter2;
						counter--;
						dock2Row2.set(counter, addCargo);
						System.out.println("\nShip Docked:\n" + shipName + "\n" + shipSize);
						pressAnyKeyToContinue();
						clearScreen();
						mainMenu(dock1Row1, dock1Row2, dock2Row1, dock2Row2, waitingList);
					}
					counter2++;
				}

			}
			//If no space is found in the docks check the waiting list for free space
			if (found != true) {
				counter2 = 1;
				for (Ship shipAdd : waitingList) {
					if (shipAdd.getShipName().equals("Free")) {
						counter = counter2;
						counter--;
						waitingList.set(counter, addCargo);
						System.out.println("\nShip Docked:\n" + shipName + "\n" + shipSize);
						pressAnyKeyToContinue();
						clearScreen();
						mainMenu(dock1Row1, dock1Row2, dock2Row1, dock2Row2, waitingList);
					}
					counter2++;
				}
			}
			// No Space found
			if (found != true) {
				System.out.println("**ERROR: No Space Available \nPlease turn back**");
				pressAnyKeyToContinue();
				clearScreen();
				mainMenu(dock1Row1, dock1Row2, dock2Row1, dock2Row2, waitingList);

			}
			//If ship size == SuperContainer do this to dock it
		} else if (shipSize.equals("Super-Container")) {
			// Look for space in dock1Row1
			for (Ship shipAdd : dock1Row1) {
				//Look for free space and Super-Container
				if (shipAdd.getShipName().equals("Free") && shipAdd.getShipSize().equals("Super-Container")) {
					counter = counter2;
					counter--;
					dock1Row1.set(counter, addCargo);
					System.out.println("\nShip Docked:\n" + shipName + "\n" + shipSize);
					pressAnyKeyToContinue();
					clearScreen();
					mainMenu(dock1Row1, dock1Row2, dock2Row1, dock2Row2, waitingList);
				}
				counter2++;
			}
			// If no space is found in dock1Row1 look for space in dock1Row2
			if (found != true) {
				counter2 = 1;
				for (Ship shipAdd : dock1Row2) {
					if (shipAdd.getShipName().equals("Free") && shipAdd.getShipSize().equals("Super-Container")) {
						counter = counter2;
						counter--;
						dock1Row2.set(counter, addCargo);
						System.out.println("\nShip Docked:\n" + shipName + "\n" + shipSize);
						pressAnyKeyToContinue();
						clearScreen();
						mainMenu(dock1Row1, dock1Row2, dock2Row1, dock2Row2, waitingList);
					}
					counter2++;
				}

			}

			// If no space is found in dock1Row2 look for space in dock2Row1
			if (found != true) {
				counter2 = 1;
				for (Ship shipAdd : dock2Row1) {
					if (shipAdd.getShipName().equals("Free") && shipAdd.getShipSize().equals("Super-Container")) {
						counter = counter2;
						counter--;
						dock2Row1.set(counter, addCargo);
						System.out.println("\nShip Docked:\n" + shipName + "\n" + shipSize);
						pressAnyKeyToContinue();
						clearScreen();
						mainMenu(dock1Row1, dock1Row2, dock2Row1, dock2Row2, waitingList);
					}
					counter2++;
				}

			}

			// If no space is found in dock2Row1 look for space in dock2Row2
			if (found != true) {
				counter2 = 1;
				for (Ship shipAdd : dock2Row2) {
					if (shipAdd.getShipName().equals("Free") && shipAdd.getShipSize().equals("Super-Container")) {
						counter = counter2;
						counter--;
						dock2Row2.set(counter, addCargo);
						System.out.println("\nShip Docked:\n" + shipName + "\n" + shipSize);
						pressAnyKeyToContinue();
						clearScreen();
						mainMenu(dock1Row1, dock1Row2, dock2Row1, dock2Row2, waitingList);
					}
					counter2++;
				}

			}
			// //If no space is found in the docks check the waiting list for free space
			if (found != true) {
				counter2 = 1;
				for (Ship shipAdd : waitingList) {
					if (shipAdd.getShipName().equals("Free")) {
						counter = counter2;
						counter--;
						waitingList.set(counter, addCargo);
						System.out.println("\nShip added to waiting list:\n" + shipName + "\n" + shipSize);
						pressAnyKeyToContinue();
						clearScreen();
						mainMenu(dock1Row1, dock1Row2, dock2Row1, dock2Row2, waitingList);
					}
					counter2++;
				}
			}
			// No Space found
			if (found != true) {
				System.out.println("**ERROR: No Space Available \nPlease turn back**");
				pressAnyKeyToContinue();
				clearScreen();
				mainMenu(dock1Row1, dock1Row2, dock2Row1, dock2Row2, waitingList);

			}
		}

	}

	// User integer input method
	public static int inputInt() {
		Scanner scan = new Scanner(System.in);
		if(scan.hasNextInt()){//Checks if user input is in int form
		int i = scan.nextInt();
		return i;
		}
		else {
			int i = 0;
			return i;
			
		}
	}

	// Used to get user input in string form
	public static String inputString() {
		Scanner scan = new Scanner(System.in);
		String s = scan.next();
		
		return s;
	}

	// Pauses the system and waits for user input
	public static void pressAnyKeyToContinue() {
		System.out.println("\nPress any key to continue...");
		try {
			System.in.read();
		} catch (Exception e) {
		}
	}

	public static void clearScreen() {
		for (int i = 0; i < 25; ++i)
			System.out.println();
	}

	/*
	 * Dock ships that are on the waiting list 
	 */
	public static void dockFromWaitingList(List<Ship> dock1Row1, List<Ship> dock1Row2, List<Ship> dock2Row1,
			List<Ship> dock2Row2, List<Ship> waitingList, String shipName, String shipSize) {
		List<Ship> remove = new ArrayList<Ship>();
		int counter2 = 1;
		int counter = 6;
		String free = "Free";

		Ship addCargo = new Ship(free, "");
		Ship addCargo2 = new Ship(free, "");
		
		//Look for ships on waiting list
		for (Ship shipAdd : waitingList) {//Iterate through waiting list
			if (shipAdd.getShipName().equals("Free")) {//Look for free space

			} else {//Ship Found
				counter = counter2;
				counter--;
				if (shipAdd.getShipSize().equals("Cargo")) {//Check size of the ship

					shipSize = "Cargo";
					addCargo2 = waitingList.get(counter);
					remove.add(addCargo2);

					StringBuilder b = new StringBuilder();
					remove.forEach(b::append);//Convert Ship element to StringBuilder
					String a = b.toString();//Convert data from b to string and save in a
					String c = a.replaceAll("Cargo", "");//Delete ship size
					shipName = c;//now we are left with only the ship name

				} else if (shipAdd.getShipSize().equals("Container")) {
					shipSize = "Container";
					addCargo2 = waitingList.get(counter);
					remove.add(addCargo2);

					StringBuilder b = new StringBuilder();
					remove.forEach(b::append);
					String a = b.toString();
					String c = a.replaceAll("Container", "");
					shipName = c;

				} else {
					shipSize = "Super-Container";
					addCargo2 = waitingList.get(counter);
					remove.add(addCargo2);

					StringBuilder b = new StringBuilder();
					remove.forEach(b::append);
					String a = b.toString();
					String c = a.replaceAll("Super-Container", "");
					shipName = c;

				}

				waitingList.set(counter, addCargo);//Replace the extracted element with Free(delete it)
				//Pass ship name and ship size to dockShip so that it can check if there is space
				dockShips(dock1Row1, dock1Row2, dock2Row1, dock2Row2, waitingList, shipName, shipSize);

			}
			counter2++;
		}
		clearScreen();
		//If no ships are on the waiting list return to mainMenu
		mainMenu(dock1Row1, dock1Row2, dock2Row1, dock2Row2, waitingList);
	}

}

