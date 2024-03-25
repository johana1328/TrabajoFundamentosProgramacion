package edu.poli.job.service;

import java.util.ArrayList;
import java.util.List;

import edu.poli.job.core.CustomException;
import edu.poli.job.core.FileStorage;
import edu.poli.job.core.JobUtil;
import edu.poli.job.dto.DocType;
import edu.poli.job.dto.SellerDto;

public class SellerService {

	private static final String MAX_USER = "edu.poli.job.total.seller";
	private static final long PREFIX_NUMBER = 92154000;

	public void buildFileSeller() throws NumberFormatException, CustomException {
		List<String> linesFile = new ArrayList<>();
		int max = Integer.parseInt(JobUtil.getProperty(MAX_USER));
		for (int i = 0; i <= max; i++) {
			SellerDto seller = new SellerDto();
			seller.setIdType(DocType.randomType());
			seller.setIdNumber(Long.toString(PREFIX_NUMBER + 1));
			seller.setName("Vendedor" + i);
			seller.setLastname("Apellido" + i);
			linesFile.add(seller.toString());
		}
		FileStorage.buildFile("sellers.txt", linesFile);
	}

}
