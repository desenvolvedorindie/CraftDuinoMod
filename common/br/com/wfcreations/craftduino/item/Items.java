package br.com.wfcreations.craftduino.item;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class Items {

	public static Item arduino;
	public static Item components;
	
	public static void init() {
		register();
		addNames(); //Temp
	}
	
	private static void register() {
		arduino = new ItemArduino(ItemsInfo.ARDUINO_ID - 256);
		GameRegistry.registerItem(arduino, arduino.getUnlocalizedName());
		components = new ItemComponents(ItemsInfo.COMPONENTS_ID - 256);
		GameRegistry.registerItem(components, components.getUnlocalizedName());
	}
	
	public static void addNames() {
		for(int i = 0; i < ItemsInfo.ARDUINO_NAMES.length; i++) {
			LanguageRegistry.addName(new ItemStack(arduino, 1, i), ItemsInfo.ARDUINO_NAMES[i]);
		}
		for(int i = 0; i < ItemsInfo.COMPONENTS_NAMES.length; i++) {
			LanguageRegistry.addName(new ItemStack(components, 1, i), ItemsInfo.COMPONENTS_NAMES[i]);
		}
	}
	
	public static void registerRecipes() {
		GameRegistry.addShapelessRecipe(new ItemStack(arduino, 1, 0), new Object[]{new ItemStack(components, 1, 0), new ItemStack(components, 1, 3)});
		GameRegistry.addShapelessRecipe(new ItemStack(arduino, 1, 1), new Object[]{new ItemStack(components, 1, 1), new ItemStack(components, 1, 3)});
		GameRegistry.addShapelessRecipe(new ItemStack(arduino, 1, 2), new Object[]{new ItemStack(components, 1, 2), new ItemStack(components, 1, 3)});
		GameRegistry.addShapelessRecipe(new ItemStack(arduino, 1, 3), new Object[]{new ItemStack(components, 1, 1), new ItemStack(components, 1, 3), new ItemStack(Item.redstone)});
		GameRegistry.addShapelessRecipe(new ItemStack(arduino, 1, 4), new Object[]{new ItemStack(components, 1, 2), new ItemStack(components, 1, 3), new ItemStack(Item.redstone)});
		GameRegistry.addRecipe(new ItemStack(components, 1, 0), new Object[]{"aba", "aca", "aba", 'a', new ItemStack(Item.goldNugget), 'b', new ItemStack(Item.coal), 'c', new ItemStack(Item.redstone)});
		GameRegistry.addRecipe(new ItemStack(components, 1, 1), new Object[]{"aba", "aca", "aba", 'a', new ItemStack(Item.goldNugget), 'b', new ItemStack(Block.coalBlock), 'c', new ItemStack(Block.blockRedstone)});
		GameRegistry.addRecipe(new ItemStack(components, 1, 2), new Object[]{"aba", "aca", "ada", 'a', new ItemStack(Item.goldNugget), 'b', new ItemStack(Block.coalBlock), 'c', new ItemStack(Block.blockRedstone), 'd', new ItemStack(Item.ingotGold)});
		GameRegistry.addRecipe(new ItemStack(components, 1, 3), new Object[]{" a ", "bcd", " e ", 'a', new ItemStack(Item.paper), 'b', new ItemStack(Item.dyePowder, 1, 4), 'c', new ItemStack(Item.redstone), 'd', new ItemStack(Item.dyePowder, 1, 12), 'e', new ItemStack(Item.dyePowder, 1, 6)});
	}
}
