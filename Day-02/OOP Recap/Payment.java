interface Payment {
    void pay(double amount);
}

class CreditCardPayment implements Payment {
    public void pay(double amount) {
        System.out.println("Paid $" + amount + " via Credit Card");
    }
}

class PayPalPayment implements Payment {
    public void pay(double amount) {
        System.out.println("Paid $" + amount + " via PayPal");
    }
}

class PaymentProcessor {
    void makePayment(Payment p, double amount) {
        p.pay(amount); // Polymorphic behavior
    }
}
