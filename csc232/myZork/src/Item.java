public class Item{
	private String name;
	private String type;
	private String description;

// Constructor
//===================================================================================		
	public Item(String pName, String pType, String pDescription){
		name = pName; 
		type = pType;
		description = pDescription;
	}

// Getter
//===================================================================================	
	public String getName() 		{return name;}
	public String getType() 		{return type;}
	public String getDescription() 	{return description;}

// Setter
//===================================================================================		
	public void setName(String pName) 				{name = pName;}
	public void setType(String pType) 				{type = pType;}
	public void setDescription(String pDescription)	{description = pDescription;}


// Override toString
//===================================================================================		
	@Override
	public String toString(){
		return name + " [ " + type + " ] : " + description;
	}
}