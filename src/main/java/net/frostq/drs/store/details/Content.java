package net.frostq.drs.store.details;

import java.nio.ByteBuffer;

import net.frostq.drs.store.Store;

/**
 * Content between the {@link Header} and {@link Footer} in the {@link Store} file.
 * @author FrostQ
 */
public class Content {
	private Frame[] frames;
}