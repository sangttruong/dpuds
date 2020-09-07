import java.util.ArrayList;
import java.util.HashMap;

public class Location {
	private String name;
	private String description;
	private ArrayList<Item> items;
	private HashMap <String, Location> connections; 

// Constructor
//===================================================================================
	public Location(String pName, String pDescription) {
		name = pName;
		description = pDescription;
		items = new ArrayList<Item>();
		// For Checkpoint 2
		connections = new HashMap <String, Location>();
	}

// Getter
//===================================================================================
	public String getName() 		{return name;}
	public String getDescription() 	{return description;}
	
// Setter
//===================================================================================
	public void setName(String pName) 				{name = pName;}
	public void setDescription(String pDescription) {description = pDescription;}

// Add item
//===================================================================================	
	public void addItem (Item i) {items.add(i);}
	
// Has Item
//===================================================================================
	public boolean hasItem (String item_name) {
		String s1 = item_name.toLowerCase();
		boolean hasItem = false;
		for (int i = 0; i < items.size(); i++) {
			String s2 = items.get(i).getName().toLowerCase();
			if (s1.equals(s2)) {hasItem = true;}
		}
		return hasItem;
	}

//Get item with name
//===================================================================================	
	public Item getItem (String item_name) {
		String s1 = item_name.toLowerCase();
		Item temp = null;
		if (hasItem(s1)) {
			for (int i = 0; i < items.size(); i++) {
				String s2 = items.get(i).getName().toLowerCase();
				if (s1.equals(s2)) {temp = items.get(i);}
			}
		}
		return temp;
	}

// Get item with index
//===================================================================================		
	public Item getItem (int item_index) {
		Item temp = null;
		if (0 <= item_index &&  item_index < items.size())
			{ temp = items.get(item_index);}
		return temp;
	}

// Number of item
//===================================================================================		
	public int numItem () {
		return items.size();
	}

// Remove item
//===================================================================================	
	public Item removeItem(String item_name) {
		Item temp = getItem(item_name);
		if (temp != null) { 
			int temp_index = items.indexOf(temp);
			items.remove(temp_index);		
		}
		return temp;
	}
	
// Connect
//===================================================================================	
	public void connect(String direction_name, Location loc) {
		connections.put(direction_name, loc);
	}
	
// Can Move
//===================================================================================
	public boolean canMove(String direction_name) {
		return connections.containsKey(direction_name);
	}

// Get Location
//===================================================================================
	public Location getLocation(String direction_name) {
		if (connections.containsKey(direction_name)) {
			return connections.get(direction_name);
		}
		else { return null; }
	}	
}