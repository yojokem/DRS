package net.frostq.drs.store;

/**
 * Header in the {@link Store} file.
 * @author FrostQ
 */
public class Header {
	private Store jurisdiction;
	
	private int version;
	private int headerSize, contentSize, footerSize;
	private String fcs; //File Configuration Sign {Unit, Units, Data, ...?}
	private String identifier;
	private long exportTimestamp;
	
	public boolean setString(int offset, int endoffset, String str) {
		
	}
	
	public boolean setInt(int offset, int target) {
		
	}
	
	public boolean setLong(int offset, long target) {
		
	}
	
	public String getString(int offset, int endoffset) {
		
	}
	
	public int getInt(int offset) {
		
	}
	
	public long getLong(int offset) {
		
	}

	public int getVersion() {
		return version;
	}

	protected void setVersion(int version) {
		this.version = version;
	}

	public int getHeaderSize() {
		return headerSize;
	}

	protected void setHeaderSize(int headerSize) {
		this.headerSize = headerSize;
	}

	public int getContentSize() {
		return contentSize;
	}

	protected void setContentSize(int contentSize) {
		this.contentSize = contentSize;
	}

	public int getFooterSize() {
		return footerSize;
	}

	protected void setFooterSize(int footerSize) {
		this.footerSize = footerSize;
	}

	public String getFcs() {
		return fcs;
	}

	protected void setFcs(String fcs) {
		this.fcs = fcs;
	}

	public String getIdentifier() {
		return identifier;
	}

	protected void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	public long getExportTimestamp() {
		return exportTimestamp;
	}

	protected void setExportTimestamp(long exportTimestamp) {
		this.exportTimestamp = exportTimestamp;
	}
}