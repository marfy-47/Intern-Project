class Bird {
    void fly() {
        System.out.println("Bird is flying");
    }
}

class Ostrich extends Bird {
    @Override
    void fly() {
        System.out.println("Ostrich can't fly!");
    }
}

public class Polymorphism {
    public static void main(String[] args) {
        Bird myBird = new Ostrich();
        myBird.fly();
    }
}
