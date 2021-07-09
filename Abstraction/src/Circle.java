public class Circle extends Shape {

    public double radius;

    public Circle(String name, double radius) {
        super(name);
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return 3.142*Math.pow(radius,2);
    }

    @Override
    public double getPerimeter() {
        return 2*3.142*radius;
    }
}
