package net.frostq.drs;

public interface ConsolePrinter {
	public String getPrefix();
	public String getSuffix();
	
	public default void outprint(Object m) {
		System.out.print(m);
	}
	
	public default void outprintln(Object m) {
		System.out.println((getPrefix().trim() + " " + m + " " + getSuffix()).trim());
	}
	
	public default void errprint(Object m) {
		System.err.print(m);
	}
	
	public default void errprintln(Object m) {
		System.err.println((getPrefix().trim() + " [ERR] " + m + " " + getSuffix()).trim());
	}
	
	public default void info(Object m) {
		outprintln("[INFO] " + m);
	}
	
	public void setDebugging(boolean debugging);
	public boolean isDebugging();
	
	public default void debug(Object m) {
		if(this.isDebugging()) outprintln("[DEBUG] " + m);
	}
}