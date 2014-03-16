package br.com.wfcreations.arduino;

import java.util.Enumeration;
import java.util.Scanner;

import gnu.io.CommPortIdentifier;
import br.com.wfcreations.arduino.data.CDBoolean;
import br.com.wfcreations.arduino.data.CDIType;
import br.com.wfcreations.arduino.data.CDNumber;
import br.com.wfcreations.arduino.protocol.DataUnit;
import br.com.wfcreations.arduino.protocol.TVL;

public class Main2 {

	public static void main(String[] args) {
		CDNumber t = new CDNumber((short) 5);

		TVL tvl = t.getTVL();
		CDNumber t2 = new CDNumber(tvl);
		System.out.println(t2.getValue());
		
		System.out.println(DataUnit.ENQUIRY.getBytes().length);
		
		CommPortIdentifier portId = null;
		Enumeration portEnum = CommPortIdentifier.getPortIdentifiers();
		
		while (portEnum.hasMoreElements()) {
			CommPortIdentifier currPortId = (CommPortIdentifier) portEnum.nextElement();
			System.out.println(currPortId.getName());
		}
	}
}
