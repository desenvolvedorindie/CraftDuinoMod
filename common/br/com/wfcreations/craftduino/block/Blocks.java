package br.com.wfcreations.craftduino.block;

import br.com.wfcreations.craftduino.item.Items;
import br.com.wfcreations.craftduino.tileentity.TileArduinoConnector;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import dan200.ComputerCraft;
import dan200.computer.core.Computer;

public class Blocks {

	public static Block arduinoConnector;
	
	public static void init() {
		register();
		registerTileEntities();
		addNames(); //Temp
	}
	
	private static void register(){
		arduinoConnector = new BlockArduinoConnector(BlocksInfo.ARDUINO_CONNECTOR_ID);
		GameRegistry.registerBlock(arduinoConnector, arduinoConnector.getUnlocalizedName());
	}
	
	public static void addNames() {
		LanguageRegistry.addName(arduinoConnector, BlocksInfo.ARDUINO_CONNECTOR_NAME);
	}

	public static void registerRecipes() {
		GameRegistry.addRecipe(new ItemStack(arduinoConnector, 1, 0), new Object[]{" a ", "bcd", " e ", 'a', new ItemStack(Items.components, 1, 0), 'b', new ItemStack(Items.components, 1, 1), 'c', new ItemStack(Block.blockIron), 'd', new ItemStack(Items.components, 1, 2), 'e', new ItemStack(Items.components, 1, 3)});
	}
	
	private static void registerTileEntities() {
		GameRegistry.registerTileEntity(TileArduinoConnector.class, BlocksInfo.ARDUINO_CONNECTOR_UNLOCALIZED_NAME);
	}
}
