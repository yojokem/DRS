package net.frostq.drs.history;

import net.frostq.drs.store.Store;

public class History extends Store { //클래스마다 따로따로 놓을 수 있는 Class 개별 히스토리; protected static 으로 개별 관리.
	private String className;
	private long timestamp = System.currentTimeMillis();
	
	//File Name 추출 시 : {[className].[[yyyy-MM-dd_HH:mm:ss]]_[timestamp]}
	//Extension 추출 시 : history
	//행위의 히스토리 추출에 대해서 자연어 중 언어별 자동 처리가 필요하다고 생각.
}