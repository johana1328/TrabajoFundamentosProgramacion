package edu.poli.job.core;

import java.io.File;
import java.io.InputStream;
import java.util.Properties;

public class FileStorage {
	private static final String FILE_CONFIG = "config.properties";
	private static final String DIR_PATH = "edu.poli.job.path.repository";

	public static String getProperty(String property) throws CustomException {
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		Properties props = new Properties();
		try (InputStream resourceStream = loader.getResourceAsStream(FILE_CONFIG)) {
			props.load(resourceStream);
		} catch (Exception e) {
			throw new CustomException("Error al leer el archivos de propiedades");
		}
		if (props.containsKey(property)) {
			return props.getProperty(property);
		}
		throw new CustomException("propiedad no encontrada");
	}

	public static void buildRootDir() throws CustomException {
		String dirPath = getProperty(DIR_PATH);
		File dir = new File(dirPath);
		if (!dir.exists()) {
			if (dir.mkdirs()) {
				System.out.println("Directorio creado");
			} else {
				System.out.println("Error al crear directorio");
			}
		}
	}

}
