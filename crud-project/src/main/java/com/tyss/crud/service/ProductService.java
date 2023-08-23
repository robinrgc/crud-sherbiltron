package com.tyss.crud.service;

import java.util.List;

import com.tyss.crud.dto.ProductDTO;

public interface ProductService {

	List<ProductDTO> getAllProducts();

	void addProduct(ProductDTO dto);

	void deleteProduct(Integer deleteId);

	void editProduct(ProductDTO dto);

}
