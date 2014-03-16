package br.com.wfcreations.craftduino.utils;

public enum GuiColor {
	BLACK,
	BLUE,
	GREEN,
	CYAN,
	RED,
	PURPLE,
	ORANGE,
	LIGHTGRAY,
	GRAY,
	LIGHTBLUE,
	LIME,
	TURQUISE,
	PINK,
	MAGENTA,
	YELLOW,
	WHITE;
	
	private GuiColor(){
	}
	
	public String toString() {
		return "\u00a7" + Integer.toHexString(this.ordinal());
	}
}
