package br.com.wfcreations.craftduino;

import net.minecraft.creativetab.CreativeTabs;
import br.com.wfcreations.craftduino.block.Blocks;
import br.com.wfcreations.craftduino.command.CommandHandler;
import br.com.wfcreations.craftduino.configuration.ConfigurationHandler;
import br.com.wfcreations.craftduino.creativetab.CreativeTabCraftDuino;
import br.com.wfcreations.craftduino.gui.GuiHandler;
import br.com.wfcreations.craftduino.item.Items;
import br.com.wfcreations.craftduino.network.PacketHandler;
import br.com.wfcreations.craftduino.proxy.CommonProxy;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;

@Mod(modid = ModInfo.MOD_ID, version = ModInfo.VERSION, name = ModInfo.MOD_NAME, dependencies = ModInfo.DEPENDENCIES)
@NetworkMod(channels = { ModInfo.CHANNEL_NAME }, clientSideRequired = true, serverSideRequired = false, packetHandler = PacketHandler.class)
public class CraftDuino {

	public static CreativeTabs tabCraftDuino =  new CreativeTabCraftDuino(CreativeTabs.getNextID());
	
	@SidedProxy(serverSide = ModInfo.COMMON_PROXY_CLASS, clientSide = ModInfo.CLIENT_PROXY_CLASS)
	public static CommonProxy proxy;
	
	@Instance(value = ModInfo.MOD_ID)
	public static CraftDuino instance;

	@EventHandler
	public void serverStarting(FMLServerStartingEvent event) {
		proxy.serverStarting(event);
	}

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		proxy.preInit(event);
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		proxy.init(event);
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		proxy.postInit(event);
	}
}
