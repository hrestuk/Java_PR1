package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Product
{
    private int id;
    private String name;
    private double price;
    private String description;

    @Override
    public String toString()
    {
        return "Товар{" +
                "id=" + id +
                ", назва='" + name + '\'' +
                ", ціна=" + price +
                ", опис='" + description + '\'' +
                '}';
    }


}
