package net.frostq.drs.store;

import java.io.OutputStream;
import java.io.Serializable;

public abstract class Store implements Serializable {
	private static final long serialVersionUID = 7964476687259398034L;
	
	public void save() {}
	
	public void export(OutputStream os) {}
}