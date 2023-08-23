package com.tyss.crud.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ProductDTO {

	private Integer id;
	private String productName;
	private String productDescription;
	private Integer productPrice;
}
