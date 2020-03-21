package net.frostq.drs.unit;

import java.io.OutputStream;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import com.google.common.collect.Lists;

import net.frostq.drs.ConsolePrinter;
import net.frostq.drs.store.Store;

/**
 * Middle Unit : 중위단위체(衆位單位體) / 중위집단(衆位集團)
 * @author FrostQ
 * @serial groupName
 *
 */
public class Units extends Store implements ConsolePrinter {
	public static final List<Long> unitPackages = Lists.newArrayList();
	public static final int MAX_SIZE = 256;
	
	private String groupName = "";
	private List<Unit> unit = Lists.newArrayList();
	private boolean closedUp = false;
	
	public void setSize(int offset) {
		if(this.closedUp) return;
		this.unit = unit.subList(offset, unit.size() - 1);
	}
	
	public int size() {
		return this.unit.size();
	}
	
	public int realSize() {
		return Long.valueOf(this.unit.parallelStream().filter(x -> !x.isEmpty())
				.count()).intValue();
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
		
		List<Unit> temp = Lists.newArrayList();
		
		for(int i = 0; i < offset.length; i++)
			temp.addAll(Arrays.asList(this.get(offset[i], size.length > 1 ? size[i] : size[0])));
		
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
	
	public void export(OutputStream os) {
		
	}
	
	public void save() {
		
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
		unit.parallelStream().filter(x -> !x.isEmpty())
			.sorted(new Comparator<Unit>() {
				@Override
				public int compare(Unit o1, Unit o2) {
					return unit.indexOf(o1) - unit.indexOf(o2);
				}
			});
	}
	
	protected void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	
	public String getGroupName() {
		return this.groupName;
	}
	
	public void closeUp() {
		this.closedUp = true;
	}
	
	public void close() {
		this.info("I'm gonna be closed!");
		unitPackages.removeIf(x -> unit.parallelStream().anyMatch(y -> y.getId() == x.longValue()));
		this.unit.forEach(x -> x.release());
		this.unit.clear();
		this.info("Closed units list. Releasing the group name.");
		
	}
	
	public boolean existsIn(Unit unit) {
		return this.unit.contains(unit) || existsIn(unit.getId());
	}
	
	public boolean existsIn(long id) {
		return this.unit.parallelStream().anyMatch(x -> x.getId() == id);
	}
	
	public static boolean exists(long unitId) {
		return unitPackages.contains(unitId);
	}

	@Override
	public String getPrefix() {
		return "[Units] 〔" + this.getGroupName() + "〕";
	}

	@Override
	public String getSuffix() {
		return "";
	}
	
	private boolean debugging = false;

	@Override
	public void setDebugging(boolean debugging) {
		this.debugging = debugging;
	}

	@Override
	public boolean isDebugging() {
		return this.debugging;
	}
}