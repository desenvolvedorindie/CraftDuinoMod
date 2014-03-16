package br.com.wfcreations.craftduino.item;

import java.util.List;

import br.com.wfcreations.craftduino.CraftDuino;
import br.com.wfcreations.craftduino.ModInfo;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;

public class ItemComponents extends Item {

	@SideOnly(Side.CLIENT)
	private Icon icons[];
	
	public ItemComponents(int id) {
		super(id);
		setCreativeTab(CraftDuino.tabCraftDuino);
		setNoRepair();
		setMaxStackSize(64);
		setUnlocalizedName(ItemsInfo.COMPONENTS_UNLOCALIZED_NAME);
		setFull3D();
		setHasSubtypes(true);
	}
	
	@Override
	public String getUnlocalizedName(ItemStack itemStack) {
		return ItemsInfo.COMPONENTS_UNLOCALIZED_NAME + itemStack.getItemDamage();
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IconRegister iconRegister) {
		icons = new Icon[ItemsInfo.COMPONENTS_ICONS.length];
		for(int i = 0; i < icons.length; i++) {
			icons[i] = iconRegister.registerIcon(ModInfo.TEXTURE_LOCATION + ItemsInfo.COMPONENTS_ICONS[i]);
		}	
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public Icon getIconFromDamage(int dmg) {
		return dmg < 7 ? this.icons[dmg] : null;
	}

	@Override
	public void getSubItems(int id, CreativeTabs creativeTabs, List list) {
		for(int i = 0 ; i < ItemsInfo.COMPONENTS_NAMES.length; i++) {
			ItemStack itemStack = new ItemStack(id, 1, i);
			list.add(itemStack);
		}
	}

}
