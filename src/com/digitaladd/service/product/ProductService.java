package com.digitaladd.service.product;

import java.util.ArrayList;

import org.springframework.web.multipart.MultipartFile;

import com.digitaladd.model.ProductDetailsMO;

public interface ProductService {
	boolean addProductDetails(String fileName,String filePath,MultipartFile file,ProductDetailsMO productDetails);
	boolean deleteProductDetails(String productUUID);
	ArrayList<ProductDetailsMO> getProducts();
	boolean updateProduct(ProductDetailsMO productDetails);
}
