package ru.gb.lesson2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Scanner;

@Configuration
@ComponentScan("ru.gb.lesson2")
public class MyApplication {

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {


        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyApplication.class);

        Cart cart = context.getBean(Cart.class);
        cart.saveProduct(1L);
        cart.saveProduct(2L);
        System.out.println("cart.findAll() " + cart.findAll());
        cart.deleteProduct(1L);

        System.out.println("cart.findAll() " + cart.findAll());


        Cart cart1 = context.getBean(Cart.class);

        cart1.saveProduct(4L);

        System.out.println("cart1.findAll() " + cart1.findAll());

        Cart cart2 = context.getBean(Cart.class);

        while (true){

            String readData = sc.nextLine();

            if (readData.equals("break")){
                break;
            } else if (readData.equals("add")){
                System.out.println("Введите id продукта, который хотите добавить в корзину");
                String readData1 = sc.nextLine();
                cart2.saveProduct(Long.parseLong(readData1));
                System.out.println("cart2.findAll() " + cart2.findAll());
            } else if (readData.equals("delete")){
                System.out.println("Введите id продукта, который хотите удалить из корзины");
                String readData1 = sc.nextLine();
                cart2.deleteProduct(Long.parseLong(readData1));
                System.out.println("cart2.findAll() " + cart2.findAll());
            }

        }

        context.close();

    }


    
}
