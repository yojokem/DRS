package net.frostq.drs.store.details;

import java.nio.ByteBuffer;

/**
 * Frame data of the {@link Content}.
 * @author FrostQ
 */
public class Frame {
	private int number;
	
	private ByteBuffer content;
	private int size;
}