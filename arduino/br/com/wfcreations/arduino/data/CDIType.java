package br.com.wfcreations.arduino.data;

import br.com.wfcreations.arduino.protocol.TVL;

public interface CDIType {

	public static final byte VOID_TYPE = 0;
	
	public static final byte BOOLEAN_TYPE = 1;
	
	public static final byte NUMBER_TYPE = 2;
	
	public static final byte STRING_TYPE = 3;
	
	public TVL getTVL();
}
