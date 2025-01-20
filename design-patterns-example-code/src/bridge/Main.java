package bridge;

public class Main {
    public static void main(String[] args) {
        Color red = new Red();
        Color blue = new Blue();

        Shape redCircle = new Circle(red);
        Shape blueSquare = new Square(blue);

        redCircle.draw();
        blueSquare.draw();
    }
}
