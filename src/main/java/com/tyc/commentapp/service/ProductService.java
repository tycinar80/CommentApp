package com.tyc.commentapp.service;

import com.tyc.commentapp.repository.IProductRepository;
import com.tyc.commentapp.repository.entity.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.PreparedStatement;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final IProductRepository productRepository;

    public Product save(Product product) {
        return productRepository.save(product);
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Optional<List<Product>> findAllOptionalByPriceGreaterThan(double price) {
        return findAllOptionalByPriceGreaterThan(price);
    }

    public Optional<List<Product>> findAllOptionalByExpirationDateBefore(LocalDate date) {
        return findAllOptionalByExpirationDateBefore(date);
    }

    public Optional<List<Product>> findAllOptionalByExpirationDateAfterOrExpirationDateIsNull(LocalDate date) {
        return findAllOptionalByExpirationDateAfterOrExpirationDateIsNull(date);
    }

    public Optional<List<Object[]>> searchProductWithPrice() {
        return searchProductWithPrice();
    }

    public int countAllByExirationDate(LocalDate date) {
        return countAllByExirationDate(date);
    }

    public Optional<List<Product>> findAllOptionalByPriceIn(List<Double> prices) {
        return findAllOptionalByPriceIn(prices);
    }

    public Optional<List<Product>> findAllOptionalByNameIn(List<String> productNames) {
        return findAllOptionalByNameIn(productNames);
    }

    public List<Product> findAllOptionalByExpirationDateBetween() {
        LocalDate now = LocalDate.now();
        LocalDate nextDate = LocalDate.now().plusMonths(6);

        List<Product> productList = productRepository.findAllOptionalByExpirationDateBetween(now, nextDate).get();
        productList.forEach(x-> x.setPrice(x.getPrice() * 0.9));
        return productList;
    }


}
