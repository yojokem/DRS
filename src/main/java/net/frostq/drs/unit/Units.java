package net.frostq.drs.unit;

import java.util.List;
import java.util.function.BinaryOperator;

import com.google.common.collect.Lists;
import com.google.common.collect.Streams;

public class Units {
	public List<Long> unitPackages = Lists.newArrayList();
	public static final int MAX_SIZE = 256;
	
	private Unit[] unit = new Unit[MAX_SIZE];
	
	public void setSize(int size, int offset) {
		Unit[] temp = new Unit[size];
		System.arraycopy(unit, offset, temp, 0, size);
		this.unit = temp;
	}
	
	public void add(Unit u) {
		Unit[] temp = new Unit[this.unit.length + 1];
		System.arraycopy(unit, 0, temp, 0, this.unit.length);
		temp[temp.length - 1] = u;
		this.unit = temp;
	}
	
	public void set(int index, Unit u) {
		assert index >= 0;
		assert unit.length > index;
		
		unit[index] = u;
	}
	
	public void remove(Unit u) {
		Streams.stream(Lists.newArrayList(this.unit).iterator())
			.reduce(new BinaryOperator<Unit>() {
				@Override
				public Unit apply(Unit t, Unit u) {
					return null;
				}
			}); //인터넷 검색하기
	}
	
	public void remove(int index) {
		
	}
	
	public void trim() {
		
	}
	
	public void closeUp() {
		
	}
}