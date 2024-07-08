package com.java.learning.lld.marketplacesystem;

import java.util.List;

interface ProductService {
    Product addProduct(Product product);
    Product updateProduct(Product product);
    Product removeProduct(Product product);

    List<Product> searchProduct(String searchKeyword);
}
