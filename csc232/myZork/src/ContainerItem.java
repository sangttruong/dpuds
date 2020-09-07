import java.util.ArrayList;

public class ContainerItem extends Item{
	private ArrayList<Item> items;

// Constructor
//===================================================================================
	public ContainerItem(String pName, String pType, String pDescription) {
		super(pName, pType, pDescription);
		items = new ArrayList<Item>();
	}
	
// Add Item
//===================================================================================
	public void addItem(Item i) { items.add(i); }

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

	
// Remove item with name
//===================================================================================	
	public Item removeItem (String item_name) {
		String s1 = item_name.toLowerCase();
		Item temp = null;
		if (hasItem(s1)) {
			for (int i = 0; i < items.size(); i++) {
				String s2 = items.get(i).getName().toLowerCase();
				if (s1.equals(s2)) {
					temp = items.get(i);
					items.remove(temp);}
			}
		}
		return temp;
	}
	
// Override toString()
//===================================================================================		
	@Override
	public String toString(){
		String all_items_name = "";
		for (int i = 0; i < items.size(); i++) {
			all_items_name = all_items_name + "+ " + items.get(i).getName() + '\n';
		}
		
		return getName() + " [ " + getType() + " ] : " + getDescription()
		+ " that contains: " + '\n' + all_items_name;
	}

// Number of Item in Inventory
//===================================================================================	
	public int numItems() {
		return items.size();
	}

// Get list of Items in the ContainerItem
//===================================================================================	
	public ArrayList<Item> getItems() {
		return items;
	}
}