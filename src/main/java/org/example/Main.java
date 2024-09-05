package org.example;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main
{
    public static void main(String[] args)
    {
        ProductManager productManager = new ProductManager();

        Category electronics = new Category(1, "Електроніка");
        Category smartphones = new Category(2, "Смартфони");
        Category accessories = new Category(3, "Аксесуари");

        Product product1 = new Product(1, "Ноутбук", 19999.99, "Високопродуктивний ноутбук для роботи та ігор", electronics);
        Product product2 = new Product(2, "Смартфон", 12999.50, "Смартфон з великим екраном та високою автономністю", smartphones);
        Product product3 = new Product(3, "Навушники", 2499.00, "Бездротові навушники з шумозаглушенням", accessories);

        Scanner scanner = new Scanner(System.in);

        List<Product> products = new ArrayList<>();
        products.add(product1);
        products.add(product2);
        products.add(product3);

        // Оголошення товарів і категорій з попереднього коду
        Cart cart = new Cart();
        while (true)
        {
            System.out.println("\nВиберіть опцію:");
            System.out.println("1 - Переглянути список товарів");
            System.out.println("2 - Додати товар до кошика по ID");
            System.out.println("3 - Додати товар до кошика по назві");
            System.out.println("4 - Видалити товар з кошика по ID");
            System.out.println("5 - Переглянути кошик");
            System.out.println("6 - Зробити замовлення");
            System.out.println("7 - Перевірити історію замовлень");
            System.out.println("0 - Вийти");

            int choice = scanner.nextInt();
            switch (choice)
            {
                case 1:
                    System.out.println(product1);
                    System.out.println(product2);
                    System.out.println(product3);
                    break;
                case 2:
                    System.out.println("Введіть ID товару для додавання до кошика:");

                    int id = scanner.nextInt();

                    for (Product product: products) {
                        if (product.getId() == id) {
                            cart.addProduct(productManager.findProductById(products, id));
                            break;
                        }
                    }
                    if (id > products.size() || id < products.size())
                    {
                        System.out.println("Товар з таким ID не знайдено");
                    }

                    break;
                case 3:
                    System.out.println("Введіть назву товару для додавання до кошика:");

                    String name = scanner.next();
                    boolean isThereName = false;
                    for (Product product: products) {
                        if (product.getName().contains(name)) {
                            cart.addProduct(productManager.findProductByName(products, name));
                            isThereName = true;
                            break;
                        }
                    }
                    if(!isThereName)
                    {
                        System.out.println("Товар з такою назвою не знайдено");
                    }
                    break;
                case 4:
                    System.out.println("Введіть ID товару для видалення з кошика:");

                    id = scanner.nextInt();

                    if (id > products.size() || id < products.size())
                    {
                        System.out.println("Товар з таким ID не знайдено");
                    }

                    for (Product product: products) {
                        if (product.getId() == id) {
                            cart.removeProduct(productManager.findProductById(products, id));
                            break;
                        }
                    }

                    break;
                case 5:
                    System.out.println(cart);
                    break;
                case 6:
                    if (cart.getProducts().isEmpty()) {
                        System.out.println("Кошик порожній. Додайте товари перед оформленням замовлення.");
                    } else {
                        Order order = new Order(cart);
                        System.out.println("Замовлення оформлено:");
                        System.out.println(order);
                        productManager.SaveOrderInfo(order);
                        cart.clear(); // Метод для очищення кошика, який потрібно реалізувати в класі Cart
                    }
                    break;
                case 7:
                    productManager.CheckOrderHistory();
                    break;
                case 0:
                    System.out.println("Дякуємо, що використовували наш магазин!");
                    return;
                default:
                    System.out.println("Невідома опція. Спробуйте ще раз.");
                    break;
            }
        }
    }
}