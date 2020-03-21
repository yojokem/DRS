package net.frostq.drs.unit;

import java.nio.Buffer;
import java.util.Random;

import net.frostq.drs.ConsolePrinter;
import net.frostq.drs.store.Store;

/**
 * Small Unit : 소위단위체(小位單位體) / 단위체(單位體)
 * @author FrostQ
 * @serial id
 *
 */
public class Unit extends Store implements ConsolePrinter {
	private long id;
	private Buffer content;
	private boolean allocated = false, lockedUp = false;
	
	// 네트워크 송신 시 {(byte[]) id / ByteBuffer content} 형태로 발송.
	// NIO 사용 여부 결정 必
	
	public Unit(Buffer content) {
		this.content = content;
	}
	
	public void lockUp() {
		this.lockedUp = true;
		this.info("This unit has been locked up.");
	}
	
	public void allocate() {
		lockUp();
		this.allocated = true;
		this.info("This unit has been allocated.");
	}
	
	public void allocate(Buffer content) {
		this.setContent(content);
		allocate();
	}
	
	protected void setId(long id) {
		this.id = !Units.unitPackages.parallelStream().anyMatch(x -> x.longValue() == id) ?
				id : 0;
	}
	
	public long getId() {
		return this.id;
	}
	
	public Unit setContent(Buffer content) {
		if(this.isLockedUp()) return this;
		this.content = content;
		this.info("Content has been changed.");
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
		this.info("I'm gonna be released!");
		
		Units.unitPackages.removeIf(x -> x.longValue() == this.getId());
		this.setContent(EmptyUnit.INSTANCE.getContent());
		
		this.info("Released content and myself from the list. Releasing ID.");
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

	@Override
	public String getPrefix() {
		return "[Unit-" + this.getId() + "]";
	}

	@Override
	public String getSuffix() {
		return "";
	}
	
	private boolean debugging = false;

	@Override
	public void setDebugging(boolean debugging) {
		this.debugging = debugging;
	}

	@Override
	public boolean isDebugging() {
		return this.debugging;
	}
}