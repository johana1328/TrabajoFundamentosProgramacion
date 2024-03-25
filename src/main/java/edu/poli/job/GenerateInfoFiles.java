package edu.poli.job;

import edu.poli.job.core.CustomException;
import edu.poli.job.core.FileStorage;
import edu.poli.job.service.SellerService;

public class GenerateInfoFiles {

	public static void main(String[] args) {
		try {
			FileStorage.buildRootDir();
			SellerService service = new SellerService();
			service.buildFileSeller();
		} catch (CustomException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
