package br.com.wfcreations.craftduino.gui;

import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.inventory.Container;

public class GuiContainerBase extends GuiContainer {

	public GuiContainerBase(Container container) {
		super(container);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float f, int mouseX, int mouseY) {}
	
	public int getLeft() {
		return guiLeft;
	}
	
	public int getTop() {
		return guiTop;
	}
	
	public FontRenderer getFontRenderer(){
		return fontRenderer;
	}
}
