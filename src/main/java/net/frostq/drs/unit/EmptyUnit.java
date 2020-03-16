package net.frostq.drs.unit;

import java.nio.Buffer;
import java.nio.ByteBuffer;

public final class EmptyUnit extends Unit {
	public static final EmptyUnit INSTANCE = new EmptyUnit(ByteBuffer.allocate(0));
	
	private EmptyUnit(Buffer buffer) {
		super(buffer);
		
		setId(-1);
	}
	
	@Override
	public Unit setContent(Buffer content) {
		return this;
	}
	
	public static long generateId() {
		return -1;
	}
	
	public static boolean verifyId(long id) {
		return id == generateId();
	}
}