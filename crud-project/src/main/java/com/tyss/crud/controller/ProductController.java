package com.tyss.crud.controller;

import static com.tyss.crud.constant.ProductConstants.PRODUCT_ADDED;
import static com.tyss.crud.constant.ProductConstants.PRODUCT_DELETED;
import static com.tyss.crud.constant.ProductConstants.PRODUCT_FETCHED;
import static com.tyss.crud.constant.ProductConstants.PRODUCT_UPDATED;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tyss.crud.dto.ProductDTO;
import com.tyss.crud.response.SuccessResponse;
import com.tyss.crud.service.ProductService;

import lombok.RequiredArgsConstructor;

@RequestMapping(path = "api/v1/products")
@RequiredArgsConstructor
@CrossOrigin
@RestController
public class ProductController {

	private final ProductService productService;

	@PostMapping(path = "/product")
	public ResponseEntity<SuccessResponse<String>> addProduct(@RequestBody ProductDTO dto) {
		productService.addProduct(dto);
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(SuccessResponse.<String>builder().message(PRODUCT_ADDED).build());
	}

	@GetMapping(path = "/products")
	public ResponseEntity<SuccessResponse<List<ProductDTO>>> getAllProducts() {
		List<ProductDTO> products = productService.getAllProducts();
		return ResponseEntity.status(HttpStatus.OK)
				.body(SuccessResponse.<List<ProductDTO>>builder().data(products).message(PRODUCT_FETCHED).build());
	}

	@DeleteMapping(path = "/product/{deleteId}")
	public ResponseEntity<SuccessResponse<Integer>> deleteProduct(@PathVariable Integer deleteId) {
		productService.deleteProduct(deleteId);
		return ResponseEntity.status(HttpStatus.OK)
				.body(SuccessResponse.<Integer>builder().data(deleteId).message(PRODUCT_DELETED).build());
	}

	@PutMapping(path = "/product")
	public ResponseEntity<SuccessResponse<Integer>> editProduct(@RequestBody ProductDTO dto) {
		productService.editProduct(dto);
		return ResponseEntity.status(HttpStatus.OK)
				.body(SuccessResponse.<Integer>builder().message(PRODUCT_UPDATED).build());
	}

}
