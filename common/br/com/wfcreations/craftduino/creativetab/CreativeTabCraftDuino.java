package br.com.wfcreations.craftduino.creativetab;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import br.com.wfcreations.craftduino.ModInfo;
import br.com.wfcreations.craftduino.item.Items;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CreativeTabCraftDuino extends CreativeTabs {

	public CreativeTabCraftDuino(int id) {
		super(id, ModInfo.MOD_ID);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public String getTranslatedTabLabel() {
		return "CraftDuino";
	}
	
	@Override
	public Item getTabIconItem() {
		return Items.arduino;
	}

}
