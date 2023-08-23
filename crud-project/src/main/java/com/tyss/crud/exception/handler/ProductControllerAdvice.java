package com.tyss.crud.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.tyss.crud.exception.ProductException;
import com.tyss.crud.response.ErrorResponse;

@RestControllerAdvice
public class ProductControllerAdvice {

	@ExceptionHandler(value = ProductException.class)
	public ResponseEntity<ErrorResponse> handler(ProductException exe) {
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.body(ErrorResponse.builder().error(exe.getMessage()).build());
	}
}
