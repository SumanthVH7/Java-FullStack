import java.util.Scanner;

interface Welcome {
    void show();
}

interface GST {
    double calculate(double price);
}

interface Bill {
    double calculate(double price, int quantity);
}

interface Discount {
    double calculate(double amount);
}

interface FinalBill {
    double calculate(double amount);
}

public class day2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Welcome w = () -> System.out.println("Welcome to Shopping!");
        w.show();

        System.out.print("Enter price: ");
        double price = sc.nextDouble();

        System.out.print("Enter quantity: ");
        int quantity = sc.nextInt();

        GST gst = p -> p * 18 / 100;
        System.out.println("GST: " + gst.calculate(price));

        Bill bill = (p, q) -> p * q;
        double total = bill.calculate(price, quantity);
        System.out.println("Total Bill: " + total);

        Discount discount = a -> a * 10 / 100;
        System.out.println("Discount: " + discount.calculate(total));

        FinalBill fb = a -> {
            double d = a * 10 / 100;
            return a - d;
        };

        System.out.println("Final Amount: " + fb.calculate(total));

        sc.close();
    }
}