package com.backendcodingexercises.javaexercises;

public class PaymentProcessorApplication {
    public static String processPayment(Payment payment, Currency targetCurrency) {
        // Pattern matching using instanceof
        if (targetCurrency instanceof USD) {
            return "Converting " + payment.amount() + " " + payment.currency() + " to USD";
        } else if (targetCurrency instanceof EUR) {
            return "Converting " + payment.amount() + " " + payment.currency() + " to EUR";
        } else if (targetCurrency instanceof GBP) {
            return "Converting " + payment.amount() + " " + payment.currency() + " to GBP";
        } else {
            throw new IllegalArgumentException("Unsupported currency: " + targetCurrency);
        }
    }

    public static void main(String[] args) {
        var payment = new Payment(100.0, "USD");

        System.out.println(processPayment(payment, new EUR())); // Example usage
    }
}
