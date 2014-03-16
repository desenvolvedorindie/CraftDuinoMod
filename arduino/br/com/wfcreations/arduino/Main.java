package br.com.wfcreations.arduino;

import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;
import gnu.io.UnsupportedCommOperationException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;

public class Main {

	private static OutputStream os = null;

	private static SerialPort serialPort;

	private static final String port = "COM3";

	private static final int TIMEOUT = 2000;

	private static final int DATA_RATE = 9600;

	public static void main(String[] args) {
		CommPortIdentifier portID = null;
		Enumeration portEnum = CommPortIdentifier.getPortIdentifiers();

		while (portEnum.hasMoreElements()) {
			CommPortIdentifier currentPort = (CommPortIdentifier) portEnum.nextElement();
			if (port.equals(currentPort.getName())) {
				portID = currentPort;
				break;
			}
		}

		if (portID == null) {
			System.out.println("Can't Connect");
			System.exit(1);
		}

		try {
			serialPort = (SerialPort) portID.open(Main.class.getName(), TIMEOUT);
			os = serialPort.getOutputStream();
			serialPort.setSerialPortParams(DATA_RATE, SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);
			os.write("a\n".getBytes());
			System.out.println("Enviado");
			//InputStream in = serialPort.getInputStream();
			//System.out.println(in.available());
			serialPort.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
