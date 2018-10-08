package ru.lanit.client;

import java.util.Date;

import ru.lanit.exceptions.CatalogLoadException;
import ru.lanit.exceptions.ItemAlreadyExistsException;
import ru.lanit.stocklist.Category;
import ru.lanit.stocklist.FoodItem;
import ru.lanit.stocklist.GenericItem;
import ru.lanit.stocklist.ItemCatalog;

public class CatalogStubLoader implements CatalogLoader {

	@Override
	public void load(ItemCatalog cat) throws CatalogLoadException {
		
		GenericItem item1 = new GenericItem("Sony TV",23000,Category.GENERAL);
		FoodItem item2 = new FoodItem("Bread",12,null,new Date(),(short)10);
		
		try {
			cat.addItem(item1);
			cat.addItem(item2);
		} catch (ItemAlreadyExistsException e) {
			e.printStackTrace();
			throw new CatalogLoadException(e);
		}
	}

}
