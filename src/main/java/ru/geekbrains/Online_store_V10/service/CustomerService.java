package ru.geekbrains.Online_store_V10.service;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.thymeleaf.spring5.processor.SpringErrorClassTagProcessor;
import ru.geekbrains.Online_store_V10.model.Customer;
import ru.geekbrains.Online_store_V10.sessionfactory.SessionFactoryUtils;


public class CustomerService implements CustomerDao {

    private SessionFactoryUtils sessionFactoryUtils;

    public CustomerService(SessionFactoryUtils sessionFactoryUtils) {
        this.sessionFactoryUtils = sessionFactoryUtils;
    }

    @Override
    public void addCustomer(Customer customer) {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            session.saveOrUpdate(customer);
            session.getTransaction().commit();
        }
    }
}
