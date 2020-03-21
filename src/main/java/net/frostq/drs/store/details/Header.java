package net.frostq.drs.store.details;

/**
 * Header in the {@link Store} file.
 * @author FrostQ
 */
public class Header {
	private int version;
	private int headerSize, contentSize, footerSize;
	private String fcs; //File Configuration Sign {Unit, Units, Data, ...?}
	private String identifier;
	private long exportTimestamp;
}