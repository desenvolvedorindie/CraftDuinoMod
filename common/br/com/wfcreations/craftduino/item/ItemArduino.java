package br.com.wfcreations.craftduino.item;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import br.com.wfcreations.craftduino.CraftDuino;
import br.com.wfcreations.craftduino.ModInfo;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;

public class ItemArduino extends Item {

	@SideOnly(Side.CLIENT)
	private Icon icons[];
	
	public ItemArduino(int id) {
		super(id);
		setCreativeTab(CraftDuino.tabCraftDuino);
		setNoRepair();
		setMaxStackSize(1);
		setUnlocalizedName(ItemsInfo.ARDUINO_UNLOCALIZED_NAME);
		setHasSubtypes(true);
	}
	
	@Override
	public String getUnlocalizedName(ItemStack itemStack) {
		return ItemsInfo.ARDUINO_UNLOCALIZED_NAME + itemStack.getItemDamage();
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IconRegister iconRegister) {
		icons = new Icon[ItemsInfo.ARDUINO_ICONS.length];
		for(int i = 0; i < icons.length; i++) {
			icons[i] = iconRegister.registerIcon(ModInfo.TEXTURE_LOCATION + ItemsInfo.ARDUINO_ICONS[i]);
		}	
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public Icon getIconFromDamage(int dmg) {
		return dmg < 7 ? this.icons[dmg] : null;
	}

	@Override
	public void getSubItems(int id, CreativeTabs creativeTabs, List list) {
		for(int i = 0 ; i < ItemsInfo.ARDUINO_NAMES.length; i++) {
			ItemStack itemStack = new ItemStack(id, 1, i);
			list.add(itemStack);
		}
	}
	
	@Override
	public void addInformation(ItemStack itemStack, EntityPlayer entityPlayer, List list, boolean useExtraInformation) {
		int type = getDamage(itemStack);
		
		if(type < 5) {
			list.add("Compatible with :");
		}
		
		switch (type) {
		case 0:
			list.add("Arduino Duemilanove or Diecimila");
			list.add("Arduino Ethernet");
			list.add("Arduino Pro or Pro Mini");
			list.add("LilyPad Arduino");
			list.add("Arduino NG or older");
			
			break;
		case 1:
			list.add("Arduino Yún");
			list.add("Arduino Esplora");
			list.add("LilyPad Arduino USB");
			list.add("Arduino Micro");
			break;			
		case 2:
			list.add("Arduino Mega 2560 or Mega ADK");
			break;
		case 3:
			list.add("Arduino Mini");
			list.add("Arduino BT");
			list.add("Arduino Fio");
			break;
		case 4:
			list.add("Arduino Robot Control");
			list.add("Arduino Robot Motor");
			break;
		}
	}

	
	@Override
	public boolean shouldRotateAroundWhenRendering() {
		return true;
	}
}
