public class Circle extends Shape2D {
    private double radius;
    String name = "circle";
    double area;

    public Circle(double radius) {
        this.radius = radius;
    }

    public String getName() {
        return name;
    }

    public double getArea() {
        area = radius * radius * Math.PI;
        return area;
    }
}
