package net.frostq.drs.store;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import net.frostq.drs.unit.Data;
import net.frostq.drs.unit.Unit;
import net.frostq.drs.unit.Units;

public class Environment {
	private Path 	env_folder,
					config_folder,
					unit_folder,
					units_folder,
					data_folder;
	
	/**
	 * Environment for the <code>{@link Store}</code>
	 * @param env_folder_path 환경 폴더 경로 | The path of the Environment folder
	 */
	public Environment(String env_folder_path) {
		env_folder = Paths.get(env_folder_path);
		this.initialConfigure();
	}
	
	/**
	 * Export a {@link Unit} to the given directory.
	 * @param dir Directory to export a {@link Unit}
	 * @param u {@link Unit} to export
	 */
	public void export(Path dir, Unit u) {
		assert Files.isDirectory(dir);
		u.export(dir);
	}
	
	/**
	 * Export a {@link Units} to the given directory.
	 * @param dir Directory to export a {@link Units}
	 * @param us {@link Units} to export
	 */
	public void export(Path dir, Units us) {
		assert Files.isDirectory(dir);
		us.export(dir);
	}
	
	/**
	 * Export a {@link Data} to the given directory.
	 * @param dir Directory to export a {@link Data}
	 * @param d {@link Data} to export
	 */
	public void export(Path dir, Data d) {
		assert Files.isDirectory(dir);
		d.export(dir);
	}
	
	/*
	 * 이제 export를 하면 어떡할 거니?
	 * 뭐... ObjectOutputStream? 아니면... 다른 직렬화 방법이 있으려나?
	 * Serializable로 다른 독자적 방식도 좋지만 귀찮다구...
	 * 근데 Units나 Data로 Unit 하여튼 상위단위체로 묶으려면 필요할 거 아니야...하 참
	 */
	
	protected void initialConfigure() {
		config_folder = Paths.get(env_folder + "/config");
		unit_folder = Paths.get(env_folder + "/unit");
		units_folder = Paths.get(env_folder + "/units");
		data_folder = Paths.get(env_folder + "/data");
		
		initFolder(env_folder);
		initFolder(config_folder);
		initFolder(unit_folder);
		initFolder(units_folder);
		initFolder(data_folder);
	}
	
	protected void initFolder(Path p) {
		assert !Files.isDirectory(p) || Files.notExists(p);
		
		try {
			Files.createDirectory(p);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * <b>Method for Environmental Inspection</b> : 
	 * This inspects the folder of the Environment for the constant configuration.
	 * <br>
	 * <b>환경 조사 메소드</b> : 환경 폴더가 일정한 구성 요소를 만족하는지 조사
	 */
	public void inspect() {
		
	}
}