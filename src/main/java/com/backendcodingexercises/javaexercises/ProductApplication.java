package com.backendcodingexercises.javaexercises;

import java.util.List;
import java.util.stream.Collectors;

public class ProductApplication {
    public static void main(String[] args) {

        var products = List.of(
                new Product("Iphone 16 Pro Max", "Iphone", 1299.9),
                new Product("Iphone 16 Pro", "Iphone", 1199.9),
                new Product("Samsung Galaxy Z Fold", "Android", 1568.9),
                new Product("Samsung Galaxy Z Flip", "Android", 1648.9)
        );

        var avgPriceByCategory = products.stream()
                .collect(Collectors.groupingBy(
                        Product::getCategory,
                        Collectors.averagingDouble(Product::getPrice)
                ));

        avgPriceByCategory.forEach((category, avgPrice) ->
                System.out.println(category + " -> " + avgPrice));

    }
}