package br.com.wfcreations.craftduino.gui;

import br.com.wfcreations.craftduino.block.container.ContainerArduinoConnector;
import br.com.wfcreations.craftduino.tileentity.TileArduinoConnector;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler {

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		if(ID == GuiInfo.GUI_ARDUINO_CONNECTOR_ID) {
			TileEntity tileEntity = world.getBlockTileEntity(x, y, z);
			return new ContainerArduinoConnector(player.inventory, (TileArduinoConnector)tileEntity);
		}

		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		if(ID == GuiInfo.GUI_ARDUINO_CONNECTOR_ID) {
			TileEntity tileEntity = world.getBlockTileEntity(x, y, z);
			return new GuiArduinoConnector(player.inventory, (TileArduinoConnector)tileEntity);
		}
		return null;
	}

}
