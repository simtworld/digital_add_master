package com.digitaladd.dao.productdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.digitaladd.common.DBConnectionHandler;
import com.digitaladd.model.ProductDetailsMO;
import com.digitaladd.util.ResourceUtility;


@Repository
public class ProductDaoImpl implements ProductDao {
	/*// singleton implementation
	private ProductDaoImpl() {
		// no op.
	}

	// singleton implementation
	public ProductDao getInstance() {
		return ProductDaoHolder.INSTANCE;
	}

	// singleton implementation
	private static class ProductDaoHolder {
		private static final ProductDao INSTANCE = new ProductDaoImpl();
	}*/

	public boolean addProductDetails(ProductDetailsMO productDetails) {
		Connection connection = null;
		ResultSet rs = null;
		PreparedStatement preparedStmt = null;
		boolean flag = false;
		try {
			connection = DBConnectionHandler.getDBConnection();
			preparedStmt = connection.prepareStatement(ResourceUtility.getSqlQuery("degitalAdd.insertProduct"));
			preparedStmt.setString(1, productDetails.getProductUuid()); // incremental umber of uuid
			preparedStmt.setString(2, productDetails.getProductName());
			preparedStmt.setString(3, productDetails.getProductUrl());
			preparedStmt.setString(4, productDetails.getProductDescriptionForSms());
			preparedStmt.setString(5, productDetails.getProductDescriptionForEmail());
			preparedStmt.setString(6, productDetails.getProductImageExtension());
			preparedStmt.setString(7, productDetails.getCountry());
			preparedStmt.setString(8, productDetails.getState());
			preparedStmt.setString(9, productDetails.getCity());
			preparedStmt.setDate(10, new java.sql.Date(productDetails.getCreatedAt().getTime()));
			preparedStmt.setDate(11, new java.sql.Date(productDetails.getUpdatedAt().getTime()));

			int i = preparedStmt.executeUpdate();

			if (i > 0) {
				flag = true;
			}
		} catch (SQLException sx) {
			System.out.println(sx);
		} catch (Exception e) {
			System.out.println("RegistrationDao > addProductDetails() > exception >" + e);
		} finally {
			DBConnectionHandler.closeJDBCResoucrs(connection, preparedStmt, rs);
		}
		return flag;
	}

	/**
	 * This method is for deleting product details from database it takes @param
	 * productUUID
	 * 
	 * @return boolean
	 */
	public boolean deleteProductDetails(String productUUID) {
		Connection connection = null;
		ResultSet rs = null;
		PreparedStatement preparedStmt = null;
		boolean flag = false;
		try {
			connection = DBConnectionHandler.getDBConnection();
			preparedStmt = connection.prepareStatement(ResourceUtility.getSqlQuery("degitalAdd.deleteProduct"));
			preparedStmt.setString(1, productUUID);
			int i = preparedStmt.executeUpdate();

			if (i == 1) {
				flag = true;
			}
			System.out.println(i);

		} catch (SQLException sx) {
			System.out.println(sx);
		} catch (Exception e) {
			System.out.println("RegistrationDao > deleteProductDetails() > exception >" + e);
		} finally {
			DBConnectionHandler.closeJDBCResoucrs(connection, preparedStmt, rs);
		}
		return flag;

	}

