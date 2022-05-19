package ru.geekbrains.Online_store_V10;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.geekbrains.Online_store_V10.model.Customer;
import ru.geekbrains.Online_store_V10.model.Products;
import ru.geekbrains.Online_store_V10.service.*;
import ru.geekbrains.Online_store_V10.sessionfactory.SessionFactoryUtils;


@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);

        SessionFactoryUtils sessionFactoryUtils = new SessionFactoryUtils();
        sessionFactoryUtils.init();
        try {

             CartDao cartDao = new CartService();
             cartDao.showCart(2l);

//            ProductsDao productsDao = new ProductService(sessionFactoryUtils);
//            productsDao.addProduct(new Products("butter", 45l));
//            productsDao.addProduct(new Products("carrot", 56l));
//            productsDao.addProduct(new Products("orange", 76l));
//            productsDao.addProduct(new Products("tea", 73l));
//
//            CustomerDao customerDao = new CustomerService(sessionFactoryUtils);
//            customerDao.addCustomer(new Customer("Bob"));
//            customerDao.addCustomer(new Customer("John"));
//            customerDao.addCustomer(new Customer("Jack"));
//            customerDao.addCustomer(new Customer("Tom"));

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sessionFactoryUtils.factoryClose();
        }

    }

}
