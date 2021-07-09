public class Square extends Shape {

public int side;

    public Square(String name, int side) {
        super(name);
        this.side = side;
    }

    @Override
    public double getArea() {
        return Math.pow(side,2);
    }

    @Override
    public double getPerimeter() {
        return side*4;
    }
}
