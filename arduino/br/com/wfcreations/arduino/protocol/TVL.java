package br.com.wfcreations.arduino.protocol;

import br.com.wfcreations.arduino.utils.ByteUtils;

public class TVL {
	private byte tag;
	
	private byte[] value;

	public TVL(byte tag, byte[] value) {
		this.setTag(tag);
		this.setValue(value);
	}
	
	public byte[] getBytes(){
		byte[] bytes = {this.getTag(), this.getLenght()};
		return ByteUtils.concat(bytes, this.getValue());
	}

	public byte getTag() {
		return tag;
	}

	public void setTag(byte tag) {
		this.tag = tag;
	}

	public byte getLenght() {
		return (byte) value.length;
	}

	public byte[] getValue() {
		return value;
	}

	public void setValue(byte[] value) {
		this.value = value;
	}
}