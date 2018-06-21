package com.digitaladd.service.product;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.digitaladd.dao.productdao.ProductDao;
import com.digitaladd.model.ProductDetailsMO;
import com.digitaladd.util.RandomGenerator;
import com.digitaladd.util.ResourceUtility;

@Service("productService")
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	ProductDao productDao;

	@Override
	public boolean addProductDetails(String fileName, String filePath, MultipartFile file, ProductDetailsMO productDetails) {
		boolean flag=false;
		try {
			byte barr[] = file.getBytes();
			BufferedOutputStream bout = new BufferedOutputStream(new FileOutputStream(filePath + fileName));

			StringBuffer buffer = new StringBuffer(ResourceUtility.getCommonConstant("user.uuid.starts.with"));
			buffer.append(RandomGenerator
					.generateNumericRandom(Integer.parseInt(ResourceUtility.getCommonConstant("user.uuid.length"))));
			productDetails.setCreatedAt(Calendar.getInstance().getTime());
			productDetails.setUpdatedAt(Calendar.getInstance().getTime());
			productDetails.setProductUuid(buffer.toString());
			productDetails.setProductImageExtension(filePath + fileName);
			flag = productDao.addProductDetails(productDetails);
			bout.write(barr);
			bout.flush();
			bout.close();

		} catch (Exception e) {
			System.out.println("ProductServiceImpl > addProductDetails >"+e);
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public boolean deleteProductDetails(String productUUID) {
		return productDao.deleteProductDetails(productUUID);
	}

	@Override
	public ArrayList<ProductDetailsMO> getProducts() {
		return productDao.getProducts();
	}

	@Override
	public boolean updateProduct(ProductDetailsMO productDetails) {
		return productDao.updateProduct(productDetails);
	}

	

}
