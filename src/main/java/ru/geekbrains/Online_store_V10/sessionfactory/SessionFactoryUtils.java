package ru.geekbrains.Online_store_V10.sessionfactory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;
import ru.geekbrains.Online_store_V10.model.Customer;
import ru.geekbrains.Online_store_V10.model.Products;
import ru.geekbrains.Online_store_V10.service.CartDao;


@Component
public class SessionFactoryUtils {

    private SessionFactory factory;

    public void init() {
        factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Products.class)
                .addAnnotatedClass(Customer.class)
                .buildSessionFactory();
    }

    public Session getSession() {
        return factory.getCurrentSession();
    }

    public void factoryClose() {
        if (factory != null) {
            factory.close();
        }
    }
}
