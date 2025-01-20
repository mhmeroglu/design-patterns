package adapter;

public class Main {
    public static void main(String[] args) {
        OldCar oldCar = new OldCar();

        Car car = new CarAdapter(oldCar);

        car.drive();
        car.stop();
    }
}
