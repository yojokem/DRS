package net.frostq.drs.unit;

import java.nio.Buffer;

public class Unit {
	private long id;
	private Buffer content;
	
	public Unit(Buffer content) {
		
		this.content = content;
	}
	
	protected void setId(long id) {
		this.id = id;
	}
	
	public long getId() {
		return this.id;
	}
	
	public Unit setContent(Buffer content) {
		this.content = content;
		return this;
	}
	
	public Buffer getContent() {
		return this.content;
	}
	
	public static long generateId() {
		
	}
	
	public static boolean verifyId(long id) {
		
	}
}