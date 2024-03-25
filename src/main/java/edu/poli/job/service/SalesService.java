package edu.poli.job.service;

import java.util.ArrayList;
import java.util.List;

import edu.poli.job.core.CustomException;
import edu.poli.job.core.FileStorage;
import edu.poli.job.core.JobUtil;
import edu.poli.job.dto.ProductDto;
import edu.poli.job.dto.SaleDto;
import edu.poli.job.dto.SellerDto;

public class SalesService {

	public void buildSalesFile(List<SellerDto> sellers, List<ProductDto> products) throws CustomException {
		List<String> linesFile = new ArrayList<>();
		for (SellerDto seller : sellers) {
			List<ProductDto> productsSold = getProductsSold(products);
			for (ProductDto product : productsSold) {
				SaleDto sale = new SaleDto();
				sale.setSeller(seller);
				sale.setProduct(product);
				sale.setCantidadProduct(JobUtil.getRandomInt(1, 10));
				linesFile.add(sale.toString());
			}
			StringBuilder fileName = new StringBuilder("V").append(seller.getIdNumber()).append(".txt");
			FileStorage.buildFile(fileName.toString(), linesFile);
			linesFile= new ArrayList<>();
		}
	}

	private List<ProductDto> getProductsSold(List<ProductDto> products) {
		List<ProductDto> productsResponse = new ArrayList<>();
		int maxSales = 5;
		if (maxSales > products.size()) {
			maxSales = products.size();
		}
		int[] poductList = JobUtil.getRandomList(maxSales, products.size()-1);
		System.out.println(poductList.length);
		for (int i = 0; i < poductList.length; i++) {
			productsResponse.add(products.get(poductList[i]));
		}
		return productsResponse;
	}

}
