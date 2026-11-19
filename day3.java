
/*
Question: E-Commerce Order Management System

Scenario:
You are developing an E-Commerce application that manages
customer orders.

Each order contains Order ID, Customer Name, Product,
Category, Amount, Status and Delivery City.

Task: Using the given Order dataset and Java Stream API:

1. Filter orders based on amount and status.
2. Sort orders by amount.
3. Find the highest and lowest order amounts.
4. Calculate total sales.
5. Count the number of orders.
6. Group orders by category and city.
7. Calculate average order amount.

Objective:
Practice Intermediate Operations, Terminal Operations
and Collectors using a real-world business scenario.
*/

import java.util.*;
import java.util.stream.*;
import java.util.function.*;

class Main {

    static class Order {
        int orderId;
        String customerName;
        String product;
        String category;
        double amount;
        String status;
        String city;

        Order(int orderId, String customerName, String product,
                String category, double amount, String status,
                String city) {

            this.orderId = orderId;
            this.customerName = customerName;
            this.product = product;
            this.category = category;
            this.amount = amount;
            this.status = status;
            this.city = city;
        }

        public String getCategory() {
            return category;
        }

        public String getCity() {
            return city;
        }

        public double getAmount() {
            return amount;
        }

        public String getStatus() {
            return status;
        }

        public String toString() {
            return orderId + " " + customerName + " " +
                    product + " " + category + " " +
                    amount + " " + status + " " + city;
        }
    }

    public static void main(String[] args) {

        // Create Order Dataset
        List<Order> orders = Arrays.asList(
                new Order(101, "Rahul", "Laptop", "Electronics",
                        60000, "Delivered", "Hyderabad"),

                new Order(102, "Priya", "Mobile", "Electronics",
                        25000, "Pending", "Vijayawada"),

                new Order(103, "Arjun", "Shoes", "Fashion",
                        3000, "Delivered", "Chennai"),

                new Order(104, "Sneha", "Watch", "Fashion",
                        5000, "Cancelled", "Hyderabad"),

                new Order(105, "Kiran", "Headphones", "Electronics",
                        2000, "Delivered", "Bangalore"));

        // 1. Filter orders based on amount and status
        System.out.println("\n1. Filtered Orders:");

        orders.stream()
                .filter(o -> o.amount >= 5000 &&
                        o.status.equals("Delivered"))
                .forEach(System.out::println);

        // 2. Sort orders by amount
        System.out.println("\n2. Sorted Orders by Amount:");

        orders.stream()
                .sorted(Comparator.comparingDouble(Order::getAmount))
                .forEach(System.out::println);

        // 3. Find highest and lowest order amounts
        System.out.println("\n3. Highest Order Amount:");

        orders.stream()
                .mapToDouble(Order::getAmount)
                .max()
                .ifPresent(System.out::println);

        System.out.println("Lowest Order Amount:");

        orders.stream()
                .mapToDouble(Order::getAmount)
                .min()
                .ifPresent(System.out::println);

        // 4. Calculate total sales
        double totalSales = orders.stream()
                .mapToDouble(Order::getAmount)
                .sum();

        System.out.println("\n4. Total Sales: " + totalSales);

        // 5. Count number of orders
        long count = orders.stream().count();

        System.out.println("\n5. Total Orders: " + count);

        // 6. Group orders by category
        System.out.println("\n6. Group Orders by Category:");

        Map<String, List<Order>> categoryGroup = orders.stream()
                .collect(Collectors.groupingBy(Order::getCategory));

        categoryGroup.forEach((category, list) -> {
            System.out.println(category + " : " + list);
        });

        // Group orders by city
        System.out.println("\nGroup Orders by City:");

        Map<String, List<Order>> cityGroup = orders.stream()
                .collect(Collectors.groupingBy(Order::getCity));

        cityGroup.forEach((city, list) -> {
            System.out.println(city + " : " + list);
        });

        // 7. Calculate average order amount
        double average = orders.stream()
                .mapToDouble(Order::getAmount)
                .average()
                .orElse(0.0);

        System.out.println("\n7. Average Order Amount: " + average);
    }
}
