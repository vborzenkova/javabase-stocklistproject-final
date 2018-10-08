package ru.lanit.warehouse;

import ru.lanit.stocklist.FoodItem;
import ru.lanit.stocklist.GenericItem;
import ru.lanit.stocklist.ItemCatalog;

public class WarehouseKeeper extends Thread {

	WhQueue q;
	Warehouse w;
	ItemCatalog cat;

	public WarehouseKeeper(WhQueue q, Warehouse w, ItemCatalog cat) {
		this.q = q;
		this.w = w;
		this.cat = cat;
	}

	public void run() {
		int[] qnt;
		while (true) {
			qnt = q.readQ();
			if (qnt[0] == -1)
				break;
			GenericItem item = cat.findItemByID(qnt[0]);
			if (item != null)
				w.addQuantity(item, qnt[1]);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Get: ID " + qnt[0] + ", Quantity " + qnt[1]);
		}
	}
}
