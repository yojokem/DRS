package net.frostq.drs;

/**
 * Console Printer Interface for classes
 * @author FrostQ
 */
public interface ConsolePrinter {
	/**
	 * Get the prefix name of the class
	 * @return Prefix name of the class
	 */
	public String getPrefix();
	/**
	 * Get the suffix name of the class
	 * @return suffix name of the class
	 */
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
	
	/**
	 * Set the status of debugging.
	 * @param debugging the boolean value for debugging
	 */
	public void setDebugging(boolean debugging);
	/**
	 * Get the status of debugging
	 * @return the status boolean value for debugging
	 */
	public boolean isDebugging();
	
	public default void debug(Object m) {
		if(this.isDebugging()) outprintln("[DEBUG] " + m);
	}
}