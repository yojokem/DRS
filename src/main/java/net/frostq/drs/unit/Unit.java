package net.frostq.drs.unit;

import java.nio.Buffer;
import java.util.Random;

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
	
	public boolean isUsable() {
		return this.getId() == 0 || Units.unitPackages.contains(this.getId());
	}
	
	public void release() {
		Units.unitPackages.removeIf(x -> x.longValue() == this.getId());
		this.setContent(EmptyUnit.INSTANCE.getContent());
		setId(0);
	}
	
	static final Random r = new Random();
	
	public static long generateId() {
		long t = r.nextLong();
		if(!verifyId(t) || Units.exists(t)) return generateId();
		return t;
	}
	
	public static boolean verifyId(long id) {
		return !(id == 0 || id == -1);
	}
}