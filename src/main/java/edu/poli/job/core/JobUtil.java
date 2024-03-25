package edu.poli.job.core;

import java.io.InputStream;
import java.util.Properties;

public class JobUtil {
	private static final String FILE_CONFIG = "config.properties";

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
}
