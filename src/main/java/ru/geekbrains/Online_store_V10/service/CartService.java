package ru.geekbrains.Online_store_V10.service;

import org.hibernate.Session;
import ru.geekbrains.Online_store_V10.DTO.ProductsDto;
import ru.geekbrains.Online_store_V10.model.Customer;
import ru.geekbrains.Online_store_V10.model.Products;
import ru.geekbrains.Online_store_V10.sessionfactory.SessionFactoryUtils;

import java.util.List;
import java.util.stream.Collectors;

public class CartService implements CartDao {

    private SessionFactoryUtils sessionFactoryUtils;

    @Override
    public void addProductCart(Long customerId, Products products) {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            Customer customer = session.find(Customer.class, customerId);
            customer.getProductsList().add(products);
            session.saveOrUpdate(customer);
            session.getTransaction().commit();
        }

    }

    @Override
    public List showCart(Long id) {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            Customer customer = session.find(Customer.class, id);
            List<Products> productsList = customer.getProductsList();
            List<ProductsDto> productsDtos = productsList.stream()
                    .map(p -> new ProductsDto(p.getId(), p.getTitle(), p.getCost()))
                    .collect(Collectors.toList());
                    session.saveOrUpdate(customer);
            session.getTransaction().commit();
            System.out.println(productsDtos);
            return productsDtos;
        }
    }


}
