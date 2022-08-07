package ru.gb.lesson2;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class ProductRepository {

    private List<Product> productList;

    @PostConstruct
    private void init() {
        productList = new ArrayList<>(Arrays.asList(
                new Product(1L, "Bread", 20),
                new Product(2L, "Milk", 85),
                new Product(3L, "Beaf", 400),
                new Product(4L, "Rice", 200),
                new Product(5L, "Cheese", 500)
        ));
    }

    public List<Product> findAll(){
        return productList;
    }

    public Product findById(Long id){
        return productList.stream().filter(i -> i.getId().equals(id)).findFirst().get();
    }
}
