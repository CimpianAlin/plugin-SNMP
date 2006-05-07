package plugins.snmplib;

import freenet.config.InvalidConfigValueException;
import freenet.config.StringCallback;

public class SNMPBindtoCallback implements StringCallback {
	
	public SNMPBindtoCallback() {
	}
	
	public String get() {
		String bindto=SNMPAgent.getSNMPAgent().getSNMPbindto();
		if(bindto!=null) return bindto;
		return "127.0.0.1";
	}

	public void set(String val) throws InvalidConfigValueException {
		if(val != get()) {
			SNMPAgent.setSNMPbindto(val);
		}
	}
}