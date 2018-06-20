package com.digitaladd.dao.productdao;

import java.util.ArrayList;

import com.digitaladd.model.ProductDetailsMO;

public interface ProductDao {
	public boolean addProductDetails(ProductDetailsMO productDetails);
	public boolean deleteProductDetails(String productUUID);
	public ArrayList<ProductDetailsMO> getProducts();
	public boolean updateProduct(ProductDetailsMO productDetails);
	public ProductDetailsMO getProductDetailsById(String productUUID);
}
