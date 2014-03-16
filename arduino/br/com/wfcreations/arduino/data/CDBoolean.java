package br.com.wfcreations.arduino.data;

import br.com.wfcreations.arduino.protocol.TVL;

public enum CDBoolean implements CDIType {
	
	BOOLEAN_TRUE(true),
	BOOLEAN_FALSE(false);
	
	public static CDBoolean createFromTVL(TVL tvl) {
		if(tvl.getTag() == CDIType.BOOLEAN_TYPE) {
			if(tvl.getLenght() == 1) {
				if(tvl.getValue()[0] == 0) {
					return BOOLEAN_FALSE;
				} else if(tvl.getValue()[0] == 1) {
					return BOOLEAN_TRUE;
				}
			}
		}
		return null;
	}
	
	private boolean value;
	
	CDBoolean(boolean value) {
		this.setValue(value);
	}

	public boolean getValue() {
		return value;
	}

	public void setValue(boolean value) {
		this.value = value;
	}
	
	@Override
	public TVL getTVL() {
		byte bytes[] = new byte[1];
		if(this.getValue()) {
			bytes[0] = (byte) 1;
		} else {
			bytes[0] = (byte) 0;
		}
		return new TVL(CDIType.BOOLEAN_TYPE, bytes);
	}
}
