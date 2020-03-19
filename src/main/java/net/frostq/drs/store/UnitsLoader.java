package net.frostq.drs.store;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class UnitsLoader {
	public void load(Path p) throws IOException {
		final ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(p));
		
	}
}