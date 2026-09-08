import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductInventorySystem {

    // Calculate the total inventory value
    public static double calculateTotalValue(List<Double> productPrices, List<Integer> productQuantities) {
        double totalValue = 0;

        if (productPrices.size() != productQuantities.size()) {
            return 0;
        }

        for (int i = 0; i < productPrices.size(); i++) {
            totalValue += productPrices.get(i) * productQuantities.get(i);
        }

        return totalValue;
    }

    // Check the stock status
    public static String checkStockStatus(int quantity) {
        if (quantity < 0) {
            return "Invalid Stock";
        } else if (quantity > 10) {
            return "High Stock";
        } else if (quantity >= 1) {
            return "Available";
        } else {
            return "Out of Stock";
        }
    }

    // Count available and out-of-stock products
    public static int[] countStockStatus(List<Integer> productQuantities) {

        int availableProducts = 0;
        int outOfStockProducts = 0;

        for (int quantity : productQuantities) {

            if (quantity >= 1) {
                availableProducts++;
            } else if (quantity == 0) {
                outOfStockProducts++;
            }
        }

        return new int[]{availableProducts, outOfStockProducts};
    }

    // Find the most expensive product
    public static String findMostExpensiveProduct(List<String> productNames,
                                                  List<Double> productPrices) {

        if (productNames.isEmpty() || productPrices.isEmpty()) {
            return "None";
        }

        double highestPrice = productPrices.get(0);
        String mostExpensiveProduct = productNames.get(0);

        for (int i = 1; i < productPrices.size(); i++) {

            if (productPrices.get(i) > highestPrice) {
                highestPrice = productPrices.get(i);
                mostExpensiveProduct = productNames.get(i);
            }
        }

        return mostExpensiveProduct;
    }

    // Display the inventory report
    public static void displayReport(List<String> productNames,
                                     List<Double> productPrices,
                                     List<Integer> productQuantities,
                                     double totalValue,
                                     int availableProducts,
                                     int outOfStockProducts,
                                     String mostExpensiveProduct) {

        System.out.println("\n========== PRODUCT INVENTORY REPORT ==========");

        for (int i = 0; i < productNames.size(); i++) {

            System.out.println("--------------------------------------------");
            System.out.println("Product Name : " + productNames.get(i));
            System.out.printf("Price        : %.2f%n", productPrices.get(i));
            System.out.println("Quantity     : " + productQuantities.get(i));
            System.out.println("Stock Status : " + checkStockStatus(productQuantities.get(i)));
        }

        System.out.println("--------------------------------------------");
        System.out.printf("Total Inventory Value      : %.2f%n", totalValue);
        System.out.println("Available Products         : " + availableProducts);
        System.out.println("Out of Stock Products      : " + outOfStockProducts);
        System.out.println("Most Expensive Product     : " + mostExpensiveProduct);
    }

    public static void main(String[] args) {

        // Create Scanner
        Scanner input = new Scanner(System.in);

        // Create lists
        List<String> productNames = new ArrayList<>();
        List<Double> productPrices = new ArrayList<>();
        List<Integer> productQuantities = new ArrayList<>();

        // Read information for 10 products
        for (int i = 1; i <= 10; i++) {

            System.out.println("\nEnter details for Product " + i);

            input.nextLine();
            System.out.print("Product Name: ");
            String name = input.nextLine().trim();

            System.out.print("Product Price: ");
            double price = input.nextDouble();

            System.out.print("Product Quantity: ");
            int quantity = input.nextInt();

            productNames.add(name);
            productPrices.add(price);
            productQuantities.add(quantity);
        }

        // Calculate total inventory value
        double totalValue = calculateTotalValue(productPrices, productQuantities);

        // Count stock status
        int[] stockCount = countStockStatus(productQuantities);

        // Find most expensive product
        String expensiveProduct = findMostExpensiveProduct(productNames, productPrices);

        // Display report
        displayReport(productNames,
                productPrices,
                productQuantities,
                totalValue,
                stockCount[0],
                stockCount[1],
                expensiveProduct);

        // Close Scanner
        input.close();
    }
}
