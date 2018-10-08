package ru.lanit.stocklist;

import java.util.ArrayList;
import java.util.HashMap;

import ru.lanit.exceptions.ItemAlreadyExistsException;

public class ItemCatalog {
	private HashMap<Integer, GenericItem> catalog = new HashMap<Integer, GenericItem>();
	private ArrayList<GenericItem> ALCatalog = new ArrayList<GenericItem>();

	public GenericItem findItemByID(int id) {
		// ≈сли нет такого ID, возвращаем пустое значение
		if (!catalog.containsKey(id)) {
			return null;
		} else {
			return catalog.get(id);
		}
	}

	public GenericItem findItemByIDAL(int id) {
		/*
		 * for(GenericItem item : getALCatalog()){ if(item.getID()==id) return item; }
		 * return null; }
		 */
		return getALCatalog().stream().filter((item) -> item.getID() == id).findFirst().get();
	}

	public void addItem(GenericItem item) throws ItemAlreadyExistsException {
		if (catalog.containsValue(item)) {
			throw new ItemAlreadyExistsException();
		}
		catalog.put(item.getID(), item);
		getALCatalog().add(item);
	}

	public void printItems() {
		/*
		 * for(GenericItem i : getALCatalog()){ System.out.println(i); }
		 */
		getALCatalog().forEach(System.out::println);
	}

	public HashMap<Integer, GenericItem> getCatalog() {
		return catalog;
	}

	public ArrayList<GenericItem> getALCatalog() {
		return ALCatalog;
	}

}
