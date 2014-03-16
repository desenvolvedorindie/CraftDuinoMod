package br.com.wfcreations.arduino.data;

import br.com.wfcreations.arduino.protocol.TVL;

public class CDString implements CDIType {

	private String value;
	
	public CDString(String s) {
		this.setValue(s);
	}
	
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public TVL getTVL() {
		return new TVL(CDIType.STRING_TYPE, this.getValue().getBytes());
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CDString other = (CDString) obj;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}
}
