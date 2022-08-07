package ru.gb.lesson2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;


@Component
@Scope("prototype")
public class Cart {

    private List<Product> productList;



    @PostConstruct
    private void init(){
        productList = new ArrayList<>();
    }

    private ProductRepository productRepository;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    public void saveProduct(Long id){
        productList.add(productRepository.findById(id));
    }

    public void deleteProduct(Long id) {
        productList.remove(productRepository.findById(id));
    }

    public List<Product> findAll(){
        return productList;
    }

}
