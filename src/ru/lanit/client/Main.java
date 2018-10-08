package ru.lanit.client;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;
import ru.lanit.exceptions.CatalogLoadException;
import ru.lanit.exceptions.ItemAlreadyExistsException;
import ru.lanit.stocklist.FoodItem;
import ru.lanit.stocklist.ItemCatalog;
import ru.lanit.warehouse.NotSynWarehouseQueue;
import ru.lanit.warehouse.Warehouse;
import ru.lanit.warehouse.WarehouseKeeper;
import ru.lanit.warehouse.WarehouseQueue;

public class Main {

	/**
	 * @param args
	 * @throws ItemAlreadyExistsException
	 */
	public static void main(String[] args) {

		ItemCatalog cat = new ItemCatalog();

		CatalogLoader loader = new CatalogStubLoader();

		try {
			loader.load(cat);
		} catch (CatalogLoadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		cat.printItems();

		long begin = new Date().getTime();
		for (int i = 0; i < 100000; i++)
			cat.findItemByID(1);
		long end = new Date().getTime();

		System.out.println("In HashMap: " + (end - begin));

		begin = new Date().getTime();
		for (int i = 0; i < 100000; i++)
			cat.findItemByIDAL(1);
		end = new Date().getTime();

		System.out.println("In ArrayList: " + (end - begin));

	}

}
