// ********************************************************************** 
//   ShoppingCart.java 
// 
//   Represents a shopping cart as an array of items 
// ********************************************************************** 
import java.text.NumberFormat; 
import java.util.Scanner; 


public class ShoppingCart 
{ 
	public void main (String[] args) 
	{ 
		Item      item;      
		String      itemName;      
		double      itemPrice;      
		int      quantity;   
		double totalPrice=0;
		
		ShoppingCart newShoppingCart = new ShoppingCart();
		
		Scanner scan = new Scanner(System.in); 
		String keepShopping = "y"; 
		do            
		{ 
			System.out.print ("Enter the name of the item: ");  
			itemName      =      scan.nextLine();      
			System.out.print ("Enter the unit price: "); 
			itemPrice      =      scan.nextDouble(); 		
			System.out.print ("Enter the quantity: "); 
			quantity      =      scan.nextInt();     
			
			newShoppingCart.addToCart(itemName, itemPrice, quantity);
			
			// *** print the contents of the cart object using println 
			//System.out.println(cart);
			
			for (int i = 0; i <= newShoppingCart.itemCount; i++) {
				System.out.println("Item: " + itemName + ", Quantity: "  + quantity + ", Price: $" + itemPrice);
				totalPrice += quantity*itemPrice;
			}
			System.out.println("Total price:" + totalPrice);
			
			System.out.print ("Continue shopping (y/n)? ");
			scan.nextLine();  
			keepShopping      =      scan.nextLine();      
		} 
		while  (keepShopping.equals("y"));      
	} 
	
	private int itemCount;      // total number of items in the cart 
	private double totalPrice;  // total price of items in the cart 
	private int capacity;       // current cart capacity 
	
	private Item[] cart;
	Item item;
	
	// ----------------------------------------------------------- 
	//  Creates an empty shopping cart with a capacity of 5 items. 
	// ----------------------------------------------------------- 
	public ShoppingCart() 
	{ 
		capacity = 5; 
		itemCount = 0; 
		totalPrice = 0.0; 
		
		cart = new Item[capacity];
	} 
	// ------------------------------------------------------- 
	//  Adds an item to the shopping cart. 
	// ------------------------------------------------------- 
	public void addToCart(String itemName, double price, int quantity) 
	{ 
		item = new Item(itemName, price, quantity);
		cart[itemCount] = item;
		
		totalPrice += price*quantity;
		itemCount++;
	} 
	// ------------------------------------------------------- 
	//  Returns the contents of the cart together with 
	//  summary information. 
	// ------------------------------------------------------- 
	public String toString() 
	{ 
		NumberFormat fmt = NumberFormat.getCurrencyInstance(); 
		String contents = "\nShopping Cart\n"; 
		contents += "\nItem\t\tUnit Price\tQuantity\tTotal\n"; 
		for (int i = 0; i < itemCount; i++) 
			contents += cart[i].toString() + "\n"; 
		contents += "\nTotal Price: " + fmt.format(totalPrice); 
		contents += "\n"; 
		return      contents;      
	} 
	// --------------------------------------------------------- 
	//  Increases the capacity of the shopping cart by 3 
	// --------------------------------------------------------- 
	private void increaseSize() 
	{ 
		//create temporary array with size capacity+3
		Item[] tempCart;
		tempCart = new Item[capacity +3];
		//copy old item to temporary array
		for (int i = 0; i <= capacity; i++) {
			tempCart[i] = cart[i];
		}
		// update cart to point to new larger array
		cart = tempCart;
		//maintain capacity
		capacity+=3;
	} 
}
