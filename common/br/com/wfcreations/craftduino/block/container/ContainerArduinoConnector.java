package br.com.wfcreations.craftduino.block.container;

import br.com.wfcreations.craftduino.block.Blocks;
import br.com.wfcreations.craftduino.gui.slot.SlotArduino;
import br.com.wfcreations.craftduino.item.Items;
import br.com.wfcreations.craftduino.tileentity.TileArduinoConnector;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerArduinoConnector extends Container {

	TileArduinoConnector tileArduinoConnector;
	
	InventoryPlayer invetoryPlayer;
	
	private static int posX = 95;
	
	public ContainerArduinoConnector(InventoryPlayer invetoryPlayer, TileArduinoConnector tileEntity) {
		this.tileArduinoConnector = tileEntity;
		this.invetoryPlayer = invetoryPlayer;
		
		int i, j;
		for(i = 0; i < 9; i++) {
			addSlotToContainer(new Slot(invetoryPlayer, i, 8 + 18 * i, posX + 58));
		}
		
		for(i = 0; i < 3; i++) {
			for (j = 0; j < 9; j++) {
				addSlotToContainer(new Slot(invetoryPlayer, j + i * 9 + 9, 8 + 18 * j, posX + i * 18));
			}
		}
		
		addSlotToContainer(new SlotArduino(tileEntity, 0, 179, 12));
	}
	
	@Override
	public boolean canInteractWith(EntityPlayer entityplayer) {
		return this.tileArduinoConnector.isUseableByPlayer(entityplayer);
	}
	
	@Override
	public ItemStack transferStackInSlot(EntityPlayer player, int i) {
		Slot slot = getSlot(i);
		
		if(slot != null && slot.getHasStack()) {
			ItemStack stack = slot.getStack();
			ItemStack result = stack.copy();
			
			if(i >= 36) {
				if(!mergeItemStack(stack, 0, 36, false)){
					return null;
				}
			} else if(stack.itemID != Items.arduino.itemID || !mergeItemStack(stack, 36, 36 + tileArduinoConnector.getSizeInventory(), false)) {
				return null;
			}
			
			if(stack.stackSize == 0) {
				slot.putStack(null);
			} else {
				slot.onSlotChanged();
			}
			
			slot.onPickupFromSlot(player, stack);
			return result;
		}
		
		return null;
	}

}
