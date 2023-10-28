package CodeAlpha_internship_;

import java.util.Scanner;

public class task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Currency Converter");
        System.out.println("Available currencies: USD, EUR, GBP");
        System.out.println("-----------------------------------");

        System.out.print("Enter the amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine(); // Consume the newline character
        System.out.println("----------------------------------------");
        System.out.print("Enter the source currency (e.g., USD): ");
        String sourceCurrency = scanner.nextLine().toUpperCase();

        System.out.print("Enter the target currency (e.g., EUR): ");
        String targetCurrency = scanner.nextLine().toUpperCase();

        double conversionRate = getConversionRate(sourceCurrency, targetCurrency);

        if (conversionRate == -1) {
            System.out.println("Invalid currency selection.");
        } else {
            double convertedAmount = amount * conversionRate;
            System.out.println(
                    amount + " " + sourceCurrency + " is equivalent to " + convertedAmount + " " + targetCurrency);
        }

        scanner.close();
    }

    private static double getConversionRate(String sourceCurrency, String targetCurrency) {
        // You would typically use an API or database to get actual conversion rates.
        // For simplicity, we'll use hardcoded rates for illustration.

        double usdToEur = 0.85;
        double usdToGbp = 0.73;
        double eurToGbp = 0.86;

        sourceCurrency = sourceCurrency.toUpperCase();
        targetCurrency = targetCurrency.toUpperCase();

        if (sourceCurrency.equals("USD") && targetCurrency.equals("EUR")) {
            return usdToEur;
        } else if (sourceCurrency.equals("USD") && targetCurrency.equals("GBP")) {
            return usdToGbp;
        } else if (sourceCurrency.equals("EUR") && targetCurrency.equals("GBP")) {
            return eurToGbp;
        } else if (sourceCurrency.equals(targetCurrency)) {
            return 1.0; // Same currency
        } else {
            return -1; // Invalid currency pair
        }
    }
}
