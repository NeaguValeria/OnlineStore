package service;

import model.Product;
import model.User;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Logger;

public class BuyService {
    private static final Logger logger = Logger.getLogger(BuyService.class.getName());
    Map<Product,Integer> shoppingCart = new HashMap<Product,Integer>();
    Map<Product,Integer> productList;

    public BuyService(Map<Product, Integer> products) {
        productList = products;
    }

    public Product getProductByName(String name){
        Iterator<Map.Entry<Product, Integer>> itr = productList.entrySet().iterator();
        while (itr.hasNext()) {
            Map.Entry<Product, Integer> map = itr.next();
            Product product = map.getKey();
            if(name.equals(product.getName())){
                return  product;
            }
        }
        logger.warning(name + "was not found");
        return null;
    }


    public void diplayAvailableProducts() {
        StringBuilder stringBuilder = new StringBuilder();
        Iterator<Map.Entry<Product, Integer>> itr = productList.entrySet().iterator();
        while (itr.hasNext()) {
            Map.Entry<Product, Integer> map = itr.next();
            Product product = map.getKey();
            Integer quantity = map.getValue();
            stringBuilder.append("Product name: ").append(product.getName()).append(" | ");
            stringBuilder.append("Quantity: ").append(quantity).append(" | ");
            stringBuilder.append("Product price: ").append(product.getPrice()).append(" | ");
            System.err.println(stringBuilder);
            stringBuilder.delete(0, stringBuilder.length());
        }
    }

    public void displayShoppingCart(User user){
        System.out.println( "======");
        if(user != null){
            System.out.println("user: " + user.getUserId());
            System.out.println("Shopping List" );
        } else {
            System.out.println("no user logged");
        }
        Iterator<Map.Entry<Product, Integer>> itr = shoppingCart.entrySet().iterator();
        StringBuilder stringBuilder = new StringBuilder();
        while (itr.hasNext()) {
            Map.Entry<Product, Integer> map = itr.next();
            Product product = map.getKey();
            Integer quantity = map.getValue();
            stringBuilder.append("Product name: ").append(product.getName()).append(" | ");
            stringBuilder.append("Quantity: ").append(quantity).append(" | ");
            stringBuilder.append("Product price: ").append((product.getPrice().intValue() * quantity)).append(" | ");
            System.err.println(stringBuilder);
            stringBuilder.delete(0, stringBuilder.length());
        }
        System.out.println( "======");
    }

    public void buyProduct(User user){
        if(user != null){
            System.out.println("Product you want to buy: ");
            Scanner scanner = new Scanner(System.in);
            String productName = scanner.nextLine();
            System.out.println("Quantity: ");
            Integer quantity = scanner.nextInt();
            Product product = getProductByName(productName);
            if(product != null) {
                shoppingCart.put(product,quantity);
            }
        }else{
            logger.warning("You have to login first, before start buying products!");
        }
    }
}
