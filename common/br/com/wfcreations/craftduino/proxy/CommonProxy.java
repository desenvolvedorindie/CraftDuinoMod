package br.com.wfcreations.craftduino.proxy;

import br.com.wfcreations.craftduino.CraftDuino;
import br.com.wfcreations.craftduino.block.Blocks;
import br.com.wfcreations.craftduino.configuration.ConfigurationHandler;
import br.com.wfcreations.craftduino.gui.GuiHandler;
import br.com.wfcreations.craftduino.item.Items;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.network.NetworkRegistry;

public class CommonProxy  {

	public void serverStarting(FMLServerStartingEvent event) {
		
	}
	
	public void preInit(FMLPreInitializationEvent event) {
		ConfigurationHandler.init(event.getSuggestedConfigurationFile());
		Blocks.init();
		Items.init();				
		Blocks.registerRecipes();
		Items.registerRecipes();
	}
	
	public void init(FMLInitializationEvent event) {
		NetworkRegistry.instance().registerGuiHandler(CraftDuino.instance, new GuiHandler());
	}
	
	public void postInit(FMLPostInitializationEvent event) {
		
	}
}
