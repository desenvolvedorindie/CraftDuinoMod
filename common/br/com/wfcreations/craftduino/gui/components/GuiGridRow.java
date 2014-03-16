package br.com.wfcreations.craftduino.gui.components;

import br.com.wfcreations.craftduino.gui.GuiContainerBase;
import net.minecraft.client.gui.inventory.GuiContainer;

public class GuiGridRow extends GuiRectangle {

	protected String text;
	
	protected int color;

	private boolean selected;
	
	public GuiGridRow(int x, int y, int width, int height, String text, int color) {
		super(x, y, width, height);
		this.text = text;
		this.color = color;
		this.selected = false;
	}

	@Override
	public void draw(GuiContainerBase gui, int srcX, int srcY) {
		gui.drawTexturedModalRect(gui.getLeft() + x, gui.getTop() + y, srcX, srcY, width, height);
	}
	
	public void drawText(GuiContainerBase gui) {
		gui.getFontRenderer().drawString(text, x + 3, y + 6, color);
	}

	public boolean mouseHit(GuiContainerBase gui, int mouseX, int mouseY) {
		mouseX -= gui.getLeft();
		mouseY -= gui.getTop();
		return x <= mouseX && mouseX <= x + width && y <= mouseY && mouseY <= y + height;
	}
	
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}
}
