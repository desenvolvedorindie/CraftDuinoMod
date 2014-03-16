package br.com.wfcreations.craftduino.tileentity;

import br.com.wfcreations.craftduino.block.BlocksInfo;
import br.com.wfcreations.craftduino.item.ItemsInfo;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import dan200.computer.api.IComputerAccess;
import dan200.computer.api.IHostedPeripheral;
import dan200.computer.api.ILuaContext;
import dan200.computer.api.IPeripheral;

public class TileArduinoConnector extends TileEntity implements IInventory, IHostedPeripheral {

	private ItemStack[] inventorySlots = new ItemStack[1];

	private String owner;

	private boolean arduinoActive;

	private String arduinoPort;

	public TileArduinoConnector() {
		this.arduinoActive = false;
		owner = "";
	}

	@Override
	public void readFromNBT(NBTTagCompound tagCompound) {
		super.readFromNBT(tagCompound);
		this.setOwner(tagCompound.getString("Owner"));
		if (tagCompound.getBoolean("ArduinoActive")) {
			tryActivateArduino(tagCompound.getString("ArduinoPort"));
		}

		NBTTagList items = tagCompound.getTagList("Items");
		for (int i = 0; i < items.tagCount(); i++) {
			NBTTagCompound item = (NBTTagCompound) items.tagAt(i);
			int slot = item.getByte("Slot");
			System.out.println(slot);
			if (slot >= 0 && slot < getSizeInventory()) {
				setInventorySlotContents(slot, ItemStack.loadItemStackFromNBT(item));
			}
		}
	}

	@Override
	public void writeToNBT(NBTTagCompound tagCompound) {
		super.writeToNBT(tagCompound);
		tagCompound.setString("Owner", getOwner());
		tagCompound.setBoolean("ArduinoActive", this.arduinoActive);
		if (this.arduinoPort != null && !this.arduinoPort.equals("")) {
			tagCompound.setString("ArduinoPort", this.arduinoPort);
		}
		NBTTagList items = new NBTTagList();
		for (int i = 0; i < getSizeInventory(); i++) {
			ItemStack itemStack = getStackInSlot(i);
			if (itemStack != null) {
				NBTTagCompound item = new NBTTagCompound();
				item.setByte("Slot", (byte) i);
				itemStack.writeToNBT(item);
				items.appendTag(item);
			}
		}
		tagCompound.setTag("Items", items);
	}

	@Override
	public int getSizeInventory() {
		return inventorySlots.length;
	}

	@Override
	public ItemStack getStackInSlot(int i) {
		return inventorySlots[i];
	}

	@Override
	public ItemStack decrStackSize(int i, int quantity) {
		if (this.inventorySlots[i] != null) {
			ItemStack itemstack;
			if (this.inventorySlots[i].stackSize <= quantity) {
				itemstack = this.inventorySlots[i];
				this.inventorySlots[i] = null;
				return itemstack;
			} else {
				itemstack = this.inventorySlots[i].splitStack(quantity);
				if (this.inventorySlots[i].stackSize == 0) {
					this.inventorySlots[i] = null;
				}
				return itemstack;
			}
		} else {
			return null;
		}
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int i) {
		return this.getStackInSlot(i);
	}

	@Override
	public void setInventorySlotContents(int i, ItemStack itemstack) {
		this.inventorySlots[i] = itemstack;
	}

	@Override
	public String getInvName() {
		return BlocksInfo.ARDUINO_CONNECTOR_NAME;
	}

	@Override
	public boolean isInvNameLocalized() {
		return false;
	}

	@Override
	public int getInventoryStackLimit() {
		return 1;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer entityplayer) {
		return this.worldObj.getBlockTileEntity(this.xCoord, this.yCoord, this.zCoord) != this ? false : entityplayer.getDistanceSq(this.xCoord + 0.5D, this.yCoord + 0.5D, this.zCoord + 0.5D) <= 64 && entityplayer.username.equals(this.getOwner());
	}

	@Override
	public void openChest() {
		// No Action
	}

	@Override
	public void closeChest() {
		// No Action
	}

	@Override
	public boolean isItemValidForSlot(int i, ItemStack itemstack) {
		return itemstack.itemID == ItemsInfo.ARDUINO_ID;
	}

	@Override
	public String getType() {
		return "cd_arduino_connector";
	}

	@Override
	public String[] getMethodNames() {
		return new String[] { "pinMode", "digitalWrite", "digitalRead", "analogReference", "analogRead", "analogWrite", "tone", "noTone", "shiftOut", "shiftIn", "pulseIn", "millis", "micros", "call" };
	}

	@Override
	public Object[] callMethod(IComputerAccess computer, ILuaContext context, int method, Object[] arguments) throws Exception {
		switch (method) {
		case 0: // pinMode
			return new Object[] {};
		case 1: // digitalWrite
			return new Object[] {};
		case 2: // digitalRead
			return new Object[] {};
		case 3: // analogReference
			return new Object[] {};
		case 4: // analogRead
			return new Object[] {};
		case 5: // analogWrite
			return new Object[] {};
		case 6: // tone
			return new Object[] {};
		case 7: // noTone
			return new Object[] {};
		case 8: // shiftOut
			return new Object[] {};
		case 9: // shiftIn
			return new Object[] {};
		case 10: // pulseIn
			return new Object[] {};
		case 11: // micros
			return new Object[] {};
		case 12: // micros
			return new Object[] {};
		}
		return null;
	}

	@Override
	public boolean canAttachToSide(int side) {
		return true;
	}

	@Override
	public void attach(IComputerAccess computer) {
		// No Action
	}

	@Override
	public void detach(IComputerAccess computer) {
		// No Action
	}

	@Override
	public void update() {
		System.out.println("ASD");
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public boolean isArduinoActive() {
		return arduinoActive;
	}

	public boolean tryActivateArduino(String arduinoPort) {

		return this.arduinoActive;
	}

	public String getArduinoPort() {
		return arduinoPort;
	}
}
