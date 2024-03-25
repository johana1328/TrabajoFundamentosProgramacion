package edu.poli.job.service;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import edu.poli.job.core.CustomException;
import edu.poli.job.core.FileStorage;
import edu.poli.job.core.JobUtil;
import edu.poli.job.dto.ProductDto;

public class ProductService {
	private static final double MIN_VALUE=2000;
	private static final double MAX_VALUE=20000;
	private static final String MAX_PRODUCT = "edu.poli.job.total.product";
	
	public void buildFilePoduct() throws NumberFormatException, CustomException {
		List<String> linesFile = new ArrayList<>();
		int max = Integer.parseInt(JobUtil.getProperty(MAX_PRODUCT));
		for (int i = 0; i <= max; i++) {
			ProductDto productDto = new ProductDto();
			productDto.setIdProduct("00"+i);
			productDto.setNameProduct("producto" + i);
			Double rand = Math.floor(Math.random() * (MAX_VALUE - MIN_VALUE + MIN_VALUE)) + MIN_VALUE;
			DecimalFormat formato = new DecimalFormat("#,###.###");
			String valorFormateado = formato.format(rand);

			productDto.setSaleProduct("$"+ valorFormateado );
			linesFile.add(productDto.toString());
		}
		FileStorage.buildFile("product.txt", linesFile);
	}

}
