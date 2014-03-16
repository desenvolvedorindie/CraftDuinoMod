package br.com.wfcreations.craftduino.block;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import br.com.wfcreations.craftduino.CraftDuino;
import br.com.wfcreations.craftduino.ModInfo;
import br.com.wfcreations.craftduino.gui.GuiInfo;
import br.com.wfcreations.craftduino.tileentity.TileArduinoConnector;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;

public class BlockArduinoConnector extends BlockContainerBase {

	Random random;
	
	@SideOnly(Side.CLIENT)
	private Icon icons[];

	public BlockArduinoConnector(int id) {
		super(id, Material.iron);
		setCreativeTab(CraftDuino.tabCraftDuino);
		setHardness(1.7F);
		setResistance(1F);
		setStepSound(Block.soundMetalFootstep);
		setUnlocalizedName(BlocksInfo.ARDUINO_CONNECTOR_UNLOCALIZED_NAME);
		this.random = new Random();
		icons = new Icon[2];
	}
	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer entityPlayer, int side, float hitX, float hitY, float hitZ) {
		if(!world.isRemote) {
			TileEntity tile = world.getBlockTileEntity(x, y, z);
			if(tile != null && tile instanceof TileArduinoConnector) {
				TileArduinoConnector tac = (TileArduinoConnector)tile;
				if(tac.getOwner().equals(entityPlayer.username)) {
					entityPlayer.openGui(CraftDuino.instance, GuiInfo.GUI_ARDUINO_CONNECTOR_ID, world, x, y, z);
				}
				else {
					entityPlayer.addChatMessage(EnumChatFormatting.RED + "Only " + tac.getOwner() + " can open this connector");
				}
			}
		}
		return true;
	}
	
	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase player, ItemStack itemStack) {
		if(!world.isRemote) {
			TileEntity te = world.getBlockTileEntity(x, y, z);
			if(te instanceof TileArduinoConnector && player instanceof EntityPlayer) {
				TileArduinoConnector tac = (TileArduinoConnector)te;
				EntityPlayer entityPlayer = (EntityPlayer)player;
				tac.setOwner(entityPlayer.username);
			}
		}
	}
	
	@Override
    public void breakBlock(World world, int x, int y, int z, int id, int meta) {
        TileArduinoConnector arduinoConnector = (TileArduinoConnector) world.getBlockTileEntity(x, y, z);
        
        if (arduinoConnector != null) {
            for (int i = 0; i < arduinoConnector.getSizeInventory(); i++) {
                ItemStack itemstack = arduinoConnector.getStackInSlot(i);

                if (itemstack != null) {
                	EntityItem entityitem;
                	
                    float randFloat1 = random.nextFloat() * 0.8F + 0.1F;
                    float randFloat2 = random.nextFloat() * 0.8F + 0.1F;

                    for (float f = random.nextFloat() * 0.8F + 0.1F; itemstack.stackSize > 0; world.spawnEntityInWorld(entityitem)) {
                        int randInt = random.nextInt(21) + 10;

                        if (randInt > itemstack.stackSize) {
                            randInt = itemstack.stackSize;
                        }

                        itemstack.stackSize -= randInt;
                        entityitem = new EntityItem(world, x + randFloat1, y + randFloat2, z + f, new ItemStack(itemstack.itemID, randInt, itemstack.getItemDamage()));
                        entityitem.motionX = (float) random.nextGaussian() * 0.05F;
                        entityitem.motionY = (float) random.nextGaussian() * 0.25F;
                        entityitem.motionZ = (float) random.nextGaussian() * 0.05F;

                        if (itemstack.hasTagCompound()) {
                            entityitem.getEntityItem().setTagCompound((NBTTagCompound)itemstack.getTagCompound().copy());
                        }
                    }
                }
            }
            world.func_96440_m(x, y, z, id);
        }
        super.breakBlock(world, x, y, z, id, meta);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IconRegister iconRegister) {
		for(int i = 0; i < 2; i++) {
			this.icons[i] = iconRegister.registerIcon(ModInfo.TEXTURE_LOCATION + BlocksInfo.ARDUINO_CONNECTOR_ICON + "_" + i);	
		}
	}

	@SideOnly(Side.CLIENT)
	@Override
	public Icon getIcon(int side, int meta) {
		return side == ForgeDirection.DOWN.ordinal() || side == ForgeDirection.UP.ordinal() ? this.icons[0] : this.icons[1];
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileArduinoConnector();
	}
}
