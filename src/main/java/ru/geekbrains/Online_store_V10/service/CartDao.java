package ru.geekbrains.Online_store_V10.service;


import ru.geekbrains.Online_store_V10.model.Products;

import java.util.List;

public interface CartDao {

    void addProductCart(Long customerId, Products products);
    public List showCart(Long id);
}
