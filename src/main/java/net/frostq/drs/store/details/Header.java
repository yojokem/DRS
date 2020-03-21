package net.frostq.drs.store.details;

import net.frostq.drs.store.Store;

/**
 * Header in the {@link Store} file.
 * @author FrostQ
 */
public class Header extends PropertyBox {
	private int version;
	private int headerSize, contentSize, footerSize;
	private String fcs; //File Configuration Sign {Unit, Units, Data, ...?}
	private String identifier;
	private long exportTimestamp;
	
	@Override
	public void onDataUpdate() {
		
	}

	public int getVersion() {
		return version;
	}

	protected void setVersion(int version) {
		this.version = version;
		onDataUpdate();
	}

	public int getHeaderSize() {
		return headerSize;
	}

	protected void setHeaderSize(int headerSize) {
		this.headerSize = headerSize;
		onDataUpdate();
	}

	public int getContentSize() {
		return contentSize;
	}

	protected void setContentSize(int contentSize) {
		this.contentSize = contentSize;
		onDataUpdate();
	}

	public int getFooterSize() {
		return footerSize;
	}

	protected void setFooterSize(int footerSize) {
		this.footerSize = footerSize;
		onDataUpdate();
	}

	public String getFcs() {
		return fcs;
	}

	protected void setFcs(String fcs) {
		this.fcs = fcs;
		onDataUpdate();
	}

	public String getIdentifier() {
		return identifier;
	}

	protected void setIdentifier(String identifier) {
		this.identifier = identifier;
		onDataUpdate();
	}

	public long getExportTimestamp() {
		return exportTimestamp;
	}

	protected void setExportTimestamp(long exportTimestamp) {
		this.exportTimestamp = exportTimestamp;
		onDataUpdate();
	}
}