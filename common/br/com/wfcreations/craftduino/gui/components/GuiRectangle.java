package br.com.wfcreations.craftduino.gui.components;

import br.com.wfcreations.craftduino.gui.GuiContainerBase;
import net.minecraft.client.gui.inventory.GuiContainer;

public abstract class GuiRectangle {

	protected int x;
	
	protected int y;
	
	protected int width;
	
	protected int height;
	
	public GuiRectangle(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	public boolean isHit(GuiContainerBase gui, int mouseX, int mouseY) {
		mouseX -= gui.getLeft();
		mouseY -= gui.getTop();
		return x <= mouseX && mouseX <= x + width && y <= mouseY && mouseY <= y + height;
	}
	
	public abstract void draw(GuiContainerBase gui, int srcX, int srcY);

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
}
