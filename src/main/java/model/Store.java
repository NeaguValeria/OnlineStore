package model;

import utils.AplicationConst;
import utils.TxtFileReader;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Store {

    private String name;
    private String address;
    private Map<Product, Integer> products = new HashMap<Product, Integer>();

    public Store(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Map<Product, Integer> getProducts() {
        return products;
    }

    public void setProducts(Map<Product, Integer> products) {
        this.products = products;
    }

    public void buildProductList() {
        TxtFileReader txtFileReader = new TxtFileReader(AplicationConst.PRODUCTS_FILE_PATH);
        ArrayList<String> lines = txtFileReader.read();
        for (String line : lines) {
            String[] tokens = line.split(" ");
            String productName = tokens[0];
            String quantity = tokens[1];
            String price = tokens[2];
            Product product = new Product(productName, BigDecimal.valueOf(Long.parseLong(price)));
            products.put(product, Integer.valueOf(quantity));
        }
    }
}
