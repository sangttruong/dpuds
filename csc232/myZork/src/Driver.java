import java.util.ArrayList;
import java.util.Scanner; 

public class Driver 
{	
	// Create current location and my inventory
	private static Location currentLocation;
	private static ContainerItem myInventory;
	
	// Create World method
	public static void CreateWorld() {
		
		// Four new locations
		Location kitchen = new Location("Kitchen" , "My kitchen");
		Location bedroom = new Location("Bedroom" , "My bedroom");
		Location toilet  = new Location("Toilet"  , "My toilet" );
		Location hallway = new Location("Hallway" , "My hallway");
		
		// Connect locations together, with 2 directions
		kitchen.connect("south", hallway);
		toilet .connect("west" , hallway);
		bedroom.connect("east" , hallway);
		
		hallway.connect("north", kitchen);
		hallway.connect("east" , toilet );
		hallway.connect("west" , bedroom);
		
		// Add items to locations
		Item knife 		= new Item("Knife"     , "Silverware", "A piece of metal that belongs to an alumni from 1987"	);
		Item turkey 	= new Item("Turkey"    , "Food"		, "A non-GMO 13 pounds bird"								);
		Item plate 		= new Item("Plate"     , "Tableware"	, "A triangle piece of ceramic"							);
		Item dishwasher = new Item("Dishwasher", "Machine"	, "A classy machine that only accepts clean dishes"			);
		Item cup 		= new Item("Cup"       , "Glasses"	, "A vintage piece of glass that has many holes on it"		);
		
		toilet .addItem(turkey);
		toilet .addItem(knife);
		bedroom.addItem(dishwasher);
		hallway.addItem(cup);
		kitchen.addItem(plate);
		
		// Set current location and my inventory
		currentLocation = bedroom;	
		myInventory = new ContainerItem("My backpack", "Bag", "The one Chris gave me for my birthday");
		
		// Add container items to locations
		ContainerItem box 	= new ContainerItem ("Box"	, "Paper container"		, "Very environmental-friendly"		);
		ContainerItem vault	= new ContainerItem ("Vault", "Metallic container"	, "Have flower on it" 				);
		ContainerItem bag 	= new ContainerItem ("Bag" 	, "Plastic container"	, "Take 2000 years to decomposed"	);
		
		Item carrot = new Item("Carrot"	, "Food", "More orange than an orange"	);
		Item banana = new Item("Banana"	, "Food", "Have potassium"				);
		Item rice	= new Item("Rice"	, "Food", "Good on pretty much anything");
		
		box.addItem(carrot);
		box.addItem(rice);
		bag.addItem(banana);
		
		bedroom.addItem(box);
		hallway.addItem(vault);
		hallway.addItem(bag);		
	}
	
	public static void main(String[] args) 
	{		
		CreateWorld();
		Scanner in = new Scanner(System.in); 
		
		boolean quit = false;
		while (!quit) {
			System.out.println("Enter command: ");	
			String s = in.nextLine(); 
	        String[] arr = s.split(" ");        
			
			switch(arr[0].toLowerCase()) {
				case "quit":
					quit = true;
					break;
					
				case "look":
					System.out.println(currentLocation.getName() + " - " + currentLocation.getDescription() + " currently has the following items:");
					for (int i = 0; i < currentLocation.numItem(); i++) {
						System.out.println("+ " + currentLocation.getItem(i).getName());
						};
					break;
					
				case "examine":
					if (arr.length != 2) {
						System.out.println("I can examine one and only one item");
					} else if (currentLocation.hasItem(arr[1]) && arr.length == 2) {
						System.out.println(currentLocation.getItem(arr[1]).getName() + " - " + currentLocation.getItem(arr[1]).getDescription());
					}
					else {
						System.out.println("Cannot find that item");
					}
					break;
				
				case "go":
					if (arr.length != 2) {
						System.out.println("I can go to one and only one location");
					}
					else if (!currentLocation.canMove(arr[1].toLowerCase())) {
						System.out.println("There is nothing in this direction or there is no such direction.");
					}
					else {
						currentLocation = currentLocation.getLocation(arr[1].toLowerCase());
					}
					break;
				
				case "inventory":
					if (myInventory.numItems() == 0) {
						System.out.println("The inventory is empty");
					}
					else {
						ArrayList<Item> items = myInventory.getItems();
						String all_items_name = "";
						for (int i = 0; i < items.size(); i++) {
							all_items_name = all_items_name + "+ " + items.get(i).getName() + '\n';
						}
						System.out.println(all_items_name);
					}
					break;
				
				case "take":
					if (arr.length == 2) {
						if (currentLocation.hasItem(arr[1])) {
							myInventory.addItem(currentLocation.removeItem(arr[1]));
						}
						else {
							System.out.println("Cannot find that item here.");
						}
					}
					
					else if (arr.length == 4) {
						if (!arr[2].toLowerCase().equals("from")) {
							System.out.println("I need to take the item FROM somewhere.");
						}
						else if (!currentLocation.hasItem(arr[3])) {
							System.out.println("Cannot find that container here.");
						}
						else {
							ContainerItem container = (ContainerItem) currentLocation.getItem(arr[3]);
							if(!container.hasItem(arr[1])) {
								System.out.println("The container doesn't have such item.");
							}
							else {
								myInventory.addItem(container.removeItem(arr[1]));
							}
						}
					}
					else {
						System.out.println("Invalid command. You provide too much or too little information.");
					}
					break;
					
				case "put":
					if (arr.length != 4) {
						System.out.println("I can put one and only one item.");
					}
					else if(!arr[2].toLowerCase().equals("in")) {
						System.out.println("I need to know which container to put this item in.");
					}
					else if (!currentLocation.hasItem(arr[3])) {
						System.out.println("There is no such container in this location.");
					}
					else if (!myInventory.hasItem(arr[1])) {
						System.out.println("There is no such item in your inventory.");
					}					
					else {
						ContainerItem container = (ContainerItem) currentLocation.getItem(arr[3]);
						container.addItem(myInventory.removeItem(arr[1]));
					}
					break;
					
				case "drop":
					if (arr.length != 2) {
						System.out.println("I can take one and only one item if it exists.");
					}
					else if (myInventory.hasItem(arr[1])) {
						currentLocation.addItem(myInventory.removeItem(arr[1]));
					}
					else {
						System.out.println("Cannot find that item in your inventory.");
					}
					break;
				
				case "help":
					System.out.println(	"quit: quit the game. \n"
									  + "look: print out the name and description of current location as well as items in that location. \n"
									  + "examine ITEM: print out name and discription of the items in the current location if the item exists. \n"
									  + "go DIRECTION: go to one of 4 following directions: north, south, west, east. \n"
									  + "inventory: print out items in my inventory. \n"
									  + "take ITEM: take ITEM from current location if it exists. \n"
									  + "take ITEM from CONTAINER: take ITEM from CONTAINER. \n"
									  + "drop ITEM: drop ITEM from my inventory to current location. \n"
									  + "put ITEM in CONTAINER: put ITEM from your inventory (if exist) to CONTAINER in current location (if exists). \n"
									  + "help: print out a list of current functions. ");
					break;
				
				default: 
					System.out.println("I don't know how to do that");
			}
		}
		in.close();
 	}
}