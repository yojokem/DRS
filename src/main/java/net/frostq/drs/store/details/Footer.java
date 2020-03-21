package net.frostq.drs.store.details;

import net.frostq.drs.store.Store;

/**
 * Footer in the {@link Store} file.
 * @author FrostQ
 */
public class Footer extends PropertyBox {
	private int dataLength, frameSize, frameCount;

	@Override
	public void onDataUpdate() {
		
	}

	public int getDataLength() {
		return dataLength;
	}

	protected void setDataLength(int dataLength) {
		this.dataLength = dataLength;
		onDataUpdate();
	}

	public int getFrameSize() {
		return frameSize;
	}

	protected void setFrameSize(int frameSize) {
		this.frameSize = frameSize;
		onDataUpdate();
	}

	public int getFrameCount() {
		return frameCount;
	}

	protected void setFrameCount(int frameCount) {
		this.frameCount = frameCount;
		onDataUpdate();
	}
}