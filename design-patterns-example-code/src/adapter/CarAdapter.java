package adapter;

public class CarAdapter implements Car {
    private OldCar oldCar;

    public CarAdapter(OldCar oldCar) {
        this.oldCar = oldCar;
    }

    @Override
    public void drive() {
        oldCar.start();
    }

    @Override
    public void stop() {
        oldCar.halt();
    }
}
