package br.com.wfcreations.craftduino.configuration;

import java.io.File;

import br.com.wfcreations.craftduino.item.ItemsInfo;
import net.minecraftforge.common.Configuration;

public class ItemConfiguration {

	public static void init(Configuration config) {
		ItemsInfo.ARDUINO_ID = config.getItem(ItemsInfo.ARDUINO_KEY, ItemsInfo.ARDUINO_DEFAULT).getInt();
		ItemsInfo.COMPONENTS_ID = config.getItem(ItemsInfo.COMPONENTS_KEY, ItemsInfo.COMPONENTS_DEFAULT).getInt();
	}
	
}
