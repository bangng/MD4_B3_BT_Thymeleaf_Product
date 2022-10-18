package rikkei.academy.service;

import rikkei.academy.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductServiceIMPL implements IProductService {
    private static final Map<Integer, Product> products;

    static {
        products = new HashMap<>();
        products.put(1, new Product(1, "Banana", 5.5, "Philip"));
        products.put(2, new Product(2, "Orange", 6.5, "China"));
        products.put(3, new Product(3, "Momo", 7.5, "Japan"));
        products.put(4, new Product(4, "Lemon", 8.5, "Laos"));
        products.put(5, new Product(5, "Rice", 9.5, "Viet Nam"));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void save(Product product) {
        product.setId(products.size()+1);
        products.put(product.getId(), product);

    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public void update(int id, Product product) {
        products.put(id, product);

    }

    @Override
    public void remove(int id) {
        products.remove(id);

    }
}
