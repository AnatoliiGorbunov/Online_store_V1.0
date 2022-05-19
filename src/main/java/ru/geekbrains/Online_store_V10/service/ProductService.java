package ru.geekbrains.Online_store_V10.service;

import org.hibernate.Session;
import ru.geekbrains.Online_store_V10.model.Products;
import ru.geekbrains.Online_store_V10.sessionfactory.SessionFactoryUtils;

public class ProductService implements ProductsDao {

    private SessionFactoryUtils sessionFactoryUtils;

    public ProductService(SessionFactoryUtils sessionFactoryUtils) {
        this.sessionFactoryUtils = sessionFactoryUtils;
    }

    @Override
    public void addProduct(Products products) {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            session.saveOrUpdate(products);
            session.getTransaction().commit();
        }
    }
}
