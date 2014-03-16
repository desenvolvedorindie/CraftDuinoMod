package br.com.wfcreations.arduino.protocol;

public class DataUnitHeader {
	
	private byte commandLenght;

	private byte commandID;

	private byte commandStatus;

	public DataUnitHeader(byte commandLenght, byte commandID, byte commandStatus) {
		this.commandLenght = commandLenght;
		this.commandID = commandID;
		this.commandStatus = commandStatus;
	}

	public byte[] getBytes() {
		byte[] bytes = { this.commandLenght, this.commandID, this.commandStatus};
		return bytes;
	}

	public byte getCommandLenght() {
		return commandLenght;
	}

	public void setCommandLenght(byte commandLenght) {
		this.commandLenght = commandLenght;
	}

	public byte getCommandID() {
		return commandID;
	}

	public void setCommandID(byte commandID) {
		this.commandID = commandID;
	}

	public byte getCommandStatus() {
		return commandStatus;
	}

	public void setCommandStatus(byte commandStatus) {
		this.commandStatus = commandStatus;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DataUnitHeader other = (DataUnitHeader) obj;
		if (commandID != other.commandID)
			return false;
		if (commandLenght != other.commandLenght)
			return false;
		if (commandStatus != other.commandStatus)
			return false;
		return true;
	}
}