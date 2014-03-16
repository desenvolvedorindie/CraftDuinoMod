package br.com.wfcreations.craftduino.gui;

import gnu.io.CommPortIdentifier;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import org.lwjgl.opengl.GL11;

import br.com.wfcreations.craftduino.ModInfo;
import br.com.wfcreations.craftduino.block.container.ContainerArduinoConnector;
import br.com.wfcreations.craftduino.gui.components.GuiGridRow;
import br.com.wfcreations.craftduino.gui.slot.SlotArduino;
import br.com.wfcreations.craftduino.tileentity.TileArduinoConnector;
import br.com.wfcreations.craftduino.utils.GuiColor;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.util.Icon;
import net.minecraft.util.ResourceLocation;

public class GuiArduinoConnector extends GuiContainerBase {

	private static final ResourceLocation texture = new ResourceLocation(ModInfo.MOD_ID, GuiInfo.GUI_ARDUINO_CONNECTOR);

	private ArrayList<GuiGridRow> griRow;

	private TileArduinoConnector tileArduinoConnector;

	private String status;
	
	private int color;
	
	private int elementActive = -1;
	
	public GuiArduinoConnector(InventoryPlayer invPlayer, TileArduinoConnector tileArduinoConnector) {
		super(new ContainerArduinoConnector(invPlayer, tileArduinoConnector));
		xSize = 201;
		ySize = 177;
		this.tileArduinoConnector = tileArduinoConnector;
		griRow = new ArrayList<GuiGridRow>();
		color = 0x000000;
	}

	@Override
	public void initGui() {
		super.initGui();
		updateConnectionList();
		buttonList.clear();
		buttonList.add(new GuiButton(0, guiLeft + 177, guiTop + 30, 20, 20, "U"));
		buttonList.add(new GuiButton(1, guiLeft + 177, guiTop + 30 + 21, 20, 20, "C"));
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float f, int mouseX, int mouseY) {
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		mc.renderEngine.bindTexture(texture);
		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);

		int srcY;

		for (int i = 0; i < griRow.size(); i++) {
			srcY = ySize;
			if(griRow.get(i).isSelected()) {
				srcY += griRow.get(i).getHeight();
			}
			griRow.get(i).draw(this, 0, srcY);
		}
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(int par1, int par2) {
		fontRenderer.drawString("Arduino Connector", 9, 6, 0x404040);
		for (int i = 0; i < griRow.size(); i++) {
			griRow.get(i).drawText(this);
		}
		getFontRenderer().drawString(status, 9, 81, color);
	}
	
	@Override
	protected void mouseClicked(int mouseX, int mouseY, int key) {
		super.mouseClicked(mouseX, mouseY, key);
		int i;
		for(i = 0; i < griRow.size(); i++) {
			if(griRow.get(i).mouseHit(this, mouseX, mouseY)) {
				if(griRow.get(i).isSelected()) {
					i = griRow.size();
				}
				break;
			}
		}
		
		elementActive = i;
		
		if(griRow.size() > 0) {
			for(int j = 0; j < griRow.size(); j++) {
				griRow.get(j).setSelected(i == j);
			}
		}
	}
	
	private void updateConnectionList() {
		int i = 0;
		
		CommPortIdentifier portId = null;
		Enumeration portEnum = CommPortIdentifier.getPortIdentifiers();
		
		griRow.clear();
		while (portEnum.hasMoreElements() && i < 3) {
			CommPortIdentifier currPortId = (CommPortIdentifier) portEnum.nextElement();
			griRow.add(new GuiGridRow(10, 18 + 19 * i, 156, 19, currPortId.getName(), 0x404040));
			i++;
		}
		
		status = GuiColor.BLACK + "Status: ";
		if(i > 0) {
			status += GuiColor.BLUE + "Found " + i;
			if(i > 1) {
				status += " Arduinos";
			} else {
				status += " Arduino";
			}
		} else {
			status += GuiColor.GRAY + "No Arduino Found";
		}		
	}
	
	@Override
	protected void actionPerformed(GuiButton button) {
		switch (button.id) {
		case 0:
			updateConnectionList();
			break;
		case 1:
			if(tileArduinoConnector.tryActivateArduino(griRow.get(elementActive).getText())) {
				
			}
			break;
		}
	}
}
