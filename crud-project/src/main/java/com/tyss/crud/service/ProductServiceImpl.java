package com.tyss.crud.service;

import static com.tyss.crud.constant.ProductConstants.PRODUCT_NOT_FOUND;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.tyss.crud.dto.ProductDTO;
import com.tyss.crud.entity.Product;
import com.tyss.crud.exception.ProductException;
import com.tyss.crud.repository.ProductRepository;
import com.tyss.crud.util.ProductUtills;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {

	private final ProductRepository productRepository;
	private final ModelMapper modelMapper;

	@Override
	public List<ProductDTO> getAllProducts() {
		List<Product> findAll = productRepository.findAll();
		return findAll.stream().map(ProductUtills::entityToDTO).collect(Collectors.toList());
	}

	@Override
	public void addProduct(ProductDTO dto) {
		Product product = ProductUtills.dtoToEntity(dto);
		product.setDate(LocalDateTime.now());
		productRepository.save(product);

	}

	@Override
	public void deleteProduct(Integer deleteId) {
		Optional<Product> prodOptional = productRepository.findById(deleteId);
		if (prodOptional.isPresent())
			productRepository.delete(prodOptional.get());
		else
			throw new ProductException(PRODUCT_NOT_FOUND);
	}

	@Override
	public void editProduct(ProductDTO dto) {
		Optional<Product> optional = productRepository.findById(dto.getId());
		if (optional.isPresent()) {
			/*
			 * Product product = optional.get(); modelMapper.map(dto, product);
			 */
			Product update = ProductUtills.dtoToEntityWithId(dto);
			productRepository.save(update);
			return;
		}
		throw new ProductException(PRODUCT_NOT_FOUND);

	}

}