	/**
	 * this method is being called by request controller when the request comes to
	 * getProducts url and it fetch the products data returns to that method
	 */
	public ArrayList<ProductDetailsMO> getProducts() {
		ProductDetailsMO productDetails = null;
		ArrayList<ProductDetailsMO> productDetailsList = new ArrayList<>();
		;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = DBConnectionHandler.getDBConnection();
			preparedStatement = connection
					.prepareStatement(ResourceUtility.getSqlQuery("digitalAdd.getAllProductData"));
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {

				productDetails = new ProductDetailsMO();
				productDetails.setProductUuid(resultSet.getString(1));
				productDetails.setProductName(resultSet.getString(2));
				productDetails.setProductUrl(resultSet.getString(3));
				productDetails.setProductDescriptionForSms(resultSet.getString(4));
				productDetails.setProductDescriptionForEmail(resultSet.getString(5));
				productDetails.setProductImageExtension(resultSet.getString(6));
				productDetails.setCountry(resultSet.getString(7));
				productDetails.setState(resultSet.getString(8));
				productDetails.setCity(resultSet.getString(9));
				productDetails.setCreatedAt(resultSet.getDate(10));
				productDetails.setUpdatedAt(resultSet.getDate(11));
				productDetailsList.add(productDetails);
			}
		} catch (SQLException sx) {
			System.out.println(sx);
		} catch (Exception e) {
			System.out.println("ProductDao > getProductDetails() > exception >" + e);
		} finally {
			DBConnectionHandler.closeJDBCResoucrs(connection, preparedStatement, resultSet);
		}
		return productDetailsList;
	}

	public boolean updateProduct(ProductDetailsMO productDetails) {
		boolean flag = false;

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		try {
			connection = DBConnectionHandler.getDBConnection();
			preparedStatement = connection.prepareStatement(ResourceUtility.getSqlQuery("digitalAdd.updateProduct"));
			preparedStatement.setString(0, productDetails.getProductName());
			preparedStatement.setString(2, productDetails.getProductUrl());
			preparedStatement.setString(3, productDetails.getProductDescriptionForSms());
			preparedStatement.setString(4, productDetails.getProductDescriptionForEmail());
			preparedStatement.setString(5, productDetails.getProductImageExtension());
			preparedStatement.setString(6, productDetails.getCountry());
			preparedStatement.setString(7, productDetails.getState());
			preparedStatement.setString(8, productDetails.getCity());
			preparedStatement.setDate(9, new java.sql.Date(productDetails.getUpdatedAt().getTime()));
			preparedStatement.setString(10, productDetails.getProductUuid());
			int i = preparedStatement.executeUpdate();

			if (i == 1) {
				flag = true;
			}
		} catch (SQLException sx) {
			System.out.println(sx);
		} catch (Exception e) {
			System.out.println("ProductDao > updateProductDetails() > exception >" + e);
		} finally {
			DBConnectionHandler.closeJDBCResoucrs(connection, preparedStatement, rs);
		}
		return flag;

	}

	public ProductDetailsMO getProductDetailsById(String productUUID) {
		ProductDetailsMO productDetailsMO = new ProductDetailsMO();

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = DBConnectionHandler.getDBConnection();
			preparedStatement = connection
					.prepareStatement(ResourceUtility.getSqlQuery("digitalAdd.getAllProductDataById"));
			preparedStatement.setString(1, productUUID);
			System.out.println(productUUID);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				productDetailsMO.setProductUuid(resultSet.getString(1));
				productDetailsMO.setProductName(resultSet.getString("product_name"));
				productDetailsMO.setProductUrl(resultSet.getString("product_url"));
				productDetailsMO.setProductDescriptionForSms(resultSet.getString("product_description_sms"));
				productDetailsMO.setProductDescriptionForEmail(resultSet.getString("product_description_email"));
				productDetailsMO.setProductImageExtension(resultSet.getString("product_image_extension"));
				productDetailsMO.setCountry(resultSet.getString("product_country_id"));
				productDetailsMO.setState(resultSet.getString("product_state_id"));
				productDetailsMO.setCity(resultSet.getString("product_city_id"));
				productDetailsMO.setCreatedAt(resultSet.getDate("created_at"));
				// productDetailsMO.setUpdatedAt(resultSet.getDate("updated_at"));
			}
		} catch (SQLException sx) {
			System.out.println(sx);
		} catch (Exception e) {
			System.out.println("ProductDao > getProductDetailsById() > exception >" + e);
			e.printStackTrace();
		} finally {
			DBConnectionHandler.closeJDBCResoucrs(connection, preparedStatement, resultSet);
		}

		return productDetailsMO;
	}

}
