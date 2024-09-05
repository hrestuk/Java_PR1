package org.example;

import lombok.Data;

import java.util.List;

@Data
public class ProductManager
{
    private String orderHistory = "";
    public Product findProductById(List<Product> products, int id)
    {
        for (Product product : products)
        {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    public Product findProductByName(List<Product> products, String productName)
    {
        for (Product product : products)
        {
            if (product.getName().equalsIgnoreCase(productName)) {
                return product;
            }
        }
        return null;
    }

    public void CheckOrderHistory()
    {
        System.out.println(orderHistory);
    }
    public void SaveOrderInfo(Order order)
    {
        orderHistory += order.toString() + "\n";
    }

}
