package net.frostq.drs.store.details;

import org.json.JSONObject;

public abstract class PropertyBox {
	private JSONObject obj;
	
	public PropertyBox() {
		this.obj = new JSONObject();
	}
	
	public abstract void onDataUpdate();
	
	protected boolean containsKey(String key) {
		return getJSON().has(key);
	}
	
	protected JSONObject getJSON() {
		this.onDataUpdate();
		return this.obj;
	}
	
	protected String getExported() {
		return getJSON().toString();
	}
}