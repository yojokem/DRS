package net.frostq.drs.unit;

import java.util.List;
import java.util.function.BinaryOperator;

import com.google.common.collect.Lists;
import com.google.common.collect.Streams;

public class Units {
	public List<Long> unitPackages = Lists.newArrayList();
	public static final int MAX_SIZE = 256;
	
	private List<Unit> unit = Lists.newArrayList();
	private boolean closedUp = false;
	
	public void setSize(int offset) {
		if(closedUp) return;
		unit = unit.subList(offset, unit.size() - 1);
	}
	
	public void add(Unit u) {
		if(closedUp) return;
		unit.add(u);
	}
	
	public void set(int index, Unit u) {
		if(closedUp) return;
		unit.set(index, u);
	}
	
	public boolean remove(Unit u) {
		if(closedUp) return false;
		int count = 0, i;
		while((i = unit.indexOf(u)) >= 0) {
			unit.set(i, EmptyUnit.INSTANCE);
			count++;
		}
		
		return count > 0;
	}
	
	public void remove(int index) {
		if(closedUp) return;
		if(unit.get(index) != null)
			unit.set(index, EmptyUnit.INSTANCE);
	}
	
	public void trim() {
		
	}
	
	public void closeUp() {
		closedUp = true;
	}
}