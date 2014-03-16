package br.com.wfcreations.arduino.protocol;

import java.util.Arrays;

import br.com.wfcreations.arduino.utils.ByteUtils;

/**
 * 	Short Message Arduino	
 * 
 * 	@author Welsiton
 *
 */

public class DataUnit {	

	public static byte SOH = 1;
	
	public static byte ETX = 3;
	
	public static byte EOT = 4;
	
	public static byte ENQ = 5;
	
	public static byte ACK = 6;
	
	private DataUnitHeader header;
	
	private TVL[] body;
	
	public DataUnit(DataUnitHeader header) {
		this.header = header;
		body = new TVL[0];
	}
	
	public void addTVL(TVL element) {
	    TVL[] result = Arrays.copyOf(body, body.length +1);
	    result[body.length] = element;
	}
	
	public byte[] getBytes() {
		byte[] bytes = {SOH};
		bytes = ByteUtils.concat(bytes, header.getBytes());
		for(int i = 0; i < body.length; i++) {
			bytes = ByteUtils.concat(bytes, body[i].getBytes());
		}
		
		bytes = ByteUtils.addElement(bytes, EOT);
		return bytes;
	}
	
	public static DataUnit ENQUIRY;
	
	static {
		ENQUIRY = new DataUnit(new DataUnitHeader((byte)3, (byte)255, ENQ));
	}
}


