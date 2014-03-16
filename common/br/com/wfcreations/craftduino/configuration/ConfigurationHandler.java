package br.com.wfcreations.craftduino.configuration;

import java.io.File;

import net.minecraftforge.common.Configuration;

public class ConfigurationHandler {

	public static Configuration configuration;
	
	public static void init(File file) {
		Configuration config = new Configuration(file);
		config.load();
		
		GeneralConfiguration.init(config);
		ItemConfiguration.init(config);
		BlockConfiguration.init(config);
		
		if(config.hasChanged()) {
			config.save();
		}
	}
}
