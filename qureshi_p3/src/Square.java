public class Square extends Shape2D {
    private double length;
    String name = "square";
    double area;

    public Square(double length) {
        this.length = length;
    }

    public String getName() {
        return name;
    }

    public double getArea() {
        area = length * length;
        return area;
    }
}
