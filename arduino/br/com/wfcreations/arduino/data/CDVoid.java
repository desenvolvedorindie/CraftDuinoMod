package br.com.wfcreations.arduino.data;

import br.com.wfcreations.arduino.protocol.TVL;

public enum CDVoid implements CDIType {

	VOID;
	
	@Override
	public TVL getTVL() {
		return new TVL(CDIType.VOID_TYPE, new byte[0]);
	}
	
}
