package net.frostq.drs.unit;

import java.nio.Buffer;
import java.nio.ByteBuffer;

public final class EmptyUnit extends Unit {
	public static final EmptyUnit INSTANCE = new EmptyUnit(ByteBuffer.allocate(0));
	
	private EmptyUnit(Buffer buffer) {
		super(buffer);
		
		this.setId(-1);
		this.allocate();
	}
	
	public static long generateId() {
		return -1;
	}
	
	public static boolean verifyId(long id) {
		return id == generateId();
	}
}