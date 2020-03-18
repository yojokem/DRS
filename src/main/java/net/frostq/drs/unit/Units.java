package net.frostq.drs.unit;

import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

import com.google.common.collect.Lists;

public class Units {
	public static final List<Long> unitPackages = Lists.newArrayList();
	public static final int MAX_SIZE = 256;
	
	private List<Unit> unit = Lists.newArrayList();
	private boolean closedUp = false;
	
	public void setSize(int offset) {
		if(this.closedUp) return;
		this.unit = unit.subList(offset, unit.size() - 1);
	}
	
	public void add(Unit u) {
		if(this.closedUp) return;
		this.unit.add(u);
	}
	
	public void set(int index, Unit u) {
		if(this.closedUp) return;
		this.unit.set(index, u);
	}
	
	public List<Unit> get(int[] offset, int[] size) {
		if(size.length > 1)
			assert offset.length == size.length;
		else assert size.length == 1;
		
		int[] sortedOffset = IntStream.of(offset).sorted().toArray();
		
		List<Unit> temp = Lists.newArrayList();
		
		
		
		return temp;
	}
	
	public Unit[] get(int offset, int size) {
		assert offset >= 0;
		assert size > 0;
		return this.unit.subList(offset, offset + size - 1).toArray(new Unit[] {});
	}
	
	public Unit get(int offset) {
		return this.get(offset, 1)[0];
	}
	
	public boolean remove(Unit u) {
		if(this.closedUp) return false;
		int count = 0, i;
		while((i = this.unit.indexOf(u)) >= 0) {
			this.unit.set(i, EmptyUnit.INSTANCE);
			count++;
		}
		
		return count > 0;
	}
	
	public void remove(int index) {
		if(this.closedUp) return;
		if(this.unit.get(index) != null)
			this.unit.set(index, EmptyUnit.INSTANCE);
	}
	
	public void trim() {
		unit.parallelStream().filter(x -> !x.getContent().equals(EmptyUnit.INSTANCE.getContent()))
			.sorted(new Comparator<Unit>() {
				@Override
				public int compare(Unit o1, Unit o2) {
					return unit.indexOf(o1) - unit.indexOf(o2);
				}
			});
	}
	
	public void closeUp() {
		this.closedUp = true;
	}
	
	public void close() {
		unitPackages.removeIf(x -> unit.parallelStream().anyMatch(y -> y.getId() == x.longValue()));
		this.unit.clear();
	}
	
	public boolean existsIn(Unit unit) {
		return this.unit.contains(unit);
	}
	
	public boolean existsIn(long id) {
		return this.unit.parallelStream().anyMatch(x -> x.getId() == id);
	}
	
	public static boolean exists(long unitId) {
		return unitPackages.contains(unitId);
	}
}