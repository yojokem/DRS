package net.frostq.drs.unit.processor;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import net.frostq.drs.unit.Unit;
import net.frostq.drs.unit.Units;

public abstract class Processor implements Callable<Unit> {
	private int code;
	protected ExecutorService executorService 	= Executors.newFixedThreadPool(10),
								multiService	= Executors.newCachedThreadPool();
	
	/*
	 * public Future process(Units units, ProcessResult result) { return
	 * executorService.submit(this::, ProcessResult.class); }
	 */
	public Future<Unit> process(Unit unit) {
		return executorService.submit(this);
	}
	
	public void process(Units units) {
		multiService.submit(() -> {
			
		});
	}
}