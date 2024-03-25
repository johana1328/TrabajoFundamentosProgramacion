package edu.poli.job;

import edu.poli.job.core.CustomException;
import edu.poli.job.core.FileStorage;
import edu.poli.job.service.ProductService;
import edu.poli.job.service.SellerService;

public class GenerateInfoFiles {

	public static void main(String[] args) {
		try {
			FileStorage.buildRootDir();
			SellerService service = new SellerService();
			service.buildFileSeller();
			ProductService productService = new ProductService();
			productService.buildFilePoduct();
		} catch (CustomException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
