package edu.poli.job.dto;

import java.io.Serializable;

public class SaleDto implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String CSV_SEPARATOR = ";";

	
	private SellerDto seller;
	private String idProduct;
	private String cantidadProduct;
	
	public String getIdProduct() {
		return idProduct;
	}
	public void setIdProduct(String idProduct) {
		this.idProduct = idProduct;
	}
	public String getCantidadProduct() {
		return cantidadProduct;
	}
	public void setCantidadProduct(String cantidadProduct) {
		this.cantidadProduct = cantidadProduct;
	}
	public SellerDto getSeller() {
		return seller;
	}
	public void setSeller(SellerDto seller) {
		this.seller = seller;
	}
	
	@Override
	public String toString() {
		return new StringBuilder(seller.getIdNumber()).append(CSV_SEPARATOR).append(idProduct).append(CSV_SEPARATOR)
				.append(cantidadProduct).toString();
	}
	
	
	

}
