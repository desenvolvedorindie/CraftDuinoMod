package br.com.wfcreations.arduino;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.Scanner;

import javax.xml.crypto.Data;

import br.com.wfcreations.arduino.protocol.DataUnit;
import br.com.wfcreations.arduino.protocol.DataUnitHeader;
import br.com.wfcreations.arduino.protocol.TVL;
import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;

public class SerialTest implements SerialPortEventListener {

	SerialPort serialPort;

	private static final String PORT_NAMES[] = { "/dev/tty.usbserial-A9007UX1", "/dev/ttyUSB0", "COM3" };

	private InputStream input;

	private OutputStream output;

	private static final int TIME_OUT = 2000;

	private static final int DATA_RATE = 9600;

	public void initialize() {
		CommPortIdentifier portId = null;
		Enumeration portEnum = CommPortIdentifier.getPortIdentifiers();
		while (portEnum.hasMoreElements()) {
			CommPortIdentifier currPortId = (CommPortIdentifier) portEnum.nextElement();
			for (String portName : PORT_NAMES) {
				if (currPortId.getName().equals(portName)) {
					portId = currPortId;
					break;
				}
			}
		}
		if (portId == null) {
			System.out.println("Could not find COM port.");
			return;
		}

		try {
			serialPort = (SerialPort) portId.open(this.getClass().getName(), TIME_OUT);
			serialPort.setSerialPortParams(DATA_RATE, SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);
			input = serialPort.getInputStream();
			output = serialPort.getOutputStream();
			serialPort.addEventListener(this);
			serialPort.notifyOnDataAvailable(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public synchronized void close() {
		if (serialPort != null) {
			serialPort.removeEventListener();
			serialPort.close();
		}
	}

	@Override
	public synchronized void serialEvent(SerialPortEvent oEvent) {
		if (oEvent.getEventType() == SerialPortEvent.DATA_AVAILABLE) {
			try {
				if (input.available() > 0) {
					int i = input.read();
					int i2 = input.read();
					int i3 = input.read();
					int i4 = input.read();
				}
				output.write("a".getBytes());
				output.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) throws Exception {
		SerialTest main = new SerialTest();
		main.initialize();
		// du.addTVL(new TVL((byte) 1, (byte) 2, "as".getBytes()));
		Thread.sleep(1000);
		//main.close();
		// System.out.println(new String(du.getBytes()));
	}
}