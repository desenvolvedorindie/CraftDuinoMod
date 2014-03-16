package br.com.wfcreations.craftduino.proxy;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;

public class ClientProxy extends CommonProxy {


	public void serverStarting(FMLServerStartingEvent event) {}; // No Action
	
	@Override
	public void init(FMLInitializationEvent event) {
		super.init(event);
		initRenders();
	}
	
	private void initRenders() {
		
	}
	
}
