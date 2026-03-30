package main;

import model.*;
import service.ProductService;
import service.CartService;
import service.OrderService;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ProductService ps = new ProductService();
        CartService cs = new CartService();
        OrderService os = new OrderService();

        String user = "USER_1";

        while (true) {
            System.out.println("\n1.Add Product\n2.View Products\n3.Add to Cart\n4.View Cart\n7.Place Order\n9.View Orders\n0.Exit");

            int ch = sc.nextInt();

            switch (ch) {
                case 1:
                    System.out.print("ID Name Price Stock: ");
                    ps.addProduct(new Product(
                        sc.next(), sc.next(), sc.nextDouble(), sc.nextInt()
                    ));
                    break;

                case 2:
                    ps.viewProducts();
                    break;

                case 3:
                    System.out.print("ProductID Qty: ");
                    Product p = ps.getProduct(sc.next());
                    int qty = sc.nextInt();
                    cs.getCart(user).addItem(p, qty);
                    break;

                case 4:
                    System.out.println(cs.getCart(user).items);
                    break;

                case 5:
                    os.placeOrder(user, cs.getCart(user));
                    break;

                case 6:
                    os.viewOrders();
                    break;

                case 0:
                    return;
            }
        }
    }
}