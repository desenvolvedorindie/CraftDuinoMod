package br.com.wfcreations.arduino.data;

import java.security.InvalidParameterException;

import br.com.wfcreations.arduino.protocol.TVL;

public class CDNumber implements CDIType {
	
	private short value;
	
	public CDNumber(short value) {
		this.setValue(value);
	}
	
	public CDNumber(TVL tvl) {
		if(tvl.getTag() != CDIType.NUMBER_TYPE)
			throw new InvalidParameterException("Invalid tag");
		if(tvl.getLenght() != 2)
			throw new InvalidParameterException("Invalid value lenght");
		
		byte bytes[] = tvl.getValue();
		this.setValue((short) ((bytes[1] << 8) + (bytes[0] & 0xFF)));
	}

	public short getValue() {
		return value;
	}

	public void setValue(short value) {
		this.value = value;
	}
	
	@Override
	public TVL getTVL() {
		byte bytes[] = new byte[2];
		bytes[0] = (byte) this.getValue();
		bytes[1] = (byte) ((this.getValue() >> 8) & 0xff);
		return new TVL(CDIType.NUMBER_TYPE, bytes);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CDNumber other = (CDNumber) obj;
		if (value != other.value)
			return false;
		return true;
	}
}
