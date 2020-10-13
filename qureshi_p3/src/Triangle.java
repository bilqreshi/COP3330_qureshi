public class Triangle extends Shape2D {
    private double base, height;
    String name = "triangle";
    double area;

    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public double getArea() {
        area = (base * height) / 2;
        return area;
    }
}
