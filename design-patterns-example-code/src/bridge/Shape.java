package bridge;

abstract class Shape {
    protected Color color;


    protected Shape(Color color) {
      this.color = color;
    }

    abstract public void draw();

}
