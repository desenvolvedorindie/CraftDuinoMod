package br.com.wfcreations.craftduino.item;

public class ItemsInfo {

	//Arduino
	public static int ARDUINO_ID;
	public static final String ARDUINO_KEY = "ItemArduino";
	public static final int ARDUINO_DEFAULT = 24201;
	public static final String ARDUINO_UNLOCALIZED_NAME = "arduino";
	public static final String[] ARDUINO_NAMES = {"Arduino Uno (Atmega328p)", "Arduino Leonardo (Atmega32u4)", "Arduino Mega (Atmega1280)", "Arduino Nano (ATmega328/ATmega168)", "Arduino Robot (ATmega32u4)"};
	public static final String[] ARDUINO_ICONS = {"arduino_uno", "arduino_leonardo", "arduino_mega", "arduino_nano", "arduino_robot"};

	//Components
	public static int COMPONENTS_ID;
	public static final String COMPONENTS_KEY = "ItemComponents";
	public static final int COMPONENTS_DEFAULT = 24202;
	public static final String COMPONENTS_UNLOCALIZED_NAME = "microcontroler";
	public static final String[] COMPONENTS_NAMES = {"ATmega328p", "ATmega32u4", "ATmega1280", "Blank PCB"};
	public static final String[] COMPONENTS_ICONS = {"atmega328p", "atmega32u4", "atmega1280", "blank_pcb"};
}
