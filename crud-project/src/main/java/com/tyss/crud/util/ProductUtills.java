package com.tyss.crud.util;

import com.tyss.crud.dto.ProductDTO;
import com.tyss.crud.entity.Product;

public class ProductUtills {
	private ProductUtills() {

	}

	public static ProductDTO entityToDTO(Product x) {
		return ProductDTO.builder().id(x.getId()).productName(x.getProductName())
				.productDescription(x.getProductDescription()).productPrice(x.getProductPrice()).build();
	}

	public static Product dtoToEntity(ProductDTO dto) {
		return Product.builder().productName(dto.getProductName()).productDescription(dto.getProductDescription())
				.productPrice(dto.getProductPrice()).build();
	}

	public static Product dtoToEntityWithId(ProductDTO dto) {
		return Product.builder().id(dto.getId()).productName(dto.getProductName()).productDescription(dto.getProductDescription())
				.productPrice(dto.getProductPrice()).build();
	}

}
