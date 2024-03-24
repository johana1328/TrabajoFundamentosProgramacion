package edu.poli.job;

import edu.poli.job.core.CustomException;
import edu.poli.job.core.FileStorage;

public class GenerateInfoFiles {

	public static void main(String[] args) {
		try {
			FileStorage.buildRootDir();
		} catch (CustomException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
