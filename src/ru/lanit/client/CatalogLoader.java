package ru.lanit.client;

import ru.lanit.exceptions.CatalogLoadException;
import ru.lanit.stocklist.ItemCatalog;

public interface CatalogLoader {
	public void load(ItemCatalog cat) throws CatalogLoadException;
}
