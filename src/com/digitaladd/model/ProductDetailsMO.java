package com.digitaladd.model;

import java.util.Date;

public class ProductDetailsMO {

	private String productUuid;
	private String productName; 
	private String productUrl;
	private String productDescriptionForSms;
	private String productDescriptionForEmail;
	private String productImageExtension;
	private String country;
	private String state;
	private String city;
	private Date createdAt;
	private Date updatedAt;
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductUrl() {
		return productUrl;
	}
	public void setProductUrl(String productUrl) {
		this.productUrl = productUrl;
	}
	
	public String getProductDescriptionForEmail() {
		return productDescriptionForEmail;
	}
	public void setProductDescriptionForEmail(String productDescriptionForEmail) {
		this.productDescriptionForEmail = productDescriptionForEmail;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getProductUuid() {
		return productUuid;
	}
	public void setProductUuid(String productUuid) {
		this.productUuid = productUuid;
	}
	public String getProductDescriptionForSms() {
		return productDescriptionForSms;
	}
	public void setProductDescriptionForSms(String productDescriptionForSms) {
		this.productDescriptionForSms = productDescriptionForSms;
	}
	public String getProductImageExtension() {
		return productImageExtension;
	}
	public void setProductImageExtension(String productImageExtension) {
		this.productImageExtension = productImageExtension;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date date) {
		this.createdAt = date;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	
	/*override for testing
	 * @Override
	public String toString() {
		return "ProductDetails [productName=" + productName + ", productUrl=" + productUrl
				+ ", productDescriptionForMobile=" + productDescriptionForMobile + ", productDescriptionForEmail="
				+ productDescriptionForEmail + ", country=" + country + ", state=" + state + ", city=" + city + "]";
	}*/
}
