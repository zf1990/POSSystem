package POSSystem.src;

import static org.junit.jupiter.api.Assertions.*;

import POSSystem.src.Item;
import org.junit.jupiter.api.Test;

class ItemTest {

//	@Test
//	void testItem() {
//		Item apple = new Item("Apple", "Riven", 50.6, 20.0, 2.99, 1, 100.0);
//		Item pear = new Item("Pear", "Fiora", 20.5, 10.0, 1.99, 2, 50.0);
//		Item Lotion = new Item("Hand Lotion", "Irelia", 50.6, 20.0, 2.99, 1, 100.0);
//	}


	@Test
	void testGetQuantity() {
		Item apple = new Item("Apple", "Riven", 50.6, 20.0, 2.99, 1, 100.0);
		Item pear = new Item("Pear", "Fiora", 20.5, 10.0, 1.99, 2, 50.0);
		
		assertEquals(50.6, apple.getQuantity());
		
		//assertEquals(2, Inventory.getInventoryList().size());
	}
}

//	@Test
//	void testSetQuantity() {
//		fail("Not yet implemented");
//	}

