package net.frostq.drs.unit;

import java.nio.Buffer;
import java.util.Random;

/**
 * Small Unit : 소위단위체(小位單位體) / 단위체(單位體)
 * @author FrostQ
 * @serial id
 *
 */
public class Unit {
	private long id;
	private Buffer content;
	private boolean allocated = false, lockedUp = false;
	
	public Unit(Buffer content) {
		this.content = content;
	}
	
	public void lockUp() {
		this.lockedUp = true;
	}
	
	public void allocate() {
		lockUp();
		this.allocated = true;
	}
	
	public void allocate(Buffer content) {
		this.setContent(content);
		allocate();
	}
	
	protected void setId(long id) {
		this.id = id;
	}
	
	public long getId() {
		return this.id;
	}
	
	public Unit setContent(Buffer content) {
		if(this.isLockedUp()) return this;
		this.content = content;
		return this;
	}
	
	public Buffer getContent() {
		return this.content;
	}
	
	public boolean isEmpty() {
		return this.getContent().equals(EmptyUnit.INSTANCE.getContent());
	}
	
	public boolean isUsable() {
		return verifyId(id);
	}
	
	public void release() {
		Units.unitPackages.removeIf(x -> x.longValue() == this.getId());
		this.setContent(EmptyUnit.INSTANCE.getContent());
		setId(0);
	}
	
	public boolean isAllocated() {
		return this.allocated == true && this.isLockedUp() == true;
	}
	
	public boolean isLockedUp() {
		return this.lockedUp;
	}
	
	@Override
	public int hashCode() {
		return Long.valueOf(this.getId()).intValue();
	}
	
	@Override
	public String toString() {
		return this.getClass().getSimpleName() + "-" + this.getId();
	}
	
	static final Random r = new Random();
	
	public static long generateId() {
		long t = r.nextLong();
		if(!verifyId(t) || Units.exists(t)) return generateId();
		return t;
	}
	
	public static boolean verifyId(long id) {
		return !(id == 0 || id == -1 || Units.unitPackages.contains(id));
	}
}