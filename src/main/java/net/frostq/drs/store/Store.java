package net.frostq.drs.store;

import java.nio.file.Path;

public abstract class Store {
	/*
	 * Unit		: (id).unit (Buffer 작성)
	 * Units	: (name).units ()
	 * Data		: (name).data ()
	 */
	
	// private List<CompletableFuture<Result>> exportJobs = Lists.newArrayList();
	// Async 형식으로 여러 export 작업 속행 처리 추가 가능
	
	protected abstract byte[] data();
	public abstract String identifier();
	/**
	 * Example: Unit-600010302001
	 * @return File name, only the name without extension.
	 */
	public abstract String file_name();
	/**
	 * Extension name without dot(.).
	 * @return Extension name
	 */
	public abstract String extension();
	
	private Header header;
	private Content content;
	private Footer footer;
	
	public String getFileName() {
		return file_name().trim() + "." + extension().trim();
	}
	
	public void export() {
		// export(Retention에서 Environment 호출을 통한 폴더 자동 탐색 必)
	}
	
	public void export(Path dir) {
		assert file_name().trim() != null && !file_name().trim().contentEquals("");
		assert extension().trim() != null && !extension().trim().contentEquals("");
		assert data().length > 0; //Data Verification 필요
	}
	
	private Header createHeader() {
		
	}
}