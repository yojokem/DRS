package net.frostq.drs.unit;

import net.frostq.drs.store.Store;

/**
 * Data Unit : 전위집단체(全位集團體) / 자료체
 * @author FrostQ
 * @serial name
 *
 */
public class Data extends Store {
	private String name;
	private long organized = System.currentTimeMillis();
	
	
	
	public void repack(Units...unitses) {
		
	}
	
	public void packAlso(Units units) {
		
	}
	
	
	
	public void unpack() {
		
	}
	
	public void release() {
		unpack();
	}
}