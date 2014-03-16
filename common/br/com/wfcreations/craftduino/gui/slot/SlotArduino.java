package br.com.wfcreations.craftduino.gui.slot;

import br.com.wfcreations.craftduino.block.BlocksInfo;
import br.com.wfcreations.craftduino.item.ItemsInfo;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotArduino extends Slot {

	private boolean unlock;
	
	public SlotArduino(IInventory inventory, int id, int x, int y) {
		super(inventory, id, x, y);
		unlock = true;
	}

	@Override
	public boolean isItemValid(ItemStack stack) {
		return stack.itemID == ItemsInfo.ARDUINO_ID;
	}
	
	@Override
	public boolean canTakeStack(EntityPlayer par1EntityPlayer) {
		return unlock;
	}

	public boolean isLock() {
		return !this.unlock;
	}

	public void lock() {
		this.unlock = false;
	}
	
	public void unlock() {
		this.unlock = true;
	}
}
